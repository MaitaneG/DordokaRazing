package eus.uni.dam;

import java.util.Properties;
import javax.sql.DataSource;

import com.NewTel.dao.ProductProductDao;
import com.NewTel.dao.ResPartnerDao;
import com.NewTel.dao.SaleOrderDao;
import com.NewTel.dao.SaleOrderLineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:/application.properties")
@EnableTransactionManagement
public class DatuBasearenKonfigurazioa_SqlServer {
    /**
     * Microsoft SQL Server datubaseko DataSource definitzea gure datu-basera konektatzeko.
     * Propietateak propertie-en fitxategitik ezartzen dira,
     * eta esleitu egiten dira Env Objektua erabiliz
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("dbout.driver"));
        dataSource.setUrl(env.getProperty("dbout.url"));
        dataSource.setUsername(env.getProperty("dbout.username"));
        dataSource.setPassword(env.getProperty("dbout.password"));
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        //Le asignamos el dataSource que acabamos de definir.
        entityManagerFactory.setDataSource(dataSource());

        // Le indicamos la ruta donde tiene que buscar las clases anotadas
        entityManagerFactory.setPackagesToScan(env.getProperty("entitymanagerout.packagesToScan"));

        // Implementación de JPA a usar: Hibernate
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Propiedades de Hibernate
        Properties additionalProperties = new Properties();
        additionalProperties.put("hibernate.dialect", env.getProperty("hibernateout.dialect"));
        additionalProperties.put("hibernate.show_sql", env.getProperty("hibernateout.show_sql"));
        additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernateout.hbm2ddl.auto"));
        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    }

    /**
     * Inicializa y declara el gestor de transacciones
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }

    /**
     *  
     * Este bean es un postprocessor que ayuda a relanzar las excepciones específicas
     * de cada plataforma en aquellas clases anotadas con @Repository
     *
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public ProductProductDao getProductDao() {
    	return new ProductProductDao();
    }
    @Bean
    public ResPartnerDao getResPartnerDao() {
    	return new ResPartnerDao();
    }
    @Bean
    public SaleOrderDao getSaleOrderDao() {
    	return new SaleOrderDao();
    }
    @Bean
    public SaleOrderLineDao getSaleOrderLineDao() {
        return new SaleOrderLineDao();
    }
    
    
    
    @Autowired
    private Environment env;

    
    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;
    

  
}