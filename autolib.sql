-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 14 Juin 2019 à 16:51
-- Version du serveur :  5.7.14
-- Version de PHP :  7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `autolib`
--

-- --------------------------------------------------------

--
-- Structure de la table `borne`
--

CREATE TABLE `borne` (
  `idBorne` int(11) NOT NULL,
  `etatBorne` tinyint(1) NOT NULL,
  `station` int(11) NOT NULL,
  `idVehicule` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `borne`
--

INSERT INTO `borne` (`idBorne`, `etatBorne`, `station`, `idVehicule`) VALUES
(1, 0, 1, 1),
(2, 0, 1, 2),
(3, 1, 1, NULL),
(4, 1, 1, NULL),
(5, 0, 2, 3),
(6, 0, 2, 4),
(7, 0, 2, 5),
(8, 1, 2, NULL),
(9, 1, 2, NULL),
(10, 1, 2, NULL),
(11, 0, 3, 6),
(12, 0, 3, 7),
(13, 1, 3, NULL),
(14, 1, 3, NULL),
(15, 0, 4, 8),
(16, 0, 4, 9),
(17, 1, 4, NULL),
(18, 1, 4, NULL),
(19, 0, 5, 10),
(20, 0, 5, 11),
(21, 1, 5, NULL),
(22, 1, 5, NULL),
(23, 0, 6, 12),
(24, 0, 6, 13),
(25, 1, 6, NULL),
(26, 1, 6, NULL),
(27, 0, 7, 14),
(28, 0, 7, 15),
(29, 1, 7, NULL),
(30, 1, 7, NULL),
(31, 0, 8, 16),
(32, 0, 8, 17),
(33, 1, 8, NULL),
(34, 1, 8, NULL),
(35, 0, 9, 18),
(36, 0, 9, 19),
(37, 0, 9, 20),
(38, 1, 9, NULL),
(39, 1, 9, NULL),
(40, 1, 9, NULL),
(41, 0, 10, 21),
(42, 0, 10, 22),
(43, 0, 10, 23),
(44, 0, 10, 24),
(45, 1, 10, NULL),
(46, 1, 10, NULL),
(47, 1, 10, NULL),
(48, 1, 10, NULL),
(49, 0, 11, 25),
(50, 1, 11, NULL),
(51, 0, 12, 26),
(52, 0, 12, 27),
(53, 0, 12, 28),
(54, 1, 12, NULL),
(55, 1, 12, NULL),
(56, 1, 12, NULL),
(57, 0, 13, 29),
(58, 0, 13, 30),
(59, 0, 13, 31),
(60, 1, 13, NULL),
(61, 1, 13, NULL),
(62, 1, 13, NULL),
(63, 0, 14, 32),
(64, 0, 14, 33),
(65, 1, 14, NULL),
(66, 1, 14, NULL),
(67, 0, 15, 34),
(68, 0, 15, 35),
(69, 1, 15, NULL),
(70, 1, 15, NULL),
(71, 0, 16, 36),
(72, 0, 16, 37),
(73, 0, 16, 38),
(74, 0, 16, 39),
(75, 0, 16, 40),
(76, 1, 16, NULL),
(77, 1, 16, NULL),
(78, 1, 16, NULL),
(79, 1, 16, NULL),
(80, 1, 16, NULL),
(81, 0, 17, 41),
(82, 0, 17, 42),
(83, 0, 17, 43),
(84, 0, 17, 44),
(85, 1, 17, NULL),
(86, 1, 17, NULL),
(87, 1, 17, NULL),
(88, 1, 17, NULL),
(89, 0, 18, 45),
(90, 0, 18, 46),
(91, 0, 18, 47),
(92, 1, 18, NULL),
(93, 1, 18, NULL),
(94, 1, 18, NULL),
(95, 0, 19, 48),
(96, 0, 19, 49),
(97, 1, 19, NULL),
(98, 1, 19, NULL),
(99, 0, 20, 50),
(100, 0, 20, 51),
(101, 1, 20, NULL),
(102, 1, 20, NULL),
(103, 0, 21, 52),
(104, 0, 21, 53),
(105, 1, 21, NULL),
(106, 1, 21, NULL),
(107, 0, 22, 54),
(108, 0, 22, 55),
(109, 1, 22, NULL),
(110, 1, 22, NULL),
(111, 0, 23, 56),
(112, 0, 23, 57),
(113, 0, 23, 58),
(114, 1, 23, NULL),
(115, 1, 23, NULL),
(116, 1, 23, NULL),
(117, 0, 24, 59),
(118, 0, 24, 60),
(119, 0, 24, 61),
(120, 1, 24, NULL),
(121, 1, 24, NULL),
(122, 1, 24, NULL),
(123, 0, 25, 62),
(124, 0, 25, 63),
(125, 0, 25, 64),
(126, 1, 25, NULL),
(127, 1, 25, NULL),
(128, 1, 25, NULL),
(129, 0, 26, 65),
(130, 1, 26, NULL),
(131, 0, 27, 66),
(132, 0, 27, 67),
(133, 1, 27, NULL),
(134, 1, 27, NULL),
(135, 0, 28, 68),
(136, 0, 28, 69),
(137, 0, 28, 70),
(138, 1, 28, NULL),
(139, 1, 28, NULL),
(140, 1, 28, NULL),
(141, 0, 29, 71),
(142, 0, 29, 72),
(143, 1, 29, NULL),
(144, 1, 29, NULL),
(145, 0, 30, 73),
(146, 0, 30, 74),
(147, 0, 30, 75),
(148, 1, 30, NULL),
(149, 1, 30, NULL),
(150, 1, 30, NULL),
(151, 0, 31, 76),
(152, 0, 31, 77),
(153, 1, 31, NULL),
(154, 1, 31, NULL),
(155, 0, 32, 78),
(156, 0, 32, 79),
(157, 1, 32, NULL),
(158, 1, 32, NULL),
(159, 0, 33, 80),
(160, 0, 33, 81),
(161, 1, 33, NULL),
(162, 1, 33, NULL),
(163, 0, 34, 82),
(164, 0, 34, 83),
(165, 0, 34, 84),
(166, 0, 34, 85),
(167, 0, 34, 86),
(168, 0, 34, 87),
(169, 1, 34, NULL),
(170, 1, 34, NULL),
(171, 1, 34, NULL),
(172, 1, 34, NULL),
(173, 1, 34, NULL),
(174, 1, 34, NULL),
(175, 0, 35, 88),
(176, 0, 35, 89),
(177, 1, 35, NULL),
(178, 1, 35, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `date_naissance` date DEFAULT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `prenom`, `date_naissance`, `login`, `password`) VALUES
(1, 'DUVERLIE', 'FRANCOISE', '1988-07-25', 'francoise.duverlie', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(2, 'LEMARCHAND', 'COLETTE', '1954-09-26', 'colette.lemarchand', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(3, 'ROCANCOURT', 'XAVIER', '1942-05-14', 'xavier.rocancourt', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(4, 'BUISARD', 'GEORGES', '1964-03-22', 'georges.buisard', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(5, 'LAROSE', 'SOLANGE', '1972-03-19', 'solange.larose', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(6, 'HOLLEY', 'JANINE', '1934-07-06', 'janine.holley', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(7, 'RIVIERE', 'GERARD', '1952-08-12', 'gerard.riviere', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(8, 'LEGRAND', 'JEAN LOUIS', '1930-04-28', 'jean louis.legrand', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(9, 'DUDOUET-MALASSIS', 'GISELE', '1976-02-01', 'gisele.dudouet-malassis', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(10, 'MORIN', 'GENEVIEVE', '1967-05-09', 'genevieve.morin', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(11, 'LE NOEL', 'GUY', '1984-07-06', 'guy.le noel', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(12, 'LANGRAND', 'AUGUSTE', '1972-02-12', 'auguste.langrand', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(13, 'ROBERT', 'PIERRE', '1947-06-09', 'pierre.robert', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(14, 'COISPEL', 'BERNARD', '1984-11-21', 'bernard.coispel', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(15, 'LEBOSQUAIN', 'JEAN', '1967-08-20', 'jean.lebosquain', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(16, 'LEROY', 'NADINE', '1967-10-10', 'nadine.leroy', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(17, 'LENORMAND', 'MICHEL', '1952-10-09', 'michel.lenormand', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(18, 'LE COMTE', 'GERARD', '1948-12-08', 'gerard.le comte', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(19, 'FERREIRA', 'JACK', '1942-11-13', 'jack.ferreira', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(20, 'VALENTE', 'J GEORGES', '1956-08-09', 'j georges.valente', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(21, 'GAUTIER', 'YVETTE', '1952-08-19', 'yvette.gautier', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(22, 'ROYER', 'JEAN', '1948-06-07', 'jean.royer', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(23, 'LOPEZ', 'JEAN PIERRE', '1987-03-25', 'jean pierre.lopez', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(24, 'LETOUZEY', 'ANNETTE', '1984-09-02', 'annette.letouzey', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(25, 'LEVAVASSEUR', 'SOPHIE', '1931-11-19', 'sophie.levavasseur', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(26, 'LAIGNEL', 'ROGER', '1971-02-04', 'roger.laignel', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(27, 'MORAINE', 'HUGUETTE', '1935-01-14', 'huguette.moraine', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(28, 'ROSEN', 'BERNADETTE', '1934-08-18', 'bernadette.rosen', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(29, 'MARIE', 'GENEVIEVE', '1943-03-21', 'genevieve.marie', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(30, 'MEUDIC', 'JANINE', '1981-06-26', 'janine.meudic', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(31, 'HEBERT', 'FRANCOISE', '1980-04-15', 'francoise.hebert', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(32, 'FALISE', 'MARIE THERESE', '1989-04-06', 'marie therese.falise', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(33, 'HEMERY', 'JEANNE', '1986-06-19', 'jeanne.hemery', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(34, 'HEUDE', 'CLAUDINE', '1960-10-06', 'claudine.heude', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(35, 'DAIGREMONT', 'CLAUDE', '1932-02-29', 'claude.daigremont', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(36, 'LEFRANCOIS', 'FRANCOIS', '1989-12-06', 'francois.lefrancois', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(37, 'THETIOT', 'JEAN', '1978-11-22', 'jean.thetiot', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(38, 'FREMONT', 'REMY', '1935-03-11', 'remy.fremont', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(39, 'BARRASSIN', 'DANIEL', '1933-05-20', 'daniel.barrassin', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(40, 'SERAFIN', 'MAURICE', '1937-09-17', 'maurice.serafin', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(41, 'DUBUS', 'JEANNE', '1986-06-25', 'jeanne.dubus', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(42, 'LEBLOND', 'MARIE LOUISE', '1983-10-24', 'marie louise.leblond', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(43, 'VANDAELE', 'BERNARD', '1941-11-16', 'bernard.vandaele', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(44, 'PERRIER', 'GUY', '1953-05-06', 'guy.perrier', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(45, 'MANCEL', 'JEAN CHARLES', '1947-02-04', 'jean charles.mancel', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(46, 'PIEDVACHE', 'MADELEINE', '1980-11-29', 'madeleine.piedvache', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(47, 'DEGRENNE', 'CLAUDE', '1941-09-10', 'claude.degrenne', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(48, 'CARABEUF', 'YVES', '1951-10-22', 'yves.carabeuf', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(49, 'BAROCHE', 'PAULETTE', '1971-08-09', 'paulette.baroche', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(50, 'DEVIQUE', 'CHRISTIAN', '1954-07-27', 'christian.devique', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(51, 'GOGUET', 'DANIEL', '1957-04-16', 'daniel.goguet', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(52, 'DAGAIN', 'ALAIN', '1955-09-14', 'alain.dagain', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(53, 'GROSMESNIL', 'MICHEL', '1990-10-17', 'michel.grosmesnil', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(54, 'COLIN', 'ALPHONSINE', '1988-11-25', 'alphonsine.colin', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(55, 'BONVICINI', 'MAURICE', '1963-09-25', 'maurice.bonvicini', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(56, 'RYDER', 'RAYMONDE', '1974-07-23', 'raymonde.ryder', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(57, 'DUCHATELLE', 'ROLAND', '1987-03-25', 'roland.duchatelle', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(58, 'GDOWSKI', 'LOUISE', '1962-03-10', 'louise.gdowski', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(59, 'MESNIL', 'PASCAL', '1977-09-05', 'pascal.mesnil', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(60, 'LEDUC', 'BERNARD', '1941-04-15', 'bernard.leduc', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(61, 'COLLET', 'THERESE', '1943-05-19', 'therese.collet', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(62, 'AUGER', 'FRANCOISE', '1966-06-06', 'francoise.auger', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(63, 'CANONNE', 'PATRICIA', '1963-08-28', 'patricia.canonne', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(64, 'VASLIN', 'BERNARD', '1952-04-21', 'bernard.vaslin', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(65, 'MARTIN', 'ELIANE', '1931-09-19', 'eliane.martin', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(66, 'CATHRINE', 'HENRI', '1955-04-19', 'henri.cathrine', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(67, 'MARTIN', 'CLAUDE', '1962-04-13', 'claude.martin', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(68, 'DELARUE', 'MARIE MADELEINE', '1941-02-15', 'marie madeleine.delarue', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(69, 'PIROU', 'PAUL', '1964-02-23', 'paul.pirou', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(70, 'FARCY', 'JOSETTE', '1975-04-21', 'josette.farcy', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(71, 'LEBLATIER', 'MARCEL', '1936-09-03', 'marcel.leblatier', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(72, 'LEFLOCH', 'GERARD', '1976-05-27', 'gerard.lefloch', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(73, 'CORDELLIER', 'MARCELLINE', '1947-11-22', 'marcelline.cordellier', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(74, 'VAN DOORNE', 'MARIE CLAUDE', '1977-03-04', 'marie claude.van doorne', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(75, 'DAUVERGNE', 'YOLANDE', '1960-04-01', 'yolande.dauvergne', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(76, 'LEDRU', 'MICHEL', '1945-04-28', 'michel.ledru', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(77, 'DESLANDES', 'MADELEINE', '1936-05-22', 'madeleine.deslandes', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(78, 'LEBRET', 'NICOLE', '1937-06-29', 'nicole.lebret', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(79, 'BAZILLE', 'DANIEL', '1968-12-05', 'daniel.bazille', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(80, 'LHERMITE', 'SIMONE', '1978-05-03', 'simone.lhermite', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(81, 'LESENECHAL', 'ARMELLE', '1955-07-12', 'armelle.lesenechal', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(82, 'GUERIN', 'PATRICIA', '1945-07-22', 'patricia.guerin', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(83, 'JOSEPHINE', 'JULIETTE', '1949-10-21', 'juliette.josephine', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(84, 'HAMEL', 'MAURICETTE', '1986-10-01', 'mauricette.hamel', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(85, 'SANCHEZ ACUNA', 'CHARLES', '1970-06-21', 'charles.sanchez acuna', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(86, 'JACQUES', 'ODETTE', '1971-08-12', 'odette.jacques', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(87, 'ANJOU', 'FERNAND', '1980-10-20', 'fernand.anjou', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(88, 'LEFIOT', 'SERGE', '1947-06-22', 'serge.lefiot', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(89, 'MENANT', 'XAVIER', '1953-12-13', 'xavier.menant', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(90, 'DAVID', 'SIMONNE', '1945-05-18', 'simonne.david', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(91, 'MARIAGE', 'IRENE', '1947-12-06', 'irene.mariage', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(92, 'CAPET', 'BERNARD', '1970-01-22', 'bernard.capet', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(93, 'GROULT', 'JEAN CLAUDE', '1938-07-22', 'jean claude.groult', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(94, 'ROGUE', 'HELENE', '1938-09-14', 'helene.rogue', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(95, 'LEMAINE', 'MARTHE', '1972-12-26', 'marthe.lemaine', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(96, 'BOURREAU', 'IRENE', '1943-08-21', 'irene.bourreau', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(97, 'ROCQUANCOURT', 'CECILE', '1949-02-26', 'cecile.rocquancourt', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(98, 'ROBINE', 'GEORGETTE', '1970-02-12', 'georgette.robine', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(99, 'LEMOIGNE', 'MARCELINE', '1988-05-13', 'marceline.lemoigne', '5ebe2294ecd0e0f08eab7690d2a6ee69'),
(100, 'LEBRETON', 'JEAN-LUC', '1970-11-27', 'jean-luc.lebreton', '5ebe2294ecd0e0f08eab7690d2a6ee69');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(10) NOT NULL,
  `vehicule` int(11) NOT NULL,
  `client` int(11) NOT NULL,
  `date_reservation` datetime NOT NULL,
  `date_echeance` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `reservation`
--

INSERT INTO `reservation` (`id`, `vehicule`, `client`, `date_reservation`, `date_echeance`) VALUES
(1, 1, 1, '2016-01-06 00:00:00', '2016-01-15 00:00:00'),
(2, 1, 1, '2016-01-07 00:00:00', '2016-01-15 00:00:00'),
(3, 2, 1, '2016-01-13 00:00:00', '2016-01-21 00:00:00'),
(4, 3, 2, '2016-01-13 00:00:00', '2016-01-14 00:00:00'),
(5, 5, 1, '2019-06-13 20:53:50', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `station`
--

CREATE TABLE `station` (
  `id` int(11) NOT NULL,
  `latitude` decimal(9,6) NOT NULL,
  `longitude` decimal(9,6) NOT NULL,
  `adresse` varchar(200) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `ville` varchar(100) DEFAULT NULL,
  `code_postal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `station`
--

INSERT INTO `station` (`id`, `latitude`, `longitude`, `adresse`, `numero`, `ville`, `code_postal`) VALUES
(1, '45.745013', '4.871353', 'Place Ambroise Courtois', 18, 'LYON', 69003),
(2, '45.756529', '4.835870', 'Place Antonin Poncet', 1, 'LYON', 69002),
(3, '45.736646', '4.869195', 'Place du 11 Novembre 1918', 1, 'LYON', 69008),
(4, '45.746291', '4.836518', 'Rue de Marseille', 99, 'LYON', 69007),
(5, '45.767066', '4.859037', 'Place Jules Ferry', 4, 'LYON', 69006),
(6, '45.750515', '4.828684', 'Place Carnot', 1, 'LYON', 69002),
(7, '45.759626', '4.831426', 'Place des Celestins', 11, 'LYON', 69001),
(8, '45.742935', '4.821108', 'Cours Charlemagne', 79, 'LYON', 69002),
(9, '45.770582', '4.863906', 'Cours Emile Zola', 25, 'VILLEURBANNE', 69100),
(10, '45.763898', '4.837211', 'Rue Antoine SallÃ¨s', 13, 'LYON', 69002),
(11, '45.763593', '4.837556', 'Rue Claudia', 18, 'LYON', 69002),
(12, '45.781623', '4.833029', 'Rue de Belfort', 79, 'LYON', 69004),
(13, '45.756493', '4.841091', 'Place Antonin Jutard', 1, 'LYON', 69003),
(14, '45.779842', '4.804396', 'Rue du 24 mars', 16, 'LYON', 69009),
(15, '45.766982', '4.804261', 'Rue de la PÃ©piniÃ¨re Royale', 1, 'LYON', 69009),
(16, '45.774699', '4.833476', 'Boulevard de la Croix-Rousse', 167, 'LYON', 69004),
(17, '45.768490', '4.836873', 'Place Louis Pradel', 1, 'LYON', 69001),
(18, '45.767306', '4.878818', 'Rue Michel Servet', 30, 'VILLEURBANNE', 69100),
(19, '45.736826', '4.836859', 'Avenue Jean JaurÃ¨s', 198, 'LYON', 69007),
(20, '45.746043', '4.841807', 'Place Jean MacÃ©', 1, 'LYON', 69007),
(21, '45.763210', '4.851320', 'Rue Garibaldi', 156, 'LYON', 69003),
(22, '45.756331', '4.878070', 'Rue Jean JaurÃ¨s', 3, 'VILLEURBANNE', 69100),
(23, '45.768299', '4.843074', 'Place du MarÃ©chal Lyautey', 11, 'LYON', 69006),
(24, '45.760181', '4.863023', 'Rue Maurice Flandin', 33, 'LYON', 69003),
(25, '45.760573', '4.857305', 'Rue Servient', 1, 'LYON', 69003),
(26, '45.756497', '4.796727', 'Place des Compagnons de la Chansons', 1, 'LYON', 69005),
(27, '45.760683', '4.835688', 'Rue de la RÃ©publique', 53, 'LYON', 69002),
(28, '45.762946', '4.832010', 'Quai Saint-Antoine', 1, 'LYON', 69002),
(29, '45.758435', '4.826310', 'Place BenoÃ®t Crepu', 6, 'LYON', 69005),
(30, '45.761159', '4.828415', 'Quai Romain Rolland', 25, 'LYON', 69005),
(31, '45.757101', '4.815734', 'Rue Trion', 40, 'LYON', 69005),
(32, '45.768823', '4.830700', 'Place Sathonay', 5, 'LYON', 69001),
(33, '45.760267', '4.845699', 'Avenue MarÃ©chal de Saxe', 91, 'LYON', 69003),
(34, '45.767139', '4.833873', 'Place des Terreaux', 23, 'LYON', 69001),
(35, '45.775182', '4.805386', 'Rue du Sergent Michel Berthet', 2, 'LYON', 69009),
(36, '45.756070', '4.845092', 'Rue Paul Bert', 18, 'LYON', 69003);

-- --------------------------------------------------------

--
-- Structure de la table `type_vehicule`
--

CREATE TABLE `type_vehicule` (
  `idType_vehicule` int(11) NOT NULL,
  `categorie` varchar(45) NOT NULL,
  `type_vehicule` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `type_vehicule`
--

INSERT INTO `type_vehicule` (`idType_vehicule`, `categorie`, `type_vehicule`) VALUES
(1, 'Petite citadine', 'Citroën C1'),
(2, 'Petite citadine', 'Toyota Aygo'),
(3, 'Utilitaire', 'Citroën Berlingo'),
(4, 'Utilitaire', 'Citroën Berlingo PRM'),
(5, 'Utilitaire', 'Nissan Evalia'),
(6, 'Compacte', 'Toyota Yaris'),
(7, 'Familliale', 'C4 Piccaso'),
(8, 'Familliale', 'Toyota Verso');

-- --------------------------------------------------------

--
-- Structure de la table `utilise`
--

CREATE TABLE `utilise` (
  `id` int(10) NOT NULL,
  `Vehicule` int(11) NOT NULL,
  `Client` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `borne_depart` int(11) NOT NULL,
  `borne_arrivee` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilise`
--

INSERT INTO `utilise` (`id`, `Vehicule`, `Client`, `date`, `borne_depart`, `borne_arrivee`) VALUES
(1, 1, 1, '2016-01-12 00:00:00', 7, 15);

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `idVehicule` int(11) NOT NULL,
  `RFID` int(11) NOT NULL,
  `etatBatterie` int(11) DEFAULT NULL,
  `Disponibilite` varchar(45) NOT NULL,
  `latitude` decimal(9,6) DEFAULT NULL,
  `longitude` decimal(9,6) DEFAULT NULL,
  `type_vehicule` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `vehicule`
--

INSERT INTO `vehicule` (`idVehicule`, `RFID`, `etatBatterie`, `Disponibilite`, `latitude`, `longitude`, `type_vehicule`) VALUES
(1, 1234567891, 100, 'LIBRE', '45.745013', '4.871353', 2),
(2, 1234567892, 100, 'LIBRE', '45.745013', '4.871353', 2),
(3, 1234567893, 100, 'LIBRE', '45.756529', '4.835870', 2),
(4, 1234567894, 100, 'LIBRE', '45.756529', '4.835870', 2),
(5, 1234567895, 100, 'LIBRE', '45.756529', '4.835870', 3),
(6, 1234567896, 100, 'LIBRE', '45.736646', '4.869195', 2),
(7, 1234567897, 100, 'LIBRE', '45.736646', '4.869195', 2),
(8, 1234567898, 100, 'LIBRE', '45.746291', '4.836518', 2),
(9, 1234567899, 100, 'LIBRE', '45.746291', '4.836518', 5),
(10, 1234567900, 100, 'LIBRE', '45.767066', '4.859037', 2),
(11, 1234567901, 100, 'LIBRE', '45.767066', '4.859037', 2),
(12, 1234567902, 100, 'LIBRE', '45.750515', '4.828684', 2),
(13, 1234567903, 100, 'LIBRE', '45.750515', '4.828684', 2),
(14, 1234567904, 100, 'LIBRE', '45.759626', '4.831426', 1),
(15, 1234567905, 100, 'LIBRE', '45.759626', '4.831426', 2),
(16, 1234567906, 100, 'LIBRE', '45.742935', '4.821108', 2),
(17, 1234567907, 100, 'LIBRE', '45.742935', '4.821108', 2),
(18, 1234567908, 100, 'LIBRE', '45.770582', '4.863906', 2),
(19, 1234567909, 100, 'LIBRE', '45.770582', '4.863906', 2),
(20, 1234567910, 100, 'LIBRE', '45.770582', '4.863906', 2),
(21, 1234567911, 100, 'LIBRE', '45.763898', '4.837211', 2),
(22, 1234567912, 100, 'LIBRE', '45.763898', '4.837211', 2),
(23, 1234567913, 100, 'LIBRE', '45.763898', '4.837211', 5),
(24, 1234567914, 100, 'LIBRE', '45.763898', '4.837211', 6),
(25, 1234567915, 100, 'LIBRE', '45.763593', '4.837556', 4),
(26, 1234567916, 100, 'LIBRE', '45.781623', '4.833029', 2),
(27, 1234567917, 100, 'LIBRE', '45.781623', '4.833029', 5),
(28, 1234567918, 100, 'LIBRE', '45.781623', '4.833029', 6),
(29, 1234567919, 100, 'LIBRE', '45.756493', '4.841091', 2),
(30, 1234567920, 100, 'LIBRE', '45.756493', '4.841091', 2),
(31, 1234567921, 100, 'LIBRE', '45.756493', '4.841091', 8),
(32, 1234567922, 100, 'LIBRE', '45.779842', '4.804396', 2),
(33, 1234567923, 100, 'LIBRE', '45.779842', '4.804396', 2),
(34, 1234567924, 100, 'LIBRE', '45.766982', '4.804261', 2),
(35, 1234567925, 100, 'LIBRE', '45.766982', '4.804261', 2),
(36, 1234567926, 100, 'LIBRE', '45.774699', '4.833476', 2),
(37, 1234567927, 100, 'LIBRE', '45.774699', '4.833476', 2),
(38, 1234567928, 100, 'LIBRE', '45.774699', '4.833476', 2),
(39, 1234567929, 100, 'LIBRE', '45.774699', '4.833476', 3),
(40, 1234567930, 100, 'LIBRE', '45.774699', '4.833476', 6),
(41, 1234567931, 100, 'LIBRE', '45.768490', '4.836873', 2),
(42, 1234567932, 100, 'LIBRE', '45.768490', '4.836873', 2),
(43, 1234567933, 100, 'LIBRE', '45.768490', '4.836873', 2),
(44, 1234567934, 100, 'LIBRE', '45.768490', '4.836873', 5),
(45, 1234567935, 100, 'LIBRE', '45.768490', '4.836873', 8),
(46, 1234567936, 100, 'LIBRE', '45.767306', '4.878818', 2),
(47, 1234567937, 100, 'LIBRE', '45.767306', '4.878818', 2),
(48, 1234567938, 100, 'LIBRE', '45.767306', '4.878818', 5),
(49, 1234567939, 100, 'LIBRE', '45.736826', '4.836859', 2),
(50, 1234567940, 100, 'LIBRE', '45.736826', '4.836859', 2),
(51, 1234567941, 100, 'LIBRE', '45.746043', '4.841807', 2),
(52, 1234567942, 100, 'LIBRE', '45.746043', '4.841807', 2),
(53, 1234567943, 100, 'LIBRE', '45.763210', '4.851320', 2),
(54, 1234567944, 100, 'LIBRE', '45.763210', '4.851320', 6),
(55, 1234567945, 100, 'LIBRE', '45.756331', '4.878070', 2),
(56, 1234567946, 100, 'LIBRE', '45.756331', '4.878070', 2),
(57, 1234567947, 100, 'LIBRE', '45.768299', '4.843074', 1),
(58, 1234567948, 100, 'LIBRE', '45.768299', '4.843074', 2),
(59, 1234567949, 100, 'LIBRE', '45.768299', '4.843074', 6),
(60, 1234567950, 100, 'LIBRE', '45.760181', '4.863023', 2),
(61, 1234567951, 100, 'LIBRE', '45.760181', '4.863023', 1),
(62, 1234567952, 100, 'LIBRE', '45.760181', '4.863023', 8),
(63, 1234567953, 100, 'LIBRE', '45.760573', '4.857305', 2),
(64, 1234567954, 100, 'LIBRE', '45.760573', '4.857305', 2),
(65, 1234567955, 100, 'LIBRE', '45.760573', '4.857305', 7),
(66, 1234567956, 100, 'LIBRE', '45.756497', '4.796727', 2),
(67, 1234567957, 100, 'LIBRE', '45.760683', '4.835688', 2),
(68, 1234567958, 100, 'LIBRE', '45.760683', '4.835688', 6),
(69, 1234567959, 100, 'LIBRE', '45.762946', '4.832010', 1),
(70, 1234567960, 100, 'LIBRE', '45.762946', '4.832010', 3),
(71, 1234567961, 100, 'LIBRE', '45.762946', '4.832010', 8),
(72, 1234567962, 100, 'LIBRE', '45.758435', '4.826310', 2),
(73, 1234567963, 100, 'LIBRE', '45.758435', '4.826310', 3),
(74, 1234567964, 100, 'LIBRE', '45.761159', '4.828415', 2),
(75, 1234567965, 100, 'LIBRE', '45.761159', '4.828415', 2),
(76, 1234567966, 100, 'LIBRE', '45.761159', '4.828415', 6),
(77, 1234567967, 100, 'LIBRE', '45.757101', '4.815734', 2),
(78, 1234567968, 100, 'LIBRE', '45.757101', '4.815734', 2),
(79, 1234567969, 100, 'LIBRE', '45.768823', '4.830700', 2),
(80, 1234567970, 100, 'LIBRE', '45.768823', '4.830700', 2),
(81, 1234567971, 100, 'LIBRE', '45.760267', '4.845699', 2),
(82, 1234567972, 100, 'LIBRE', '45.760267', '4.845699', 2),
(83, 1234567973, 100, 'LIBRE', '45.767139', '4.833873', 2),
(84, 1234567974, 100, 'LIBRE', '45.767139', '4.833873', 2),
(85, 1234567975, 100, 'LIBRE', '45.767139', '4.833873', 2),
(86, 1234567976, 100, 'LIBRE', '45.767139', '4.833873', 5),
(87, 1234567977, 100, 'LIBRE', '45.767139', '4.833873', 6),
(88, 1234567978, 100, 'LIBRE', '45.775182', '4.805386', 2),
(89, 1234567979, 100, 'LIBRE', '45.775182', '4.805386', 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `borne`
--
ALTER TABLE `borne`
  ADD PRIMARY KEY (`idBorne`),
  ADD KEY `fk_Borne_Station1_idx` (`station`),
  ADD KEY `fk_Borne_Vehicule1_idx` (`idVehicule`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`),
  ADD UNIQUE KEY `login` (`login`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `vehicule` (`vehicule`,`client`,`date_reservation`),
  ADD UNIQUE KEY `vehicule_2` (`vehicule`,`client`,`date_reservation`),
  ADD KEY `fk_Reservation_Vehicule1_idx` (`vehicule`),
  ADD KEY `fk_Reservation_Client1_idx` (`client`);

--
-- Index pour la table `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `type_vehicule`
--
ALTER TABLE `type_vehicule`
  ADD PRIMARY KEY (`idType_vehicule`);

--
-- Index pour la table `utilise`
--
ALTER TABLE `utilise`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Vehicule` (`Vehicule`,`Client`,`date`),
  ADD KEY `fk_table1_Client1_idx` (`Client`),
  ADD KEY `fk_utilise_Borne1_idx` (`borne_depart`),
  ADD KEY `fk_utilise_Borne2_idx` (`borne_arrivee`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`idVehicule`),
  ADD UNIQUE KEY `RFID_UNIQUE` (`RFID`),
  ADD KEY `fk_Vehicule_Type_vehicule1_idx` (`type_vehicule`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `borne`
--
ALTER TABLE `borne`
  MODIFY `idBorne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=179;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=401;
--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `station`
--
ALTER TABLE `station`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT pour la table `type_vehicule`
--
ALTER TABLE `type_vehicule`
  MODIFY `idType_vehicule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `utilise`
--
ALTER TABLE `utilise`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `idVehicule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `borne`
--
ALTER TABLE `borne`
  ADD CONSTRAINT `fk_Borne_Station1` FOREIGN KEY (`station`) REFERENCES `station` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Borne_Vehicule1` FOREIGN KEY (`idVehicule`) REFERENCES `vehicule` (`idVehicule`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_Reservation_Client1` FOREIGN KEY (`client`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Reservation_Vehicule1` FOREIGN KEY (`vehicule`) REFERENCES `vehicule` (`idVehicule`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `utilise`
--
ALTER TABLE `utilise`
  ADD CONSTRAINT `fk_table1_Client1` FOREIGN KEY (`Client`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_table1_Vehicule1` FOREIGN KEY (`Vehicule`) REFERENCES `vehicule` (`idVehicule`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_utilise_Borne1` FOREIGN KEY (`borne_depart`) REFERENCES `borne` (`idBorne`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_utilise_Borne2` FOREIGN KEY (`borne_arrivee`) REFERENCES `borne` (`idBorne`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `fk_Vehicule_Type_vehicule1` FOREIGN KEY (`type_vehicule`) REFERENCES `type_vehicule` (`idType_vehicule`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
