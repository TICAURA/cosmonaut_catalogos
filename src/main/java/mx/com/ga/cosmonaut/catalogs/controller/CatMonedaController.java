
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
import mx.com.ga.cosmonaut.catalogs.service.CatMonedaService;
import mx.com.ga.cosmonaut.common.util.Utilidades;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;

@Controller("/catalogo/moneda")
public class CatMonedaController {

    @Inject 
    private  CatMonedaService catMonedaService;
    
     @Operation(summary = "${cosmonaut.controller.CatMoneda.findAll.resumen}",
             description = "${cosmonaut.controller.CatMoneda.findAll.descripcion}",
             operationId = "CatMoneda.findAll")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Moneda - Listar Todos")
    @Get(value = "/listar/todos",produces = MediaType.APPLICATION_JSON,consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findAll(){
        try {
            return HttpResponse.ok(catMonedaService.findAll());
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.CatMoneda.findById.resumen}",
            description = "${cosmonaut.controller.CatMoneda.findById.descripcion}",
            operationId = "CatMoneda.findById")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Moneda - Obtener por ID")
    @Get(value = "/obtener/id/{id}",consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findById(@NotBlank @PathVariable Long id){
        try {
            return HttpResponse.ok(catMonedaService.findByMonedaId(id));
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${cosmonaut.controller.CatMoneda.findByEsActivo.resumen}",
            description = "${cosmonaut.controller.CatMoneda.findByEsActivo.descripcion}",
            operationId = "CatMoneda.findByEsActivo")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Catálogo Moneda - Listar Todos activo/inactivo.")
    @Get(value = "/listar/todosActivo/{activo}",produces = MediaType.APPLICATION_JSON,consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> findByEsActivo(@PathVariable Boolean activo){
        try {
            return HttpResponse.ok(catMonedaService.findByEsActivo(activo));
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }
       
}
