package mx.com.ga.cosmonaut.catalogs.service.impl;

import mx.com.ga.cosmonaut.catalogs.service.CsTipoOtroPagoService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.repository.catalogo.sat.CsTipoOtroPagoRepository;
import mx.com.ga.cosmonaut.common.util.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CsTipoOtroPagoServiceImpl implements CsTipoOtroPagoService {

    @Inject
    private CsTipoOtroPagoRepository csTipoOtroPagoRepository;
    private RespuestaGenerica respuestaGenerica = new RespuestaGenerica();

    @Override
    public RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException{
        try {
            respuestaGenerica.setDatos(csTipoOtroPagoRepository.findByEsActivoOrderByDescripcion(activo));
            respuestaGenerica.setMensaje(Constantes.EXITO);
            respuestaGenerica.setResultado(Constantes.RESULTADO_EXITO);
            return respuestaGenerica;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }
}
