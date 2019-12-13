package com.lairun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.lairun.**.mapper")
public class LairunErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LairunErpApplication.class, args);
	}

}
