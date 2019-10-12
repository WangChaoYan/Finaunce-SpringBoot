package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author
 * @date 2019/9/29
 * @Time 20:56
 */
//@ServletComponentScan(basePackages ="com.qf.config")
@SpringBootApplication
public class FinaunceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinaunceApplication.class,args);
    }
}
