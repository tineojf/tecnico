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

    @NotNull(message = "El tipo de transacción es requerido")
    private TipoTransaccionEnum tipoTransaccion;

    @NotNull(message = "El monto de origen es requerido")
    private Double montoOrigen;

    @NotNull(message = "La moneda de origen es requerida")
    @Length(min = 3, max = 3)
    private String monedaOrigen;

    @NotNull(message = "La moneda de destino es requerida")
    @Length(min = 3, max = 3)
    private String monedaDestino;
}
