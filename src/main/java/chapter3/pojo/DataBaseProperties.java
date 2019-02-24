package chapter3.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package chapter3.pojo
 * @Description: TODO
 * @date Date : 2019-02-24 16:59
 */


// @ConfigurationProperties("database")
@Component
@Data
@PropertySource("classpath:jdbc.properties") // 指定文件
@ConfigurationProperties(prefix = "database")  // 按命名进行指定
public class DataBaseProperties {

    // @Value("${database.driverName}")
    private String driverName = null;

    // @Value("${database.url}")
    private String url = null;

    // @Value("${database.username}")
    private String username = null;

    // @Value("${database.password}")
    private String password = null;

    @Override
    public String toString() {
        return this.driverName + "\n" + this.username + "\n" + this.password + "\n" + this.url;
    }
}
