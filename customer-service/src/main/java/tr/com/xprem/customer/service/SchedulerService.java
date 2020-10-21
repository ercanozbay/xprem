package tr.com.xprem.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tr.com.xprem.customer.model.Customer;
import tr.com.xprem.customer.model.KartBilgisi;
import tr.com.xprem.customer.repository.CustomerRepository;
import tr.com.xprem.customer.repository.KartBilgisiRepository;

import java.text.ParseException;
import java.util.List;

@Service
public class SchedulerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    KartBilgisiRepository kartBilgisiRepository;

//    @Autowired
    CustomerService customerService;

    @Scheduled(cron="0 0 0 * * *")//her gün 24 te ilgili kullanıcıların işlemlerini yapar
//    @Scheduled(fixedRate = 1000)//her saniye  ilgili kullanıcıların işlemlerini yapar
    public void scheduleFixedRateTask() {

        List<Customer> customerList=customerRepository.findUyelikSuresiDolanPremiumCustomer();

        customerList.forEach(customer -> {
            List<KartBilgisi> kartBilgisiList=kartBilgisiRepository.findByCustomerId(customer.getId());
            kartBilgisiList.forEach(kartBilgisi -> {
                try {
                    customerService.odemeYap(kartBilgisi);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            });
        });

    }
}
