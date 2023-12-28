/*
 * Archivo: SwaggerConfig.java
 * Fecha: 2023-04-17
 * Todos los derechos de propiedad intelectual e industrial sobre esta
 * aplicacion son de propiedad exclusiva del GRUPO ASD S.A.S.
 * Su uso, alteracion, reproduccion o modificacion sin el debido
 * consentimiento por escrito de GRUPO ASD S.A.S. quedan totalmente prohibidos.
 *  
 * Este programa se encuentra protegido por las disposiciones de la
 * Ley 23 de 1982 y demas normas concordantes sobre derechos de autor y
 * propiedad intelectual. Su uso no autorizado dara lugar a las sanciones
 * previstas en la Ley.
 */
package co.com.grupoasd.prueba.activos.activosfijos.config;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Bean qué instancia la configuración de Swagger.
 *
 * @author Diego Alejandro Rojas Suárez drojasm@grupoasd.com
 */
@Configuration
public class SwaggerConfig {

    @Value("${application.contact.name}")
    private String contactName;
    @Value("${application.contact.url}")
    private String contactUrl;
    @Value("${application.contact.email}")
    private String contactEmail;
    @Value("${application.info.api.title}")
    private String infoApiTitle;
    @Value("${application.info.api.description}")
    private String infoApiDescription;
    @Value("${application.info.api.version}")
    private String infoApiVersion;
    @Value("${application.info.api.termsOfServiceUrl}")
    private String infoApiTermOfServiceUrl;
    @Value("${application.info.api.license}")
    private String infoApiLicense;
    @Value("${application.info.api.licenseUrl}")
    private String infoApiLicenseUrl;

    /**
     * Bean de clase.
     *
     * @return docket.
     */
    @Bean
    public Docket api(BuildProperties buildProperties) {
        infoApiTitle = buildProperties.getName() + " - " + infoApiTitle;
        infoApiVersion = buildProperties.getVersion();
        Contact defaultConcat = new Contact(contactName, contactUrl, contactEmail) {
        };

        ApiInfo defaultApiInfo = new ApiInfo(infoApiTitle, infoApiDescription, infoApiVersion, infoApiTermOfServiceUrl,
                defaultConcat, infoApiLicense, infoApiLicenseUrl, new ArrayList<>());

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(defaultApiInfo);
    }
}
