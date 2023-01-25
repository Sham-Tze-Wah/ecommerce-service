FROM openjdk:8
copy ./target/ecommerce-service-0.0.1-SNAPSHOT.jar ecommerce-service-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "ecommerce-service-0.0.1-SNAPSHOT.jar"]
# EXPOSE 13306
# EXPOSE 3306
# COPY ./src/main/java/com.sham.ecommerceservice/ /tmp
# WORKDIR /tmp
# ENTRYPOINT ["java","EcommerceServiceApplication"]
