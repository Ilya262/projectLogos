package logos.ua.projectLogos.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/login").setViewName("login"); //registry.addViewController("login"): localhost:8080
		registry.addViewController("/403").setViewName("403");
registry.addViewController("/create-periodical").setViewName("create-periodical");

	}
	
	@Bean
	public InternalResourceViewResolver resolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

	// resolver.setPrefix("src/main/resource/webapp/jsp");

		resolver.setPrefix("/jsp/");

		resolver.setSuffix(".jsp");

		return resolver;

	}

}
