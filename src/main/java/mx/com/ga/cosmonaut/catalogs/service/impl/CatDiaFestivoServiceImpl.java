/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ga.cosmonaut.catalogs.service.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Singleton;
import mx.com.ga.cosmonaut.common.repository.catalogo.negocio.CatDiaFestivoRepository;
import mx.com.ga.cosmonaut.catalogs.service.CatDiaFestivoService;
import mx.com.ga.cosmonaut.common.entity.catalogo.negocio.CatDiaFestivo;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;

import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.util.Constantes;


/**
 *
 * @author Usuario
 */
@Singleton
public class CatDiaFestivoServiceImpl implements CatDiaFestivoService {

    private RespuestaGenerica respuesta = new RespuestaGenerica();

    @Inject
    private CatDiaFestivoRepository catDiaFestivoRepository;

    @Override
    public RespuestaGenerica findAll() throws ServiceException {
        try {

            respuesta.setDatos(catDiaFestivoRepository.findAll());
            respuesta.setMensaje(Constantes.EXITO);
            respuesta.setResultado(Constantes.RESULTADO_EXITO);
            return respuesta;
        } catch (Exception e) {

            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findAll " + Constantes.ERROR_EXCEPCION, e);
        }

    }

    public RespuestaGenerica obtenerId(Date diaFestivoId) throws ServiceException {
        try {

            respuesta.setDatos(catDiaFestivoRepository.findById(diaFestivoId).orElse(new CatDiaFestivo()));
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {

            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " obtenerId " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    @Override
    public RespuestaGenerica findByEsActivo(Boolean activo) throws ServiceException {
        try {
            respuesta.setDatos(catDiaFestivoRepository.findByEsActivoOrderByNombre(activo));
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }
}
