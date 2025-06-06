-- MySQL Script generated by MySQL Workbench
-- Thu May 29 14:53:53 2025
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema projeto_av3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projeto_av3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projeto_av3` DEFAULT CHARACTER SET utf8 ;
USE `projeto_av3` ;

-- -----------------------------------------------------
-- Table `projeto_av3`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_av3`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `cpf` CHAR(11) NOT NULL,
  `nome_completo` VARCHAR(150) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `telefone` CHAR(14) NOT NULL,
  `genero` CHAR(9) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `nome_contato_emergencia` VARCHAR(150) NOT NULL,
  `telefone_contato_emergencia` CHAR(14) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_av3`.`denuncia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_av3`.`denuncia` (
  `id_denuncia` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `data` DATETIME(2) NOT NULL,
  `tipo_violencia` VARCHAR(11) NOT NULL,
  `denunciante_e_vitima` TINYINT NOT NULL,
  `possui_vinculo_agressor` TINYINT NOT NULL,
  `agressor_armado` TINYINT NOT NULL,
  `localizacao` VARCHAR(150) NOT NULL,
  `ponto_referencia` VARCHAR(100) NULL,
  `descricao_agressor` VARCHAR(200) NULL,
  PRIMARY KEY (`id_denuncia`),
  INDEX `fk_denuncia_usuario1_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_denuncia_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `projeto_av3`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_av3`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_av3`.`endereco` (
  `id_endereco` INT NOT NULL AUTO_INCREMENT,
  `CEP` CHAR(8) NOT NULL,
  `logradouro` VARCHAR(100) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `bairro` VARCHAR(100) NOT NULL,
  `municipio` VARCHAR(100) NOT NULL,
  `estado` VARCHAR(50) NOT NULL,
  `complemento` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_endereco`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_av3`.`boletim`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto_av3`.`boletim` (
  `id_boletim` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `data` DATETIME(2) NOT NULL,
  `vitima_nome` VARCHAR(120) NOT NULL,
  `vitima_idade` INT NOT NULL,
  `vitima_cpf` CHAR(11) NOT NULL,
  `vitima_telefone` CHAR(14) NOT NULL,
  `lesoes` TEXT(500) NULL,
  `descricao_fato` TEXT(2000) NOT NULL,
  `agressor_armado` TINYINT NOT NULL,
  `possui_vinculo_agressor` TINYINT NOT NULL,
  `id_endereco` INT NOT NULL,
  PRIMARY KEY (`id_boletim`),
  INDEX `fk_boletim_usuario1_idx` (`id_usuario` ASC) VISIBLE,
  INDEX `fk_boletim_endereco1_idx` (`id_endereco` ASC) VISIBLE,
  CONSTRAINT `fk_boletim_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `projeto_av3`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_boletim_endereco1`
    FOREIGN KEY (`id_endereco`)
    REFERENCES `projeto_av3`.`endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;