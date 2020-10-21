-- DROP TABLE IF EXISTS customer;


/*CREATE TABLE customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  ad VARCHAR(250) NOT NULL,
  soyad VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  uyelikTarihi Date DEFAULT NULL,
  uyelikDurumu VARCHAR(1) DEFAULT NULL,
  premiumUyelikBitisTarihi  Date DEFAULT NULL
);
*/
 INSERT INTO customer (id,ad,soyad,email,uyelik_Durumu) VALUES
   (1,'Ercan', 'Özbay', 'ercanozbay@gmail.com','N');