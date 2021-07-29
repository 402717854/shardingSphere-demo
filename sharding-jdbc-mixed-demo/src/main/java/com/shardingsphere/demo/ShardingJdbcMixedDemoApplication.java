package com.shardingsphere.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shardingsphere.demo.dao")
public class ShardingJdbcMixedDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcMixedDemoApplication.class, args);
    }

}
