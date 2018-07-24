CREATE DATABASE  IF NOT EXISTS `daramis` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `daramis`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: daramis
-- ------------------------------------------------------
-- Server version	5.6.37-log

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
-- Table structure for table `aif`
--

DROP TABLE IF EXISTS `aif`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aif` (
  `id_aif` int(11) NOT NULL AUTO_INCREMENT,
  `id_po` int(11) NOT NULL,
  `date_requested` date NOT NULL,
  `control_no` int(11) NOT NULL,
  `date_received` date NOT NULL,
  `received_from` varchar(45) NOT NULL,
  `received_by` varchar(45) NOT NULL,
  PRIMARY KEY (`id_aif`),
  UNIQUE KEY `id_aif_UNIQUE` (`id_aif`),
  KEY `fk_po_aif_idx` (`id_po`),
  CONSTRAINT `fk_aifdetails` FOREIGN KEY (`id_aif`) REFERENCES `aif_details` (`id_aif_details`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_po_aif` FOREIGN KEY (`id_po`) REFERENCES `po` (`id_po`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aif`
--

LOCK TABLES `aif` WRITE;
/*!40000 ALTER TABLE `aif` DISABLE KEYS */;
/*!40000 ALTER TABLE `aif` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aif_details`
--

DROP TABLE IF EXISTS `aif_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aif_details` (
  `id_aif_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_aif` int(11) NOT NULL,
  `type_of_request` varchar(45) NOT NULL,
  `type_of_request2` varchar(45) NOT NULL,
  `type_of_request_others` varchar(45) DEFAULT NULL,
  `inspector` varchar(45) NOT NULL,
  `requiered_action` varchar(45) NOT NULL,
  `required_action_others` varchar(45) DEFAULT NULL,
  `name_request` varchar(45) NOT NULL,
  `date_signed` date NOT NULL,
  PRIMARY KEY (`id_aif_details`),
  KEY `fk_aif_details_aif_idx` (`id_aif`),
  CONSTRAINT `fk_aif_details_aif` FOREIGN KEY (`id_aif`) REFERENCES `aif` (`id_aif`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aif_details`
--

LOCK TABLES `aif_details` WRITE;
/*!40000 ALTER TABLE `aif_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `aif_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcements`
--

DROP TABLE IF EXISTS `announcements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcements` (
  `id_announcements` int(11) NOT NULL AUTO_INCREMENT,
  `announcement_by` int(11) NOT NULL,
  `date_posted` date NOT NULL,
  `subject` varchar(45) NOT NULL,
  `announcement` varchar(90) NOT NULL,
  PRIMARY KEY (`id_announcements`),
  UNIQUE KEY `id_announcements_UNIQUE` (`id_announcements`),
  KEY `fk_employees_announcement_idx` (`announcement_by`),
  CONSTRAINT `fk_announcements_announcedby` FOREIGN KEY (`announcement_by`) REFERENCES `employee` (`id_employee`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcements`
--

LOCK TABLES `announcements` WRITE;
/*!40000 ALTER TABLE `announcements` DISABLE KEYS */;
INSERT INTO `announcements` VALUES (1,1,'2017-11-10','Leave','I will be on leave. Hehe'),(3,2,'2018-03-19','Good Morning','Hi'),(4,2,'2018-02-17','Good Morning','Hi'),(5,3,'2018-03-20','DAR-AMIS in Progress','Faith in DLSU Group!'),(6,2,'2018-03-20','Announcement','Walang pasok today! Hehe');
/*!40000 ALTER TABLE `announcements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apc`
--

DROP TABLE IF EXISTS `apc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apc` (
  `id_apc` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id for Asset Physical Count\n',
  `id_po` int(11) NOT NULL,
  PRIMARY KEY (`id_apc`),
  UNIQUE KEY `id_items_UNIQUE` (`id_apc`),
  KEY `fk_id_po_idx` (`id_po`),
  CONSTRAINT `fk_apc_po` FOREIGN KEY (`id_po`) REFERENCES `po` (`id_po`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apc`
--

LOCK TABLES `apc` WRITE;
/*!40000 ALTER TABLE `apc` DISABLE KEYS */;
/*!40000 ALTER TABLE `apc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app`
--

DROP TABLE IF EXISTS `app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app` (
  `id_app` int(11) NOT NULL AUTO_INCREMENT,
  `id_office` int(11) NOT NULL,
  `item_specs` varchar(45) NOT NULL,
  PRIMARY KEY (`id_app`),
  UNIQUE KEY `id_app_UNIQUE` (`id_app`),
  KEY `fk_office_app_idx` (`id_office`),
  CONSTRAINT `fk_office_app` FOREIGN KEY (`id_office`) REFERENCES `office` (`id_office`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app`
--

LOCK TABLES `app` WRITE;
/*!40000 ALTER TABLE `app` DISABLE KEYS */;
INSERT INTO `app` VALUES (3,4,'Chair'),(4,4,'table'),(5,4,'table'),(6,4,'shelf'),(8,4,'qweqweqeqw');
/*!40000 ALTER TABLE `app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_details`
--

DROP TABLE IF EXISTS `app_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_details` (
  `id_app_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_app` int(11) NOT NULL,
  `item_spec` varchar(120) DEFAULT NULL,
  `q1` double DEFAULT NULL,
  `q2` double DEFAULT NULL,
  `q3` double DEFAULT NULL,
  `q4` double DEFAULT NULL,
  `total_qty` int(11) DEFAULT NULL,
  `total_price_afn` double DEFAULT NULL,
  `id_office` int(11) NOT NULL,
  PRIMARY KEY (`id_app_details`),
  UNIQUE KEY `id_app_details_UNIQUE` (`id_app_details`),
  KEY `fk_app` (`id_app`),
  CONSTRAINT `fk_app_details_app` FOREIGN KEY (`id_app`) REFERENCES `app` (`id_app`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_details`
--

LOCK TABLES `app_details` WRITE;
/*!40000 ALTER TABLE `app_details` DISABLE KEYS */;
INSERT INTO `app_details` VALUES (1,3,NULL,10,20,30,40,NULL,NULL,4),(2,5,NULL,10,10,10,10,NULL,NULL,4),(3,6,NULL,10,20,10,20,NULL,NULL,4),(4,8,'qweqweqeqw',123,123,123,123,5,123123123,4);
/*!40000 ALTER TABLE `app_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset`
--

DROP TABLE IF EXISTS `asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asset` (
  `id_asset` int(11) NOT NULL AUTO_INCREMENT,
  `id_apc` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `id_po` int(11) NOT NULL,
  PRIMARY KEY (`id_asset`),
  UNIQUE KEY `id_asset_UNIQUE` (`id_asset`),
  KEY `fk_items_idx` (`id_apc`),
  CONSTRAINT `fk_items` FOREIGN KEY (`id_apc`) REFERENCES `apc` (`id_apc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `division` (
  `id_division` int(11) NOT NULL AUTO_INCREMENT,
  `id_office` int(11) NOT NULL,
  `division` mediumtext NOT NULL,
  PRIMARY KEY (`id_division`),
  UNIQUE KEY `id_division_UNIQUE` (`id_division`),
  KEY `fk_office_division_idx` (`id_office`),
  CONSTRAINT `fk_office_division` FOREIGN KEY (`id_office`) REFERENCES `office` (`id_office`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,4,'Admin Services'),(3,4,'General Services'),(4,4,'Financial Management'),(6,4,'Management'),(7,4,'Records'),(8,4,'Procurement'),(9,4,'Personnel');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dr`
--

DROP TABLE IF EXISTS `dr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dr` (
  `id_dr` int(11) NOT NULL AUTO_INCREMENT,
  `id_po` int(11) NOT NULL,
  `id_sc` int(11) NOT NULL,
  `id_pc` int(11) NOT NULL,
  PRIMARY KEY (`id_dr`),
  UNIQUE KEY `id_dr_UNIQUE` (`id_dr`),
  KEY `fk_po_idx` (`id_po`),
  CONSTRAINT `fk_dr_po` FOREIGN KEY (`id_po`) REFERENCES `po` (`id_po`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dr`
--

LOCK TABLES `dr` WRITE;
/*!40000 ALTER TABLE `dr` DISABLE KEYS */;
/*!40000 ALTER TABLE `dr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dr_details`
--

DROP TABLE IF EXISTS `dr_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dr_details` (
  `id_dr_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_dr` int(11) NOT NULL,
  PRIMARY KEY (`id_dr_details`),
  UNIQUE KEY `id_dr_details_UNIQUE` (`id_dr_details`),
  KEY `fk_dr_details_parent_idx` (`id_dr`),
  CONSTRAINT `fk_dr_details_parent` FOREIGN KEY (`id_dr`) REFERENCES `dr` (`id_dr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dr_details`
--

LOCK TABLES `dr_details` WRITE;
/*!40000 ALTER TABLE `dr_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `dr_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id_employee` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `middle_initial` varchar(45) DEFAULT NULL,
  `civil_status` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(120) NOT NULL,
  `dob` date NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile_num` varchar(45) NOT NULL,
  `employee_status` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `id_tier` int(11) DEFAULT NULL,
  `id_division` int(11) DEFAULT NULL,
  `user_activated` int(11) NOT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id_employee`),
  UNIQUE KEY `id_employee_UNIQUE` (`id_employee`),
  KEY `fk_tier_idx` (`id_tier`),
  KEY `fk_division_idx` (`id_division`),
  CONSTRAINT `fk_division` FOREIGN KEY (`id_division`) REFERENCES `division` (`id_division`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tier` FOREIGN KEY (`id_tier`) REFERENCES `tier` (`id_tier`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Colocar','Rene','E','Married','Male','101 Elliptical Rd Quezon City','1961-11-12','rc@dar.gov','09171234567','Regular','rc@dar.gov','1234',1,1,1,NULL),(2,'Bilog','Maria Rowena','C','Married','Female','910 Commonwealth Ave Quezon City','1963-04-21','mb@dar.gov','09170987654','Regular','mb@dar.gov','1234',2,1,1,'2018-03-22'),(3,'Juliano','Gloria','A','Married','Female','122 North Ave Quezon City','1969-09-09','gj@dar.gov','09188901234','Regular','gj@dar.gov','1234',3,3,1,NULL),(4,'Abante','Jonie','P','Married','Male','421 Visayas Ave Quezon City','1972-06-12','ja@dar.gov','09174321234','Regular','ja@dar.gov','1234',4,3,1,'2018-03-22'),(5,'Santos','John','S','Single','Male','123 Timog Ave Quezon City','1981-09-18','js@dar.gov','09177890123','Regular','js@dar.gov','1234',5,3,1,'2018-03-22'),(7,'Tuason','Angelo','Y','Single','Male','456 Visayas Ave Quezon City','1986-11-01','at@dar.gov','09157994069','Regular','at@dar.gov','1234',6,6,1,'2018-03-22'),(8,'Castro','Bryan','Q','Single','Male','391 Commonwealth Ave Quezon City','1989-12-01','bc@dar.gov','09179398922','Regular','bc@dar.gov','1234',6,6,0,NULL),(9,'Dominado','Keanu','C','1','1','2401 Taft Avenue Manila City','1994-11-10','kd@dar.gov','09209590269','1','kd@dar.gov','1234',6,1,0,'2018-03-24');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_repo`
--

DROP TABLE IF EXISTS `form_repo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form_repo` (
  `id_form_repo` int(11) NOT NULL AUTO_INCREMENT,
  `id_pr` int(11) DEFAULT NULL,
  `id_po` int(11) DEFAULT NULL,
  `id_ptr` int(11) DEFAULT NULL,
  `id_ris` int(11) DEFAULT NULL,
  `id_rfi` int(11) DEFAULT NULL,
  `id_par` int(11) DEFAULT NULL,
  `id_aif` int(11) DEFAULT NULL,
  `id_iar` int(11) DEFAULT NULL,
  `id_rsmi` int(11) DEFAULT NULL,
  `id_ics` int(11) DEFAULT NULL,
  `id_ppelc` int(11) DEFAULT NULL,
  `id_rpci` int(11) DEFAULT NULL,
  `id_rpcppe` int(11) DEFAULT NULL,
  `id_wmr` int(11) DEFAULT NULL,
  `id_iirup` int(11) DEFAULT NULL,
  `id_sc` int(11) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `approved_by` int(11) DEFAULT NULL,
  `denied_by` int(11) DEFAULT NULL,
  `approve_date` date DEFAULT NULL,
  `deny_date` date DEFAULT NULL,
  `comments` mediumtext,
  PRIMARY KEY (`id_form_repo`),
  UNIQUE KEY `id_form_repo_UNIQUE` (`id_form_repo`),
  KEY `fk_pr_repo_idx` (`id_pr`),
  KEY `fk_po_repo_idx` (`id_po`),
  KEY `fk_aif_repo_idx` (`id_aif`),
  KEY `fk_rsmi_repo_idx` (`id_rsmi`),
  KEY `fk_ics_repo_idx` (`id_ics`),
  KEY `fk_sc_repo_idx` (`id_sc`),
  KEY `fk_par_repo_idx` (`id_par`),
  KEY `fk_ppelc_repo_idx` (`id_ppelc`),
  KEY `fk_rpci_repo_idx` (`id_rpci`),
  KEY `fk_rpcppe_repo_idx` (`id_rpcppe`),
  KEY `fk_wmr_repo_idx` (`id_wmr`),
  KEY `fk_iirup_repo_idx` (`id_iirup`),
  KEY `fk_ptr_repo_idx` (`id_ptr`),
  KEY `fk_rfi_repo_idx` (`id_rfi`),
  KEY `fk_approve_emp_idx` (`approved_by`),
  KEY `fk_denied_emp_idx` (`denied_by`),
  KEY `fk_created_emp` (`created_by`),
  KEY `fk_ris_repo_idx` (`id_ris`),
  CONSTRAINT `fk_aif_repo` FOREIGN KEY (`id_aif`) REFERENCES `aif` (`id_aif`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_approve_emp` FOREIGN KEY (`approved_by`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_created_emp` FOREIGN KEY (`created_by`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_denied_emp` FOREIGN KEY (`denied_by`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ics_repo` FOREIGN KEY (`id_ics`) REFERENCES `ics` (`id_ics`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iirup_repo` FOREIGN KEY (`id_iirup`) REFERENCES `iirup` (`id_iirup`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_par_repo` FOREIGN KEY (`id_par`) REFERENCES `par` (`id_par`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_po_repo` FOREIGN KEY (`id_po`) REFERENCES `po` (`id_po`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ppelc_repo` FOREIGN KEY (`id_ppelc`) REFERENCES `ppelc` (`id_ppelc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pr_repo` FOREIGN KEY (`id_pr`) REFERENCES `pr` (`id_pr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ptr_repo` FOREIGN KEY (`id_ptr`) REFERENCES `ptr` (`id_ptr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rfi_repo` FOREIGN KEY (`id_rfi`) REFERENCES `rfi` (`id_rfi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ris_repo` FOREIGN KEY (`id_ris`) REFERENCES `ris` (`id_ris`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rpci_repo` FOREIGN KEY (`id_rpci`) REFERENCES `rpci` (`id_rpci`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rpcppe_repo` FOREIGN KEY (`id_rpcppe`) REFERENCES `rpcppe` (`id_rpcppe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rsmi_repo` FOREIGN KEY (`id_rsmi`) REFERENCES `rsmi` (`id_rsmi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sc_repo` FOREIGN KEY (`id_sc`) REFERENCES `sc` (`id_sc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_wmr_repo` FOREIGN KEY (`id_wmr`) REFERENCES `wmr` (`id_wmr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_repo`
--

LOCK TABLES `form_repo` WRITE;
/*!40000 ALTER TABLE `form_repo` DISABLE KEYS */;
INSERT INTO `form_repo` VALUES (19,37,13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL),(21,38,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL),(22,39,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL),(30,48,17,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL),(31,58,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `form_repo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iar`
--

DROP TABLE IF EXISTS `iar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iar` (
  `id_iar` int(11) NOT NULL,
  `entity_name` varchar(45) DEFAULT NULL,
  `ris_no` int(11) DEFAULT NULL,
  `fund_cluster` varchar(45) DEFAULT NULL,
  `ris_date` date DEFAULT NULL,
  `supplier` varchar(45) DEFAULT NULL,
  `invoice_no` int(11) DEFAULT NULL,
  `po_no` int(11) DEFAULT NULL,
  `invoice_date` date DEFAULT NULL,
  `requisitioning_dept` varchar(45) DEFAULT NULL,
  `responsibility_code` varchar(45) DEFAULT NULL,
  `date_inspected` date DEFAULT NULL,
  `verified` tinyint(4) DEFAULT NULL,
  `inspection_committee` varchar(45) DEFAULT NULL,
  `date_received` date DEFAULT NULL,
  `complete` tinyint(4) DEFAULT NULL,
  `partial` tinyint(4) DEFAULT NULL,
  `specific_quantity` int(11) DEFAULT NULL,
  `supply_officer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_iar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iar`
--

LOCK TABLES `iar` WRITE;
/*!40000 ALTER TABLE `iar` DISABLE KEYS */;
/*!40000 ALTER TABLE `iar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iar_details`
--

DROP TABLE IF EXISTS `iar_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iar_details` (
  `id_iar_details` int(11) NOT NULL,
  `iar_no` int(11) NOT NULL,
  `stock_no` int(11) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_iar_details`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iar_details`
--

LOCK TABLES `iar_details` WRITE;
/*!40000 ALTER TABLE `iar_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `iar_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ics`
--

DROP TABLE IF EXISTS `ics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ics` (
  `id_ics` int(11) NOT NULL AUTO_INCREMENT,
  `id_ics_details` int(11) NOT NULL,
  PRIMARY KEY (`id_ics`),
  UNIQUE KEY `id_ics_UNIQUE` (`id_ics`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ics`
--

LOCK TABLES `ics` WRITE;
/*!40000 ALTER TABLE `ics` DISABLE KEYS */;
/*!40000 ALTER TABLE `ics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ics_details`
--

DROP TABLE IF EXISTS `ics_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ics_details` (
  `id_ics_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_ics` int(11) NOT NULL,
  PRIMARY KEY (`id_ics_details`),
  UNIQUE KEY `id_ics_details_UNIQUE` (`id_ics_details`),
  KEY `dk_ics_details_parent_idx` (`id_ics`),
  CONSTRAINT `dk_ics_details_parent` FOREIGN KEY (`id_ics`) REFERENCES `ics` (`id_ics`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ics_details`
--

LOCK TABLES `ics_details` WRITE;
/*!40000 ALTER TABLE `ics_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ics_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iirup`
--

DROP TABLE IF EXISTS `iirup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iirup` (
  `id_iirup` int(11) NOT NULL AUTO_INCREMENT,
  `id_wmr` int(11) NOT NULL,
  `id_ppelc` int(11) NOT NULL,
  PRIMARY KEY (`id_iirup`),
  UNIQUE KEY `id_iirup_UNIQUE` (`id_iirup`),
  KEY `fk_iirup_wmr_idx` (`id_wmr`),
  KEY `fk_iirup_ppelc_idx` (`id_ppelc`),
  CONSTRAINT `fk_iirup_ppelc` FOREIGN KEY (`id_ppelc`) REFERENCES `ppelc` (`id_ppelc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iirup_wmr` FOREIGN KEY (`id_wmr`) REFERENCES `wmr` (`id_wmr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iirup`
--

LOCK TABLES `iirup` WRITE;
/*!40000 ALTER TABLE `iirup` DISABLE KEYS */;
/*!40000 ALTER TABLE `iirup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iirup_details`
--

DROP TABLE IF EXISTS `iirup_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iirup_details` (
  `id_iirup_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_iirup` int(11) NOT NULL,
  PRIMARY KEY (`id_iirup_details`),
  UNIQUE KEY `id_iirup_details_UNIQUE` (`id_iirup_details`),
  KEY `fk_iirup_details_parent_idx` (`id_iirup`),
  CONSTRAINT `fk_iirup_details_parent` FOREIGN KEY (`id_iirup`) REFERENCES `iirup` (`id_iirup`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iirup_details`
--

LOCK TABLES `iirup_details` WRITE;
/*!40000 ALTER TABLE `iirup_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `iirup_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `office`
--

DROP TABLE IF EXISTS `office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `office` (
  `id_office` int(11) NOT NULL AUTO_INCREMENT,
  `department` varchar(45) NOT NULL,
  PRIMARY KEY (`id_office`),
  UNIQUE KEY `id_office_UNIQUE` (`id_office`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `office`
--

LOCK TABLES `office` WRITE;
/*!40000 ALTER TABLE `office` DISABLE KEYS */;
INSERT INTO `office` VALUES (4,'FMAO');
/*!40000 ALTER TABLE `office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `par`
--

DROP TABLE IF EXISTS `par`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `par` (
  `id_par` int(11) NOT NULL AUTO_INCREMENT,
  `id_pc` int(11) NOT NULL,
  `entity_name` varchar(45) DEFAULT NULL,
  `ris_no` int(11) DEFAULT NULL,
  `fund_cluster` varchar(45) DEFAULT NULL,
  `purpose` varchar(45) DEFAULT NULL,
  `received_name` varchar(45) DEFAULT NULL,
  `received_position` varchar(45) DEFAULT NULL,
  `received_office` varchar(45) DEFAULT NULL,
  `received_date` date DEFAULT NULL,
  `issued_name` varchar(45) DEFAULT NULL,
  `issued_position` varchar(45) DEFAULT NULL,
  `issued_office` varchar(45) DEFAULT NULL,
  `issued_date` date DEFAULT NULL,
  PRIMARY KEY (`id_par`),
  UNIQUE KEY `id_par_UNIQUE` (`id_par`),
  CONSTRAINT `fk_par_details` FOREIGN KEY (`id_par`) REFERENCES `par_details` (`id_par_details`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `par`
--

LOCK TABLES `par` WRITE;
/*!40000 ALTER TABLE `par` DISABLE KEYS */;
/*!40000 ALTER TABLE `par` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `par_details`
--

DROP TABLE IF EXISTS `par_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `par_details` (
  `id_par_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_par` int(11) NOT NULL,
  `par_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `property_no` int(11) DEFAULT NULL,
  `date_acq` date DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`id_par_details`),
  UNIQUE KEY `idpar_details_UNIQUE` (`id_par_details`),
  UNIQUE KEY `id_par_UNIQUE` (`id_par`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='																												';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `par_details`
--

LOCK TABLES `par_details` WRITE;
/*!40000 ALTER TABLE `par_details` DISABLE KEYS */;
INSERT INTO `par_details` VALUES (1,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `par_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pc`
--

DROP TABLE IF EXISTS `pc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pc` (
  `id_pc` int(11) NOT NULL AUTO_INCREMENT,
  `id_par` int(11) NOT NULL,
  `id_dr` int(11) NOT NULL,
  `id_pr` int(11) NOT NULL,
  `id_po` int(11) NOT NULL,
  `ppe_id` int(11) DEFAULT NULL,
  `property_no` int(11) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `supplier` varchar(45) DEFAULT NULL,
  `dr_si_no` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `repair_nature` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `office` varchar(45) DEFAULT NULL,
  `end_user` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_pc`),
  UNIQUE KEY `id_pc_UNIQUE` (`id_pc`),
  KEY `fk_par_idx` (`id_par`),
  KEY `fk_dr_idx` (`id_dr`),
  KEY `fk_po_idx` (`id_po`),
  KEY `fk_pc_pr_idx` (`id_pr`),
  CONSTRAINT `fk_pc_dr` FOREIGN KEY (`id_dr`) REFERENCES `dr` (`id_dr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pc_par` FOREIGN KEY (`id_par`) REFERENCES `par` (`id_par`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pc_po` FOREIGN KEY (`id_po`) REFERENCES `po` (`id_po`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pc_pr` FOREIGN KEY (`id_pr`) REFERENCES `pr` (`id_pr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pc`
--

LOCK TABLES `pc` WRITE;
/*!40000 ALTER TABLE `pc` DISABLE KEYS */;
/*!40000 ALTER TABLE `pc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `po`
--

DROP TABLE IF EXISTS `po`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `po` (
  `id_po` int(11) NOT NULL AUTO_INCREMENT,
  `id_sc` int(11) DEFAULT NULL,
  `id_pc` int(11) DEFAULT NULL,
  `id_pr` int(11) NOT NULL,
  `id_asset` int(11) DEFAULT NULL,
  `entity` varchar(45) DEFAULT NULL,
  `supplier` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `mode_of_proc` varchar(45) DEFAULT NULL,
  `tin` varchar(45) DEFAULT NULL,
  `gentlemen` varchar(45) DEFAULT NULL,
  `place_of_delivery` varchar(45) DEFAULT NULL,
  `mode_of_proc2` varchar(45) DEFAULT NULL,
  `date_delivery` date DEFAULT NULL,
  `pay_term` varchar(45) DEFAULT NULL,
  `amount_words` varchar(45) DEFAULT NULL,
  `name_conforme` varchar(45) DEFAULT NULL,
  `name_truly` varchar(45) DEFAULT NULL,
  `date_delivery2` date DEFAULT NULL,
  `pay_term2` varchar(45) DEFAULT NULL,
  `fund_cluster` varchar(45) DEFAULT NULL,
  `ors_burs_no` int(11) DEFAULT NULL,
  `date_orsburs` date DEFAULT NULL,
  `name_req` varchar(45) DEFAULT NULL,
  `amount2` float DEFAULT NULL,
  PRIMARY KEY (`id_po`),
  UNIQUE KEY `id_po_UNIQUE` (`id_po`),
  KEY `fk_po_pr_idx` (`id_pr`),
  KEY `fk_po_asset_idx` (`id_asset`),
  CONSTRAINT `fk_po_asset` FOREIGN KEY (`id_asset`) REFERENCES `asset` (`id_asset`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_po_pr` FOREIGN KEY (`id_pr`) REFERENCES `pr` (`id_pr`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `po`
--

LOCK TABLES `po` WRITE;
/*!40000 ALTER TABLE `po` DISABLE KEYS */;
INSERT INTO `po` VALUES (13,NULL,NULL,37,NULL,NULL,'supplier','2018-04-19','Manila','Bidding','99988877776554','','Quezon City','Bidding','2018-03-21','cash','Ten Thousand','Myles Mempin','Myles Mempin','2018-03-21','cash',NULL,NULL,'2018-03-29','Daryll Ian Romero',10000),(14,NULL,NULL,38,NULL,NULL,'supplier','2018-04-19','F31B Gueventville II, Libertad Street','Bidding','99988877776554','Hi','Quezon City','Bidding','2018-03-21','cash','Twenty Thousand','Myles Mempin','Myles Mempin','2018-03-21','cash',NULL,NULL,'2018-03-29','Myles Mempin',20000),(15,NULL,NULL,39,NULL,NULL,'supplier','2018-04-19','Manila','Bidding','99988877776554','Hi','Quezon City','Bidding','2018-03-21','cash','Twenty-Five Thousand','Rene Colocar','Rene Colocar','2018-03-21','cash',NULL,NULL,'2018-03-29','Myles Mempin',25000),(17,NULL,NULL,48,NULL,NULL,'supplier','2018-04-20','Manila','Bidding','7','','Quezon City','Bidding','2018-03-21','cash','','Myles Mempin','Myles Mempin','2018-03-21','cash',NULL,NULL,'2018-03-29','Revin',20000);
/*!40000 ALTER TABLE `po` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `po_details`
--

DROP TABLE IF EXISTS `po_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `po_details` (
  `id_po_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_po` int(11) NOT NULL,
  `stock_no` int(11) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`id_po_details`),
  UNIQUE KEY `id_po_details_UNIQUE` (`id_po_details`),
  KEY `fk_po_details_parent_idx` (`id_po`),
  CONSTRAINT `fk_po_details_po` FOREIGN KEY (`id_po`) REFERENCES `po` (`id_po`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `po_details`
--

LOCK TABLES `po_details` WRITE;
/*!40000 ALTER TABLE `po_details` DISABLE KEYS */;
INSERT INTO `po_details` VALUES (8,13,12,'Chair','for sitting',40,250,10000),(9,14,13,'Libertad Street','for surface',40,500,20000),(10,15,14,'Table','for surface',50,500,25000),(13,17,25,'Chair','for sitting',5,500,2500),(14,17,26,'shelf','for surface',9,700,6300),(15,17,27,'Desk','for surface',8,600,4800);
/*!40000 ALTER TABLE `po_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ppelc`
--

DROP TABLE IF EXISTS `ppelc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ppelc` (
  `id_ppelc` int(11) NOT NULL AUTO_INCREMENT,
  `id_pc` int(11) NOT NULL,
  PRIMARY KEY (`id_ppelc`),
  UNIQUE KEY `id_ppelc_UNIQUE` (`id_ppelc`),
  KEY `fk_ppelc_pc_idx` (`id_pc`),
  CONSTRAINT `fk_ppelc_pc` FOREIGN KEY (`id_pc`) REFERENCES `pc` (`id_pc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ppelc`
--

LOCK TABLES `ppelc` WRITE;
/*!40000 ALTER TABLE `ppelc` DISABLE KEYS */;
/*!40000 ALTER TABLE `ppelc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ppmp`
--

DROP TABLE IF EXISTS `ppmp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ppmp` (
  `id_ppmp` int(11) NOT NULL AUTO_INCREMENT,
  `id_office` int(11) NOT NULL,
  PRIMARY KEY (`id_ppmp`),
  UNIQUE KEY `id_ppmp_UNIQUE` (`id_ppmp`),
  KEY `fk_office_ppmp_idx` (`id_office`),
  CONSTRAINT `fk_office_ppmp` FOREIGN KEY (`id_office`) REFERENCES `office` (`id_office`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ppmp`
--

LOCK TABLES `ppmp` WRITE;
/*!40000 ALTER TABLE `ppmp` DISABLE KEYS */;
INSERT INTO `ppmp` VALUES (1,4);
/*!40000 ALTER TABLE `ppmp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ppmp_details`
--

DROP TABLE IF EXISTS `ppmp_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ppmp_details` (
  `id_ppmp_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_ppmp` int(11) NOT NULL,
  `item_spec` varchar(120) NOT NULL,
  `q1` double DEFAULT NULL,
  `q2` double DEFAULT NULL,
  `q3` double DEFAULT NULL,
  `q4` double DEFAULT NULL,
  `total_qty` int(11) DEFAULT NULL,
  `total_price_afn` double DEFAULT NULL,
  `id_office` int(11) NOT NULL,
  PRIMARY KEY (`id_ppmp_details`),
  UNIQUE KEY `id_ppmp_details_UNIQUE` (`id_ppmp_details`),
  KEY `fk_ppmp_details_ppmp` (`id_ppmp`),
  CONSTRAINT `fk_ppmp_details_ppmp` FOREIGN KEY (`id_ppmp`) REFERENCES `ppmp` (`id_ppmp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ppmp_details`
--

LOCK TABLES `ppmp_details` WRITE;
/*!40000 ALTER TABLE `ppmp_details` DISABLE KEYS */;
INSERT INTO `ppmp_details` VALUES (1,1,'q345tretg',2435,2345,2345,2345,142657,254734754,4);
/*!40000 ALTER TABLE `ppmp_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pr`
--

DROP TABLE IF EXISTS `pr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pr` (
  `id_pr` int(11) NOT NULL AUTO_INCREMENT,
  `id_ris` int(11) DEFAULT NULL,
  `id_office` int(11) DEFAULT NULL,
  `id_sc` int(11) DEFAULT NULL,
  `id_pc` int(11) DEFAULT NULL,
  `id_wfp` int(11) DEFAULT NULL,
  `id_ppmp` int(11) DEFAULT NULL,
  `id_app` int(11) DEFAULT NULL,
  `entity_name` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `fund_cluster` varchar(45) DEFAULT NULL,
  `responsibility_center_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_pr`),
  UNIQUE KEY `id_pr_UNIQUE` (`id_pr`),
  KEY `fk_office_idx` (`id_office`),
  KEY `fk_sc_wfp_idx` (`id_wfp`),
  KEY `fk_ppmp_idx` (`id_ppmp`),
  KEY `fk_app_idx` (`id_app`),
  KEY `fk_pr_ris_idx` (`id_ris`),
  CONSTRAINT `fk_pr_app` FOREIGN KEY (`id_app`) REFERENCES `app` (`id_app`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pr_office` FOREIGN KEY (`id_office`) REFERENCES `office` (`id_office`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pr_ppmp` FOREIGN KEY (`id_ppmp`) REFERENCES `ppmp` (`id_ppmp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pr_ris` FOREIGN KEY (`id_ris`) REFERENCES `ris` (`id_ris`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pr_wfp` FOREIGN KEY (`id_wfp`) REFERENCES `wfp` (`id_wfp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pr`
--

LOCK TABLES `pr` WRITE;
/*!40000 ALTER TABLE `pr` DISABLE KEYS */;
INSERT INTO `pr` VALUES (37,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-04-19',NULL,'hi'),(38,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-04-19',NULL,'hi'),(39,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-04-19',NULL,'hi'),(48,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-04-20',NULL,'hi'),(49,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-07-22',NULL,'N/A'),(50,NULL,4,NULL,NULL,NULL,NULL,NULL,'Department of Agrarian Reform','2018-07-22',NULL,'N/A'),(51,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-07-22',NULL,'N/A'),(52,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-07-22',NULL,'N/A'),(53,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-07-22',NULL,'N/A'),(54,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-07-22',NULL,'N/A'),(55,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-07-22',NULL,'N/A'),(56,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-07-22',NULL,'N/A'),(57,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-07-22',NULL,'N/A'),(58,NULL,4,NULL,NULL,NULL,NULL,NULL,'Entity','2018-07-22',NULL,'N/A');
/*!40000 ALTER TABLE `pr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pr_details`
--

DROP TABLE IF EXISTS `pr_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pr_details` (
  `id_pr_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_pr` int(11) NOT NULL,
  `stock_num` int(100) NOT NULL,
  `unit` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unit_cost` float NOT NULL,
  `total_cost` double NOT NULL,
  `purpose` varchar(45) NOT NULL,
  `rq_name` varchar(45) NOT NULL,
  `rq_desig` varchar(45) NOT NULL,
  PRIMARY KEY (`id_pr_details`),
  UNIQUE KEY `id_pr_details_UNIQUE` (`id_pr_details`),
  KEY `fk_pr_details_parent_idx` (`id_pr`),
  CONSTRAINT `fk_pr_details_pr` FOREIGN KEY (`id_pr`) REFERENCES `pr` (`id_pr`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pr_details`
--

LOCK TABLES `pr_details` WRITE;
/*!40000 ALTER TABLE `pr_details` DISABLE KEYS */;
INSERT INTO `pr_details` VALUES (12,37,0,'Chair','for sitting',40,0,0,'','',''),(13,38,0,'Desk','for surface',40,0,0,'','',''),(14,39,0,'Table','for surface',50,0,0,'','',''),(25,48,0,'Chair','for sitting',5,0,0,'','',''),(26,48,0,'shelf','for surface',9,0,0,'','',''),(27,48,0,'desk','for surface',8,0,0,'','',''),(28,58,0,'sdfsadf','scfdgf',123,123,123,'fsdagsdfg','sadfdsf','asdfasdf');
/*!40000 ALTER TABLE `pr_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptr`
--

DROP TABLE IF EXISTS `ptr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ptr` (
  `id_ptr` int(11) NOT NULL AUTO_INCREMENT,
  `id_par` int(11) NOT NULL,
  `id_ics` int(11) NOT NULL,
  PRIMARY KEY (`id_ptr`),
  UNIQUE KEY `id_ptr_UNIQUE` (`id_ptr`),
  KEY `fk_ptr_par_idx` (`id_par`),
  KEY `fk_ptr_ics_idx` (`id_ics`),
  CONSTRAINT `fk_ptr_ics` FOREIGN KEY (`id_ics`) REFERENCES `ics` (`id_ics`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ptr_par` FOREIGN KEY (`id_par`) REFERENCES `par` (`id_par`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptr`
--

LOCK TABLES `ptr` WRITE;
/*!40000 ALTER TABLE `ptr` DISABLE KEYS */;
/*!40000 ALTER TABLE `ptr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptr_details`
--

DROP TABLE IF EXISTS `ptr_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ptr_details` (
  `id_ptr_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_ptr` int(11) NOT NULL,
  PRIMARY KEY (`id_ptr_details`),
  UNIQUE KEY `id_ptr_details_UNIQUE` (`id_ptr_details`),
  KEY `fk_ptr_details_parent_idx` (`id_ptr`),
  CONSTRAINT `fk_ptr_details_parent` FOREIGN KEY (`id_ptr`) REFERENCES `ptr` (`id_ptr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptr_details`
--

LOCK TABLES `ptr_details` WRITE;
/*!40000 ALTER TABLE `ptr_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ptr_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rfi`
--

DROP TABLE IF EXISTS `rfi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rfi` (
  `id_rfi` int(11) NOT NULL AUTO_INCREMENT,
  `id_po` int(11) NOT NULL,
  `type_inspection` varchar(45) DEFAULT NULL,
  `type_repair` varchar(45) DEFAULT NULL,
  `type_property` varchar(45) DEFAULT NULL,
  `desc_type_property` varchar(45) DEFAULT NULL,
  `desc_model` varchar(45) DEFAULT NULL,
  `desc_engine_no` int(11) DEFAULT NULL,
  `desc_plate_no` varchar(45) DEFAULT NULL,
  `desc_defects_complaints_scope` varchar(45) DEFAULT NULL,
  `desc_end_user` varchar(45) DEFAULT NULL,
  `desc_amout` float DEFAULT NULL,
  `desc_attachments_pre_repair` tinyint(4) DEFAULT NULL,
  `desc_attachments_post_repair` tinyint(4) DEFAULT NULL,
  `deliveries_supplier` varchar(45) DEFAULT NULL,
  `deliveries_invoice_no` int(11) DEFAULT NULL,
  `deliveries_dr_no` int(11) DEFAULT NULL,
  `deliveries_pr_no` int(11) DEFAULT NULL,
  `deliveries_end_user` varchar(45) DEFAULT NULL,
  `deliveries_amount` float DEFAULT NULL,
  `deliveries_attachments` tinyint(4) DEFAULT NULL,
  `approval_name` varchar(45) DEFAULT NULL,
  `approval_designation` varchar(45) DEFAULT NULL,
  `approval_date` date DEFAULT NULL,
  `deliveries` varchar(45) DEFAULT NULL,
  `control_no` int(11) DEFAULT NULL,
  `pre_repair` varchar(45) DEFAULT NULL,
  `post_repair` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_rfi`),
  UNIQUE KEY `id_rfi_UNIQUE` (`id_rfi`),
  KEY `fk_po_rfi_idx` (`id_po`),
  CONSTRAINT `fk_po_rfi` FOREIGN KEY (`id_po`) REFERENCES `po` (`id_po`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rfidetails` FOREIGN KEY (`id_rfi`) REFERENCES `rfi_fk` (`idrfi_details`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfi`
--

LOCK TABLES `rfi` WRITE;
/*!40000 ALTER TABLE `rfi` DISABLE KEYS */;
/*!40000 ALTER TABLE `rfi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rfi_deliveries`
--

DROP TABLE IF EXISTS `rfi_deliveries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rfi_deliveries` (
  `id_deliveries` int(11) NOT NULL,
  `id_rfi` int(11) NOT NULL,
  `name_request` varchar(45) NOT NULL,
  `date_requested` date NOT NULL,
  `type_of_request` varchar(45) NOT NULL,
  PRIMARY KEY (`id_deliveries`),
  KEY `fk_rfi_deliveries_parent_idx` (`id_rfi`),
  CONSTRAINT `fk_rfi_deliveries_parent` FOREIGN KEY (`id_rfi`) REFERENCES `rfi` (`id_rfi`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfi_deliveries`
--

LOCK TABLES `rfi_deliveries` WRITE;
/*!40000 ALTER TABLE `rfi_deliveries` DISABLE KEYS */;
/*!40000 ALTER TABLE `rfi_deliveries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rfi_fk`
--

DROP TABLE IF EXISTS `rfi_fk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rfi_fk` (
  `idrfi_details` int(11) NOT NULL,
  `name_request` varchar(45) NOT NULL,
  `date_requested` date NOT NULL,
  `type_of_request` varchar(45) NOT NULL,
  PRIMARY KEY (`idrfi_details`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfi_fk`
--

LOCK TABLES `rfi_fk` WRITE;
/*!40000 ALTER TABLE `rfi_fk` DISABLE KEYS */;
/*!40000 ALTER TABLE `rfi_fk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rfi_repair_post`
--

DROP TABLE IF EXISTS `rfi_repair_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rfi_repair_post` (
  `id_repair_post` int(11) NOT NULL AUTO_INCREMENT,
  `id_rfi` int(11) NOT NULL,
  `name_request` varchar(45) NOT NULL,
  `date_requested` date NOT NULL,
  `type_of_request` varchar(45) NOT NULL,
  PRIMARY KEY (`id_repair_post`),
  UNIQUE KEY `id_repair_post_UNIQUE` (`id_repair_post`),
  KEY `fk_rfi_reppost_parent_idx` (`id_rfi`),
  CONSTRAINT `fk_rfi_reppost_parent` FOREIGN KEY (`id_rfi`) REFERENCES `rfi` (`id_rfi`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfi_repair_post`
--

LOCK TABLES `rfi_repair_post` WRITE;
/*!40000 ALTER TABLE `rfi_repair_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `rfi_repair_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ris`
--

DROP TABLE IF EXISTS `ris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ris` (
  `id_ris` int(11) NOT NULL AUTO_INCREMENT,
  `id_sc` int(11) NOT NULL,
  `entity_name` varchar(45) DEFAULT NULL,
  `ris_no` int(11) DEFAULT NULL,
  `office` varchar(45) DEFAULT NULL,
  `fund_cluster` varchar(45) DEFAULT NULL,
  `division` varchar(45) DEFAULT NULL,
  `responsibility_code` varchar(45) DEFAULT NULL,
  `purpose` varchar(45) DEFAULT NULL,
  `requested_name` varchar(45) DEFAULT NULL,
  `requested_designation` varchar(45) DEFAULT NULL,
  `requested_date` date DEFAULT NULL,
  `approved_name` varchar(45) DEFAULT NULL,
  `approved_desgination` varchar(45) DEFAULT NULL,
  `approved_date` date DEFAULT NULL,
  `issued_name` varchar(45) DEFAULT NULL,
  `issued_designation` varchar(45) DEFAULT NULL,
  `issued_date` date DEFAULT NULL,
  `received_name` varchar(45) DEFAULT NULL,
  `received_designation` varchar(45) DEFAULT NULL,
  `received_date` date DEFAULT NULL,
  PRIMARY KEY (`id_ris`),
  UNIQUE KEY `id_ris_UNIQUE` (`id_ris`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ris`
--

LOCK TABLES `ris` WRITE;
/*!40000 ALTER TABLE `ris` DISABLE KEYS */;
INSERT INTO `ris` VALUES (1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ris` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ris_details`
--

DROP TABLE IF EXISTS `ris_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ris_details` (
  `id_ris_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_ris` int(11) NOT NULL,
  `stock_no` int(11) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `req_quantity` int(11) DEFAULT NULL,
  `stock_avail` int(11) DEFAULT NULL,
  `issued_quantity` int(11) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_ris_details`),
  UNIQUE KEY `id_ris_details_UNIQUE` (`id_ris_details`),
  KEY `fk_ris_details_parent_idx` (`id_ris`),
  CONSTRAINT `fk_ris_details_parent` FOREIGN KEY (`id_ris`) REFERENCES `ris` (`id_ris`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ris_details`
--

LOCK TABLES `ris_details` WRITE;
/*!40000 ALTER TABLE `ris_details` DISABLE KEYS */;
INSERT INTO `ris_details` VALUES (1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ris_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rpci`
--

DROP TABLE IF EXISTS `rpci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rpci` (
  `id_rpci` int(11) NOT NULL,
  `id_sc` int(11) NOT NULL,
  `inventory_type` varchar(45) DEFAULT NULL,
  `fund_cluster` varchar(45) DEFAULT NULL,
  `accountable_officer` varchar(45) DEFAULT NULL,
  `official_designation` varchar(45) DEFAULT NULL,
  `entity` varchar(45) DEFAULT NULL,
  `accountability_date` date DEFAULT NULL,
  `article` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `stock_no` int(11) DEFAULT NULL,
  `unit_measure` varchar(45) DEFAULT NULL,
  `bpc_quantity` int(11) DEFAULT NULL,
  `ohpc_quantity` int(11) DEFAULT NULL,
  `shortage_overage_quantity` int(11) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `checker` varchar(45) DEFAULT NULL,
  `checker_designation` varchar(45) DEFAULT NULL,
  `name_app` varchar(45) DEFAULT NULL,
  `designation_app` varchar(45) DEFAULT NULL,
  `name_ver` varchar(45) DEFAULT NULL,
  `designation_ver` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_rpci`),
  UNIQUE KEY `id_rpci_UNIQUE` (`id_rpci`),
  KEY `fk_sc_idx` (`id_sc`),
  CONSTRAINT `fk_sc` FOREIGN KEY (`id_sc`) REFERENCES `sc` (`id_sc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rpci`
--

LOCK TABLES `rpci` WRITE;
/*!40000 ALTER TABLE `rpci` DISABLE KEYS */;
/*!40000 ALTER TABLE `rpci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rpcppe`
--

DROP TABLE IF EXISTS `rpcppe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rpcppe` (
  `id_rpcppe` int(11) NOT NULL AUTO_INCREMENT,
  `id_pc` int(11) NOT NULL,
  `inventory_type` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `fund_cluster` varchar(45) DEFAULT NULL,
  `accountable_officer` varchar(45) DEFAULT NULL,
  `officer_designation` varchar(45) DEFAULT NULL,
  `entity` varchar(45) DEFAULT NULL,
  `accountability_date` date DEFAULT NULL,
  `article` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `po_num` int(11) DEFAULT NULL,
  `unit_measure` varchar(45) DEFAULT NULL,
  `unit_value` float DEFAULT NULL,
  `pc_quantity` int(11) DEFAULT NULL,
  `phc_quantity` int(11) DEFAULT NULL,
  `shortage_overage` varchar(45) DEFAULT NULL,
  `value` float DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `name_checker` varchar(45) DEFAULT NULL,
  `designation_checker` varchar(45) DEFAULT NULL,
  `name_app` varchar(45) DEFAULT NULL,
  `designation_app` varchar(45) DEFAULT NULL,
  `name_ver` varchar(45) DEFAULT NULL,
  `designation_ver` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_rpcppe`),
  UNIQUE KEY `id_rpcppe_UNIQUE` (`id_rpcppe`),
  KEY `fk_pc_idx` (`id_pc`),
  CONSTRAINT `fk_pc` FOREIGN KEY (`id_pc`) REFERENCES `pc` (`id_pc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rpcppe`
--

LOCK TABLES `rpcppe` WRITE;
/*!40000 ALTER TABLE `rpcppe` DISABLE KEYS */;
/*!40000 ALTER TABLE `rpcppe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rsmi`
--

DROP TABLE IF EXISTS `rsmi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rsmi` (
  `id_rsmi` int(11) NOT NULL AUTO_INCREMENT,
  `id_ris` int(11) NOT NULL,
  `id_dr` int(11) NOT NULL,
  PRIMARY KEY (`id_rsmi`),
  UNIQUE KEY `id_rsmi_UNIQUE` (`id_rsmi`),
  KEY `fk_rsmi_dr_idx` (`id_dr`),
  KEY `fk_rsmi_ris_idx` (`id_ris`),
  CONSTRAINT `fk_rsmi_dr` FOREIGN KEY (`id_dr`) REFERENCES `dr` (`id_dr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rsmi_ris` FOREIGN KEY (`id_ris`) REFERENCES `ris` (`id_ris`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rsmi`
--

LOCK TABLES `rsmi` WRITE;
/*!40000 ALTER TABLE `rsmi` DISABLE KEYS */;
/*!40000 ALTER TABLE `rsmi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sc`
--

DROP TABLE IF EXISTS `sc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sc` (
  `id_sc` int(11) NOT NULL AUTO_INCREMENT,
  `id_pr` int(11) NOT NULL,
  `id_dr` int(11) NOT NULL,
  `id_ris` int(11) NOT NULL,
  `id_po` int(11) NOT NULL,
  `entity` varchar(45) DEFAULT NULL,
  `fund_cluster` varchar(45) DEFAULT NULL,
  `item` varchar(45) DEFAULT NULL,
  `stock_no` int(11) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `reorder_point` varchar(45) DEFAULT NULL,
  `unit_of_measurement` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `reference` varchar(45) DEFAULT NULL,
  `receipt_qty` int(11) DEFAULT NULL,
  `issue_qty` int(11) DEFAULT NULL,
  `office_qty` int(11) DEFAULT NULL,
  `balance_qty` int(11) DEFAULT NULL,
  `no_days_left` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_sc`),
  UNIQUE KEY `id_sc_UNIQUE` (`id_sc`),
  KEY `fk_pr_idx` (`id_pr`),
  KEY `fk_dr_idx` (`id_dr`),
  KEY `fk_po_idx` (`id_po`),
  KEY `fk_sc_ris_idx` (`id_ris`),
  CONSTRAINT `fk_sc_dr` FOREIGN KEY (`id_dr`) REFERENCES `dr` (`id_dr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sc_po` FOREIGN KEY (`id_po`) REFERENCES `po` (`id_po`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sc_pr` FOREIGN KEY (`id_pr`) REFERENCES `pr` (`id_pr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sc_ris` FOREIGN KEY (`id_ris`) REFERENCES `ris` (`id_ris`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sc`
--

LOCK TABLES `sc` WRITE;
/*!40000 ALTER TABLE `sc` DISABLE KEYS */;
/*!40000 ALTER TABLE `sc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockitem`
--

DROP TABLE IF EXISTS `stockitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockitem` (
  `id_stockitem` int(11) NOT NULL AUTO_INCREMENT,
  `stock_num` varchar(45) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_cost` float DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`id_stockitem`),
  UNIQUE KEY `id_stockitem_UNIQUE` (`id_stockitem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockitem`
--

LOCK TABLES `stockitem` WRITE;
/*!40000 ALTER TABLE `stockitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tier`
--

DROP TABLE IF EXISTS `tier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tier` (
  `id_tier` int(11) NOT NULL AUTO_INCREMENT,
  `position` mediumtext NOT NULL,
  PRIMARY KEY (`id_tier`),
  UNIQUE KEY `id_tier_UNIQUE` (`id_tier`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tier`
--

LOCK TABLES `tier` WRITE;
/*!40000 ALTER TABLE `tier` DISABLE KEYS */;
INSERT INTO `tier` VALUES (1,'Director'),(2,'Admin Officer'),(3,'GSD Division Chief'),(4,'Supply Officer'),(5,'Property Officer'),(6,'Inspector'),(7,'User Employee'),(8,'Procurement Division Chief');
/*!40000 ALTER TABLE `tier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wfp`
--

DROP TABLE IF EXISTS `wfp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wfp` (
  `id_wfp` int(11) NOT NULL AUTO_INCREMENT,
  `id_office` int(11) NOT NULL,
  PRIMARY KEY (`id_wfp`),
  UNIQUE KEY `id_wfp_UNIQUE` (`id_wfp`),
  KEY `fk_office_idx` (`id_office`),
  CONSTRAINT `fk_office_wfp` FOREIGN KEY (`id_office`) REFERENCES `office` (`id_office`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wfp`
--

LOCK TABLES `wfp` WRITE;
/*!40000 ALTER TABLE `wfp` DISABLE KEYS */;
INSERT INTO `wfp` VALUES (1,4);
/*!40000 ALTER TABLE `wfp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wfp_details`
--

DROP TABLE IF EXISTS `wfp_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wfp_details` (
  `id_wfp_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_wfp` int(11) NOT NULL,
  `object_exp` varchar(45) DEFAULT NULL,
  `q1` double DEFAULT NULL,
  `q2` double DEFAULT NULL,
  `q3` double DEFAULT NULL,
  `q4` double DEFAULT NULL,
  `total_qty` double DEFAULT NULL,
  PRIMARY KEY (`id_wfp_details`),
  UNIQUE KEY `id_details_UNIQUE` (`id_wfp_details`),
  KEY `dk_wfp_details_wfp_idx` (`id_wfp`),
  CONSTRAINT `fk_wfp_details_wfp` FOREIGN KEY (`id_wfp`) REFERENCES `wfp` (`id_wfp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wfp_details`
--

LOCK TABLES `wfp_details` WRITE;
/*!40000 ALTER TABLE `wfp_details` DISABLE KEYS */;
INSERT INTO `wfp_details` VALUES (1,1,'Assets',123,123,123,123,123456789),(2,1,'Supplies & Materials',321,321,321,321,987654321);
/*!40000 ALTER TABLE `wfp_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wmr`
--

DROP TABLE IF EXISTS `wmr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wmr` (
  `id_wmr` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_wmr`),
  UNIQUE KEY `id_stockitem_UNIQUE` (`id_wmr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wmr`
--

LOCK TABLES `wmr` WRITE;
/*!40000 ALTER TABLE `wmr` DISABLE KEYS */;
/*!40000 ALTER TABLE `wmr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wmr_details`
--

DROP TABLE IF EXISTS `wmr_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wmr_details` (
  `id_wmr_details` int(11) NOT NULL AUTO_INCREMENT,
  `id_wmr` int(11) NOT NULL,
  PRIMARY KEY (`id_wmr_details`),
  UNIQUE KEY `id_wmr_details_UNIQUE` (`id_wmr_details`),
  KEY `fk_wmr_details_parent_idx` (`id_wmr`),
  CONSTRAINT `fk_wmr_details_parent` FOREIGN KEY (`id_wmr`) REFERENCES `wmr` (`id_wmr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wmr_details`
--

LOCK TABLES `wmr_details` WRITE;
/*!40000 ALTER TABLE `wmr_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `wmr_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-22 22:53:47
