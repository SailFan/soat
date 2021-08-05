package com.tool.soat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@MapperScan(basePackages = "com.tool.soat.dao")
public class SoatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoatApplication.class, args);
    }
}
