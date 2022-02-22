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
import mx.com.ga.cosmonaut.catalogs.service.CsActividadEconomicaService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

@Controller("/catalogo/csActividadEconomica")
public class CsActividadEconomicaController {


    @Inject
    private CsActividadEconomicaService csActividadEconomicaService ;

    @Operation(summary = "${cosmonaut.controller.csActividadEconomica.findAll.resumen}",
            description = "${cosmonaut.controller.csActividadEconomica.findAll.descripcion}",
            operationId = "csActividadEconomica.findAll")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Actividad Economica - Listar Todos")
    @Get(value = "/listar/todos", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findAll() {
        try {
            return HttpResponse.ok(csActividadEconomicaService.findAll());
        } catch (Exception e) {

            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.csActividadEconomica.findById.resumen}",
            description = "${cosmonaut.controller.csActividadEconomica.findById.descripcion}",
            operationId = "csActividadEconomica.findById")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Actividad Economica - Obtener por ID")
    @Get(value = "/obtener/id/{id}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findById(@NotBlank @PathVariable Integer id) {
        try {
            return HttpResponse.ok(csActividadEconomicaService.findById(id));
        } catch (Exception e) {

            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.csActividadEconomica.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.csActividadEconomica.findByEsActivo.descripcion}",
            operationId = "csActividadEconomica.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Actividad Economica - Obtener por Estatus")
    @Get(value = "/obtener/todos/{estatus}/{nivel}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@NotBlank @PathVariable Boolean estatus, Integer nivel) {
        try {
            return HttpResponse.ok(csActividadEconomicaService.findByEsActivo(estatus, nivel));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }
    
    @Operation(summary = "${cosmonaut.controller.csActividadEconomica.findByEsActivoSector.resumen}",
            description = "${cosmonaut.controller.csActividadEconomica.findByEsActivoSector.descripcion}",
            operationId = "csActividadEconomica.findByEsActivoSector")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Actividad Economica - Obtener por Nivel")
    @Get(value = "/obtener/todos/{estatus}/{nivel}/{sector}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@NotBlank @PathVariable Boolean estatus, Integer nivel, Integer sector) {
        try {
            return HttpResponse.ok(csActividadEconomicaService.findByEsActivo(estatus, nivel, sector));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.csActividadEconomica.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.csActividadEconomica.findByEsActivo.descripcion}")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Actividad Economica - Obtener activo/inactivo.")
    @Get(value = "/listar/todosActivo/{activo}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@PathVariable Boolean activo) {
        try {
            return HttpResponse.ok(csActividadEconomicaService.findByEsActivo(activo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }
}
