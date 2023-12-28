/*
 * Archivo: ObjActivoFijo.java
 * Fecha: 2023-12-19
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
package co.com.grupoasd.prueba.activos.activosfijos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import lombok.Data;


/**
 * Modelo que representa la estructura Json para los estados.
 *
 * @author Diego Alejandro Rojas Siárez drojas@grupoasd.com
 */
@Data
public class ObjEstado {

    /**
     * Campo idEstado de la tabla.
     */
    @JsonProperty("idEstado")
    private Integer idEstado;

    /**
     * Campo descripción de la tabla.
     */
    @JsonProperty("descripcion")
    private String descripcion;

    /**
     * Retorna un json string de la clase.
     *
     */
    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
