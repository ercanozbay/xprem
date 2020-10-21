FROM openjdk:8-jdk-alpine
ADD target/payment-service.jar payment-service.jar
EXPOSE 2222
ENTRYPOINT ["java", "-jar", "/payment-service.jar"]