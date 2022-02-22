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
import mx.com.ga.cosmonaut.catalogs.service.CatEmisionService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

import javax.inject.Inject;

@Controller("/catalogo/catEmision")
public class CatEmisionController {

    @Inject
    private CatEmisionService catEmisionService;

    @Operation(summary = "${cosmonaut.controller.catEmision.listar.resumen}",
            description = "${cosmonaut.controller.catEmision.listar.descripcion}",
            operationId = "catEmision.listar")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo emision - Listar todos.")
    @Get(value = "/listar", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findAll() {
        try {
            return HttpResponse.ok(catEmisionService.findAll());
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.catEmision.listarTipoEmision.resumen}",
            description = "${cosmonaut.controller.catEmision.listarTipoEmision.descripcion}",
            operationId = "catEmision.listarTipoEmision")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo emision - Listar por tipo de mision.")
    @Get(value = "/listar/tipo/{idTipoEmision}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByIdTipoEmisionIdTipoEmision(@PathVariable Integer idTipoEmision) {
        try {
            return HttpResponse.ok(catEmisionService.findByIdTipoEmisionIdTipoEmision(idTipoEmision));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

}
