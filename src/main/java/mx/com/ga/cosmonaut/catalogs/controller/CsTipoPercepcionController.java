package mx.com.ga.cosmonaut.catalogs.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.com.ga.cosmonaut.catalogs.service.CsTipoPercepcionService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

import javax.inject.Inject;

@Controller("/catalogo/csTipoPercepcion")
public class CsTipoPercepcionController {

    @Inject
    private CsTipoPercepcionService csTipoPercepcionService;

    @Operation(summary = "${cosmonaut.controller.csTipoPercepcion.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.csTipoPercepcion.findByEsActivo.descripcion}",
            operationId = "csTipoPercepcion.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Tipo percepción - Listar todos activo/inactivo.")
    @Get(value = "/listar/todosActivo/{activo}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@PathVariable Boolean activo) {
        try {
            return HttpResponse.ok(csTipoPercepcionService.findByEsActivo(activo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.csTipoPercepcion.findByEsActivoPeriodicidad.resumen}",
            description = "${cosmonaut.controller.csTipoPercepcion.findByEsActivoPeriodicidad.descripcion}",
            operationId = "csTipoPercepcion.findByEsActivoPeriodicidad")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Tipo percepción - Listar todos activo/inactivo y tipoPeriodicidad.")
    @Get(value = "/listar/todosActivo/{activo}/{tipoPeriodicidad}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivoPeriodicidad(@PathVariable Boolean activo, String tipoPeriodicidad) {
        try {
            return HttpResponse.ok(csTipoPercepcionService.findByEsActivoPeriodicidad(activo,tipoPeriodicidad));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.csTipoPercepcion.findByPeriodicidadAndEditable.resumen}",
            description = "${cosmonaut.controller.csTipoPercepcion.findByPeriodicidadAndEditable.descripcion}")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @Tag(name = "Catálogo Tipo percepción - Listar todos activo/inactivo por tipoPeriodicidad y que sean editables.")
    @Get(value = "/listar/todosActivo/{activo}/{tipoPeriodicidad}/editables", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByPeriodicidadAndEditable(@PathVariable Boolean activo, String tipoPeriodicidad) {
        try {
            return HttpResponse.ok(csTipoPercepcionService.findByPeriodicidadAndEditable(activo,tipoPeriodicidad));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

}
