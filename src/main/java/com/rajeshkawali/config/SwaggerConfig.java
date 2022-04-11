/**
 * ------------------------------------------------------------------------------------------------
 * Change History: SwaggerConfig
 * 
 * Revision     Date              Developer            Comments
 * ------------------------------------------------------------------------------------------------
 * 1.0        06-April-2022       Rajesh_Kawali        Initial Commit
 * ------------------------------------------------------------------------------------------------
 * Copyright (c) 2022 Dell Technologies or its subsidiaries. All Rights Reserved.
 * This software contains the intellectual property of Dell Technologies or is licensed to
 * Dell Technologies from third parties. Use of this software and the intellectual property
 * contained therein is expressly limited to the terms and conditions of the License
 * Agreement under which it is provided by or on behalf of Dell Technologies.
 * ------------------------------------------------------------------------------------------------
 */
package com.rajeshkawali.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author Rajesh_Kawali
 * 
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
    public Docket configApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rajeshkawali"))
                .paths(PathSelectors.ant("/api/v1/**"))
                .build()
                .groupName("MyGroup")
                .apiInfo(apiInfo());
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring boot async service API")
				.description("Spring boot async service API reference for developer.")
				.license("Copyright (c) 2022 Rajesh or its subsidiaries. All Rights Reserved.")
				.version("1.0")
				.build();
	}
}