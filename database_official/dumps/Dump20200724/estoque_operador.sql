-- MariaDB dump 10.17  Distrib 10.4.13-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: estoque
-- ------------------------------------------------------
-- Server version	10.4.13-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `operador`
--

DROP TABLE IF EXISTS `operador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operador` (
  `id_operador` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` varchar(200) DEFAULT NULL,
  `nome_operador` varchar(500) DEFAULT NULL,
  `email_operador` varchar(500) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `celular` varchar(200) DEFAULT NULL,
  `endereco` varchar(500) DEFAULT NULL,
  `cep` varchar(200) DEFAULT NULL,
  `numero` varchar(200) DEFAULT NULL,
  `complemento` varchar(500) DEFAULT NULL,
  `referencia` varchar(500) DEFAULT NULL,
  `bairro` varchar(500) DEFAULT NULL,
  `cidade` varchar(500) DEFAULT NULL,
  `estado` varchar(500) DEFAULT NULL,
  `setor` varchar(500) DEFAULT NULL,
  `cargo` varchar(500) DEFAULT NULL,
  `status_operador` varchar(50) DEFAULT NULL,
  `empresa` varchar(500) DEFAULT NULL,
  `supervisor` varchar(500) DEFAULT NULL,
  `cpf` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_operador`),
  UNIQUE KEY `email_operador` (`email_operador`),
  UNIQUE KEY `tel` (`tel`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operador`
--

LOCK TABLES `operador` WRITE;
/*!40000 ALTER TABLE `operador` DISABLE KEYS */;
INSERT INTO `operador` VALUES (4,'23/07/2020','Thiago Silva','thiago.silva@jhome.com.br','(12)9128-0192','(19)2308-1093','xxxx','00000-000','xxx','xxx','xxxx','xxxxx','xxxxx','xxx','4Mobee','Agente','Selecione:','xxx','Gabriel',NULL),(3,'21/07/2020','Denise Araujo','denise.araujo@jhome.com.br','(31)3131-3111','(12)1213-1313','xxxx','11111-111','xxx','xxx','xxx','xxxx','xxx','xxx','Agente','Agente','Sem Kit','Rakuten','Eloisa',NULL);
/*!40000 ALTER TABLE `operador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-24 12:14:43
