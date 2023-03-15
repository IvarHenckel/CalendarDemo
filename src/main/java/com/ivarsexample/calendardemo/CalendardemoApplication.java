package com.ivarsexample.calendardemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class CalendardemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CalendardemoApplication.class, args);
		// The application context acts as a bean factory
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		//Note that the Message class defined as a @Component will show up as a bean definition name "message".
	}

}
