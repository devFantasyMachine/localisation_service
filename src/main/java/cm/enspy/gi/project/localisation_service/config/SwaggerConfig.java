package cm.enspy.gi.project.localisation_service.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
// import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
// import io.swagger.v3.oas.annotations.info.Contact;
// import io.swagger.v3.oas.annotations.info.Info;
// import io.swagger.v3.oas.annotations.info.License;
// import io.swagger.v3.oas.annotations.security.SecurityScheme;
// import io.swagger.v3.oas.annotations.servers.Server; 
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
 

 

@Configuration
/* @OpenAPIDefinition(
  info =@Info(
    title = "User Service API",
    version = "${api.version:1.0}",
    contact = @Contact(
      name = "FantasyMachine", email = "devFantasyMmachine@gmail.com", url = "mailto:devFantasyMmachine@gmail.com"
    ),
    license = @License(
      name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
    ),
    termsOfService = "${tos.uri:http://localhost:8888}",
    description = "${api.description:User Service}"
  ),
  servers = @Server(
    url = "${api.server.url:http://localhost:8888}",
    description = "Production"
  )
)
@SecurityScheme(
  name = "Bearer Authorization",
  type = SecuritySchemeType.HTTP,
  bearerFormat = "JWT",
  scheme = "bearer"
)  */
public class SwaggerConfig {
 
  private ApiInfo apiInfo() {
    return new ApiInfo("Localisation Service Rest APIs",
            "APIs for Localisation Service .",
            "1.0",
            "Terms of service",
            new Contact("FantasyMachine", "4gi.enspy.cm", "devFantasyMmachine@gmail.com"),
            "ISC",
            "API license URL",
            Collections.emptyList());
}

@Bean
public Docket api() {
    return new Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            //.securityContexts(Arrays.asList(securityContext()))
            //.securitySchemes(Arrays.asList(apiKey()))
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
}

private ApiKey apiKey() {
    return new ApiKey("Authorization", "JWT", "header");
}

private SecurityContext securityContext() {
    return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .build();
}

List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope
            = new AuthorizationScope("global" , "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
}
 
}