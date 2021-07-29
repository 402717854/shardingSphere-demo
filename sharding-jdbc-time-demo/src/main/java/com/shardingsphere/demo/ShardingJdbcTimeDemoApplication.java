package com.shardingsphere.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shardingsphere.demo.dao")
public class ShardingJdbcTimeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcTimeDemoApplication.class, args);
    }

}
