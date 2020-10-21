# X-PREM PREMIUM APP PROJECT

Backend olarak geliştirilen proje spring boot framework'unu kullanmaktadır.



### Çalıştırılması

docker-compose up

Eğer servislerde değişiklik olursa:

docker-compose build
docker-compose up

### Kapatılması

docker-compose down

### Uygulamanın kullanımı
tüm requestlerde:
Postman uygulaması kullandım. 1 id li customer üzerinde işlem yaptım.
Auth Type: BasicAuth 
    Username=1 
    
#### müşteri profilini görmek için
Methode:get
http://localhost:3333

#### ödeme yapmak için
Method:post
http://localhost:3333/odemeyap
Body:
{
        "id": 1,
        "customerId": 1,
        "adSoyad": "ali veli",
        "kartNo": "5",
        "gecerlilikTarihi": "2022-06-01 00:00:00",
        "cvc": ""
    }

#### online destek sayfası 
Method:post
http://localhost:3333/premium/onlinedestek

Body:
{"konu":"abc","mesaj":"asdffsad"}

#### uyelik İptal sayfası 
Method:post
http://localhost:3333/uyelikIptal




## Mimarisi

- **gateway-service** - Proxy gateway olarak kullandım
- **discovery-service** - Eureka yı kullanarak service discovery sağlar.
- **customer-service** - müşteri bilgisi ve online destek uygulamasını içerir. 
- **payment-service** - Ödeme servisidir

