package com.tineo.reto.dto.transaccion;

import com.tineo.reto.entity.TipoTransaccionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransaccionResponseDTO {
    private Double montoDestino;
    private String monedaDestino;
    private TipoTransaccionEnum tipoTransaccion;
}
