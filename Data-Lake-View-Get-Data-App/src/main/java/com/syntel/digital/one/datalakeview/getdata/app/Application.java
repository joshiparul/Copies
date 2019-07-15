package com.syntel.digital.one.datalakeview.getdata.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.syntel.digital.one.datalakeview.getdata.*")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
