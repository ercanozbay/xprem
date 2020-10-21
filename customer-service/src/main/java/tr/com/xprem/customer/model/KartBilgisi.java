package tr.com.xprem.customer.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Table(name = "KartBilgisi")
@Entity
public class KartBilgisi extends BaseModel{

    private Integer customerId;
    private String adSoyad;

    @CreditCardNumber(ignoreNonDigitCharacters = true)
    private String kartNo;
    private Date gecerlilikTarihi;
    private String cvc;

    public KartBilgisi() {
    }


    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    public String getKartNo() {
        return kartNo;
    }

    public void setKartNo(String kartNo) {
        this.kartNo = kartNo;
    }

    public Date getGecerlilikTarihi() {
        return gecerlilikTarihi;
    }

    public void setGecerlilikTarihi(Date gecerlilikTarihi) {
        this.gecerlilikTarihi = gecerlilikTarihi;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
