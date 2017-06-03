USE `cocktailbar`;

CREATE TABLE `role` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(45) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `account` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`username` varchar(45) NOT NULL,
	`password` varchar(60) NOT NULL,
	`id_role` int(11) NOT NULL,
	`enabled` tinyint(1) NOT NULL DEFAULT 1,
	PRIMARY KEY (`id`),
	UNIQUE KEY `id_UNIQUE` (`id`),
	KEY `FK_ACCOUNT_ROLE_idx` (`id_role`),
	CONSTRAINT `FK_ACCOUNT_ROLE` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `role` VALUES (1, 'BARMAN');
INSERT INTO `role` VALUES (2, 'MANAGER');
INSERT INTO `role` VALUES (3, 'ADMIN');

INSERT INTO `account` VALUES (NULL, 'barman', 'barman', 1, 1);
INSERT INTO `account` VALUES (NULL, 'manager', 'manager', 2, 1);
INSERT INTO `account` VALUES (NULL, 'admin', 'admin', 3, 1);