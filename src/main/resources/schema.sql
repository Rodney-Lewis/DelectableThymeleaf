-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.36-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for delectable
CREATE DATABASE IF NOT EXISTS `delectable` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `delectable`;

-- Dumping structure for table delectable.nutrient
CREATE TABLE IF NOT EXISTS `nutrient` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `unit_of_measure` varchar(255) DEFAULT NULL,
  `value` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table delectable.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `calories` int(11) NOT NULL,
  `ingredient` bit(1) NOT NULL,
  `ingredients` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `premade` bit(1) NOT NULL,
  `serving_size` float NOT NULL,
  `unit_of_measure` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table delectable.recipe
CREATE TABLE IF NOT EXISTS `recipe` (
  `id` int(11) NOT NULL,
  `cook_time` time DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `directions` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prep_time` time DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table delectable.restaurant
CREATE TABLE IF NOT EXISTS `restaurant` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `carry_out` bit(1) NOT NULL,
  `delivers` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table delectable.vendor
CREATE TABLE IF NOT EXISTS `vendor` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
