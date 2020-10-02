-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: todoapp
-- ------------------------------------------------------
-- Server version	5.5.44

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
-- Table structure for table `adminlogin`
--

DROP TABLE IF EXISTS `adminlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminlogin` (
  `adminname` varchar(20) NOT NULL,
  `adminpwd` varchar(45) NOT NULL,
  `adminemail` varchar(45) NOT NULL,
  PRIMARY KEY (`adminname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminlogin`
--

LOCK TABLES `adminlogin` WRITE;
/*!40000 ALTER TABLE `adminlogin` DISABLE KEYS */;
INSERT INTO `adminlogin` VALUES ('admin','admin','admin@gmail.com');
/*!40000 ALTER TABLE `adminlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_signup`
--

DROP TABLE IF EXISTS `emp_signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_signup` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `emp_fname` varchar(45) NOT NULL,
  `emp_lname` varchar(45) NOT NULL,
  `emp_gen` varchar(45) NOT NULL,
  `emp_dob` date NOT NULL,
  `emp_pwd` varchar(45) NOT NULL,
  `emp_cpwd` varchar(45) NOT NULL,
  `tdate` date NOT NULL,
  `emp_email` varchar(45) NOT NULL,
  `empstatus` varchar(45) NOT NULL,
  PRIMARY KEY (`empid`),
  UNIQUE KEY `emp_email_UNIQUE` (`emp_email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_signup`
--

LOCK TABLES `emp_signup` WRITE;
/*!40000 ALTER TABLE `emp_signup` DISABLE KEYS */;
INSERT INTO `emp_signup` VALUES (1,'vikram','raut','male','1990-03-03','vikram','vikram','2020-09-29','vikram.raut2002@gmail.com','deactivate'),(2,'gaurav','patil','male','1996-05-05','gaurav','gaurav','2020-09-29','gaurav.dandge@rediffmail.com','active'),(3,'renu','dandge','female','1996-04-04','renu','renu','2020-09-29','renu.dandge@gmail.com','deactivate'),(4,'renuka','patil','female','1994-05-05','renuka','renuka','2020-09-29','renuka.dandge@gmail.com','active'),(5,'tina','rao','female','1993-02-02','tina','tina','2020-10-01','tina@gmail.com','active');
/*!40000 ALTER TABLE `emp_signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otps`
--

DROP TABLE IF EXISTS `otps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `otps` (
  `otp_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `otp` varchar(45) NOT NULL,
  PRIMARY KEY (`otp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otps`
--

LOCK TABLES `otps` WRITE;
/*!40000 ALTER TABLE `otps` DISABLE KEYS */;
INSERT INTO `otps` VALUES (1,'renu.dandge@gmail.com','2755'),(2,'vikram.raut2002@gmail.com','0182');
/*!40000 ALTER TABLE `otps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasklist`
--

DROP TABLE IF EXISTS `tasklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasklist` (
  `taskid` int(11) NOT NULL AUTO_INCREMENT,
  `taskname` varchar(45) NOT NULL,
  `taskdesc` varchar(45) NOT NULL,
  `taskstatus` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`taskid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasklist`
--

LOCK TABLES `tasklist` WRITE;
/*!40000 ALTER TABLE `tasklist` DISABLE KEYS */;
INSERT INTO `tasklist` VALUES (1,'v1','v1','new','vikram.raut2002@gmail.com','2020-09-29'),(2,'v2','v2','new','vikram.raut2002@gmail.com','2020-09-29'),(3,'g1','g1','new','gaurav.dandge@rediffmail.com','2020-09-29'),(4,'g2','g2','new','gaurav.dandge@rediffmail.com','2020-09-29'),(5,'r1','r1','new','renu.dandge@gmail.com','2020-09-29'),(6,'rr1','rr11','completed','renuka.dandge@gmail.com','2020-09-29'),(7,'rr2','rr2','new','renuka.dandge@gmail.com','2020-09-29');
/*!40000 ALTER TABLE `tasklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truncatedemo`
--

DROP TABLE IF EXISTS `truncatedemo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truncatedemo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truncatedemo`
--

LOCK TABLES `truncatedemo` WRITE;
/*!40000 ALTER TABLE `truncatedemo` DISABLE KEYS */;
INSERT INTO `truncatedemo` VALUES (1,'tiya');
/*!40000 ALTER TABLE `truncatedemo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-02 17:54:46
