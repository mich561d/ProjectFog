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
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  `roof` TINYINT NOT NULL,
  `angle` INT NOT NULL,
  `shed` TINYINT NOT NULL,
  `shedLength` INT NOT NULL,
  `shedWidth` INT NOT NULL,
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
-- Table `ProjectFogDatabase`.`paymentInformation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjectFogDatabase`.`paymentInformation` (
  `id` INT NOT NULL,
  `cardNumber` VARCHAR(45) NOT NULL,
  `expireDate` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjectFogDatabase`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjectFogDatabase`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `number` INT NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `zip` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjectFogDatabase`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjectFogDatabase`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `saltValue` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjectFogDatabase`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjectFogDatabase`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `paymentID` INT NOT NULL,
  `addressID` INT NOT NULL,
  `userID` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `customerPaymentInfo_idx` (`paymentID` ASC),
  INDEX `customerAddressInfo_idx` (`addressID` ASC),
  INDEX `customerUserInfo_idx` (`userID` ASC),
  CONSTRAINT `customerPaymentInfo`
    FOREIGN KEY (`paymentID`)
    REFERENCES `ProjectFogDatabase`.`paymentInformation` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `customerAddressInfo`
    FOREIGN KEY (`addressID`)
    REFERENCES `ProjectFogDatabase`.`address` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `customerUserInfo`
    FOREIGN KEY (`userID`)
    REFERENCES `ProjectFogDatabase`.`user` (`id`)
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
  `productID` INT NOT NULL,
  `customerID` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `productId_UNIQUE` (`productID` ASC),
  INDEX `OrdersCustomer_idx` (`customerID` ASC),
  CONSTRAINT `OrdersProduct`
    FOREIGN KEY (`productID`)
    REFERENCES `ProjectFogDatabase`.`carport` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `OrdersCustomer`
    FOREIGN KEY (`customerID`)
    REFERENCES `ProjectFogDatabase`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjectFogDatabase`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjectFogDatabase`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `workPhone` VARCHAR(45) NULL,
  `role` VARCHAR(45) NOT NULL,
  `addressID` INT NOT NULL,
  `userID` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `employeeAddressInfo_idx` (`addressID` ASC),
  INDEX `employeeUserInfo_idx` (`userID` ASC),
  CONSTRAINT `employeeAddressInfo`
    FOREIGN KEY (`addressID`)
    REFERENCES `ProjectFogDatabase`.`address` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `employeeUserInfo`
    FOREIGN KEY (`userID`)
    REFERENCES `ProjectFogDatabase`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
