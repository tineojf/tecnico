package com.tineo.reto.dto.tipocambio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoCambioResponseDTO {
    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal compra;
    private BigDecimal venta;
    private LocalDateTime actualizacion;
}
