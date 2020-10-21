package tr.com.xprem.customer.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tr.com.xprem.customer.model.KartBilgisi;
import tr.com.xprem.customer.repository.CustomerRepository;
import tr.com.xprem.customer.repository.KartBilgisiRepository;
import tr.com.xprem.customer.repository.OnlineDestekRepository;
import tr.com.xprem.customer.service.AsyncService;
import tr.com.xprem.customer.service.CustomerService;
import tr.com.xprem.customer.util.UtilKullanici;
import tr.com.xprem.customer.model.Customer;
import tr.com.xprem.customer.model.Message;
import tr.com.xprem.customer.model.OnlineDestek;

import java.text.ParseException;
import java.util.Optional;

@RestController
@Transactional
public class Api {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OnlineDestekRepository onlineDestekRepository;

    @Autowired
    private KartBilgisiRepository kartBilgisiRepository;

    @Autowired
    private AsyncService asyncService;
    @Autowired
    private CustomerService customerService;



    public Api() throws ParseException {

    }
    Logger log = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(method = RequestMethod.GET, value = "")
    public Customer getCurrentCustomer() {

        log.info("Customer.getCurrentCustomer() giris");
        return UtilKullanici.getCustomer();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/premium/onlinedestek")
    public OnlineDestek onlineDestek(@RequestBody OnlineDestek onlineDestek) {
        log.info("onlineDestek Giriş");
        onlineDestek.setCustomerId(UtilKullanici.getCustomer().getId());
        onlineDestekRepository.save(onlineDestek);
        return onlineDestek;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/odemeyap")
    public Message odemeYap(@RequestBody KartBilgisi kartBilgisi) throws Exception{
        log.info("odemeYap Giriş");
        kartBilgisi.setCustomerId(UtilKullanici.getCustomer().getId());

        boolean isPremium= UtilKullanici.isPremium();
        if(false&&isPremium){

            return new Message(Message.Level.UYARI,"Zaten Premium üyesiniz!..");
        }
        Message message=customerService.odemeYap(kartBilgisi);

        return message;
    }




    @RequestMapping(method = RequestMethod.POST, value = "")
    public Customer createNewCustomer(@RequestBody Customer customer) {
          log.info("createNewCustomer Giriş");

        customerRepository.save(customer);
        return customer;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/uyelikIptal")
    public Customer uyelikIptal() {
        log.info("uyelikIptal Giriş");
        Customer customer=UtilKullanici.getCustomer();
        customer.setUyelikDurumu("N");//Normal uye olundu

        customerRepository.save(customer);
        return customer;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/kartBilgisi")
    public KartBilgisi createKartBilgileri(@RequestBody KartBilgisi kartBilgisi) {
        log.info("createKartBilgileri Giriş");
        kartBilgisi.setCustomerId(UtilKullanici.getCustomer().getId());
        kartBilgisiRepository.save(kartBilgisi);

        return kartBilgisi;
    }

}
