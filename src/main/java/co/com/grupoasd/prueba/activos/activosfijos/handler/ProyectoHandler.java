/*
 * Archivo: ProyectoHandler.java
 * Fecha: 2022-06-20
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
package co.com.grupoasd.prueba.activos.activosfijos.handler;

import co.com.grupoasd.prueba.activos.activosfijos.entity.Proyecto;
import co.com.grupoasd.prueba.activos.activosfijos.entity.Ubicacion;
import co.com.grupoasd.prueba.activos.activosfijos.repository.ProyectoRepository;
import co.com.grupoasd.prueba.activos.activosfijos.repository.UbicacionRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Component;

/**
 * Manejador para realizar las transacciones de los Empleados.
 *
 * @author Diego Alejandro Rojas Suárez drojas@grupoasd.com
 */
@Component
@Slf4j
@AllArgsConstructor
public class ProyectoHandler {

    private final ProyectoRepository proyectoRepository;

    private final UbicacionRepository ubicacionRepository;

    private final MongoTemplate mongoTemplate;

    /**
     * Método para obtener los proyectos.
     * @return List Proyecto
     */
    public List<Proyecto> obtenerProyectos() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("UBICACION")
                .localField("ubicacionId")
                .foreignField("_id")
                .as("ubicacionId");

        TypedAggregation<Proyecto> aggregation = Aggregation.newAggregation(Proyecto.class, lookupOperation);

        List<Proyecto> proyectoList = mongoTemplate.aggregate(aggregation, Proyecto.class).getMappedResults();

        for (Proyecto proyecto: proyectoList) {
            if (proyecto.getUbicacionId() != null) {
                Optional<Ubicacion> ubicacion = ubicacionRepository.findById(proyecto.getUbicacionId());
                proyecto.setUbicacion(ubicacion.get());
            }
        }
        return proyectoList;
    }
}
