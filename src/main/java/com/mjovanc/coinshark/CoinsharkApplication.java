package com.mjovanc.coinshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CoinsharkApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(CoinsharkApplication.class, args);
	}
}
