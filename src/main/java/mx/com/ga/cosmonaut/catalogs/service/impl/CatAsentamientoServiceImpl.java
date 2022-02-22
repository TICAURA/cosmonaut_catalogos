
package mx.com.ga.cosmonaut.catalogs.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import mx.com.ga.cosmonaut.catalogs.service.CatAsentamientoService;
import mx.com.ga.cosmonaut.common.entity.catalogo.ubicacion.CatAsentamiento;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.repository.catalogo.ubicacion.CatAsentamientoRepository;
import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.util.Constantes;

@Singleton
public class CatAsentamientoServiceImpl implements CatAsentamientoService {

    @Inject
    private CatAsentamientoRepository catAsentaminetoRepository;

    public RespuestaGenerica findByCodigoAndEsActivo(String codigo) throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            List<CatAsentamiento> lista = catAsentaminetoRepository.obtieneAsentamientos(codigo);
            if (!lista.isEmpty()) {
                respuesta.setDatos(lista);
                respuesta.setResultado(true);
                respuesta.setMensaje(Constantes.EXITO);
            }
            return respuesta;
        } catch (Exception e) {

            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findById " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    @Override
    public RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            respuesta.setDatos(catAsentaminetoRepository.findByEsActivo(activo));
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }
}
