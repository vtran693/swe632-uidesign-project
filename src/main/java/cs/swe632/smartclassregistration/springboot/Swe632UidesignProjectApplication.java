package cs.swe632.smartclassregistration.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Swe632UidesignProjectApplication extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(Swe632UidesignProjectApplication.class);
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Swe632UidesignProjectApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Swe632UidesignProjectApplication.class, args);
	}
}
