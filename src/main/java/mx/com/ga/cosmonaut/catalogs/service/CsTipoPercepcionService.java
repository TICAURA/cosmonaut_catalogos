package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;

public interface CsTipoPercepcionService {

    RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException;

    RespuestaGenerica findByEsActivoPeriodicidad(Boolean activo, String tipoPeriodicidad) throws ServiceException;

    RespuestaGenerica findByPeriodicidadAndEditable(Boolean activo, String tipoPeriodicidad) throws ServiceException;

}
