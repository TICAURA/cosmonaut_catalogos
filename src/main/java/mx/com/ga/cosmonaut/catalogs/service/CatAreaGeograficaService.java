
package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;


public interface CatAreaGeograficaService {

    RespuestaGenerica findAll() throws ServiceException;

    RespuestaGenerica findById(Long areaGeograficaId) throws ServiceException;

    RespuestaGenerica findByEsActivo( Boolean activo) throws ServiceException;
}
