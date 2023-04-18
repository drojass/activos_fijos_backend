/*
 * Archivo: ActivosfijosApplication.java
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
package co.com.grupoasd.prueba.activos.activosfijos;

import java.time.Instant;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@SpringBootApplication
public class ActivosfijosApplication {
    private static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone("America/Bogota");
    @Autowired
    BuildProperties buildProperties;

    @PostConstruct
    public void init() {
        TimeZone.setDefault(DEFAULT_TIME_ZONE);
        log.info("Spring boot application running in UTC timezone :" + new Date());
    }

    public static void main(String[] args) {
        SpringApplication.run(ActivosfijosApplication.class, args);
    }

    /**
     * Definición del Bean que permite realizar la conexión a otros servicios.
     * RestFull
     *
     * @return rest template.
     */
    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

    /**
     * Servicio rest que permite consultar las propiedades del proyecto.
     *
     * @return BuildProperties
     */
    @GetMapping(value = "/about", produces = "application/json")
    public Properties about() {
        Properties prop = new Properties();
        /*
         * need to explicitly loop over all entries, just returning the
         * BuildProperties object only contains the specific fields (artificact,
         * group, name, time and version)
         */
        buildProperties.forEach(entry -> prop.put(entry.getKey(), entry.getValue()));
        //proper date formatting for time
        prop.put("time", Instant.ofEpochMilli(Long.parseLong(prop.getProperty("time"))).toString());
        return prop;
    }

}
