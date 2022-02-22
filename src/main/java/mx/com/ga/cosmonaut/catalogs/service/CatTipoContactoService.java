
package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;


public interface CatTipoContactoService {

    RespuestaGenerica findAll() throws ServiceException;

    RespuestaGenerica findById(Long tipoContactoId) throws ServiceException;

    RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException;
}
