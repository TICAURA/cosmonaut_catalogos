/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ga.cosmonaut.catalogs.service;

import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.exception.ServiceException;

/**
 *
 * @author Usuario
 */
public interface CsActividadEconomicaService {

    RespuestaGenerica findAll() throws ServiceException;

    RespuestaGenerica findById(Integer id) throws ServiceException;

    RespuestaGenerica findByEsActivo(Boolean estatus, Integer nivel) throws ServiceException;
    
    RespuestaGenerica findByEsActivo(Boolean estatus, Integer nivel, Integer sector) throws ServiceException;

    RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException;
}
