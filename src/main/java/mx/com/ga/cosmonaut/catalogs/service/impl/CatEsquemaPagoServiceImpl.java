
package mx.com.ga.cosmonaut.catalogs.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;
import mx.com.ga.cosmonaut.common.repository.catalogo.negocio.CatEsquemaPagoRepository;
import mx.com.ga.cosmonaut.catalogs.service.CatEsquemaPagoService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.entity.catalogo.negocio.CatEsquemaPago;
import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.util.Constantes;




@Singleton
public class CatEsquemaPagoServiceImpl implements CatEsquemaPagoService {

    private RespuestaGenerica respuesta = new RespuestaGenerica();

    @Inject
    private CatEsquemaPagoRepository catEsquemaPagoRepository;

    @Override
    public RespuestaGenerica findAll() throws ServiceException {
        try {

            respuesta.setDatos(catEsquemaPagoRepository.findAll());
            respuesta.setMensaje(Constantes.EXITO);
            respuesta.setResultado(Constantes.RESULTADO_EXITO);
            return respuesta;
        } catch (Exception e) {

            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findAll " + Constantes.ERROR_EXCEPCION, e);
        }

    }

    public RespuestaGenerica findById(Long esquemaPagoId) throws ServiceException {
        try {

            respuesta.setDatos(catEsquemaPagoRepository.findById(esquemaPagoId).orElse(new CatEsquemaPago()));
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
            respuesta.setDatos(catEsquemaPagoRepository.findByEsActivoOrderByDescripcion(activo));
            respuesta.setMensaje(Constantes.EXITO);
            respuesta.setResultado(Constantes.RESULTADO_EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }
}
