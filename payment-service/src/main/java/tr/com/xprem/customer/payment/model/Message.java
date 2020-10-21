package tr.com.xprem.customer.payment.model;

public class Message {
    public enum Level {
        BASARILI,
        HATA,
        UYARI
    }

    private Level kodu;//0:Basarili;1:Hatali;2:uyari

    public Level getKodu() {
        return kodu;
    }

    public void setKodu(Level kodu) {
        this.kodu = kodu;
    }

    private String message;

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message(Level kodu, String message) {
        this.kodu = kodu;
        this.message = message;
    }
}
