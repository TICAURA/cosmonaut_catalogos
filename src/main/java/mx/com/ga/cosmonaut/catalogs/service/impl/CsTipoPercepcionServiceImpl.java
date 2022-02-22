package mx.com.ga.cosmonaut.catalogs.service.impl;

import mx.com.ga.cosmonaut.catalogs.service.CsTipoPercepcionService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.entity.catalogo.sat.CsTipoPercepcion;
import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.repository.catalogo.sat.CsTipoPercepcionRepository;
import mx.com.ga.cosmonaut.common.util.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class CsTipoPercepcionServiceImpl implements CsTipoPercepcionService {

    @Inject
    private CsTipoPercepcionRepository csTipoPercepcionRepository;
    private RespuestaGenerica respuesta = new RespuestaGenerica();

    @Override
    public RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException {
        try {
            respuesta.setDatos(csTipoPercepcionRepository.findByEsActivo(activo));
            respuesta.setMensaje(Constantes.EXITO);
            respuesta.setResultado(Constantes.RESULTADO_EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    public RespuestaGenerica findByEsActivoPeriodicidad(Boolean activo, String tipoPeriodicidad) throws ServiceException {
        try {
            respuesta.setDatos(csTipoPercepcionRepository.obtieneTipoPercepcionEmpleado(activo, tipoPeriodicidad));
            respuesta.setMensaje(Constantes.EXITO);
            respuesta.setResultado(Constantes.RESULTADO_EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    @Override
    public RespuestaGenerica findByPeriodicidadAndEditable(Boolean activo, String tipoPeriodicidad) throws ServiceException {
        try {
            List<CsTipoPercepcion> tipos = csTipoPercepcionRepository
                    .obtieneTipoPercepcionEmpleado(activo, tipoPeriodicidad);
            tipos.removeIf(CsTipoPercepcion::isNoEditable);
            respuesta.setDatos(tipos);
            respuesta.setMensaje(Constantes.EXITO);
            respuesta.setResultado(Constantes.RESULTADO_EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }
}
