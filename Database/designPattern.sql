SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE database IF NOT EXISTS `design_pattern_ecommerce` DEFAULT CHARACTER SET utf8 ;
USE `design_pattern_ecommerce` ;

-- -----------------------------------------------------
-- Table `design_pattern_ecommerce`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `design_pattern_ecommerce`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL,
  `email` VARCHAR(45) NULL,
  `rua` VARCHAR(50) NULL,
  `senha` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `design_pattern_ecommerce`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `design_pattern_ecommerce`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `preco` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `design_pattern_ecommerce`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `design_pattern_ecommerce`.`pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NULL,
  `data_compra` VARCHAR(45) NULL,
  `produto_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_compra_cliente_idx` (`cliente_id` ASC),
  INDEX `fk_Pedido_produto1_idx` (`produto_id` ASC),
  CONSTRAINT `fk_compra_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `design_pattern_ecommerce`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `design_pattern_ecommerce`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
