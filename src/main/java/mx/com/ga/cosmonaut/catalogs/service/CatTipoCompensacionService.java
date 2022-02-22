
package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;


public interface CatTipoCompensacionService {

    RespuestaGenerica findAll() throws ServiceException;

    RespuestaGenerica findById(Long tipoCompensacionId) throws ServiceException;

    RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException;
}
