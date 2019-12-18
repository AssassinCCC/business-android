package com.overload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.overload.dao")
public class BussinessAndroidApplication {

    public static void main(String[] args) {
        SpringApplication.run(BussinessAndroidApplication.class, args);
    }

}
