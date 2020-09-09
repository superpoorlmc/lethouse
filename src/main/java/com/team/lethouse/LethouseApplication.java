package com.team.lethouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.team.lethouse.mapper")
public class LethouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(LethouseApplication.class, args);
    }

}
