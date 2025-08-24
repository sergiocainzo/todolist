package br.com.dio.todo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Cloud Server URL")})
@SpringBootApplication
public class API {

	public static void main(String[] args) {
		SpringApplication.run(API.class, args);
	}

}
