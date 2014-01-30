package com.phillip.news.config;

import java.net.URI;
import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.phillip.news.repository")
public class PersistenceConfig /*implements TransactionManagementConfigurer*/{

	@Inject
	private Environment env;
	
	private Properties hibernateProperties(){
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return hibernateProperties;
	}
	
	@Bean
	public DataSource dataSource(){		
		BasicDataSource dataSource = new BasicDataSource();
		
		try{
			URI dbUri = new URI(System.getenv("DATABASE_URL"));
			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
			
			
			dataSource.setUrl(dbUrl);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setDriverClassName("org.postgresql.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setInitialSize(Integer.parseInt(env.getProperty("jdbc.initialSize")));
		dataSource.setMaxActive(Integer.parseInt(env.getProperty("jdbc.maxActive")));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));*/
		
		return dataSource;
	} 
    
	@Bean  
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {  
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();  
        entityManagerFactoryBean.setDataSource(dataSource());  
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);  
        entityManagerFactoryBean.setPackagesToScan("com.phillip.news.domain");  
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());  
          
        return entityManagerFactoryBean;  
    }  
	
    @Bean  
    public JpaTransactionManager transactionManager() {  
        JpaTransactionManager transactionManager = new JpaTransactionManager();  
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());  
        
        return transactionManager;  
    } 
}
