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
-- Table structure for table `pc`
--

DROP TABLE IF EXISTS `pc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pc` (
  `id_formulario` int(11) NOT NULL AUTO_INCREMENT,
  `datacad` varchar(100) DEFAULT NULL,
  `codpc` varchar(500) NOT NULL,
  `nome_pc` varchar(500) DEFAULT NULL,
  `processador` varchar(500) DEFAULT NULL,
  `marca_pc` varchar(500) DEFAULT NULL,
  `hd` varchar(10) DEFAULT NULL,
  `memoria` varchar(10) DEFAULT NULL,
  `so` varchar(500) DEFAULT NULL,
  `garantia` varchar(100) DEFAULT NULL,
  `status_pc` varchar(50) DEFAULT NULL,
  `modelo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_formulario`),
  UNIQUE KEY `codpc` (`codpc`),
  UNIQUE KEY `nome_pc` (`nome_pc`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pc`
--

LOCK TABLES `pc` WRITE;
/*!40000 ALTER TABLE `pc` DISABLE KEYS */;
INSERT INTO `pc` VALUES (3,'08/07/2020 13:52:57','HP2','HP1','Athlon 3500+ 2.20Ghz','HP','75GB','5GB','win7PRO-32b','00/00/0000','No Estoque','HP'),(4,'08/07/2020 13:53:36','HP','HP2','athlon 5000+ 2.60Ghz','HP','75GB','4GB','win7PRO-32b','00/00/0000','No Estoque','HP'),(5,'08/07/2020 13:54:44','HP3','HP3','athlon 5000+ 2.60Ghz','HP','75GB','4GB','win7PRO','00/00/0000','No Estoque','HP'),(6,'08/07/2020 13:55:13','HP4','HP4','Athlon 4450B + 2.30Ghz','HP','75GB','4GB','win7PRO-32b','00/00/0000','No Estoque','HP'),(7,'08/07/2020 13:55:49','POSITIVO1','POSITIVO1','Pentium 4','POSITIVO','80GB','-','Linux/Win','00/00/0000','No Estoque','POSITIVO'),(8,'08/07/2020 13:56:15','CCE1','CCE1','Pentium E2180 2.00Ghz','CCE','74GB','4GB','win7PRO-32b','00/00/0000','No Estoque','CCE'),(9,'08/07/2020 13:56:47','HP5','HP5','Athlon 3500+ 2.20Ghz','HP','74GB','4GB','win7PRO-32b','00/00/0000','No Estoque','HP'),(10,'08/07/2020 13:57:11','HP6','HP6','Celeron 2.66Ghz','HP','37GB','4GB','win7PRO-32b','00/00/0000','No Estoque','HP'),(11,'08/07/2020 13:57:31','HP7','HP7','Pentium 3.00Ghz','HP','75GB','3GB','win7PRO-64b','00/00/0000','No Estoque','HP'),(12,'21/07/2020 16:31:04','XXXXXX','JH016 ','amd Athlon(tm) Dual Core ','HP9','75GB ','4GB ','Windows 7 Pro ','00/00/0000','Saida','HP9'),(13,'23/07/2020 17:19:02','HPJH00','jh00','AMD Athon(tM) ','HP','75GB','4GB','Windows 7 Pro','00/00/0000','Saida','64 Processor 3500');
/*!40000 ALTER TABLE `pc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-24 12:14:42
