package mx.com.ga.cosmonaut.catalogs.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;
import mx.com.ga.cosmonaut.catalogs.service.CsRegimenFiscalService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.entity.catalogo.sat.CsRegimenFiscal;
import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.repository.catalogo.sat.CsRegimenFiscalRepository;
import mx.com.ga.cosmonaut.common.util.Constantes;

@Singleton
public class CsRegimenFiscalServiceImpl implements CsRegimenFiscalService{

    @Inject
    private CsRegimenFiscalRepository csRegimenFiscalRepository;
    private RespuestaGenerica respuesta = new RespuestaGenerica();

    public RespuestaGenerica findAll() throws ServiceException {
        try {

            respuesta.setDatos(csRegimenFiscalRepository.findAll());
            respuesta.setMensaje(Constantes.EXITO);
            respuesta.setResultado(Constantes.RESULTADO_EXITO);
            return respuesta;
        } catch (Exception e) {

            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findAll " + Constantes.ERROR_EXCEPCION, e);
        }

    }

    public RespuestaGenerica findById(String id) throws ServiceException {
        try {
            RespuestaGenerica response = new RespuestaGenerica();
            response.setDatos(csRegimenFiscalRepository.findById(id).orElse(new CsRegimenFiscal()));
            response.setResultado(true);
            response.setMensaje(Constantes.EXITO);
            return response;
        } catch (Exception e) {

            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findById " + Constantes.ERROR_EXCEPCION, e);
        }
    }
    
    @Override
    public RespuestaGenerica findEsActivo(Boolean activo) throws ServiceException {
        try {
            respuesta.setDatos(csRegimenFiscalRepository.findByActivo(activo));
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }

}
