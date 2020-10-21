package tr.com.xprem.customer.payment.handler;
//import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tr.com.xprem.customer.payment.model.Message;
//import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class FeignExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Message handleValidationExceptions(MethodArgumentNotValidException ex) {

        Message message=new Message();
        message.setKodu(Message.Level.HATA);
        message.setMessage(ex.getMessage());
        return  message;
    }




}