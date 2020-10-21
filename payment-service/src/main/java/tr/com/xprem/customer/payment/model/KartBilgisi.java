package tr.com.xprem.customer.payment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.CreditCardNumber;


import java.util.Date;


public class KartBilgisi {


    private Integer id;
    private Integer customerId;
    private String adSoyad;

    @CreditCardNumber(ignoreNonDigitCharacters = true)
    private String kartNo;
    private Date gecerlilikTarihi;
    private String cvc;

    public KartBilgisi() {
    }

    public KartBilgisi(Integer id, Integer customerId, String adSoyad, String kartNo, Date gecerlilikTarihi, String cvc) {
        this.id = id;
        this.customerId = customerId;
        this.adSoyad = adSoyad;
        this.kartNo = kartNo;
        this.gecerlilikTarihi = gecerlilikTarihi;
        this.cvc = cvc;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
