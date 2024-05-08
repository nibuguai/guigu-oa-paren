package com.wq;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * @Author 王骞
 * @Date 2023/6/28 15:16
 * @Version 1.0
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.wq.mapper") // 指定Mapper接口所在的包路径
@ServletComponentScan()
public class ServiceOaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOaApplication.class, args);
    }
}
