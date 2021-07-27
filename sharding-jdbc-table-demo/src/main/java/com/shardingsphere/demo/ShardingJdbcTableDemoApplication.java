package com.shardingsphere.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry //重试注解
@SpringBootApplication
@MapperScan("com.shardingsphere.demo.dao")
public class ShardingJdbcTableDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcTableDemoApplication.class, args);
    }

}
