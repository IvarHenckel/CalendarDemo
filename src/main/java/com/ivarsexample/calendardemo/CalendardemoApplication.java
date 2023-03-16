package com.ivarsexample.calendardemo;

import com.ivarsexample.calendardemo.config.ContentCalendarProperties;
import com.ivarsexample.calendardemo.model.Content;
import com.ivarsexample.calendardemo.model.Status;
import com.ivarsexample.calendardemo.model.Type;
import com.ivarsexample.calendardemo.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class CalendardemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CalendardemoApplication.class, args);
		// The application context acts as a bean factory
		//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		//Note that the Message class defined as a @Component will show up as a bean definition name "message".
	}

	// We are now initializing data in the DataLoader class.
//	@Bean
//	public CommandLineRunner commandLineRunner(ContentRepository repository) {
//		// Since this method is marked with @Bean the function will automatically be executed at startup to add the returned instance to Springs pool of managed instances.
//		// Our ContentRepository is a singleton marked as a bean (by the extended class)
//		// -> the argument will be autowired.
//		return args -> {
//			System.out.println("Hi from a commandLineRunner Bean!");
//			Content content = new Content(
//					null, //auto incremented
//					"Hello Chat GPT",
//					"All about Chat GPT",
//					Status.IDEA,
//					Type.VIDEO,
//					LocalDateTime.now(),
//					null,
//					""
//			);
//			repository.save(content);
//		};
//	}
}
