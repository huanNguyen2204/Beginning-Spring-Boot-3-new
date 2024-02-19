package com.apress.demo5;

import com.apress.demo5.springblog.dto.PostHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
public class Demo5Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo5Application.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routes(PostHandler postHandler) {
	}
}
