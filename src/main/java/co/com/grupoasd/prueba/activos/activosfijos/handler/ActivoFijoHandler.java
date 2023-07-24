/*
 * Archivo: ActivoFijoHandler.java
 * Fecha: 2022-04-19
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

import co.com.grupoasd.prueba.activos.activosfijos.entity.ActivoFijo;
import co.com.grupoasd.prueba.activos.activosfijos.repository.ActivoFijoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

/**
 * Manejador para realizar las transacciones de Activos Fijos.
 *
 * @author Diego Alejandro Rojas Suárez drojas@grupoasd.com
 */
@Component
@Slf4j
@AllArgsConstructor
public class ActivoFijoHandler {

    private final ActivoFijoRepository activoFijoRepository;

    /**
     * Método que obtiene la lista de los activos fijos.
     *
     * @return List ActivoFijo.
     */
    public List<ActivoFijo> obtenerActivos() {
        return activoFijoRepository.findAll();
    }

    /**
     * Método para obtener el activo por su ID.
     *
     * @param id id del activo.
     * @return ActivoFijo.
     */
    public ActivoFijo obtenerActivo(ObjectId id) {
        return activoFijoRepository.findById(id).get();
    }

    /**
     * Método que crea los activos fijos.
     *
     * @param activoFijo activo a insertar.
     * @return ActivoFijo.
     */
    public ActivoFijo crearActivo(ActivoFijo activoFijo) {
        return activoFijoRepository.save(activoFijo);
    }


}
