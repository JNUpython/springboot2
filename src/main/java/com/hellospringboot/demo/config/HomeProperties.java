package com.hellospringboot.demo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "home")
public class HomeProperties {
    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 描述
     */
    private String desc;

    @Override
    public String toString() {
        return String.format("%s-%s-%s", province, city, desc);
    }
}
