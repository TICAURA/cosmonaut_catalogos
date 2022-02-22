package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;

public interface CsPeriodicidadPagoService {

    RespuestaGenerica findAll() throws ServiceException;

    RespuestaGenerica findById(String id) throws ServiceException;

    RespuestaGenerica findByEsActivo(Boolean estatus) throws ServiceException;

}
