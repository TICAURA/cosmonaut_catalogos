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
import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import mx.com.ga.cosmonaut.catalogs.service.CsPeriodicidadPagoService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

@Controller("/catalogo/csPeriodicidadPago")
public class CsPeriodicidadPagoController {

    @Inject
    private CsPeriodicidadPagoService csPeriodicidadPagoService;

    @Operation(summary = "${cosmonaut.controller.csPeriodicidadPago.findAll.resumen}",
            description = "${cosmonaut.controller.csPeriodicidadPago.findAll.descripcion}",
            operationId = "csPeriodicidadPago.findAl")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Periodicidad Pago - Listar todos")
    @Get(value = "/listar/todos", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findAll() {
        try {
            return HttpResponse.ok(csPeriodicidadPagoService.findAll());
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.csPeriodicidadPago.findById.resumen}",
            description = "${cosmonaut.controller.csPeriodicidadPago.findById.descripcion}",
            operationId = "csPeriodicidadPago.findById")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Periodicidad Pago - Obtener por ID")
    @Get(value = "/obtener/id/{idPeriodicidad}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findById(@NotBlank @PathVariable String idPeriodicidad) {
        try {

            return HttpResponse.ok(csPeriodicidadPagoService.findById(idPeriodicidad));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

     @Operation(summary = "${cosmonaut.controller.csPeriodicidadPago.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.csPeriodicidadPago.findByEsActivo.descripcion}",
            operationId = "csPeriodicidadPago.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Periodicidad Pago - Obtener por activo/inactivo.")
    @Get(value = "/listar/todosActivo/{activo}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@PathVariable Boolean activo) {
        try {
            return HttpResponse.ok(csPeriodicidadPagoService.findByEsActivo(activo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

}
