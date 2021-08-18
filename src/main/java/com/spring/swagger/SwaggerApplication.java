package com.spring.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class SwaggerApplication {

	// The swagger is enabled automatically without any further annotations
	// The default web page for doc is at server:port/swagger-ui.html, not server:port/context-path/swagger-ui.html(By default, the context-path is empty)
	// For OpenApi description, just go to server:port/api-docs not /v1, /v2, or some-path/v3/api-docs

	// The documentation mentioned that the context-path is the context path of the application, in this app(which is the basic case, no extra context-path)

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

}
