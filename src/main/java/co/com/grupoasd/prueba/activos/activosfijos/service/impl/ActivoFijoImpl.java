/*
 * Archivo: ActivoFijoImpl.java
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
package co.com.grupoasd.prueba.activos.activosfijos.service.impl;

import co.com.grupoasd.prueba.activos.activosfijos.entity.ActivoFijo;
import co.com.grupoasd.prueba.activos.activosfijos.handler.ActivoFijoHandler;
import co.com.grupoasd.prueba.activos.activosfijos.service.ActivoFijoIface;
import java.util.List;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

/**
 * Servicio para realizar las transacciones de Activos Fijos.
 *
 * @author Diego Alejandro Rojas Suárez drojas@grupoasd.com
 */
@Service
@AllArgsConstructor
public class ActivoFijoImpl implements ActivoFijoIface {
    
    private final ActivoFijoHandler activoFijoHandler;
    
    /**
     * Método para obtener el listado de los activos.
     *
     * @return List ActivoFijo.
     */
    @Override
    public List<ActivoFijo> obtenerActivos() {
        return activoFijoHandler.obtenerActivos();
    }

    /**
     * Método para obtener un activo por su ID.
     *
     * @return ActivoFijo.
     */
    @Override
    public ActivoFijo obtenerActivo(ObjectId id) {
        return activoFijoHandler.obtenerActivo(id);
    }

    /**
     * Método para crear el activo fijo.
     *
     * @param activoFijo activo a insertar.
     * @return ActivoFijo
     */
    @Override
    public ActivoFijo crearActivo(ActivoFijo activoFijo) {
        return activoFijoHandler.crearActivo(activoFijo);
    }
}
