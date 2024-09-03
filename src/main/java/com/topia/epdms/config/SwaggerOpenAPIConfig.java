package com.topia.epdms.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerOpenAPIConfig {
    @Value("${epdms.openapi.local-url}")
    private String swaggerUri;

    @Value("${epdms.openapi.dev-url}")
    private String swaggerDevUri;

    @Bean
    public OpenAPI myOpenAPI() {
        Server empdmsLocalServer = new Server();
        empdmsLocalServer.setUrl(swaggerUri);
        empdmsLocalServer.setDescription("Server URL in Development environment");

        Server devServer = new Server();
        devServer.setUrl(swaggerDevUri);
        devServer.setDescription("Server URL in Production environment");


        Contact contact = new Contact();
        contact.setEmail("topia@sourcefuse.com");
        contact.setName("SourceFuse");
        contact.setUrl("https://www.sourcefuse.com/");

        License mitLicense = new License().name("SourceFuse License").url("https://www.sourcefuse.com/");

        Info info = new Info()
                .title("EPDMS Spring Reactive Service")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage EPDMS operations").termsOfService("https://www.sourcefuse.com/")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(empdmsLocalServer,devServer));
    }
}
