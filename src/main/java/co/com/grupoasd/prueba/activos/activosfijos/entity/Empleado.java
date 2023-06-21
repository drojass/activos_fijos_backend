/*
 * Archivo: Empleado.java
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
package co.com.grupoasd.prueba.activos.activosfijos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entidad para la colección de Empleados.
 *
 * @author Diego Alejandro Rojas Suárez drojas@grupoasd.com
 */
@Document(collection = "EMPLEADO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    @Id
    private Integer id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private Ubicacion ubicacionId;
    private Boolean activo;
}
