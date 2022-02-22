package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;

public interface CatPagosXliquidacionService {
    RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException;
}
