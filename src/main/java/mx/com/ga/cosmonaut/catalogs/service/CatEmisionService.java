package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;

public interface CatEmisionService {

    RespuestaGenerica findAll() throws ServiceException;

    RespuestaGenerica findByIdTipoEmisionIdTipoEmision(Integer idTipoEmision) throws ServiceException;

}
