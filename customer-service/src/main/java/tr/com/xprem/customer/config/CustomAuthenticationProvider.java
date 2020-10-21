package tr.com.xprem.customer.config;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import tr.com.xprem.customer.model.Customer;
import tr.com.xprem.customer.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    private CustomerRepository customerRepository;
    public CustomAuthenticationProvider(CustomerRepository customerRepository) {
        this.customerRepository=customerRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Optional<Customer> customerLocal=customerRepository.findById(Integer.parseInt(authentication.getName()));

        boolean isPremium=false;

        if(customerLocal.get().getPremiumUyelikBitisTarihi()!=null&&
                customerLocal.get().getPremiumUyelikBitisTarihi().compareTo(new Date())>=0){
            isPremium=true;
        }


        List<GrantedAuthority> authorities = new ArrayList<>();
        if(isPremium)
            authorities.add(new SimpleGrantedAuthority("ROLE_PREMIUM"));
        else
            authorities.add(new SimpleGrantedAuthority("ROLE_NORMAL"));

        customerLocal.get().setPremium(isPremium);

        Authentication auth = new AnonymousAuthenticationToken("name", customerLocal.get(), authorities);
        return auth;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}