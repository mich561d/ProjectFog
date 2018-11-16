-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ProjectFogDatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ProjectFogDatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ProjectFogDatabase` DEFAULT CHARACTER SET utf8 ;
USE `ProjectFogDatabase` ;

-- -----------------------------------------------------
-- Table `ProjectFogDatabase`.`part`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjectFogDatabase`.`part` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `material` VARCHAR(45) NOT NULL,
  `size` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `price` DOUBLE NOT NULL,
  `brand` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjectFogDatabase`.`carport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjectFogDatabase`.`carport` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjectFogDatabase`.`carportHasPart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjectFogDatabase`.`carportHasPart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `carportId` INT NOT NULL,
  `partId` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Carport_idx` (`carportId` ASC),
  INDEX `Part_idx` (`partId` ASC),
  CONSTRAINT `Carport`
    FOREIGN KEY (`carportId`)
    REFERENCES `ProjectFogDatabase`.`carport` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Part`
    FOREIGN KEY (`partId`)
    REFERENCES `ProjectFogDatabase`.`part` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjectFogDatabase`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjectFogDatabase`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orderStatus` ENUM('Ordered', 'Sent', 'Delievered', 'Cancelled', 'Blocked') NOT NULL,
  `boughtDate` DATETIME NOT NULL,
  `delieveredDate` DATETIME NULL,
  `productId` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `productId_UNIQUE` (`productId` ASC),
  CONSTRAINT `OrdersProduct`
    FOREIGN KEY (`productId`)
    REFERENCES `ProjectFogDatabase`.`carport` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
