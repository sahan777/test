package lk.online.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * This is for mysql Database configuration
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManager",
        transactionManagerRef = "mysqlTransactionManager",
        basePackages = "lk.online.DAO"
)
@PropertySource("classpath:application.properties")
public class MySqlDBConfig {

    @Autowired
    Environment environment;


    /**
     * These can't be  Primary
     *
     * @return
     */

    @Bean(name = "mysqlDatasource")
    @ConfigurationProperties(prefix = "spring.mysql.datasource")
    public DriverManagerDataSource mySqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.mysql.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.mysql.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.mysql.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.mysql.datasource.password"));
        return dataSource;
    }


    @Bean(name = "mysqlEntityManager")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactoryBean(@Qualifier("mysqlDatasource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPersistenceUnitName("mysqlPU");
        emf.setJpaProperties(hibernateProperties());
        emf.setPackagesToScan("lk.online");
        emf.setJpaVendorAdapter(getHibernateAdapter());
        return emf;
//        return builder.dataSource(mySqlDataSource()).properties(hibernateProperties()).packages("lk.mobitel.model").persistenceUnit("mysqlPU").build();
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mySqlTransactionManager(@Qualifier("mysqlEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        return props;
    }

    @Bean
    public JpaVendorAdapter getHibernateAdapter() {
        return new HibernateJpaVendorAdapter();
    }
}
