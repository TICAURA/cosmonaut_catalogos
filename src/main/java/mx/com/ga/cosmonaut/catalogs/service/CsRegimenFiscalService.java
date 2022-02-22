package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;

public interface CsRegimenFiscalService {

    RespuestaGenerica findAll() throws ServiceException;
    
    RespuestaGenerica findById(String id) throws ServiceException;

    RespuestaGenerica findEsActivo(Boolean activo) throws ServiceException;

}
