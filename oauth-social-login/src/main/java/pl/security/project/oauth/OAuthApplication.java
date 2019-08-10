package pl.security.project.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthApplication.class, args);
	}

}
