package edu.nju.hxh.yummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class YummyApplication {

    public static void main(String[] args) {
        SpringApplication.run(YummyApplication.class, args);
    }



}

