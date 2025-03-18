//package com.sham.ecommerceservice.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//
///*
//* Source: https://www.baeldung.com/spring-boot-configure-multiple-datasources
//*
//* */
//
//@Configuration
//public class JDBCConfig {
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.ecom")
//    public DataSourceProperties ecomDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.ecom.hikari")
//    public DataSource todosDataSource() {
//        return ecomDataSourceProperties()
//                .initializeDataSourceBuilder()
//                .build();
//    }
//
//    @Bean
//    public JdbcTemplate ecomJdbcTemplate(@Qualifier("ecomDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//}
