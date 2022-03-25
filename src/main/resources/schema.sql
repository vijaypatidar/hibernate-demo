-- hibernate.country definition

CREATE TABLE `country` (
  `country_id` bigint NOT NULL AUTO_INCREMENT,
  `country_name` varchar(50) NOT NULL,
  `country_code` varchar(3) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- hibernate.users definition

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- hibernate.state definition

CREATE TABLE `state` (
  `state_id` bigint NOT NULL AUTO_INCREMENT,
  `country_id` bigint NOT NULL,
  `state_name` varchar(50) NOT NULL,
  `state_code` varchar(3) NOT NULL,
  PRIMARY KEY (`state_id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `state_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- hibernate.user_roles definition

CREATE TABLE `user_roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`,`role`),
  KEY `username` (`username`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- hibernate.city definition

CREATE TABLE `city` (
  `city_id` bigint NOT NULL AUTO_INCREMENT,
  `state_id` bigint NOT NULL,
  `city_name` varchar(50) NOT NULL,
  PRIMARY KEY (`city_id`),
  KEY `state_id` (`state_id`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- hibernate.user_addresses definition

CREATE TABLE `user_addresses` (
  `address_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `country_code` varchar(25) NOT NULL,
  `state_code` varchar(25) NOT NULL,
  `city_id` bigint NOT NULL,
  PRIMARY KEY (`address_id`),
  KEY `username` (`username`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `user_addresses_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  CONSTRAINT `user_addresses_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;