package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;

public interface CsBancoService {

    RespuestaGenerica findAll() throws ServiceException;
    
    RespuestaGenerica findByRazonSocial(String razonSocial) throws ServiceException;
    
    RespuestaGenerica findById(Long id) throws ServiceException;

    RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException;
}
