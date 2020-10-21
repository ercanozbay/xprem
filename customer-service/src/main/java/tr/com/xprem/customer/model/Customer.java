package tr.com.xprem.customer.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Customer")
@Entity
public class Customer  extends BaseModel{


    private String ad;
    private String soyad;
    private String email;
    private Date uyelikTarihi;
    private String uyelikDurumu;
    private Date premiumUyelikBitisTarihi;

    @Transient
    private boolean premium;

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public Customer() {
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public Date getUyelikTarihi() {
        return uyelikTarihi;
    }

    public void setUyelikTarihi(Date uyelikTarihi) {
        this.uyelikTarihi = uyelikTarihi;
    }

    public String getUyelikDurumu() {
        return uyelikDurumu;
    }

    public void setUyelikDurumu(String uyelikDurumu) {
        this.uyelikDurumu = uyelikDurumu;
    }

    public Date getPremiumUyelikBitisTarihi() {
        return premiumUyelikBitisTarihi;
    }

    public void setPremiumUyelikBitisTarihi(Date premiumUyelikBitisTarihi) {
        this.premiumUyelikBitisTarihi = premiumUyelikBitisTarihi;
    }


}
