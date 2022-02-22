
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
import mx.com.ga.cosmonaut.catalogs.service.CatAsentamientoService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.util.Utilidades;

@Controller("/catalogo/catAsentamiento")
public class CatAsentamientoController {

    @Inject
    private CatAsentamientoService catAsentamientoService;


    @Operation(summary = "${cosmonaut.controller.CatAsentamiento.findById.resumen}",
            description = "${cosmonaut.controller.CatAsentamiento.findById.descripcion}",
            operationId = "CatAsentamiento.findById")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Asentamiento - Obtener por c\u00f3digo")
    @Get(value = "/obtener/codigo/{codigo}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByCodigoAndEsActivo(@NotBlank @PathVariable String codigo) {
        try {
            return HttpResponse.ok(catAsentamientoService.findByCodigoAndEsActivo(codigo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.CatAsentamiento.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.CatAsentamiento.findByEsActivo.descripcion}",
            operationId = "CatAsentamiento.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Asentamiento - Obtener por activo/inactivo.")
    @Get(value = "/listar/todosActivo/{activo}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@NotBlank @PathVariable Boolean activo) {
        try {
            return HttpResponse.ok(catAsentamientoService.findByEsActivo(activo));
        } catch (Exception e) {
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

}
