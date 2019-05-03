package com.chapter3.config;

import com.chapter3.pojo.User;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration  // java 的的配置文件， 程序
@ComponentScan(value = "com.chapter3.*")  // 通过扫描的方式将指定范围的Component装配到IoC容器
// @ComponentScan(value = "com.chapter3.*", excludeFilters = {@ComponentScan.Filter(classes = {Service.class})}) // 可以Scan跳过Service类
@EnableConfigurationProperties
public class AppConfig {

    /**
     * @return
     */
    @Bean(name = "initUser") // 给定bean一个名称，不给默认是方法的名称
    public User initUser() {
        User user = new User();
        user.setId(1L);
        user.setUserName("user_name_1");
        user.setNote("note_1");
        return user;
    }


    @Bean("dataSource")
    public DataSource getDataSource() {
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true");
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception error) {
            error.printStackTrace();
        }
        return dataSource;
    }

}
