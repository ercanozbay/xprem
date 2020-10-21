package tr.com.xprem.customer.util;

import org.springframework.security.core.context.SecurityContextHolder;
import tr.com.xprem.customer.model.Customer;

public class UtilKullanici {

    public static boolean isPremium() {
        boolean isPremium = ((Customer) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())).isPremium();

        return isPremium;

    }

    public static Customer getCustomer() {
        return ((Customer) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()));


    }

}
