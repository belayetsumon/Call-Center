/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.globalConfiguration;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Admin
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "childEntityManagerFactory",
        transactionManagerRef = "childTransactionManager",
        basePackages = {"com.itgarden.ERP.module.callcenter.repository"})
public class ChildDatasourceConfiguration {

    @Bean(name = "childDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.child")
    public DataSource childDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "childEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean childLocalContainerEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", "validate");
        return builder
                .dataSource(childDataSource())
                .properties(properties)
                .persistenceUnit("child")
                .packages("com.itgarden.ERP.module.callcenter.Model")
                .build();
    }

    @Bean(name = "childTransactionManager")
    public PlatformTransactionManager childTransactionManager(
            final @Qualifier("childEntityManagerFactory") LocalContainerEntityManagerFactoryBean childEntityManagerFactory) {
        return new JpaTransactionManager(childEntityManagerFactory.getObject());
    }

}
