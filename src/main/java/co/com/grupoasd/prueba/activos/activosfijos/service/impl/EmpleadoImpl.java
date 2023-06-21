/*
 * Archivo: EmpleadoImpl.java
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
package co.com.grupoasd.prueba.activos.activosfijos.service.impl;

import co.com.grupoasd.prueba.activos.activosfijos.entity.Empleado;
import co.com.grupoasd.prueba.activos.activosfijos.handler.EmpleadoHandler;
import co.com.grupoasd.prueba.activos.activosfijos.service.EmpleadoIface;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Servicio para realizar las transacciones de los Empleados.
 *
 * @author Diego Alejandro Rojas Suárez drojas@grupoasd.com
 */
@Service
@AllArgsConstructor
public class EmpleadoImpl implements EmpleadoIface {
    
    private final EmpleadoHandler empleadoHandler;
    
    /**
     * Método para obtener la lista de los empleados.
     *
     * @return List Empleado.
     */
    @Override
    public List<Empleado> obtenerEmpleados() {
        return empleadoHandler.obtenerEmpleados();
    }
}
