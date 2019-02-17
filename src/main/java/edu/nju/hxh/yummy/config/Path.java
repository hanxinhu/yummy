package edu.nju.hxh.yummy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hxh
 * @date 2019-02-17 09:12
 */
@Configuration
@EnableConfigurationProperties(Path.class)
@ConfigurationProperties(prefix = "path")
@PropertySource("classpath:application.properties")
@Data
public class Path {
    public String path;
}
