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
import mx.com.ga.cosmonaut.catalogs.service.CatTipoDescuentoInfonavitService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

@Controller("/catalogo/catTipoDescuentoInfonavit")
public class CatTipoDescuentoInfonavitController {

   
    @Inject
    private CatTipoDescuentoInfonavitService catTipoDescuentoInfonavitService ;

    @Operation(summary = "${cosmonaut.controller.catTipoDescuentoInfonavit.findAll.resumen}",
            description = "${cosmonaut.controller.catTipoDescuentoInfonavit.findAll.descripcion}",
            operationId = "catTipoDescuentoInfonavit.findAll")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Tipo Descuento Infonavit - Listar Todos")
    @Get(value = "/listar/todos", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findAll() {
        try {
            return HttpResponse.ok(catTipoDescuentoInfonavitService.findAll());
        } catch (Exception e) {
            
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.catTipoDescuentoInfonavit.findById.resumen}",
            description = "${cosmonaut.controller.catTipoDescuentoInfonavit.findById.descripcion}",
            operationId = "catTipoDescuentoInfonavit.findById")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Tipo Descuento Infonavit - Obtener por ID")
    @Get(value = "/obtener/id/{id}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findById(@NotBlank @PathVariable Integer id) {
        try {
            return HttpResponse.ok(catTipoDescuentoInfonavitService.findById(id));
        } catch (Exception e) {
            
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.catTipoDescuentoInfonavit.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.catTipoDescuentoInfonavit.findByEsActivo.descripcion}",
            operationId = "catTipoDescuentoInfonavit.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Tipo Descuento Infonavit - Listar Todos activo/inactivo")
    @Get(value = "/listar/todosActivo/{activo}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@PathVariable Boolean activo) {
        try {
            return HttpResponse.ok(catTipoDescuentoInfonavitService.findEsActivo(activo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }
}