package al.ikubinfo.healthometer;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Lists;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StopWatch;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Slf4j
public class SwaggerConfig {

  @Value(value = "${swagger.enabled}")
  private Boolean swaggerEnabled;

  @Autowired private TypeResolver typeResolver;

  @Bean
  protected Docket apiDocket() {
    StopWatch watch = new StopWatch();
    watch.start();
    val docket =
        new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .securitySchemes(Lists.newArrayList(apiKey()))
            .securityContexts(Arrays.asList(securityContext()))
            .forCodeGeneration(true)
            .enable(swaggerEnabled)
            .ignoredParameterTypes(Pageable.class)
            .alternateTypeRules(
                newRule(
                    typeResolver.resolve(List.class, LocalDate.class),
                    typeResolver.resolve(List.class, String.class),
                    Ordered.HIGHEST_PRECEDENCE),
                newRule(
                    typeResolver.resolve(List.class, LocalDateTime.class),
                    typeResolver.resolve(List.class, String.class),
                    Ordered.HIGHEST_PRECEDENCE))
            .select()
            .apis(RequestHandlerSelectors.basePackage("al.ikubinfo.healthometer"))
            .paths(PathSelectors.any())
            .build();
    watch.stop();
    log.info("Started Swagger in {} ms", watch.getTotalTimeMillis());
    return docket;
  }

  private ApiKey apiKey() {
    return new ApiKey("apiKey", "Authorization", "header");
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences(defaultAuth())
        .forPaths(PathSelectors.any())
        .build();
  }

  private List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Arrays.asList(new SecurityReference("apiKey", authorizationScopes));
  }

  // Setting up api information
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Healthometer API 1.0.1")
        .description("Swagger Documentation")
        .version("2.0.0")
        .build();
  }

  @Bean
  public SecurityConfiguration security() {
    return SecurityConfigurationBuilder.builder()
        .scopeSeparator(",")
        .additionalQueryStringParams(null)
        .useBasicAuthenticationWithAccessCodeGrant(false)
        .build();
  }

  protected SwaggerResource swaggerResource(String name, String location, String version) {
    SwaggerResource swaggerResource = new SwaggerResource();
    swaggerResource.setName(name);
    swaggerResource.setLocation(location);
    swaggerResource.setSwaggerVersion(version);
    return swaggerResource;
  }
}
