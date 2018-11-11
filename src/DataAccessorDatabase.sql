DROP SCHEMA IF EXISTS `glarmester`;
CREATE SCHEMA `glarmester`;
USE `glarmester`;

DROP TABLE IF EXISTS `frames`;
DROP TABLE IF EXISTS `glass`;

CREATE TABLE `frames` (
 `id` int(11) NOT NULL,
 `quality` varchar(45),
 `frame_price` varchar(45),
 PRIMARY KEY (`id`)
);

CREATE TABLE `glass` (
 `id` int(11) NOT NULL,
 `glass_price` int(11) NOT NULL,
 PRIMARY KEY (`id`)
);


INSERT INTO `frames` (`id`, `quality`, `frame_price`) VALUES (1,'Plain',100);
INSERT INTO `frames` (`id`, `quality`, `frame_price`) VALUES (2,'Ornate', 200);
INSERT INTO `frames` (`id`, `quality`, `frame_price`) VALUES (3,'Lavish', 350);
INSERT INTO `frames` (`id`, `quality`, `frame_price`) VALUES (4,'Extreme', 1550);

INSERT INTO `glass` (`id`, `glass_price`) VALUES (1,300);
INSERT INTO `glass` (`id`, `glass_price`) VALUES (2,300);
INSERT INTO `glass` (`id`, `glass_price`) VALUES (3,300);
INSERT INTO `glass` (`id`, `glass_price`) VALUES (4,300);
