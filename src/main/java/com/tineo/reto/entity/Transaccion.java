package com.tineo.reto.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("transaccion")
@Data
public class Transaccion {
    @Id
    private Long transaccionId;
    private TipoTransaccionEnum tipoTransaccion;
    private Double montoOrigen;
    private Long monedaOrigenId;
    private Long monedaDestinoId;
    private Double montoDestino;
    private Double tipoCambio;
    private LocalDateTime fechaHoraTransaccion;
}
