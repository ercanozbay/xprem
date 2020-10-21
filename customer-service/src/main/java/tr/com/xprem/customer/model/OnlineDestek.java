package tr.com.xprem.customer.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "OnlineDestek")
@Entity
public class OnlineDestek extends BaseModel{


    private Integer customerId;
    private String konu;
    private String mesaj;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
}
