package com.excercise.dbclm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private Environment env;
	
	public SwaggerConfiguration(Environment env) {
		this.env = env;
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.host(env.getProperty("swagger.host",""))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.excercise.dbclm.controller"))
				.paths(PathSelectors.any()).build()
				.apiInfo(metaData());
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo metaData() {
		return new ApiInfo(env.getProperty("app.name"), 
				env.getProperty("app.description"), 
				null, null, null, null, null);
	}
}
