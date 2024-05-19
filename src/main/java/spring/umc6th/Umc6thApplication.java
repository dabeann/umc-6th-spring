package spring.umc6th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Umc6thApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc6thApplication.class, args);
	}

}
