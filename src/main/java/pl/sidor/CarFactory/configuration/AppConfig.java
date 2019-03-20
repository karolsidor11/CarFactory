package pl.sidor.CarFactory.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("pl.sidor")
@EntityScan("models")
public class AppConfig {

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }

    @Value("${spring.datasource.driver-class-name}")
    private String DRIVER_CLASS;

    @Value("${spring.datasource.url}")
    private String DATEBASE_URL;

    @Value("${spring.datasource.username}")
    private String USER_NAME;

    @Value("${spring.datasource.password}")
    private String USER_PASSWORD;

//    @Value("${hibernate.dialect}")
//    private String DIALECT;


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(DRIVER_CLASS);
        driverManagerDataSource.setUsername(USER_NAME);
        driverManagerDataSource.setPassword(USER_PASSWORD);
        driverManagerDataSource.setUrl(DATEBASE_URL);

        return driverManagerDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

        em.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        em.setPackagesToScan("models");
        em.setJpaProperties(properties());

        return em;
    }

    public Properties properties() {

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }
}
