
package mx.com.ga.cosmonaut.catalogs.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import mx.com.ga.cosmonaut.common.repository.catalogo.ubicacion.CatNacionalidadRepository;
import mx.com.ga.cosmonaut.catalogs.service.CatNacionalidadService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.entity.catalogo.ubicacion.CatNacionalidad;

import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.util.Constantes;


@Singleton
public class CatNacionalidadServiceImpl implements CatNacionalidadService {

    private RespuestaGenerica respuesta = new RespuestaGenerica();

    @Inject
    private CatNacionalidadRepository catNacionalidadRepository;

    @Override
    public RespuestaGenerica findAll() throws ServiceException {
        try {
            respuesta.setDatos(catNacionalidadRepository.findAll());
            respuesta.setMensaje(Constantes.EXITO);
            respuesta.setResultado(Constantes.RESULTADO_EXITO);
            return respuesta;
        } catch (Exception e) {

            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findAll " + Constantes.ERROR_EXCEPCION, e);
        }

    }

    public RespuestaGenerica findById(Long idNacionalidad) throws ServiceException {
        try {

            respuesta.setDatos(catNacionalidadRepository.findById(idNacionalidad).orElse(new CatNacionalidad()));
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {

            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findById " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    @Override
    public RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException {
        try {
            RespuestaGenerica response = new RespuestaGenerica();
            response.setDatos(catNacionalidadRepository.findByEsActivoOrderByDescripcion(activo));
            response.setResultado(true);
            response.setMensaje(Constantes.EXITO);
            return response;
        } catch (Exception e) {

            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }
}
