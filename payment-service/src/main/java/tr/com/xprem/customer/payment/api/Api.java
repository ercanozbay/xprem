package tr.com.xprem.customer.payment.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tr.com.xprem.customer.payment.model.KartBilgisi;
import tr.com.xprem.customer.payment.model.Message;

import javax.validation.Valid;

@RestController
public class Api {
    Logger log = LoggerFactory.getLogger(this.getClass());


    public Api() {

    }



    @RequestMapping(method = RequestMethod.POST, value = "/customer/odemeyap")
    public Message odemeYap(@Valid @RequestBody KartBilgisi kartBilgisi) {
        log.info(String.format("Account.findByCustomer(%s)", kartBilgisi));
        Message message=new Message();
        message.setKodu(Message.Level.BASARILI);
        message.setMessage("Odeme Yapildi");
        return message;
    }





}
