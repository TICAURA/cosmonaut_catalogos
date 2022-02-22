package mx.com.ga.cosmonaut.catalogs.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.com.ga.cosmonaut.catalogs.service.CatProveedorDispersionService;
import mx.com.ga.cosmonaut.catalogs.service.CatProveedorTimbradoService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

import javax.inject.Inject;

@Controller("/proveedor-timbrado")
public class CatProveedorTimbradoController {

    @Inject
    private CatProveedorTimbradoService catProveedorTimbradoService;

    @Operation(summary = "${cosmonaut.controller.proveedortimbrado.listar.resumen}",
            description = "${cosmonaut.controller.proveedortimbrado.listar.descripcion}",
            operationId = "proveedortimbrado.listar")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Proveedor Timbrado - Listar Todos")
    @Get(value = "/listar/todos", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> listar() {
        try {
            return HttpResponse.ok(catProveedorTimbradoService.listar());
        } catch (Exception e) {

            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }
}
