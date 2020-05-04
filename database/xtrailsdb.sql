-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema xtrailsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `xtrailsdb` ;

-- -----------------------------------------------------
-- Schema xtrailsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `xtrailsdb` DEFAULT CHARACTER SET utf8 ;
USE `xtrailsdb` ;

-- -----------------------------------------------------
-- Table `Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Location` ;

CREATE TABLE IF NOT EXISTS `Location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(500) NULL,
  `park` VARCHAR(500) NULL,
  `state` VARCHAR(500) NULL,
  `longitude` DECIMAL(9,6) NULL,
  `latitude` DECIMAL(9,6) NULL,
  `county` VARCHAR(500) NULL,
  `street` VARCHAR(400) NULL,
  `zipcode` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `User` ;

CREATE TABLE IF NOT EXISTS `User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NULL,
  `active` TINYINT NULL,
  `playlist` VARCHAR(45) NULL,
  `comments` VARCHAR(500) NULL,
  `favorite_activities` VARCHAR(500) NULL,
  `stats` VARCHAR(500) NULL,
  `Location_id` INT NULL,
  `role` VARCHAR(100) NULL,
  `enabled` TINYINT NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_User_Location_idx` (`Location_id` ASC),
  CONSTRAINT `fk_User_Location`
    FOREIGN KEY (`Location_id`)
    REFERENCES `Location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Trail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Trail` ;

CREATE TABLE IF NOT EXISTS `Trail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `location` VARCHAR(700) NULL,
  `dogFriendly` TINYINT NULL,
  `hashtags` VARCHAR(45) NULL,
  `description` VARCHAR(5000) NULL,
  `photos` VARCHAR(700) NULL,
  `rating` DECIMAL(2,2) NULL,
  `review` VARCHAR(500) NULL,
  `routeType` VARCHAR(45) NULL,
  `distance` DECIMAL(5,2) NULL,
  `elevationGain` INT NULL,
  `articleLinks` VARCHAR(700) NULL,
  `directions` VARCHAR(500) NULL,
  `share` VARCHAR(700) NULL,
  `difficulty` VARCHAR(500) NULL,
  `weather` VARCHAR(500) NULL,
  `Comment_id` INT NULL,
  `Location_id` INT NOT NULL,
  `exercise` VARCHAR(200) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Trail_Location1_idx` (`Location_id` ASC),
  CONSTRAINT `fk_Trail_Location1`
    FOREIGN KEY (`Location_id`)
    REFERENCES `Location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Playlist` ;

CREATE TABLE IF NOT EXISTS `Playlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(500) NOT NULL,
  `description` VARCHAR(500) NULL,
  `hashtags` VARCHAR(500) NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Playlist_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_Playlist_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Comment` ;

CREATE TABLE IF NOT EXISTS `Comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `actualComment` VARCHAR(45) NULL,
  `User_id` INT NOT NULL,
  `Trail_id` INT NOT NULL,
  `datePosted` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Comment_User1_idx` (`User_id` ASC),
  INDEX `fk_Comment_Trail1_idx` (`Trail_id` ASC),
  CONSTRAINT `fk_Comment_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_Trail1`
    FOREIGN KEY (`Trail_id`)
    REFERENCES `Trail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Location`
-- -----------------------------------------------------
START TRANSACTION;
USE `xtrailsdb`;
INSERT INTO `Location` (`id`, `city`, `park`, `state`, `longitude`, `latitude`, `county`, `street`, `zipcode`) VALUES (1, 'Centennial', 'idk', 'CO', NULL, NULL, 'Arapahoe', NULL, NULL);
INSERT INTO `Location` (`id`, `city`, `park`, `state`, `longitude`, `latitude`, `county`, `street`, `zipcode`) VALUES (2, 'High line Canal Trail', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `Location` (`id`, `city`, `park`, `state`, `longitude`, `latitude`, `county`, `street`, `zipcode`) VALUES (3, 'Lakewood', 'Sloans Lake Park', 'CO', -105.05258, 39.66421, 'Arrapahoe', NULL, 80111);
INSERT INTO `Location` (`id`, `city`, `park`, `state`, `longitude`, `latitude`, `county`, `street`, `zipcode`) VALUES (4, 'Englewood', 'some park in englewood', 'CO', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `Location` (`id`, `city`, `park`, `state`, `longitude`, `latitude`, `county`, `street`, `zipcode`) VALUES (5, 'Conifer', 'stauton park', 'CO', NULL, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `User`
-- -----------------------------------------------------
START TRANSACTION;
USE `xtrailsdb`;
INSERT INTO `User` (`id`, `username`, `email`, `active`, `playlist`, `comments`, `favorite_activities`, `stats`, `Location_id`, `role`, `enabled`, `password`) VALUES (1, 'matt', 'matt@matt.com', 1, NULL, NULL, 'cycling', NULL, 1, NULL, 1, '123');
INSERT INTO `User` (`id`, `username`, `email`, `active`, `playlist`, `comments`, `favorite_activities`, `stats`, `Location_id`, `role`, `enabled`, `password`) VALUES (2, 'vanessa', 'vanessa@aol.com', 1, NULL, NULL, 'running', NULL, 2, NULL, 1, 'pass');
INSERT INTO `User` (`id`, `username`, `email`, `active`, `playlist`, `comments`, `favorite_activities`, `stats`, `Location_id`, `role`, `enabled`, `password`) VALUES (3, 'james', 'james@aol.com', 1, NULL, NULL, 'mountain biking', NULL, 3, NULL, 1, 'pass2');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Trail`
-- -----------------------------------------------------
START TRANSACTION;
USE `xtrailsdb`;
INSERT INTO `Trail` (`id`, `name`, `location`, `dogFriendly`, `hashtags`, `description`, `photos`, `rating`, `review`, `routeType`, `distance`, `elevationGain`, `articleLinks`, `directions`, `share`, `difficulty`, `weather`, `Comment_id`, `Location_id`, `exercise`) VALUES (1, 'high line canal', 'greenwood village', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 4, NULL);
INSERT INTO `Trail` (`id`, `name`, `location`, `dogFriendly`, `hashtags`, `description`, `photos`, `rating`, `review`, `routeType`, `distance`, `elevationGain`, `articleLinks`, `directions`, `share`, `difficulty`, `weather`, `Comment_id`, `Location_id`, `exercise`) VALUES (2, 'ken caryl trail', 'ken caryl', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 5, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Playlist`
-- -----------------------------------------------------
START TRANSACTION;
USE `xtrailsdb`;
INSERT INTO `Playlist` (`id`, `name`, `description`, `hashtags`, `User_id`) VALUES (1, '5 milers', '5 mile trails i enjoy', NULL, 1);
INSERT INTO `Playlist` (`id`, `name`, `description`, `hashtags`, `User_id`) VALUES (2, 'bike routes', 'sweet mtn bike routes', NULL, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `xtrailsdb`;
INSERT INTO `Comment` (`id`, `actualComment`, `User_id`, `Trail_id`, `datePosted`) VALUES (1, 'this trail is awesome', 1, 1, '2020-04-27');
INSERT INTO `Comment` (`id`, `actualComment`, `User_id`, `Trail_id`, `datePosted`) VALUES (2, 'this playlist is awesome', 3, 2, '2020-04-27');

COMMIT;

