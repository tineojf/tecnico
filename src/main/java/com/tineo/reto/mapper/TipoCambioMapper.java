package com.tineo.reto.mapper;

import com.tineo.reto.dto.tipocambio.TipoCambioResponseDTO;
import com.tineo.reto.entity.MonedaModel;
import com.tineo.reto.entity.TipoCambioModel;
import org.springframework.stereotype.Component;

@Component
public class TipoCambioMapper {
    public TipoCambioResponseDTO toDTO(TipoCambioModel tipoCambioModel, MonedaModel monedaOrigen, MonedaModel monedaDestino) {
        return TipoCambioResponseDTO.builder()
                .monedaOrigen(monedaOrigen.getCodigo())
                .monedaDestino(monedaDestino.getCodigo())
                .compra(tipoCambioModel.getCompra())
                .venta(tipoCambioModel.getVenta())
                .actualizacion(tipoCambioModel.getActualizacion())
                .build();
    }
}
