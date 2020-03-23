package com.mobility.MobilityApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MobilityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilityAppApplication.class, args);
	}

}
