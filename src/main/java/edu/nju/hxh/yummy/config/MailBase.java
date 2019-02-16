package edu.nju.hxh.yummy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hxh
 * @date 2019-02-16 08:29
 */
@Configuration
@EnableConfigurationProperties(MailBase.class)
@ConfigurationProperties(prefix = "mail")
@PropertySource("classpath:application.properties")
@Data
public class MailBase {
    public String context;
    public String subject;
}
