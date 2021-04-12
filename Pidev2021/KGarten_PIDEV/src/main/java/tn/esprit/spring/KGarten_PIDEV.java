package tn.esprit.spring;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;




@SpringBootApplication
public class KGarten_PIDEV {
	
	
	public static void main(String[] args) {
		SpringApplication.run(KGarten_PIDEV.class, args);
		
	
	}
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setLocation("./uploads");
		return factory.createMultipartConfig();
	}


	
}
