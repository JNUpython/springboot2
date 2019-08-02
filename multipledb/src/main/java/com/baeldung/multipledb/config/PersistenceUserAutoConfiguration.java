package com.baeldung.multipledb.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.testng.annotations.ITestOrConfiguration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.baeldung.multipledb.config
 * @Description: TODO
 * @date Date : 2019-08-03 0:34
 */
@Configuration
@PropertySource({"classpath:persistence-multiple-db-boot.properties"})
@EnableJpaRepositories(
        basePackages = "com.baeldung.multipledb.dao.user",
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef = "userTransactionManager")
public class PersistenceUserAutoConfiguration {

    @Primary
    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }


    // userEntityManager bean
    @Primary
    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    barEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("userDataSource") DataSource dataSource
    ) {
        return builder.dataSource(dataSource)
                .packages("com.baeldung.multipledb.model.user")
                .persistenceUnit("user")
                .build();
    }

    // userTransactionManager bean
    @Primary
    @Bean(name = "userTransactionManager")
    public PlatformTransactionManager userTransactionManager(
            @Qualifier("userEntityManagerFactory") EntityManagerFactory userEntityManagerFactory
    ) {
        return new JpaTransactionManager(userEntityManagerFactory);
    }

}
