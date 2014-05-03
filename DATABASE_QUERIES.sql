SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

SHOW WARNINGS;
SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `usermaster`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usermaster` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `usermaster` (
  `UserID` VARCHAR(45) NOT NULL ,
  `Password` VARCHAR(45) NOT NULL ,
  `FirstName` VARCHAR(45) NOT NULL ,
  `LastName` VARCHAR(45) NOT NULL ,
  `Gender` VARCHAR(45) NOT NULL ,
  `EmailAddress` VARCHAR(45) NOT NULL ,
  `PhoneNo` BIGINT(20) NOT NULL ,
  `ConfirmationCode` VARCHAR(60) NOT NULL ,
  `ActivationStatus` VARCHAR(45) NOT NULL ,
  `LastLoginTime` DATETIME NOT NULL ,
  PRIMARY KEY (`UserID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `categorymaster`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `categorymaster` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `categorymaster` (
  `CategoryID` INT(11) NOT NULL AUTO_INCREMENT ,
  `CategoryName` VARCHAR(45) NOT NULL ,
  `CategoryImage` LONGBLOB NOT NULL ,
  PRIMARY KEY (`CategoryID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `boardmaster`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `boardmaster` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `boardmaster` (
  `BoardID` INT(11) NOT NULL AUTO_INCREMENT ,
  `BoardName` VARCHAR(45) NOT NULL ,
  `BoardImage` LONGBLOB NOT NULL ,
  `BoardType` VARCHAR(45) NOT NULL ,
  `CategoryID` INT(11) NOT NULL ,
  `UserID` VARCHAR(45) NOT NULL ,
  `FollowStatus` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`BoardID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 36
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `CategoryID_idx` ON `boardmaster` (`CategoryID` ASC) ;

SHOW WARNINGS;
CREATE INDEX `UserID_idx` ON `boardmaster` (`UserID` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `followmaster`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `followmaster` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `followmaster` (
  `FollowID` INT(11) NOT NULL AUTO_INCREMENT ,
  `UserFollowerID` VARCHAR(45) NOT NULL ,
  `UserID` VARCHAR(45) NOT NULL ,
  `BoardID` INT(11) NOT NULL ,
  PRIMARY KEY (`FollowID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `BoardID_idx` ON `followmaster` (`BoardID` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `likemaster`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `likemaster` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `likemaster` (
  `LikeID` INT(11) NOT NULL AUTO_INCREMENT ,
  `UserLikerID` VARCHAR(45) NOT NULL ,
  `UserID` VARCHAR(45) NOT NULL ,
  `TackID` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`LikeID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tackmaster`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tackmaster` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `tackmaster` (
  `TackID` INT(11) NOT NULL AUTO_INCREMENT ,
  `TackName` VARCHAR(45) NOT NULL ,
  `TackImage` LONGBLOB NOT NULL ,
  `BoardID` VARCHAR(45) NOT NULL ,
  `TackURL` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`TackID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
