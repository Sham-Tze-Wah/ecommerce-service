FROM openjdk:1.8
COPY ./src/main/java/com.sham.ecommerceservice/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","EcommerceServiceApplication"]
