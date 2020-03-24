CREATE DATABASE IF NOT EXISTS mobility_db;

CREATE TABLE IF NOT EXISTS `buses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5994 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `itineraries` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5994 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `locations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `itinerary_id` int DEFAULT NULL,
  `position` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `il_fk_idx` (`itinerary_id`),
  CONSTRAINT `il_fk` FOREIGN KEY (`itinerary_id`) REFERENCES `itineraries` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=518367 DEFAULT CHARSET=latin1;