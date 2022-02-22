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
import mx.com.ga.cosmonaut.catalogs.service.CsRegimenFiscalService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

@Controller("/catalogo/csRegimenFiscal")
public class CsRegimenFiscalController {

    @Inject
    private CsRegimenFiscalService csRegimenFiscalService;

    @Operation(summary = "${cosmonaut.controller.csRegimenFiscal.findAll.resumen}",
            description = "${cosmonaut.controller.csRegimenFiscal.findAll.descripcion}",
            operationId = "csRegimenFiscal.findAll")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Régimen Fiscal - Listar todos")
    @Get(value = "/listar/todos", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findAll() {
        try {
            return HttpResponse.ok(csRegimenFiscalService.findAll());
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.csRegimenFiscal.findById.resumen}",
            description = "${cosmonaut.controller.csRegimenFiscal.findById.descripcion}",
            operationId = "csRegimenFiscal.findById")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Régimen Fiscal - Obtener por ID")
    @Get(value = "/obtener/id/{idRegimen}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findById(@NotBlank @PathVariable String idRegimen) {
        try {

            return HttpResponse.ok(csRegimenFiscalService.findById(idRegimen));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }
    
     @Operation(summary = "${cosmonaut.controller.csRegimenFiscal.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.csRegimenFiscal.findByEsActivo.descripcion}",
             operationId = "csRegimenFiscal.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Régimen Fiscal - Listar Todos activo/inactivo")
    @Get(value = "/listar/todosActivo/{activo}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@PathVariable Boolean activo) {
        try {
            return HttpResponse.ok(csRegimenFiscalService.findEsActivo(activo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

}