/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 8.0.11 : Database - table_post
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`table_post` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `table_post`;

/*Table structure for table `assinatura` */

DROP TABLE IF EXISTS `assinatura`;

CREATE TABLE `assinatura` (
  `id_ASSINATURA` int(11) NOT NULL AUTO_INCREMENT,
  `id_plano` int(11) NOT NULL,
  `desconto` int(3) DEFAULT NULL,
  `data_inicial` date DEFAULT NULL,
  `data_final` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `id_forma_pgt` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_ASSINATURA`),
  KEY `id_plano_idx` (`id_plano`),
  KEY `id_forma_pgt_idx` (`id_forma_pgt`),
  KEY `id_user_idx` (`id_user`),
  CONSTRAINT `id_forma_pgt` FOREIGN KEY (`id_forma_pgt`) REFERENCES `forma_pgt` (`id_forma_pgt`),
  CONSTRAINT `id_plano` FOREIGN KEY (`id_plano`) REFERENCES `plano` (`id_plano`),
  CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `assinatura` */

insert  into `assinatura`(`id_ASSINATURA`,`id_plano`,`desconto`,`data_inicial`,`data_final`,`status`,`id_forma_pgt`,`id_user`) values 
(1,3,5,'2008-09-19','2018-12-12','Aberto',2,13),
(2,1,78,'1998-03-31','2008-03-31','Boleto Bancário',3,6);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id_category`,`description`) values 
(1,'Postagens legais'),
(2,'Infantil'),
(4,'Literatura');

/*Table structure for table `forma_pgt` */

DROP TABLE IF EXISTS `forma_pgt`;

CREATE TABLE `forma_pgt` (
  `id_forma_pgt` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(127) DEFAULT NULL,
  PRIMARY KEY (`id_forma_pgt`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `forma_pgt` */

insert  into `forma_pgt`(`id_forma_pgt`,`descricao`) values 
(2,'Cartão de Crédito'),
(3,'Boleto Bancário');

/*Table structure for table `plano` */

DROP TABLE IF EXISTS `plano`;

CREATE TABLE `plano` (
  `id_plano` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(127) DEFAULT NULL,
  `preco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_plano`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `plano` */

insert  into `plano`(`id_plano`,`descricao`,`preco`) values 
(1,'Plano master','578.50'),
(2,'Plano Médio','129,90'),
(3,'Plano Básico','49,90');

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `Id_Post` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) DEFAULT NULL,
  `id_author` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `published_at` datetime DEFAULT NULL,
  PRIMARY KEY (`Id_Post`),
  KEY `author_idx` (`id_author`),
  KEY `category_idx` (`id_category`),
  CONSTRAINT `id_author` FOREIGN KEY (`id_author`) REFERENCES `user` (`id_user`),
  CONSTRAINT `id_category` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `post` */

insert  into `post`(`Id_Post`,`content`,`id_author`,`id_category`,`created_at`,`published_at`) values 
(1,'A Tataia é tão linda! Nhaaa!',13,2,'0027-01-08 04:00:00','0028-01-08 04:00:00'),
(2,'Tataia Tatainha nhanhanhanhanhanhanha!!!',13,1,'2018-11-20 03:00:00','2018-11-22 03:00:00'),
(3,'ATIREI O PAU NO GATO, MAS O GATO NÃO MORREEEEEU!',13,1,'2018-11-13 03:00:00','2018-11-28 03:00:00'),
(4,'Olá, mundo! Teste de novo post!',6,2,'2018-11-09 03:00:00','2018-11-10 03:00:00'),
(5,'Gosto das HQs do Homem-Aranha',8,2,'2018-11-14 03:00:00','2018-11-16 03:00:00'),
(6,'Fui publicada em um livro de poesias sobre a história de Naipi, pq eu sou demais!',9,2,'2018-11-09 03:00:00','2018-11-10 03:00:00'),
(7,'Amo livros! Sou uma escritora renomada, a melhor de todas!',10,4,'2018-11-06 03:00:00','2018-11-20 03:00:00');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`id_role`,`description`) values 
(2,'Analista de Banco de Dados'),
(4,'Programador'),
(6,'Gerente de Infra'),
(7,'Analista de Desenvolvimento Pleno'),
(8,'Analista de Contrato de Comodato'),
(12,'Escritor');

/*Table structure for table `tags` */

DROP TABLE IF EXISTS `tags`;

CREATE TABLE `tags` (
  `Id_Tags` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id_Tags`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tags` */

insert  into `tags`(`Id_Tags`,`description`) values 
(1,'Computação'),
(3,'Java'),
(5,'Livros');

/*Table structure for table `tags_has_post` */

DROP TABLE IF EXISTS `tags_has_post`;

CREATE TABLE `tags_has_post` (
  `post_id` int(11) NOT NULL,
  `tags_id` int(11) NOT NULL,
  KEY `fk_tags_has_post_post1_idx` (`post_id`),
  KEY `fk_tags_has_post_tags1_idx` (`tags_id`),
  CONSTRAINT `Tags_id` FOREIGN KEY (`tags_id`) REFERENCES `tags` (`id_tags`),
  CONSTRAINT `fk_tags_has_post_post1` FOREIGN KEY (`post_id`) REFERENCES `post` (`Id_Post`),
  CONSTRAINT `post_id` FOREIGN KEY (`post_id`) REFERENCES `post` (`id_post`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tags_has_post` */

insert  into `tags_has_post`(`post_id`,`tags_id`) values 
(3,1),
(4,1),
(5,3),
(7,5);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `role_idx` (`id_role`),
  CONSTRAINT `id_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id_user`,`name`,`username`,`email`,`password`,`id_role`) values 
(6,'Rafael Nonino Filho','rnonino','rnonino@gmail.com','rnonino123456789',7),
(8,'Filipe Santos','fsantos','fsantos@veltec.com.br','fsantos123456789',6),
(9,'Natália Cristina Martins de Sá','nataliacmsa','nataliacmsa@gmail.com','tataia123456',7),
(10,'Naty 2','naty2','naty2@gmail.com','tataia123123',12),
(13,'Victor Hugo Negrisoli','vhnegrisoli','vhnegrisoli@gmail.com','123456789',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
