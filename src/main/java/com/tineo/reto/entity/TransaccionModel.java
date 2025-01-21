package com.tineo.reto.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("transaccion")
@Data
@Builder
public class TransaccionModel {
    @Id
    private Long transaccionId;

    @Column("tipo_transaccion")
    private TipoTransaccionEnum tipoTransaccion;

    private Double montoOrigen;

    @Column("moneda_origen")
    private Long monedaOrigenId;

    @Column("moneda_destino")
    private Long monedaDestinoId;

    private Double montoDestino;

    private BigDecimal tipoCambio;

    private LocalDateTime fechaHoraTransaccion;
}
