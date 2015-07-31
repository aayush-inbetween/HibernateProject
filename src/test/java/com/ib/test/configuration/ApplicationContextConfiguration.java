package com.ib.test.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ib.entity.Klass;
import com.ib.entity.Relationship;

@Configuration
@ComponentScan("com.ib.*")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ib.repository")
public class ApplicationContextConfiguration {
  
  @Autowired
  ApplicationContext applicationContext;
  
  @Bean
  public DataSource dataSource()
  {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/testdb?createDatabaseIfNotExist=true");
    dataSource.setUsername("root");
    dataSource.setPassword("");
    
    return dataSource;
  }
  
  @Bean
  public JpaTransactionManager transactionManager()
  {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    
    return transactionManager;
  }
  
  @Bean
  public HibernateJpaVendorAdapter jpaVendorAdapter()
  {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setShowSql(true);
    jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
    jpaVendorAdapter.setGenerateDdl(true);
    return jpaVendorAdapter;
  }
  
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory()
  {
    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    
    entityManagerFactory.setDataSource(dataSource());
    entityManagerFactory.setPackagesToScan("com.ib.*");
    entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
    
    Properties jpaProterties = new Properties();
    jpaProterties.put("hibernate.hbm2ddl.auto", "update");
    jpaProterties.put("hibernate.format_sql", true);
    jpaProterties.put("hibernate.use_sql_comments", true);
    jpaProterties.put("hibernate.show_sql", true);
    jpaProterties.put("hibernate.search.default.indexBase", "/var/lucene/indexes");
    
    entityManagerFactory.setJpaProperties(jpaProterties);
    return entityManagerFactory;
  }
  
  @Bean
  List<Long> createdAttributeIds()
  {
    return new ArrayList<Long>();
  }
  
  @Bean
  List<Klass> createdKlasses()
  {
    return new ArrayList<Klass>();
  }
  
  @Bean
  List<Relationship> createdRelationships()
  {
    return new ArrayList<Relationship>();
  }
}
