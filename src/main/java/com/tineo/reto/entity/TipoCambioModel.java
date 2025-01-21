package com.tineo.reto.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("tipo_cambio")
@Data
public class TipoCambioModel {
    @Id
    private Long tipoCambioId;
    private Long monedaOrigenId;
    private Long monedaDestinoId;
    private Double compra;
    private Double venta;
    private LocalDateTime actualizacion;
}
