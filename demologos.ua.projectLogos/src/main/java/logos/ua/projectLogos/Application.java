package logos.ua.projectLogos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   
//@EnableAutoConfiguration
//@ComponentScan("logos.ua.projectLogos")
//@EnableJpaRepositories(basePackages="<logos.ua.projectLogos.repository>")
//@EnableTransactionManagement
//@EntityScan(basePackages="<logos.ua.projectLogos.domain>")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//application
	}

}
