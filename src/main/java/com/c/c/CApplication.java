package com.c.c;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.c.c.dao")
@EnableCaching
public class CApplication {

	public static void main(String[] args) {
		SpringApplication.run(CApplication.class, args);
	}

}
