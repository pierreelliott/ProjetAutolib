package com.epul.autolib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AutolibApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AutolibApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AutolibApplication.class, args);
	}
}

