
package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;


public interface CatNacionalidadService {

    RespuestaGenerica findAll() throws ServiceException;

    RespuestaGenerica findById(Long idNacionalidad) throws ServiceException;

    RespuestaGenerica findByEsActivo(Boolean estatus) throws ServiceException;
}
