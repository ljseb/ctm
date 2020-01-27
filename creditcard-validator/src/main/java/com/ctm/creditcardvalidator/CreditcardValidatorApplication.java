package com.ctm.creditcardvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ctm."})

public class CreditcardValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditcardValidatorApplication.class, args);
	}

}
