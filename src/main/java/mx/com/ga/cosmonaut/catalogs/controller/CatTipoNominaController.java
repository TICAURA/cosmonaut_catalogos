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
import mx.com.ga.cosmonaut.catalogs.service.CatTipoNominaService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

import javax.inject.Inject;

@Controller("/catalogo/tipoNomina")
public class CatTipoNominaController {

    @Inject
    private CatTipoNominaService catTipoNominaService;

    @Operation(summary = "${cosmonaut.controller.tipoNomina.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.tipoNomina.findByEsActivo.descripcion}",
            operationId = "tipoNomina.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Tipo Nómina - Listar Todos activo/inactivo.")
    @Get(value = "/listar/todosActivo/{activo}",produces = MediaType.APPLICATION_JSON,consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@PathVariable Boolean activo){
        try {
            return HttpResponse.ok(catTipoNominaService.findByEsActivo(activo));
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.tipoNominaAg.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.tipoNominaAg.findByEsActivo.descripcion}",
            operationId = "tipoNominaAg.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Tipo Nómina Aguinaldo - Listar Todos activo/inactivo para Aguinaldos.")
    @Get(value = "/aguinaldo/listar/todosActivo/{activo}",produces = MediaType.APPLICATION_JSON,consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivoAguinaldo(@PathVariable Boolean activo){
        try {
            return HttpResponse.ok(catTipoNominaService.findByEsActivoAguinaldo(activo));
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

}
