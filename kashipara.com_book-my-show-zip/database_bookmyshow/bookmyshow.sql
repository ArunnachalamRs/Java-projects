-- MySQL dump 10.13  Distrib 5.5.50, for Win32 (x86)
--
-- Host: localhost    Database: bookmyshow
-- ------------------------------------------------------
-- Server version	5.5.50

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
-- Table structure for table `shaad1`
--

DROP TABLE IF EXISTS `shaad1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shaad1` (
  `seat_type` varchar(20) DEFAULT NULL,
  `seat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shaad1`
--

LOCK TABLES `shaad1` WRITE;
/*!40000 ALTER TABLE `shaad1` DISABLE KEYS */;
INSERT INTO `shaad1` VALUES ('silver',183),('gold',71),('diamond',28);
/*!40000 ALTER TABLE `shaad1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shaad2`
--

DROP TABLE IF EXISTS `shaad2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shaad2` (
  `seat_type` varchar(20) DEFAULT NULL,
  `seat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shaad2`
--

LOCK TABLES `shaad2` WRITE;
/*!40000 ALTER TABLE `shaad2` DISABLE KEYS */;
INSERT INTO `shaad2` VALUES ('silver',196),('gold',71),('diamond',28);
/*!40000 ALTER TABLE `shaad2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shaad3`
--

DROP TABLE IF EXISTS `shaad3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shaad3` (
  `seat_type` varchar(20) DEFAULT NULL,
  `seat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shaad3`
--

LOCK TABLES `shaad3` WRITE;
/*!40000 ALTER TABLE `shaad3` DISABLE KEYS */;
INSERT INTO `shaad3` VALUES ('silver',196),('gold',71),('diamond',26);
/*!40000 ALTER TABLE `shaad3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw1`
--

DROP TABLE IF EXISTS `sw1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sw1` (
  `seat_type` varchar(20) DEFAULT NULL,
  `seat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw1`
--

LOCK TABLES `sw1` WRITE;
/*!40000 ALTER TABLE `sw1` DISABLE KEYS */;
INSERT INTO `sw1` VALUES ('silver',192),('gold',67),('Diamond',28);
/*!40000 ALTER TABLE `sw1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw2`
--

DROP TABLE IF EXISTS `sw2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sw2` (
  `seat_type` varchar(20) DEFAULT NULL,
  `seat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw2`
--

LOCK TABLES `sw2` WRITE;
/*!40000 ALTER TABLE `sw2` DISABLE KEYS */;
INSERT INTO `sw2` VALUES ('silver',196),('gold',71),('Diamond',26);
/*!40000 ALTER TABLE `sw2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw3`
--

DROP TABLE IF EXISTS `sw3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sw3` (
  `seat_type` varchar(20) DEFAULT NULL,
  `seat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw3`
--

LOCK TABLES `sw3` WRITE;
/*!40000 ALTER TABLE `sw3` DISABLE KEYS */;
INSERT INTO `sw3` VALUES ('silver',196),('gold',71),('Diamond',24);
/*!40000 ALTER TABLE `sw3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ts1`
--

DROP TABLE IF EXISTS `ts1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ts1` (
  `seat_type` varchar(20) DEFAULT NULL,
  `seat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ts1`
--

LOCK TABLES `ts1` WRITE;
/*!40000 ALTER TABLE `ts1` DISABLE KEYS */;
INSERT INTO `ts1` VALUES ('silver',158),('gold',57),('Diamond',24);
/*!40000 ALTER TABLE `ts1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ts2`
--

DROP TABLE IF EXISTS `ts2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ts2` (
  `seat_type` varchar(20) DEFAULT NULL,
  `seat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ts2`
--

LOCK TABLES `ts2` WRITE;
/*!40000 ALTER TABLE `ts2` DISABLE KEYS */;
INSERT INTO `ts2` VALUES ('silver',190),('gold',60),('Diamond',28);
/*!40000 ALTER TABLE `ts2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ts3`
--

DROP TABLE IF EXISTS `ts3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ts3` (
  `seat_type` varchar(20) DEFAULT NULL,
  `seat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ts3`
--

LOCK TABLES `ts3` WRITE;
/*!40000 ALTER TABLE `ts3` DISABLE KEYS */;
INSERT INTO `ts3` VALUES ('silver',196),('gold',71),('Diamond',26);
/*!40000 ALTER TABLE `ts3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `name` varchar(40) DEFAULT NULL,
  `email` varchar(40) NOT NULL DEFAULT '',
  `password` varchar(30) DEFAULT NULL,
  `mobile` varchar(20) NOT NULL DEFAULT '',
  `city` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`email`,`mobile`),
  UNIQUE KEY `email` (`email`,`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES ('gulfam hassan','gulfam.h@gmail.com','123456','9874563210','delhi','MALE');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-24  2:31:28
