package com.tineo.reto.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("moneda")
@Data
public class MonedaModel {
    @Id
    private Long monedaId;
    private String codigo;
    private String descripcion;
}
