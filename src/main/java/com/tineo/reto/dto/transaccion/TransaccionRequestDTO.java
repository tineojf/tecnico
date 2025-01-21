package com.tineo.reto.dto.transaccion;

import com.tineo.reto.entity.TipoTransaccionEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransaccionRequestDTO {

    @NotNull
    private TipoTransaccionEnum tipoTransaccion;

    @NotNull
    private Double montoOrigen;

    @NotNull
    @Length(min = 3, max = 3)
    private String monedaOrigen;

    @NotNull
    @Length(min = 3, max = 3)
    private String monedaDestino;
}
