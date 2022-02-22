package mx.com.ga.cosmonaut.catalogs.service.impl;

import mx.com.ga.cosmonaut.catalogs.service.TablasValoresService;
import mx.com.ga.cosmonaut.common.dto.RespuestaGenerica;
import mx.com.ga.cosmonaut.common.entity.catalogo.negocio.CatTasaAplicableIsn;
import mx.com.ga.cosmonaut.common.entity.catalogo.negocio.CatValorReferencia;
import mx.com.ga.cosmonaut.common.entity.catalogo.sat.CsTarifaPeriodicaIsr;
import mx.com.ga.cosmonaut.common.entity.catalogo.sat.CsTarifaPeriodicaSubsidio;
import mx.com.ga.cosmonaut.common.entity.catalogo.ubicacion.CatEstado;
import mx.com.ga.cosmonaut.common.exception.ServiceException;
import mx.com.ga.cosmonaut.common.repository.catalogo.negocio.CatAnioFiscalRepository;
import mx.com.ga.cosmonaut.common.repository.catalogo.negocio.CatTasaAplicableIsnRepository;
import mx.com.ga.cosmonaut.common.repository.catalogo.negocio.CatTipoValorReferenciaRepository;
import mx.com.ga.cosmonaut.common.repository.catalogo.negocio.CatValorReferenciaRepository;
import mx.com.ga.cosmonaut.common.repository.catalogo.sat.CsPeriodicidadPagoRepository;
import mx.com.ga.cosmonaut.common.repository.catalogo.sat.CsTarifaPeriodicaIsrRepository;
import mx.com.ga.cosmonaut.common.repository.catalogo.sat.CsTarifaPeriodicaSubsidioRepository;
import mx.com.ga.cosmonaut.common.repository.catalogo.ubicacion.CatEstadoRepository;
import mx.com.ga.cosmonaut.common.repository.nativo.TablasRepository;
import mx.com.ga.cosmonaut.common.util.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class TablasValoresServiceImpl implements TablasValoresService {

    @Inject
    private CatValorReferenciaRepository catValorReferenciaRepository;

    @Inject
    private CatTasaAplicableIsnRepository catTasaAplicableIsnRepository;

    @Inject
    private CsTarifaPeriodicaIsrRepository csTarifaPeriodicaIsrRepository;

    @Inject
    private CsTarifaPeriodicaSubsidioRepository csTarifaPeriodicaSubsidioRepository;

    @Inject
    private CsPeriodicidadPagoRepository csPeriodicidadPagoRepository;

    @Inject
    private TablasRepository tablasRepository;

    @Inject
    private CatAnioFiscalRepository catAnioFiscalRepository;

    @Inject
    private CatTipoValorReferenciaRepository catTipoValorReferenciaRepository;

    @Inject
    private CatEstadoRepository catEstadoRepository;

    public RespuestaGenerica findValorReferenciaByEsActivo(Boolean activo, Long anio) throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            List<CatValorReferencia> valores = catValorReferenciaRepository
                    .findByEsActivoOrderByValorReferenciaId(activo);

            for (CatValorReferencia valor : valores) {
                catAnioFiscalRepository.findById(valor.getAnioLey().getAnioLey()).ifPresent(valor::setAnioLey);
                catTipoValorReferenciaRepository.findById(valor.getTipoValorReferenciaId().getTipoValorReferenciaId())
                        .ifPresent(valor::setTipoValorReferenciaId);
            }

            respuesta.setDatos(valores);
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findValorReferenciaByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    @Override
    public RespuestaGenerica findTarifaIsrByEsActivo(Boolean activo, String periodicidad) throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            List<CsTarifaPeriodicaIsr> tarifas = csTarifaPeriodicaIsrRepository
                    .findByEsActivoAndPeriodicidadPagoIdPeriodicidadPagoIdOrderByTarifaPeriodicaIsrId(activo, periodicidad);

            for (CsTarifaPeriodicaIsr tarifa : tarifas) {
                csPeriodicidadPagoRepository.findById(tarifa.getPeriodicidadPagoId().getPeriodicidadPagoId())
                        .ifPresent(tarifa::setPeriodicidadPagoId);
            }

            respuesta.setDatos(tarifas);
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findTarifaIsrByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    @Override
    public RespuestaGenerica findTarifaSubsidioIsrByEsActivo(Boolean activo, String periodicidad) throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            List<CsTarifaPeriodicaSubsidio> tarifas = csTarifaPeriodicaSubsidioRepository
                    .findByEsActivoAndPeriodicidadPagoIdPeriodicidadPagoIdOrderBytarifaPeriodicaSubsidioId(activo, periodicidad);

            for (CsTarifaPeriodicaSubsidio tarifa : tarifas) {
                csPeriodicidadPagoRepository.findById(tarifa.getPeriodicidadPagoId().getPeriodicidadPagoId())
                        .ifPresent(tarifa::setPeriodicidadPagoId);
            }

            respuesta.setDatos(tarifas);
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findTarifaSubsidioIsrByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    public RespuestaGenerica findTablasISRPeriodicas() throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            respuesta.setDatos(tablasRepository.obtieneCatPeriodoPago());
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findTablasISRPeriodicas " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    public RespuestaGenerica findTablasISRSubsidio() throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            respuesta.setDatos(tablasRepository.obtieneCatPeriodoPagoSubsidio());
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findTablasISRSubsidio " + Constantes.ERROR_EXCEPCION, e);
        }
    }
    
    public RespuestaGenerica findTablasISN() throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            respuesta.setDatos(tablasRepository.obtieneTablasEdo());
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findTablasISN " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    @Override
    public RespuestaGenerica findEstadosISN() throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            respuesta.setDatos(catTasaAplicableIsnRepository.findCestado().stream()
                    .sorted(Comparator.comparing(CatEstado::getEstado))
                    .collect(Collectors.toCollection(LinkedHashSet::new)));
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findEstadosISN " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    @Override
    public RespuestaGenerica findTasaAplicableIsnByEsActivo(Boolean activo) throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            respuesta.setDatos(catTasaAplicableIsnRepository.findByEsActivoOrderByTasaAplicableIsnId(activo));
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findTasaAplicableIsnByEsActivo " + Constantes.ERROR_EXCEPCION, e);
        }
    }

    @Override
    public RespuestaGenerica findByEsActivoAndCestadoEstadoId(Boolean activo, Integer estadoId) throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            List<CatTasaAplicableIsn> tasas = catTasaAplicableIsnRepository
                    .findByEsActivoAndCestadoEstadoIdOrderByTasaAplicableIsnId(activo, estadoId);

            for (CatTasaAplicableIsn tasa : tasas) {
                catEstadoRepository.findById(Long.valueOf(tasa.getCestado().getEstadoId())).ifPresent(tasa::setCestado);
            }

            respuesta.setDatos(tasas);
            respuesta.setResultado(true);
            respuesta.setMensaje(Constantes.EXITO);
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException(Constantes.ERROR_CLASE + this.getClass().getSimpleName()
                    + Constantes.ERROR_METODO + " findTasaAplicableIsnByEsActivoAndCestadoEstadoId " + Constantes.ERROR_EXCEPCION, e);
        }
    }

}
