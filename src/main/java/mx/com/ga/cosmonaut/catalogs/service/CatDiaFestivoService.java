
package mx.com.ga.cosmonaut.catalogs.service;

import java.util.Date;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;


public interface CatDiaFestivoService {

    RespuestaGenerica findAll() throws ServiceException;

    RespuestaGenerica obtenerId(Date diaFestivoId) throws ServiceException;

    RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException;
}
