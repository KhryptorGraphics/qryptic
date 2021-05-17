package com.mjovanc.coinshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CoinsharkApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoinsharkApplication.class, args);
	}
}
