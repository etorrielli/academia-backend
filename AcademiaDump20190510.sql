-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ae3
-- ------------------------------------------------------
-- Server version	5.5.39

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `alumno_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'jorge',
  `alumno_nombre` varchar(63) NOT NULL DEFAULT '' COMMENT 'damian',
  `alumno_dni` varchar(10) DEFAULT NULL,
  `alumno_fecha_nacimiento` date DEFAULT NULL,
  `alumno_telefono` varchar(30) DEFAULT NULL,
  `alumno_celular` varchar(30) DEFAULT NULL,
  `alumno_mail` varchar(50) DEFAULT NULL,
  `alumno_calle` varchar(50) DEFAULT NULL,
  `alumno_nro` varchar(10) DEFAULT NULL,
  `alumno_barrio` varchar(20) DEFAULT NULL,
  `sexo_id` int(11) NOT NULL,
  `localidad_id` int(11) NOT NULL,
  `flia_id` int(11) NOT NULL,
  `colegio_id` int(11) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `pc` varchar(100) NOT NULL,
  `fyh` datetime NOT NULL,
  PRIMARY KEY (`alumno_id`),
  UNIQUE KEY `ix_alumno_nombre_apellido_dni` (`alumno_nombre`,`alumno_dni`),
  KEY `ix_localidad_id` (`localidad_id`),
  KEY `ix_flia_id` (`flia_id`),
  KEY `ix_sexo` (`sexo_id`),
  KEY `ix_colegio_id` (`colegio_id`),
  CONSTRAINT `fk_alumno_flia_id` FOREIGN KEY (`flia_id`) REFERENCES `flia` (`flia_id`),
  CONSTRAINT `fk_alumno_localidad` FOREIGN KEY (`localidad_id`) REFERENCES `localidad` (`localidad_id`),
  CONSTRAINT `fk_alumno_sexo` FOREIGN KEY (`sexo_id`) REFERENCES `sexo` (`sexo_id`),
  CONSTRAINT `fk_alumno_colegio` FOREIGN KEY (`colegio_id`) REFERENCES `colegio` (`colegio_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Luis Scola','25999888','2000-01-01','3514225588','3516225544','luis@mail.com','Chacabuco','5600','Centro',1,1,1,1,'admin','1','2000-01-01 00:00:00'),(2,'Manu Ginobili',NULL,'2000-01-01','3514225577','3516221133','manu@mail.com','Rivera Indarte','700','Centro',1,1,2,1,'admin','1','2000-01-01 00:00:00'),(3,'Carlos Delfino',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,1,1,'app','1','2019-05-10 19:04:50');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_curso`
--

DROP TABLE IF EXISTS `alumno_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_curso` (
  `alumno_curso_id` int(11) NOT NULL AUTO_INCREMENT,
  `alumno_id` int(11) NOT NULL,
  `curso_id` int(11) NOT NULL,
  `alumno_curso_fecha_alta` date NOT NULL,
  `alumno_curso_fecha_baja` date DEFAULT NULL,
  `alumno_curso_observaciones` varchar(200) DEFAULT NULL,
  `alumno_curso_becado` tinyint(1) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `pc` varchar(100) NOT NULL,
  `fyh` datetime NOT NULL,
  PRIMARY KEY (`alumno_curso_id`),
  KEY `ix_alumno_id` (`alumno_id`),
  KEY `ix_curso_id` (`curso_id`),
  CONSTRAINT `fk_alumno_curso_alumno` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`alumno_id`),
  CONSTRAINT `fk_alumno_curso_curso` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_curso`
--

LOCK TABLES `alumno_curso` WRITE;
/*!40000 ALTER TABLE `alumno_curso` DISABLE KEYS */;
INSERT INTO `alumno_curso` VALUES (1,1,1,'2019-05-01',NULL,NULL,0,'admin','1','2019-05-01 00:00:00'),(2,2,1,'2019-05-01',NULL,NULL,0,'admin','1','2019-05-01 00:00:00');
/*!40000 ALTER TABLE `alumno_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistencia` (
  `asistencia_id` int(11) NOT NULL AUTO_INCREMENT,
  `dia_nombre` varchar(13) NOT NULL,
  `dia_fecha` date NOT NULL,
  `curso_id` int(11) NOT NULL,
  `asistencia_observaciones` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`asistencia_id`),
  UNIQUE KEY `ix_dia_fecha_curso_id` (`dia_fecha`,`curso_id`),
  KEY `ix_curso_id` (`curso_id`),
  CONSTRAINT `fk_asistenciacurso` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencia`
--

LOCK TABLES `asistencia` WRITE;
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
INSERT INTO `asistencia` VALUES (1,'Lunes','2019-05-06',1,NULL),(2,'Miercoles','2019-05-08',1,NULL);
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colegio`
--

DROP TABLE IF EXISTS `colegio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colegio` (
  `colegio_id` int(11) NOT NULL AUTO_INCREMENT,
  `colegio_nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`colegio_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colegio`
--

