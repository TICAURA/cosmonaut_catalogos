
package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;


public interface CatSubcontratistaService {

    RespuestaGenerica findAll() throws ServiceException;

    RespuestaGenerica findById(Long subcontratistaId) throws ServiceException;

    RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException;
}
