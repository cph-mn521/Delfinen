DROP SCHEMA IF EXISTS `delfinen`;
CREATE SCHEMA `delfinen`;
USE `delfinen`;

DROP TABLE IF EXISTS `medlemmer`;
DROP TABLE IF EXISTS `resultater`;

CREATE TABLE `medlemmer` (
 `id` int(11) NOT NULL,
 `navn` varchar(45),
 `status` varchar(45),
 `gruppe` varchar(45),
 `aktivitet` varchar(45),
 `restance` int(11) NOT NULL,
 `email` varchar(45),
 `telefon` int(11) NOT NULL,
 `alder` int(11) NOT NULL,
 `adresse` varchar(45),
 PRIMARY KEY (`id`)
);

CREATE TABLE `resultater` (
 `id` int(11) NOT NULL,
 `resultat_id` int(11) NOT NULL,
 `disciplin` varchar(45),
 `dato` int(11) NOT NULL,
 `staevne` varchar(45),
 `placering` int(11) NOT NULL,
 `tid` int(11) NOT NULL,
 PRIMARY KEY (`id`)
);
