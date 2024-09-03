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

import static com.topia.epdms.constant.EpdmsConstant.OpenApi.*;

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
        empdmsLocalServer.setDescription(DEV_ENVIRONMENT_DESCRIPTION);

        Server devServer = new Server();
        devServer.setUrl(swaggerDevUri);
        devServer.setDescription(PROD_ENVIRONMENT_DESCRIPTION);


        Contact contact = new Contact();
        contact.setEmail(TOPIA_EMAIL);
        contact.setName(COMPANY_NAME);
        contact.setUrl(ENTITY_URL);

        License mitLicense = new License().name(COMPANY_NAME+LICENCE).url(ENTITY_URL);

        Info info = new Info()
                .title(EPDMS_SERVICE_DESCRIPTION)
                .version("1.0")
                .contact(contact)
                .description(OPEN_API_DESCRIPTION).termsOfService(ENTITY_URL)
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(empdmsLocalServer,devServer));
    }
}
