package mx.com.ga.cosmonaut.catalogs.service.impl;

import mx.com.ga.cosmonaut.catalogs.service.CatEmisionService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.entity.catalogo.negocio.CatEmision;
import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.repository.catalogo.negocio.CatEmisionRepository;
import mx.com.ga.cosmonaut.common.util.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Comparator;
import java.util.stream.Collectors;

@Singleton
public class CatEmisionServiceImpl implements CatEmisionService {

    @Inject
    private CatEmisionRepository catEmisionRepository;

    @Override
    public RespuestaGenerica findAll() throws ServiceException {
        try {
            RespuestaGenerica respuestaGenerica = new RespuestaGenerica();
            respuestaGenerica.setDatos(catEmisionRepository.findAll());
            respuestaGenerica.setResultado(Constantes.RESULTADO_EXITO);
            respuestaGenerica.setMensaje(Constantes.EXITO);
            return respuestaGenerica;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findAll " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    @Override
    public RespuestaGenerica findByIdTipoEmisionIdTipoEmision(Integer idTipoEmision) throws ServiceException {
        try {
            RespuestaGenerica respuestaGenerica = new RespuestaGenerica();
            respuestaGenerica.setDatos(catEmisionRepository.findByIdTipoEmisionIdTipoEmision(idTipoEmision)
                    .stream().sorted(Comparator.comparing(CatEmision::getIdEmision)).collect(Collectors.toList()));
            respuestaGenerica.setResultado(Constantes.RESULTADO_EXITO);
            respuestaGenerica.setMensaje(Constantes.EXITO);
            return respuestaGenerica;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findAll " + Constantes.ERROR_EXCEPCION, e);
        }
    }

}
