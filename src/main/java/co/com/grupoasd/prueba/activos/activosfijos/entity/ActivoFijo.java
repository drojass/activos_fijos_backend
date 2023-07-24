/*
 * Archivo: ActivoFijo.java
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

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entidad para la colección de Tipo de activos.
 *
 * @author Diego Alejandro Rojas Suárez drojas@grupoasd.com
 */
@Document(collection = "ACTIVO_FIJO")
@Data
@AllArgsConstructor
public class ActivoFijo {

    @Id
    private ObjectId id;
    private String nombre;
    private String descripcion;
    private List<SubActivo> subActivos;
    private String serial;
    private String placa;
    private String peso;
    private String alto;
    private String ancho;
    private String largo;
    private Integer valorCompra;
    private Date fechaCompra;
    private Date fechaBaja;
    private Integer tipoId;
    private Integer estadoId;
    private Boolean activo;

    public ActivoFijo() {
        this.activo = true;
        this.fechaCompra = new Date();
    }
}
