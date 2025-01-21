-- Delete all tables
DROP TABLE IF EXISTS `transaccion`;
DROP TABLE IF EXISTS `tipo_cambio`;
DROP TABLE IF EXISTS `moneda`;

-- -----------------------------------------------------
 -- Table `moneda`
 -- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `moneda` (
   `moneda_id` BIGINT NOT NULL AUTO_INCREMENT,
   `codigo` VARCHAR(3) NOT NULL UNIQUE,
   `descripcion` VARCHAR(45) NOT NULL,
   PRIMARY KEY (`moneda_id`));

 -- -----------------------------------------------------
 -- Table `tipo_cambio`
 -- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `tipo_cambio` (
   `tipo_cambio_id` BIGINT NOT NULL AUTO_INCREMENT,
   `moneda_origen` BIGINT NOT NULL,
   `moneda_destino` BIGINT NOT NULL,
   `compra` DECIMAL(10,4) NOT NULL,
   `venta` DECIMAL(10,4) NOT NULL,
   `actualizacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`tipo_cambio_id`),
   INDEX `fk_tipo_cambio_moneda_origen_idx` (`moneda_origen` ASC) VISIBLE,
   INDEX `fk_tipo_cambio_moneda_destino_idx` (`moneda_destino` ASC) VISIBLE,
   CONSTRAINT `fk_tipo_cambio_moneda_origen`
     FOREIGN KEY (`moneda_origen`) REFERENCES `moneda` (`moneda_id`) ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT `fk_tipo_cambio_moneda_destino`
     FOREIGN KEY (`moneda_destino`) REFERENCES `moneda` (`moneda_id`) ON DELETE CASCADE ON UPDATE CASCADE);

 -- -----------------------------------------------------
 -- Table `transaccion`
 -- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `transaccion` (
   `transaccion_id` INT NOT NULL AUTO_INCREMENT,
   `tipo_transaccion` ENUM('VENTA', 'COMPRA') NOT NULL,
   `monto_origen` DECIMAL(10,2) NOT NULL,
   `moneda_origen` BIGINT NOT NULL,
   `moneda_destino` BIGINT NOT NULL,
   `monto_destino` DECIMAL(10,2) NOT NULL,
   `tipo_cambio` DECIMAL(10,4) NOT NULL,
   `fecha_hora_transaccion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`transaccion_id`),
   INDEX `fk_transaccion_moneda_origen_idx` (`moneda_origen` ASC) VISIBLE,
   INDEX `fk_transaccion_moneda_destino_idx` (`moneda_destino` ASC) VISIBLE,
   CONSTRAINT `fk_transaccion_moneda_origen`
     FOREIGN KEY (`moneda_origen`) REFERENCES `moneda` (`moneda_id`) ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT `fk_transaccion_moneda_destino`
     FOREIGN KEY (`moneda_destino`) REFERENCES `moneda` (`moneda_id`) ON DELETE CASCADE ON UPDATE CASCADE);






