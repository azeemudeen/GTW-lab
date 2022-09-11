CREATE DATABASE servletdb;

CREATE TABLE users_demo (
id int AUTO_INCREMENT,
name VARCHAR(20),
password VARCHAR(20),
flag TINYINT(1) DEFAULT 0,
PRIMARY KEY(id)
);

CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 