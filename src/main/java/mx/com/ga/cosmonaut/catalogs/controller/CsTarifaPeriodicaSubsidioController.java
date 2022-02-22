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
import mx.com.ga.cosmonaut.catalogs.service.CsTarifaPeriodicaSubsidioService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

import javax.inject.Inject;

@Controller("/catalogo/csTarifaPeriodicaSubsidio")
public class CsTarifaPeriodicaSubsidioController {

    @Inject
    private CsTarifaPeriodicaSubsidioService csTarifaPeriodicaSubsidioService;

    @Operation(summary = "${cosmonaut.controller.csTarifaPeriodicaSubsidio.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.csTarifaPeriodicaSubsidio.findByEsActivo.descripcion}",
            operationId = "csTarifaPeriodicaSubsidio.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Tarifa Periodica Subsidio - Listar Todos activo/inactivo.")
    @Get(value = "/listar/todosActivo/{activo}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@PathVariable Boolean activo) {
        try {
            return HttpResponse.ok(csTarifaPeriodicaSubsidioService.findByEsActivo(activo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }
}
