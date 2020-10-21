package tr.com.xprem.customer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.com.xprem.customer.model.KartBilgisi;
import tr.com.xprem.customer.model.Message;

@FeignClient(value = "payment-service"
//        , fallback = HystrixClientFallbackFactory.class
)
public interface AccountClient {

    @RequestMapping(method = RequestMethod.POST, value = "/customer/odemeyap")
    Message odemeYap(KartBilgisi kartBilgisi);

}