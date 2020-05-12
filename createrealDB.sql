-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`agent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`agent` (
  `id` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id` VARCHAR(16) NOT NULL,
  `firstname` VARCHAR(20) NULL,
  `lastname` VARCHAR(20) NOT NULL,
  `email` VARCHAR(100) NULL,
  `dob` DATETIME NULL,
  `agent_userid` VARCHAR(16) NOT NULL,
  `owner_userid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_Agent`
    FOREIGN KEY (`agent_userid`)
    REFERENCES `mydb`.`agent` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`clientwish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`clientwish` (
  `id` VARCHAR(16) NOT NULL,
  `featureid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`property`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`property` (
  `propertyid` VARCHAR(16) NOT NULL,
  `dateadded` DATETIME NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `userid` VARCHAR(16) NOT NULL,
  `numberofrooms` INT NOT NULL,
  `numberofbathrooms` INT NOT NULL,
  `numberofgarage` INT NOT NULL,
  `squarefootage` INT NOT NULL,
  `propertydescription` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`propertyid`));


-- -----------------------------------------------------
-- Table `mydb`.`propertyforsale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`propertyforsale` (
  `propertyid` VARCHAR(16) NOT NULL,
  `propertyprice` INT NULL,
  `property_propertyid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`propertyid`, `property_propertyid`),
  CONSTRAINT `fk_propertyforsale_property1`
    FOREIGN KEY (`property_propertyid`)
    REFERENCES `mydb`.`property` (`propertyid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`sale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sale` (
  `id` VARCHAR(16) NOT NULL,
  `agentid` VARCHAR(25) NOT NULL,
  `clientid` VARCHAR(45) NOT NULL,
  `dateofsale` DATETIME NOT NULL,
  `propertyid` VARCHAR(16) NOT NULL,
  `propertyforsale` VARCHAR(16) NOT NULL,
  `agent_userid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`, `agent_userid`),
  CONSTRAINT `fk_Sale_PropertyForsale1`
    FOREIGN KEY (`propertyforsale`)
    REFERENCES `mydb`.`propertyforsale` (`propertyid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_agent1`
    FOREIGN KEY (`agent_userid`)
    REFERENCES `mydb`.`agent` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`rent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rent` (
  `id` VARCHAR(16) NOT NULL,
  `agentid` VARCHAR(25) NOT NULL,
  `clientid` VARCHAR(45) NOT NULL,
  `rentstartdate` DATETIME NOT NULL,
  `propertydate` VARCHAR(16) NOT NULL,
  `rentprice` INT NOT NULL,
  `rentend` DATETIME NULL,
  `agent_userid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`, `agent_userid`),
  CONSTRAINT `fk_rent_agent1`
    FOREIGN KEY (`agent_userid`)
    REFERENCES `mydb`.`agent` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`client` (
  `id` VARCHAR(16) NOT NULL,
  `maxprice` INT(8) NOT NULL,
  `user_userid` VARCHAR(16) NOT NULL,
  `clientwish_userid` VARCHAR(16) NOT NULL,
  `sale_userid` VARCHAR(16) NOT NULL,
  `rent_userid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Buyer_user1`
    FOREIGN KEY (`user_userid`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Buyer_ClientWish1`
    FOREIGN KEY (`clientwish_userid`)
    REFERENCES `mydb`.`clientwish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_Sale1`
    FOREIGN KEY (`sale_userid`)
    REFERENCES `mydb`.`sale` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_Rent1`
    FOREIGN KEY (`rent_userid`)
    REFERENCES `mydb`.`rent` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`propertyfeature`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`propertyfeature` (
  `propertyid` VARCHAR(16) NOT NULL,
  `featureid` VARCHAR(45) NOT NULL,
  `property_propertyID` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`featureid`),
  CONSTRAINT `fk_PropertyFeature_Property1`
    FOREIGN KEY (`property_propertyID`)
    REFERENCES `mydb`.`property` (`propertyid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`feature`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`feature` (
  `featureid` VARCHAR(16) NOT NULL,
  `featuredescription` VARCHAR(50) NULL,
  `clientwish_userid` VARCHAR(16) NOT NULL,
  `propertyfeature_featureid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`featureid`),
  CONSTRAINT `fk_Feature_ClientWish1`
    FOREIGN KEY (`clientwish_userid`)
    REFERENCES `mydb`.`clientwish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feature_propertyfeature1`
    FOREIGN KEY (`propertyfeature_featureid`)
    REFERENCES `mydb`.`propertyfeature` (`featureid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`visit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`visit` (
  `id` VARCHAR(16) NOT NULL,
  `agentid` VARCHAR(25) NOT NULL,
  `clientid` VARCHAR(45) NOT NULL,
  `visitdate` DATETIME NOT NULL,
  `propertyid` VARCHAR(16) NOT NULL,
  `agent_userid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`, `agent_userid`),
  CONSTRAINT `fk_visit_agent1`
    FOREIGN KEY (`agent_userid`)
    REFERENCES `mydb`.`agent` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`address` (
  `addresid` VARCHAR(65) NOT NULL,
  `streetnumber` INT NOT NULL,
  `streetname` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `zipcode_cityid` VARCHAR(45) NOT NULL,
  `property_propertyid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`addresid`, `property_propertyid`),
  CONSTRAINT `fk_address_property1`
    FOREIGN KEY (`property_propertyid`)
    REFERENCES `mydb`.`property` (`propertyid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`propertyforent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`propertyforent` (
  `propertyID` VARCHAR(16) NOT NULL,
  `rentprice` INT NOT NULL,
  `availabledate` DATETIME NOT NULL,
  `property_propertyid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`propertyID`, `property_propertyid`),
  CONSTRAINT `fk_propertyforent_property1`
    FOREIGN KEY (`property_propertyid`)
    REFERENCES `mydb`.`property` (`propertyid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`city` (
  `cityid` VARCHAR(65) NOT NULL,
  `cityname` VARCHAR(45) NOT NULL,
  `address_addresid` VARCHAR(65) NOT NULL,
  `address_property_propertyid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`cityid`),
  CONSTRAINT `fk_city_address1`
    FOREIGN KEY (`address_addresid` , `address_property_propertyid`)
    REFERENCES `mydb`.`address` (`addresid` , `property_propertyid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`state` (
  `stateid` VARCHAR(65) NOT NULL,
  `statename` VARCHAR(45) NOT NULL,
  `address_addresid` VARCHAR(65) NOT NULL,
  `address_property_propertyid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`stateid`),
  CONSTRAINT `fk_state_address1`
    FOREIGN KEY (`address_addresid` , `address_property_propertyid`)
    REFERENCES `mydb`.`address` (`addresid` , `property_propertyid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`country` (
  `countryid` VARCHAR(65) NOT NULL,
  `countryname` VARCHAR(45) NOT NULL,
  `address_addresid` VARCHAR(65) NOT NULL,
  `address_property_propertyid` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`countryid`),
  CONSTRAINT `fk_country_address1`
    FOREIGN KEY (`address_addresid` , `address_property_propertyid`)
    REFERENCES `mydb`.`address` (`addresid` , `property_propertyid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
