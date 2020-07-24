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
-- Table structure for table `kit`
--

DROP TABLE IF EXISTS `kit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kit` (
  `id_kit` int(11) NOT NULL AUTO_INCREMENT,
  `data_kit` varchar(200) DEFAULT NULL,
  `status_kit` varchar(200) DEFAULT NULL,
  `id_operador` varchar(200) DEFAULT NULL,
  `nome_operador` varchar(500) DEFAULT NULL,
  `telefone` varchar(200) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  `endereco` varchar(500) DEFAULT NULL,
  `cargo` varchar(500) DEFAULT NULL,
  `setor` varchar(500) DEFAULT NULL,
  `supervisor` varchar(500) DEFAULT NULL,
  `operacao` varchar(500) DEFAULT NULL,
  `nome_pc` varchar(500) DEFAULT NULL,
  `cod_pc` varchar(500) DEFAULT NULL,
  `marca_pc` varchar(500) DEFAULT NULL,
  `modelo_pc` varchar(500) DEFAULT NULL,
  `processador` varchar(500) DEFAULT NULL,
  `memoria` varchar(200) DEFAULT NULL,
  `so` varchar(200) DEFAULT NULL,
  `hd` varchar(200) DEFAULT NULL,
  `garantia` varchar(200) DEFAULT NULL,
  `marca_monitor` varchar(500) DEFAULT NULL,
  `marca_teclado` varchar(500) DEFAULT NULL,
  `marca_mouse` varchar(200) DEFAULT NULL,
  `marca_head` varchar(200) DEFAULT NULL,
  `marca_webcam` varchar(200) DEFAULT NULL,
  `qnt_vga` varchar(200) DEFAULT NULL,
  `qnt_e` varchar(200) DEFAULT NULL,
  `rede` varchar(200) DEFAULT NULL,
  `lacre` varchar(200) DEFAULT NULL,
  `id_monitor` varchar(200) DEFAULT NULL,
  `cod_monitor` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_kit`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kit`
--

LOCK TABLES `kit` WRITE;
/*!40000 ALTER TABLE `kit` DISABLE KEYS */;
INSERT INTO `kit` VALUES (1,'21/07/2020 17:00:44','Saida','3','Denise Araujo','(31)3131-3111','denise.araujo@jhome.com.br','xxxx','Agente','Agente','Eloisa','Rakuten','JH016 ','XXXXXX','HP9','HP9','amd Athlon(tm) Dual Core ','4GB ','Windows 7 Pro ','75GB ','00/00/0000','testet','Selecione:','Selecione:','Selecione:','Selecione:','1','2','Não ','','1','teste'),(2,'23/07/2020 17:21:50','Saida','4','Thiago Silva','(12)9128-0192','thiago.silva@jhome.com.br','xxxx','Agente','4Mobee','Gabriel','xxx','jh00','HPJH00','HP','64 Processor 3500','AMD Athon(tM) ','4GB','Windows 7 Pro','75GB','00/00/0000','','Selecione:','Selecione:','Selecione:','Selecione:','1','2','Não ','jh000ThiagoNogueira','','');
/*!40000 ALTER TABLE `kit` ENABLE KEYS */;
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
