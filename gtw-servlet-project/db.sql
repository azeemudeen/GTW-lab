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
  `image_uri` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `product_category` (
  `id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO `servletdb`.`product_category` (`id`, `name`) VALUES ('1', 'fruit');
INSERT INTO `servletdb`.`product_category` (`id`, `name`) VALUES ('2', 'vegetable');

