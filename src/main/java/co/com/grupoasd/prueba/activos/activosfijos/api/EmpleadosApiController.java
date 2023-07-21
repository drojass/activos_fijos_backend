/*
 * Archivo: EmpleadosApiController.java
 * Fecha: 2022-05-20
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
package co.com.grupoasd.prueba.activos.activosfijos.api;

import co.com.grupoasd.prueba.activos.activosfijos.entity.Empleado;
import co.com.grupoasd.prueba.activos.activosfijos.entity.Estado;
import co.com.grupoasd.prueba.activos.activosfijos.service.EmpleadoIface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador de la api que realiza las transacciones de los empleados.
 *
 * @author Diego Alejandro Rojas Suárez drojas@grupoasd.com
 */
@RestController
@AllArgsConstructor
@Api(value = "empleados", tags = {"Empleados"})
@RequestMapping("${app.context-api}/empleados")
public class EmpleadosApiController {

    private final EmpleadoIface empleadoIface;

    /**
     * Servicio que retorna la lista de los empleados.
     *
     * @author Diego Alejandro Rojas Suárez drojas@grupoasd.com
     * @return ResponseEntity List Empleado.
     */
    @ApiOperation(
            value = "Método que retorna la lista de los empleados.",
            response = Empleado.class,
            notes = "Web Service destinado a la consulta de los empleados")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            code = 200,
                            message = "Respuesta exitosa del componente",
                            response = Estado.class),
                    @ApiResponse(
                            code = 400,
                            message = "Bad Request",
                            reference = "La solicitud realizada no cumple con las validaciones de datos implementada"),
                    @ApiResponse(
                            code = 403,
                            message = "Access Denied",
                            reference = "La petición debe llevar la cabecera Authorization con el token JWT"),
                    @ApiResponse(
                            code = 500,
                            message = "Error interno del servidor")
            }
    )
    @GetMapping(
            value = "/lista",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<List<Empleado>> obtenerEmpleados() {
        try {
            return new ResponseEntity<>(empleadoIface.obtenerEmpleados(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}