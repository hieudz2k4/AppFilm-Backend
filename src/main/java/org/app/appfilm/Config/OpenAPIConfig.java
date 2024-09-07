package org.app.appfilm.Config;

import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI config() {
    return new OpenAPI().info(new Info()
                                  .title("APP_FILM_BACKEND API DOCUMENT")
                                  .version("v1")
                                  .description("Dev Enviroment")
                                  .license(null))
                        .servers(List.of(new Server()
                                  .url("https://localhost:8081")
                                  .description("DEV_ENV")));
  }

  @Bean
  public GroupedOpenApi groupUserAPI() {
    return setGroupAPI("user_api", "/api/v1/users/**");
  }

  @Bean
  public GroupedOpenApi groupMovieAPI() {
    return setGroupAPI("movie_api", "/api/v1/movies/**");
  }


  private GroupedOpenApi setGroupAPI(String groupName, String... pathsToMatch) {
    return GroupedOpenApi
        .builder()
        .group(groupName)
        .packagesToScan("org.app.appfilm.Controller")
        .pathsToMatch(pathsToMatch)
        .build();
  }
}
