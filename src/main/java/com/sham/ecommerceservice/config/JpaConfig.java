package com.sham.ecommerceservice.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

/**
 * @EnableAutoConfiguration:  enables the auto-configuration of Spring ApplicationContext by scanning the classpath components and registering the beans.
 *  @SpringBootApplication: made up of @Configuration , @EnableAutoConfiguration , and @ComponentScan. A class-level annotation that is part of the Spring Boot framework. It indicates that a class provides application configuration. It is a primary source of the application.
 *  @ComponentScan: to specify the packages that we want to be scanned.
 *  @SpringBootConfiguration:  class-level annotation that is part of the Spring Boot framework. It indicates that a class provides application configuration.
 * @EnableConfigurationProperties: In order to use a configuration class in our project, we need to register it as a regular Spring bean.
 * Source for hibernate config: https://docs.jboss.org/hibernate/core/3.3/reference/en/html/session-configuration.html#configuration-programmatic
 * Source for JPA config: https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa
 * Source for setting hibernate.naming strategy: https://stackoverflow.com/questions/40509395/cant-set-jpa-naming-strategy-after-configuring-multiple-data-sources-spring-1
 */

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "ecommerceEntityManagerFactory",
        transactionManagerRef = "ecommerceTransactionManager",
        basePackages = {"com.sham.ecommerceservice.repository"}
)
@EntityScan(
        basePackages = {"com.sham.ecommerceservice.entity"}
)
@EnableTransactionManagement //on by default, can ignore
@EnableJpaAuditing
@Slf4j
//@Primary
public class JpaConfig {

    @Value("${spring.datasource.url}")
    private String dataSrcUrl;


    @Value("${spring.datasource.username}")
    private String dataSrcUsername;


    @Value("${spring.datasource.password}")
    private String dataSrcPwd;


    @Value("${spring.datasource.driverClassName}")
    private String dataSrcDriver;


    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;


    @Value("${spring.jpa.hibernate.generate-ddl}")
    private String ddlGeneration;


    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;


    @Value("${spring.jpa.hibernate.show_sql: true}")
    private String showSql;


    @Value("${spring.jpa.hibernate.naming.physical-strategy}")
    private String physicalStrategy;


    @Value("${spring.jpa.hibernate.naming.implicit-strategy}")
    private String implicitStrategy;


    @Value("${spring.jpa.properties.hibernate.jdbc.batch:20}")
    private String jdbcBatchSize;


    @Value("${spring.jpa.properties.hibernate.order_updates: true}")
    private String orderUpdates;
    @Value("${spring.jpa.properties.hibernate.batch_versioned_data: true}")
    private String versionedData;

    @Value("${spring.jpa.properties.hibernate.format_sql: false}")
    private String formatSql;

    @Bean(name="ecommerceDataSource")
    public DataSource ecommerceDataSourceProperties() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSrcUrl);
        dataSource.setUsername(dataSrcUsername);
        dataSource.setPassword(dataSrcPwd);
        dataSource.setDriverClassName(dataSrcDriver);
        return dataSource;
    }



    @Bean(name = "ecommerceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ecommerceEntityManagerFactory(@Qualifier("ecommerceDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan("com.sham.ecommerceservice.entity");
        entityManagerFactoryBean.setPersistenceUnitName("ecommercePU");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.parseBoolean(ddlGeneration));
        vendorAdapter.setShowSql(Boolean.parseBoolean(showSql));
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
//        properties.setProperty("hibernate.generate-ddl", ddlGeneration);
        properties.setProperty("hibernate.naming_physical_strategy", physicalStrategy);
        properties.setProperty("hibernate.naming_implicit_strategy", implicitStrategy);
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("hibernate.jdbc.batch_size", jdbcBatchSize.trim());
        properties.setProperty("hibernate.order_updates", orderUpdates);
        properties.setProperty("hibernate.batch_versioned_data", versionedData);
        properties.setProperty("hibernate.show_sql",showSql);

        //
//        properties.setProperty("hibernate.connection.characterEncoding", "utf8");
//        properties.setProperty("hibernate.connection.CharSet", "utf8mb3");
//        properties.setProperty("hibernate.connection.useUnicode", "true");
        entityManagerFactoryBean.setJpaProperties(properties);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean;
    }


    @Bean(name="ecommerceTransactionManager")
    public PlatformTransactionManager ecommerceTransactionManager(
            final @Qualifier("ecommerceEntityManagerFactory") LocalContainerEntityManagerFactoryBean ecommerceEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(ecommerceEntityManagerFactory.getObject()));
    }


}
