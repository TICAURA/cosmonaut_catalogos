package mx.com.ga.cosmonaut.catalogs.service.impl;

import mx.com.ga.cosmonaut.catalogs.service.CatProveedorTimbradoService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.repository.catalogo.negocio.CatProveedorTimbradoRepository;
import mx.com.ga.cosmonaut.common.util.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CatProveedorTimbradoServiceImpl implements CatProveedorTimbradoService {

    @Inject
    private CatProveedorTimbradoRepository catProveedorTimbradoRepository;

    @Override
    public RespuestaGenerica listar() throws ServiceException {
        try {
            return new RespuestaGenerica(
                    catProveedorTimbradoRepository.findByEsActivoOrderByDescripcion(Constantes.ESTATUS_ACTIVO),
                    Constantes.RESULTADO_EXITO,
                    Constantes.EXITO);
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " listar " + Constantes.ERROR_EXCEPCION, e);
        }
    }
}
