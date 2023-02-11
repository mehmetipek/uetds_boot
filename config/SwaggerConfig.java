package com.arma.uetds_boot.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@Configuration
public class SwaggerConfig  extends WebMvcConfigurationSupport {
	 @Bean
	    public Docket productApi(){
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.arma.uetds_boot"))
	                
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(apiEndPointsInfo())
	                .securitySchemes(Arrays.asList(apiKey()));
	    }

	    private ApiInfo apiEndPointsInfo() {
	        return new ApiInfoBuilder()
	                .title("Arma Yazılım UETDS Basit Yol REST API")
	                .version("1.0.0")
	                
	                .build();
	    }
	    @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	      registry.addRedirectViewController("/doc/v2/api-docs", "/v2/api-docs").setKeepQueryParams(true);
	      registry.addRedirectViewController("/doc/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
	      registry.addRedirectViewController("/doc/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
	      registry.addRedirectViewController("/doc/swagger-resources", "/swagger-resources");
	    }

	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	      registry.addResourceHandler("/doc/**").addResourceLocations("classpath:/META-INF/resources/");
	    }

	    private SecurityScheme apiKey(){
	        return new ApiKey("Bearer", "Authorization", "header");
	    }
}
