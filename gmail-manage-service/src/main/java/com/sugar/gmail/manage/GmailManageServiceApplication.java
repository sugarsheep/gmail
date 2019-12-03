package com.sugar.gmail.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.sugar.gmail.manage.mapper")
public class GmailManageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmailManageServiceApplication.class, args);
    }
}
