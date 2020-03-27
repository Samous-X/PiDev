-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 27 mars 2020 à 19:05
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet_jardin`
--

-- --------------------------------------------------------

--
-- Structure de la table `bus`
--

CREATE TABLE `bus` (
  `Id_bus` int(11) NOT NULL,
  `Immat` varchar(50) NOT NULL,
  `ligne` varchar(50) NOT NULL,
  `horaire` time(6) NOT NULL,
  `chauffeur` varchar(50) NOT NULL,
  `nbrplace` int(11) NOT NULL,
  `image` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bus`
--

INSERT INTO `bus` (`Id_bus`, `Immat`, `ligne`, `horaire`, `chauffeur`, `nbrplace`, `image`) VALUES
(37, '172 Tunis 15', 'N8', '00:00:22.000000', 'ahmed', 14, 'C:/Users/Hejer Ghariani/Desktop/classeco.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `cat_reclamation`
--

CREATE TABLE `cat_reclamation` (
  `id_categorie` int(11) NOT NULL,
  `type` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `Id` int(11) NOT NULL,
  `nom_classe` varchar(50) NOT NULL,
  `niveau_classe` int(11) NOT NULL,
  `enfant` varchar(20) NOT NULL,
  `nombre` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`Id`, `nom_classe`, `niveau_classe`, `enfant`, `nombre`) VALUES
(1, 'sanafer', 1, 'ahmed', 10),
(2, 'sanafer', 1, 'ahmed', 10),
(3, 'sanafer', 1, 'ahmed', 10);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id_com` int(100) NOT NULL,
  `numcompte` varchar(11) DEFAULT NULL,
  `date_com` date DEFAULT NULL,
  `date_liv` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_com`, `numcompte`, `date_com`, `date_liv`) VALUES
