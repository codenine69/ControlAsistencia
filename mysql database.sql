-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema controlasistencia
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `controlasistencia` ;

-- -----------------------------------------------------
-- Schema controlasistencia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `controlasistencia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `controlasistencia` ;

-- -----------------------------------------------------
-- Table `controlasistencia`.`oficina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlasistencia`.`oficina` ;

CREATE TABLE IF NOT EXISTS `controlasistencia`.`oficina` (
  `idOficina` INT(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idOficina`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `controlasistencia`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlasistencia`.`persona` ;

CREATE TABLE IF NOT EXISTS `controlasistencia`.`persona` (
  `idPersona` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Paterno` VARCHAR(45) NULL DEFAULT NULL,
  `Materno` VARCHAR(45) NULL DEFAULT NULL,
  `Sexo` VARCHAR(2) NULL DEFAULT NULL,
  `Cargo` VARCHAR(45) NULL DEFAULT NULL,
  `idOficinafk` INT(11) NOT NULL,
  PRIMARY KEY (`idPersona`),
  INDEX `fk_Persona_Oficina_idx` (`idOficinafk` ASC) VISIBLE,
  CONSTRAINT `fk_Persona_Oficina`
    FOREIGN KEY (`idOficinafk`)
    REFERENCES `controlasistencia`.`oficina` (`idOficina`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `controlasistencia`.`ocurrencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlasistencia`.`ocurrencia` ;

CREATE TABLE IF NOT EXISTS `controlasistencia`.`ocurrencia` (
  `idocurrencia` INT(11) NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idocurrencia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `controlasistencia`.`asistencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controlasistencia`.`asistencia` ;

CREATE TABLE IF NOT EXISTS `controlasistencia`.`asistencia` (
  `idPersona` INT(11) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `idocurrencia` INT(11) NOT NULL,
  `Detalle` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idPersona`, `fecha`),
  INDEX `fk_Asistencia_Persona1_idx` (`idPersona` ASC) VISIBLE,
  INDEX `fk_asistencia_ocurrencia1_idx` (`idocurrencia` ASC) VISIBLE,
  CONSTRAINT `fk_Asistencia_Persona1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `controlasistencia`.`persona` (`idPersona`),
  CONSTRAINT `fk_asistencia_ocurrencia1`
    FOREIGN KEY (`idocurrencia`)
    REFERENCES `controlasistencia`.`ocurrencia` (`idocurrencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
