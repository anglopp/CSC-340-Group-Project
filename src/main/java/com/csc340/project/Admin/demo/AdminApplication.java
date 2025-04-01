package Admin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Admin.demo", "posting", "review", "transaction", "tutor"})
@EnableJpaRepositories(basePackages = {"Admin.demo", "posting", "review", "transaction", "tutor"})
@EntityScan(basePackages = {"Admin.demo", "posting", "review", "transaction", "tutor"})
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
}
