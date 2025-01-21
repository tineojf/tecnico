-- Inserciones para la tabla moneda
INSERT INTO `moneda` (`codigo`, `descripcion`) VALUES
('USD', 'Dolar americano'),
('PEN', 'Sol peruano');

-- Inserciones para la tabla tipo_cambio
INSERT INTO `tipo_cambio` (`moneda_origen`, `moneda_destino`, `compra`, `venta`) VALUES
(1, 2, 3.5, 3.6),
(2, 1, 0.28, 0.29);

-- Inserciones para la tabla transaccion
INSERT INTO `transaccion` (`tipo_transaccion`, `monto_origen`, `moneda_origen`, `moneda_destino`, `monto_destino`, `tipo_cambio`) VALUES
('COMPRA', 100.00, 1, 2, 350.00, 3.50),
('VENTA', 100.00, 2, 1, 28.00, 0.28);
