package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;

public interface CsTarifaPeriodicaIsrService {
    RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException;
}
