/*
 * Archivo: ProyectoIface.java
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
package co.com.grupoasd.prueba.activos.activosfijos.service;

import co.com.grupoasd.prueba.activos.activosfijos.entity.Proyecto;
import java.util.List;

/**
 * Interfaz para realizar las transacciones de los Proyectos.
 *
 * @author Diego Alejandro Rojas Suárez drojas@grupoasd.com
 */
public interface ProyectoIface {
    List<Proyecto> obtenerProyectos();
}
