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
import mx.com.ga.cosmonaut.catalogs.service.CsTipoDeduccionService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

import javax.inject.Inject;

@Controller("/catalogo/csTipoDeduccion")
public class CsTipoDeduccionController {

    @Inject
    private CsTipoDeduccionService csTipoDeduccionService;

    @Operation(summary = "${cosmonaut.controller.csTipoDeduccion.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.csTipoDeduccion.findByEsActivo.descripcion}",
            operationId = "csTipoDeduccion.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Tipo Deducción - Listar todos activo/inactivo.")
    @Get(value = "/listar/todosActivo/{activo}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@PathVariable Boolean activo) {
        try {
            return HttpResponse.ok(csTipoDeduccionService.findByEsActivo(activo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.csTipoDeduccion.findByEsActivoAndEditable.resumen}",
            description = "${cosmonaut.controller.csTipoDeduccion.findByEsActivoAndEditable.descripcion}")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @Tag(name = "Catálogo Tipo Deducción - Listar todos activo/inactivo.")
    @Get(value = "/listar/todosActivo/{activo}/editables", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivoAndEditable(@PathVariable Boolean activo) {
        try {
            return HttpResponse.ok(csTipoDeduccionService.findByEsActivoAndEditable(activo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

}
