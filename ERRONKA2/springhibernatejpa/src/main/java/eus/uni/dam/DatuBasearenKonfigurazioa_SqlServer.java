package eus.uni.dam;

import java.util.Properties;
import javax.sql.DataSource;
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
     * Definición del DataSource para la conexión a nuestra base de datos.
     * Las propiedades son establecidas desde el fichero de properties, y
     * asignadas usando el objeto env.
     *
     
    @Bean("dataSourceIn")
    public DataSource dataSourceIn() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("dbin.driver"));
        dataSource.setUrl(env.getProperty("dbin.url"));
        dataSource.setUsername(env.getProperty("dbin.username"));
        dataSource.setPassword(env.getProperty("dbin.password"));
        return dataSource;
    }
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
    
    /**
     *
     * Declaración del EntityManagerFactory de JPA
    
    @Bean("factoryIn")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryin() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        //Le asignamos el dataSource que acabamos de definir.
        entityManagerFactory.setDataSource(dataSourceIn());

        // Le indicamos la ruta donde tiene que buscar las clases anotadas
        entityManagerFactory.setPackagesToScan(env.getProperty("entitymanagerin.packagesToScan"));

        // Implementación de JPA a usar: Hibernate
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Propiedades de Hibernate
        Properties additionalProperties = new Properties();
        additionalProperties.put("hibernate.dialect", env.getProperty("hibernatein.dialect"));
        additionalProperties.put("hibernate.show_sql", env.getProperty("hibernatein.show_sql"));
        additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernatein.hbm2ddl.auto"));
        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    } 
    */
    
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