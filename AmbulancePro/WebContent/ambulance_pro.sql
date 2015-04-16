-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2015 at 02:11 PM
-- Server version: 5.6.15-log
-- PHP Version: 5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ambulance_pro`
--

-- --------------------------------------------------------

--
-- Table structure for table `demande_transport`
--

CREATE TABLE IF NOT EXISTS `demande_transport` (
  `id_demande_transport` int(10) NOT NULL AUTO_INCREMENT,
  `date_demande_transport` date DEFAULT NULL,
  `heure_demande_transport` time DEFAULT NULL,
  `adresse_debut` varchar(255) DEFAULT NULL,
  `adresse_fin` varchar(255) DEFAULT NULL,
  `etat_demande_transport` varchar(255) DEFAULT NULL,
  `id_etablissement` int(10) NOT NULL,
  `id_malade` int(10) NOT NULL,
  `id_personnel` int(11) NOT NULL,
  `id_vehicule` int(11) NOT NULL,
  PRIMARY KEY (`id_demande_transport`),
  KEY `FKdemande_tr258279` (`id_malade`),
  KEY `FKdemande_tr598306` (`id_etablissement`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `demande_transport`
--

INSERT INTO `demande_transport` (`id_demande_transport`, `date_demande_transport`, `heure_demande_transport`, `adresse_debut`, `adresse_fin`, `etat_demande_transport`, `id_etablissement`, `id_malade`, `id_personnel`, `id_vehicule`) VALUES
(1, '2015-03-10', '12:21:00', 'kljfgsoif', 'sldkufhoiyf&', NULL, 0, 1, 0, 0),
(2, '2015-03-10', '11:00:00', '1 rue de france', '21 rue de france', NULL, 0, 2, 0, 0),
(3, '2015-04-04', '12:05:00', '92 avenue de la division leclerc', '15 c avenue general de gaulle', NULL, 0, 3, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `etablissement`
--

CREATE TABLE IF NOT EXISTS `etablissement` (
  `id_etablissement` int(10) NOT NULL AUTO_INCREMENT,
  `nom_etablissement` varchar(255) DEFAULT NULL,
  `adresse_etablissement` varchar(255) DEFAULT NULL,
  `mail_etablissement` varchar(255) DEFAULT NULL,
  `tel_etablissement` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_etablissement`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `etablissement`
--

INSERT INTO `etablissement` (`id_etablissement`, `nom_etablissement`, `adresse_etablissement`, `mail_etablissement`, `tel_etablissement`) VALUES
(1, 'clinique de l''essonne', '23 rue de france 91180 evry', '0', '1'),
(2, 'Clinique de L''Essonne', '23 Ibgbi', 'tayyabr@facebook.com', '0164649877'),
(3, 'Hopital Massy', '50 rue des pyrenees', 'hopital.massy@hop.com', '0121696782');

-- --------------------------------------------------------

--
-- Table structure for table `malade`
--

CREATE TABLE IF NOT EXISTS `malade` (
  `id_malade` int(10) NOT NULL AUTO_INCREMENT,
  `nom_malade` varchar(255) DEFAULT NULL,
  `prenom_malade` varchar(255) DEFAULT NULL,
  `adresse_malade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_malade`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `malade`
--

INSERT INTO `malade` (`id_malade`, `nom_malade`, `prenom_malade`, `adresse_malade`) VALUES
(1, 'sdlkjgshpioty', 'slkdjbgsiuhga', 'sdkljfhgseiot'),
(2, 'Tayyab', 'Ramzan', '1 rue de l''essonne'),
(3, 'cecilia', 'silia', '92 avenue de la division leclerc');

-- --------------------------------------------------------

--
-- Table structure for table `personnel`
--

CREATE TABLE IF NOT EXISTS `personnel` (
  `id_personnel` int(10) NOT NULL AUTO_INCREMENT,
  `nom_personnel` varchar(255) DEFAULT NULL,
  `prenom_personnel` varchar(255) DEFAULT NULL,
  `email_personnel` varchar(255) DEFAULT NULL,
  `mdp_personnel` varchar(255) DEFAULT NULL,
  `id_role_personnel` int(10) NOT NULL,
  PRIMARY KEY (`id_personnel`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `role_personnel`
--

CREATE TABLE IF NOT EXISTS `role_personnel` (
  `id_role_personnel` int(10) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  `niveau_access` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_role_personnel`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `vehicule`
--

CREATE TABLE IF NOT EXISTS `vehicule` (
  `numero_immatricule` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`numero_immatricule`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
