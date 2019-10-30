-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 30 oct. 2019 à 09:49
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetjavarecette`
--

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id_ingredient` int(11) NOT NULL AUTO_INCREMENT,
  `nom_ingredient` varchar(100) NOT NULL,
  `categorie_ingredient` varchar(100) NOT NULL,
  `prix_ingredient` int(11) NOT NULL,
  `quantite_ingredient` int(11) NOT NULL,
  PRIMARY KEY (`id_ingredient`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id_ingredient`, `nom_ingredient`, `categorie_ingredient`, `prix_ingredient`, `quantite_ingredient`) VALUES
(1, 'Banane', 'Fruit', 0, 0),
(2, 'Pomme', 'Fruit', 0, 0),
(3, 'Pate', 'Feculent', 0, 0),
(4, 'Farine', 'Céréale', 0, 0),
(5, 'Chocolat', 'bof', 0, 0),
(6, 'Carotte', 'Légume', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `ingredient_recette`
--

DROP TABLE IF EXISTS `ingredient_recette`;
CREATE TABLE IF NOT EXISTS `ingredient_recette` (
  `id_ingredient_recette` int(11) NOT NULL AUTO_INCREMENT,
  `id_ingredient` int(11) NOT NULL,
  `id_recette` int(11) NOT NULL,
  PRIMARY KEY (`id_ingredient_recette`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `recette`
--

DROP TABLE IF EXISTS `recette`;
CREATE TABLE IF NOT EXISTS `recette` (
  `id_recette` int(11) NOT NULL AUTO_INCREMENT,
  `nom_recette` varchar(100) NOT NULL,
  `description_recette` text NOT NULL,
  PRIMARY KEY (`id_recette`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
