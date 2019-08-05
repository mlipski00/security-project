package com.security.project.zuul.oauthzuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class OauthZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthZuulGatewayApplication.class, args);
	}

}
