package com.example.shoppingcart.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.shoppingcart.controllers.HomeController;
import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@ComponentScan(basePackageClasses=HomeController.class)
@EnableSwagger2
public class SwaggerConfig {
	//version for project
	private static final String SWAGGER_API_VERSION="1.0";
	//text in last line in swagger header, which displays license info
	private static final String LICENSE_TEXT ="License";
	//Title in swagger
	private static final String title= "Items REST API";
	//Description of exposed url.
	private static final String description = "RESTful API for items";
	
	// Setting header information in swagger 
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.license(LICENSE_TEXT)
				.version(SWAGGER_API_VERSION)
				.build();  
		}
	// Create a docket bean which maps urls to swagger.
	@Bean
	public Docket ItemsApi() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()) // calls header method.
				.pathMapping("/api") // prefixes url with "/api" in swagger.
				.select()
				.paths(PathSelectors.regex("/.*")) // Display all paths in swagger that matches /.*
				.build();
		
	}
	
	
}