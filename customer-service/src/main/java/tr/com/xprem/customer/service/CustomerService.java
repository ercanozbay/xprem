package tr.com.xprem.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.xprem.customer.client.AccountClient;
import tr.com.xprem.customer.model.Customer;
import tr.com.xprem.customer.model.KartBilgisi;
import tr.com.xprem.customer.model.Message;
import tr.com.xprem.customer.repository.CustomerRepository;
import tr.com.xprem.customer.repository.KartBilgisiRepository;
import tr.com.xprem.customer.util.Const;
import tr.com.xprem.customer.util.UtilDate;
import tr.com.xprem.customer.util.UtilKullanici;

import java.text.ParseException;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private AccountClient accountClient;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private KartBilgisiRepository kartBilgisiRepository;

    @Autowired
    private AsyncService asyncService;

    public Message odemeYap(KartBilgisi kartBilgisi) throws InterruptedException, ParseException {

        Message message=accountClient.odemeYap(kartBilgisi);

        if(message.getKodu()==Message.Level.BASARILI){

            asyncService.mailAt(UtilKullanici.getCustomer().getEmail(),"X-PREM premimum ödemeniz hk.","Premium üyeliğiniz için yapılan ödemeniz kredi kartınızdan çekilmiştir!... ");
            Customer customer=UtilKullanici.getCustomer();
            customer.setUyelikDurumu(Const.CUSTOMER_DURUMU_PREMIUM);
            customer.setPremiumUyelikBitisTarihi(UtilDate.addMonth(1));
            customerRepository.save(customer);
            kartBilgisiRepository.save(kartBilgisi);
        }
        return message;

    }


}
