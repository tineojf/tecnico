package com.tineo.reto.mapper;

import com.tineo.reto.dto.transaccion.TransaccionRequestDTO;
import com.tineo.reto.dto.transaccion.TransaccionResponseDTO;
import com.tineo.reto.entity.MonedaModel;
import com.tineo.reto.entity.TransaccionModel;
import org.springframework.stereotype.Component;

@Component
public class TransaccionMapper {
    public TransaccionResponseDTO toDTO(TransaccionModel transaccionModel, MonedaModel monedaModel) {
        return TransaccionResponseDTO.builder()
                .montoDestino(transaccionModel.getMontoDestino())
                .monedaDestino(monedaModel.getCodigo())
                .tipoTransaccion(transaccionModel.getTipoTransaccion())
                .build();
    }

    public TransaccionModel toEntity(TransaccionRequestDTO transaccionRequestDTO, MonedaModel monedaOrigen, MonedaModel monedaDestino) {
        return TransaccionModel.builder()
                .tipoTransaccion(transaccionRequestDTO.getTipoTransaccion())
                .montoOrigen(transaccionRequestDTO.getMontoOrigen())
                .monedaOrigenId(monedaOrigen.getMonedaId())
                .monedaDestinoId(monedaDestino.getMonedaId())
                .build();
    }
}