LOCK TABLES `colegio` WRITE;
/*!40000 ALTER TABLE `colegio` DISABLE KEYS */;
INSERT INTO `colegio` VALUES (1,'Manuel Belgrano');
/*!40000 ALTER TABLE `colegio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `curso_id` int(11) NOT NULL AUTO_INCREMENT,
  `curso_nombre` varchar(93) NOT NULL DEFAULT '',
  `curso_abreviatura` varchar(15) NOT NULL DEFAULT '',
  `curso_descripcion` varchar(200) DEFAULT NULL,
  `curso_precio` double DEFAULT NULL,
  `curso_inscripcion` double DEFAULT NULL,
  `curso_dia_clase` int(11) NOT NULL,
  `curso_hora_clase` int(11) NOT NULL,
  `curso_activo` tinyint(1) DEFAULT NULL,
  `tipo_asignacion_id` int(11) DEFAULT NULL,
  `usuario` varchar(100) NOT NULL,
  `pc` varchar(100) NOT NULL,
  `fyh` datetime NOT NULL,
  PRIMARY KEY (`curso_id`),
  UNIQUE KEY `ix_curso_nombre` (`curso_nombre`),
  KEY `ix_tipo_asinacion_id` (`tipo_asignacion_id`),
  CONSTRAINT `fk_curso_tipo_asignacion` FOREIGN KEY (`tipo_asignacion_id`) REFERENCES `tipo_asignacion` (`tipo_asignacion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'JEE','JEE','JEE',6500,1,1,4,1,1,'admin','1','2000-01-01 00:00:00');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_asistencia`
--

DROP TABLE IF EXISTS `detalle_asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_asistencia` (
  `detalle_asistencia_id` int(11) NOT NULL AUTO_INCREMENT,
  `asistencia_id` int(11) NOT NULL,
  `alumno_id` int(11) NOT NULL,
  `presente` char(1) NOT NULL,
  `detalle_asistencia_observaciones` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`detalle_asistencia_id`),
  KEY `ix_asistencia_id` (`asistencia_id`),
  KEY `ix_alumno_id` (`alumno_id`),
  CONSTRAINT `fk_detalle_asistenciaalumno` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`alumno_id`),
  CONSTRAINT `fk_detalle_asistenciaasistencia` FOREIGN KEY (`asistencia_id`) REFERENCES `asistencia` (`asistencia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_asistencia`
--

LOCK TABLES `detalle_asistencia` WRITE;
/*!40000 ALTER TABLE `detalle_asistencia` DISABLE KEYS */;
INSERT INTO `detalle_asistencia` VALUES (1,1,1,'P',NULL),(2,1,2,'P',NULL);
/*!40000 ALTER TABLE `detalle_asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flia`
--

DROP TABLE IF EXISTS `flia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flia` (
  `flia_id` int(11) NOT NULL AUTO_INCREMENT,
  `flia_nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`flia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flia`
--

LOCK TABLES `flia` WRITE;
/*!40000 ALTER TABLE `flia` DISABLE KEYS */;
INSERT INTO `flia` VALUES (1,'Scola'),(2,'Ginobili');
/*!40000 ALTER TABLE `flia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidad`
--

DROP TABLE IF EXISTS `localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidad` (
  `localidad_id` int(11) NOT NULL AUTO_INCREMENT,
  `localidad_nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`localidad_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidad`
--

LOCK TABLES `localidad` WRITE;
/*!40000 ALTER TABLE `localidad` DISABLE KEYS */;
INSERT INTO `localidad` VALUES (1,'Cordoba');
/*!40000 ALTER TABLE `localidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `profesor_id` int(11) NOT NULL AUTO_INCREMENT,
  `profesor_nombre` varchar(63) NOT NULL,
  `profesor_dni` varchar(12) DEFAULT '',
  `profesor_telefono` varchar(20) DEFAULT NULL,
  `profesor_celular` varchar(20) DEFAULT NULL,
  `profesor_abreviatura` varchar(5) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `pc` varchar(100) NOT NULL,
  `fyh` datetime NOT NULL,
  PRIMARY KEY (`profesor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'Gregg Popovich',' 12888444','3514208877','3516221122','GP','admin','1','2000-01-01 00:00:00');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor_curso`
--

DROP TABLE IF EXISTS `profesor_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor_curso` (
  `profesor_curso_id` int(11) NOT NULL AUTO_INCREMENT,
  `profesor_id` int(11) NOT NULL,
  `curso_id` int(11) NOT NULL,
  `profesor_curso_fecha_alta` date NOT NULL,
  `profesor_curso_fecha_baja` date DEFAULT NULL,
  `profesor_curso_observaciones` varchar(200) DEFAULT NULL,
  `usuario` varchar(100) NOT NULL,
  `pc` varchar(100) NOT NULL,
  `fyh` datetime NOT NULL,
  PRIMARY KEY (`profesor_curso_id`),
  KEY `ix_profesor_id` (`profesor_id`),
  KEY `ix_curso_id` (`curso_id`),
  CONSTRAINT `fk_profesor_cursocurso` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_id`),
  CONSTRAINT `fk_profesor_cursoprofesor` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`profesor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor_curso`
--

LOCK TABLES `profesor_curso` WRITE;
/*!40000 ALTER TABLE `profesor_curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesor_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexo`
--

DROP TABLE IF EXISTS `sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sexo` (
  `sexo_id` int(11) NOT NULL AUTO_INCREMENT,
  `sexo_nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sexo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexo`
--

LOCK TABLES `sexo` WRITE;
/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
INSERT INTO `sexo` VALUES (1,'Masculino'),(2,'Femenino');
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_asignacion`
--

DROP TABLE IF EXISTS `tipo_asignacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_asignacion` (
  `tipo_asignacion_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_asignacion_nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tipo_asignacion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_asignacion`
--

LOCK TABLES `tipo_asignacion` WRITE;
/*!40000 ALTER TABLE `tipo_asignacion` DISABLE KEYS */;
INSERT INTO `tipo_asignacion` VALUES (1,'Simple'),(2,'Completo');
/*!40000 ALTER TABLE `tipo_asignacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-10 16:09:02
