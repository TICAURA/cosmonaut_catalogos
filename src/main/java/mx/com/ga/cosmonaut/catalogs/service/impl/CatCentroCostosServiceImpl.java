
package mx.com.ga.cosmonaut.catalogs.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;
import mx.com.ga.cosmonaut.common.repository.catalogo.negocio.CatCentroCostosRepository;
import mx.com.ga.cosmonaut.catalogs.service.CatCentroCostosService;
import mx.com.ga.cosmonaut.common.entity.catalogo.negocio.*;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.util.Constantes;




@Singleton
public class CatCentroCostosServiceImpl implements CatCentroCostosService {

    private RespuestaGenerica respuesta = new RespuestaGenerica();

    @Inject
    private CatCentroCostosRepository catCentroCostosRepository;

    @Override
    public RespuestaGenerica findAll() throws ServiceException {
        try {

            respuesta.setDatos(catCentroCostosRepository.findAll());
            respuesta.setMensaje(Constantes.EXITO);
            respuesta.setResultado(Constantes.RESULTADO_EXITO);
            return respuesta;
        } catch (Exception e) {

            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findAll " + Constantes.ERROR_EXCEPCION, e);
        }

    }

    public RespuestaGenerica findById(Long centroCostosId) throws ServiceException {
        try {

            respuesta.setDatos(catCentroCostosRepository.findById(centroCostosId).orElse(new CatCentroCostos()));
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
            respuesta.setDatos(catCentroCostosRepository.findByEsActivoOrderByDescripcion(activo));
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }
}