(1, '45125', '2020-02-26', '2020-03-08'),
(2, '2222', '2020-02-27', '2020-02-28'),
(3, '8512165', '2020-02-27', '2020-02-28'),
(4, '12365544', '2020-02-27', '2020-03-07');

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE `comment` (
  `idc` int(11) NOT NULL,
  `textec` varchar(50) NOT NULL,
  `datec` date NOT NULL,
  `id` varchar(88) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `comment`
--

INSERT INTO `comment` (`idc`, `textec`, `datec`, `id`) VALUES
(1, 'oussama', '2020-02-22', 'popo'),
(5, 'ah', '2020-02-27', 'aaa');

-- --------------------------------------------------------

--
-- Structure de la table `enfant`
--

CREATE TABLE `enfant` (
  `id_enfant` int(11) NOT NULL,
  `nom` varchar(11) NOT NULL,
  `prenom` varchar(11) NOT NULL,
  `age` int(11) NOT NULL,
  `photo` text NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `vaccin` tinyint(1) NOT NULL,
  `alergie` tinyint(1) NOT NULL,
  `idjardin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enfant`
--

INSERT INTO `enfant` (`id_enfant`, `nom`, `prenom`, `age`, `photo`, `id_utilisateur`, `vaccin`, `alergie`, `idjardin`) VALUES
(13, 'hejer', 'hassan', 3, '', 14, 1, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id_event` int(11) NOT NULL,
  `titre` varchar(30) NOT NULL,
  `description` text NOT NULL,
  `date` date NOT NULL,
  `idjardin` int(11) NOT NULL,
  `heureD` time NOT NULL,
  `heureF` time NOT NULL,
  `prix_event` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id_event`, `titre`, `description`, `date`, `idjardin`, `heureD`, `heureF`, `prix_event`) VALUES
(3, 'ahmed', 'ahmed', '2020-02-27', 22, '21:27:00', '22:27:00', 20),
(6, 'ahmed', 'hejer', '2020-02-27', 22, '20:54:00', '22:54:00', 20),
(7, 'ahmed', 'hghjh', '2020-02-04', 22, '03:07:00', '01:07:00', 4);

-- --------------------------------------------------------

--
-- Structure de la table `jardin`
--

CREATE TABLE `jardin` (
  `idjardin` int(11) NOT NULL,
  `nom` varchar(1000) NOT NULL,
  `Adresse` varchar(1000) NOT NULL,
  `lang` double NOT NULL,
  `lat` double NOT NULL,
  `Prix_mois` int(11) NOT NULL,
  `Numero_telephone` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `jardin`
--

INSERT INTO `jardin` (`idjardin`, `nom`, `Adresse`, `lang`, `lat`, `Prix_mois`, `Numero_telephone`, `id_utilisateur`) VALUES
(22, 'Bloom', '4 rue ezzahra', 0, 0, 180, 29616696, 13),
(24, 'hhh', 'neheh', 0, 0, 12, 0, 11),
(25, 'hee', 'hhh', 0, 0, 22, 0, 11),
(26, 'hhh', 'enfedjn', 0, 0, 25, 0, 11),
(27, 'hehe', 'heh', 0, 0, 1200, 0, 11),
(28, 'hhh', 'bnc', 0, 0, 255, 0, 11),
(29, 'jejje', 'vvv', 0, 0, 255, 0, 11),
(30, 'hhhdd', 'dd', 0, 0, 255, 0, 11),
(31, 'kk', 'jjjj', 0, 0, 25, 0, 11),
(32, 'gg', 'bnnn', 0, 0, 25, 0, 11),
(33, 'slimen', 'rades', 0, 0, 12, 0, 11),
(34, 'hh', 'nn', 0, 0, 22, 0, 11);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `idpanier` int(100) NOT NULL,
  `idproduit` int(100) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `qte_prod` int(100) DEFAULT NULL,
  `prix_prod` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `parent`
--

CREATE TABLE `parent` (
  `id_parent` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `cin` int(11) NOT NULL,
  `email` varchar(60) NOT NULL,
  `photo` text NOT NULL,
  `tel` int(11) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL,
  `etat` tinyint(1) NOT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `parent`
--

INSERT INTO `parent` (`id_parent`, `nom`, `prenom`, `cin`, `email`, `photo`, `tel`, `login`, `password`, `etat`, `created_on`) VALUES
(1, 'ahmed', 'aaa', 0, 'aaa', 'aaa', 2, '', '', 0, '2020-02-26 15:15:19'),
(2, 'oussama', 'aaa', 0, 'ee', 'eee', 555, 'hejer', 'hejer', 0, '2020-02-26 15:15:19'),
(3, 'hejer', 'ghariani', 7494532, 'hejer.ghariani@esprit.tn', 'ahmed.jpg', 0, 'hejer.ghariani@esprit.tn', '7494532', 1, '2020-03-02 15:03:10');

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

CREATE TABLE `participant` (
  `id_participant` int(11) NOT NULL,
  `id_event` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `nombre_enfant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `idproduit` int(255) NOT NULL,
  `nomproduit` varchar(255) NOT NULL,
  `prix_prod` int(255) NOT NULL,
  `qte` int(100) NOT NULL,
  `img_prod` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idproduit`, `nomproduit`, `prix_prod`, `qte`, `img_prod`) VALUES
(40, 'hejer', 22, 2, 'C:/Users/Hejer Ghariani/Desktop/classeco.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

CREATE TABLE `publication` (
  `id` int(11) NOT NULL,
  `texte` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `score` int(11) NOT NULL,
  `categorie` varchar(30) NOT NULL,
  `image` varchar(528) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`id`, `texte`, `date`, `score`, `categorie`, `image`) VALUES
(7, 'tout', '2020-02-27', 0, 'suggestion', 'C:/Users/Hejer Ghariani/Pictures/13072137_1309060362441587_1395321118_o.jpg'),
(8, 'tout', '2020-02-27', 0, 'suggestion', 'C:/Users/Hejer Ghariani/Pictures/13072137_1309060362441587_1395321118_o.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id_reclamation` int(11) NOT NULL,
  `email` varchar(60) NOT NULL,
  `contenu` text NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_categorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id_res` int(11) NOT NULL,
  `nom_p` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `immatriculation` varchar(50) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `enfant` varchar(50) NOT NULL,
  `etat` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_res`, `nom_p`, `type`, `immatriculation`, `date_debut`, `date_fin`, `enfant`, `etat`) VALUES
(1, 'ahmed', 'Aller Simple', '175', '2020-01-30', '2020-03-06', 'aymen', 1);

-- --------------------------------------------------------

--
-- Structure de la table `staff`
--

CREATE TABLE `staff` (
  `Id_staff` int(100) NOT NULL,
  `Nom_staff` varchar(100) NOT NULL,
  `Prenom_staff` varchar(100) NOT NULL,
  `Poste` varchar(100) NOT NULL,
  `idjardin` int(11) NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `staff`
--

INSERT INTO `staff` (`Id_staff`, `Nom_staff`, `Prenom_staff`, `Poste`, `idjardin`, `Status`) VALUES
(12, 'heje', 'hhh', 'nnn', 22, 'Actif '),
(14, 'ahmed', 'aaa', 'chauffeur', 22, 'Actif '),
(15, 'salah', 'meher', 'chef', 22, ''),
(16, 'salma', 'tahri', 'medecin', 22, ''),
(17, 'salah', 'salah', 'chef', 22, 'Actif ');

-- --------------------------------------------------------

--
-- Structure de la table `store`
--

CREATE TABLE `store` (
  `idstore` int(100) NOT NULL,
  `nom_store` varchar(100) NOT NULL,
  `idjardin` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id_utilisateur` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `tel` int(8) NOT NULL,
  `login` varchar(60) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(20) DEFAULT NULL,
  `cin` int(11) NOT NULL,
  `photo` text NOT NULL,
  `etat` tinyint(1) NOT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `nom`, `prenom`, `email`, `tel`, `login`, `password`, `role`, `cin`, `photo`, `etat`, `created_on`) VALUES
(11, 'hejer', '', 'hejer.gharianii@gmail.com', 29616696, 'wafa', '1234', 'directeur', 0, '', 0, '2020-03-21 15:26:25'),
(12, 'hejer', '', 'h.ahmed@esprit.tn', 29616696, 'wafa', '1234', 'directeur', 0, '', 0, '2020-03-21 15:26:25'),
(13, 'hejer', '', 'hejer.ghariani@gmail.com', 23242480, 'hejer', '2511', 'admin', 0, '', 0, '2020-03-21 15:26:25'),
(14, 'aa', '', 'aa', 25, 'aa', '22', 'parent', 0, '', 0, '2020-03-21 15:26:25'),
(15, 'emna', 'ghariani', 'emna', 0, 'emna', '1234', 'parent', 1234, 'logo-esprit-final.png', 1, '2020-03-21 15:49:24');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`Id_bus`),
  ADD UNIQUE KEY `Immat` (`Immat`);

--
-- Index pour la table `cat_reclamation`
--
ALTER TABLE `cat_reclamation`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id_com`);

--
-- Index pour la table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`idc`);

--
-- Index pour la table `enfant`
--
ALTER TABLE `enfant`
  ADD PRIMARY KEY (`id_enfant`),
  ADD KEY `id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id_event`),
  ADD KEY `idjardin` (`idjardin`);

--
-- Index pour la table `jardin`
--
ALTER TABLE `jardin`
  ADD PRIMARY KEY (`idjardin`),
  ADD KEY `id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`idpanier`),
  ADD UNIQUE KEY `idproduit` (`idproduit`),
  ADD KEY `id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `parent`
--
ALTER TABLE `parent`
  ADD PRIMARY KEY (`id_parent`);

--
-- Index pour la table `participant`
--
ALTER TABLE `participant`
  ADD PRIMARY KEY (`id_participant`),
  ADD KEY `id_event` (`id_event`,`id_utilisateur`),
  ADD KEY `id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`idproduit`);

--
-- Index pour la table `publication`
--
ALTER TABLE `publication`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id_reclamation`),
  ADD KEY `id_utilisateur` (`id_utilisateur`),
  ADD KEY `id_categorie` (`id_categorie`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id_res`);

--
-- Index pour la table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`Id_staff`),
  ADD KEY `staff_ibfk_1` (`idjardin`);

--
-- Index pour la table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`idstore`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id_utilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bus`
--
ALTER TABLE `bus`
  MODIFY `Id_bus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT pour la table `cat_reclamation`
--
ALTER TABLE `cat_reclamation`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id_com` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `comment`
--
ALTER TABLE `comment`
  MODIFY `idc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `enfant`
--
ALTER TABLE `enfant`
  MODIFY `id_enfant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id_event` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `jardin`
--
ALTER TABLE `jardin`
  MODIFY `idjardin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT pour la table `panier`
--
ALTER TABLE `panier`
  MODIFY `idpanier` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `parent`
--
ALTER TABLE `parent`
  MODIFY `id_parent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `participant`
--
ALTER TABLE `participant`
  MODIFY `id_participant` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `idproduit` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT pour la table `publication`
--
ALTER TABLE `publication`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id_reclamation` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id_res` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `staff`
--
ALTER TABLE `staff`
  MODIFY `Id_staff` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `store`
--
ALTER TABLE `store`
  MODIFY `idstore` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `enfant`
--
ALTER TABLE `enfant`
  ADD CONSTRAINT `enfant_ibfk_2` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `evenement_ibfk_1` FOREIGN KEY (`idjardin`) REFERENCES `jardin` (`idjardin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `jardin`
--
ALTER TABLE `jardin`
  ADD CONSTRAINT `jardin_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `panier_ibfk_1` FOREIGN KEY (`idproduit`) REFERENCES `produit` (`idproduit`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `panier_ibfk_2` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `participant`
--
ALTER TABLE `participant`
  ADD CONSTRAINT `participant_ibfk_1` FOREIGN KEY (`id_event`) REFERENCES `evenement` (`id_event`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `participant_ibfk_2` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `reclamation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reclamation_ibfk_2` FOREIGN KEY (`id_categorie`) REFERENCES `cat_reclamation` (`id_categorie`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`idjardin`) REFERENCES `jardin` (`idjardin`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
