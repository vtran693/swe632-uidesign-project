package cs.swe632.smartclassregistration.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Swe632UidesignProjectApplication extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Swe632UidesignProjectApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Swe632UidesignProjectApplication.class, args);
	}
}
