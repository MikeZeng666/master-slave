package com.mike.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mike.demo.mapper")
@SpringBootApplication(scanBasePackages = "com.mike.demo")
public class DemoApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(DemoApplication.class, args);
    }
}
