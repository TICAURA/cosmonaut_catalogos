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
import mx.com.ga.cosmonaut.catalogs.service.CatBasePeriodoService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades; 

@Controller("/catalogo/catBasePeriodo")
public class CatBasePeriodoController {

    @Inject
    private CatBasePeriodoService catBasePeriodoService;

    @Operation(summary = "${cosmonaut.controller.catBasePeriodo.findAll.resumen}",
            description = "${cosmonaut.controller.catBasePeriodo.findAll.descripcion}",
            operationId = "catBasePeriodo.findAll")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Base Periódo - Listar todos")
    @Get(value = "/listar/todos", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findAll() {
        try {
            return HttpResponse.ok(catBasePeriodoService.findAll());
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.catBasePeriodo.findById.resumen}",
            description = "${cosmonaut.controller.catBasePeriodo.findById.descripcion}",
            operationId = "catBasePeriodo.findById")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Base Periódo - Obtener por ID")
    @Get(value = "/obtener/id/{idBase}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findById(@NotBlank @PathVariable Integer idBase) {
        try {

            return HttpResponse.ok(catBasePeriodoService.findById(idBase));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }
	

    @Operation(summary = "${cosmonaut.controller.catBasePeriodo.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.catBasePeriodo.findByEsActivo.descripcion}",
            operationId = "catBasePeriodo.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Base Periódo - Obtener por activo/inactivo.")
    @Get(value = "/listar/todosActivo/{activo}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@PathVariable Boolean activo) {
        try {
            return HttpResponse.ok(catBasePeriodoService.findByEsActivo(activo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }
}
