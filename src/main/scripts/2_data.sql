USE `cocktailbar`;

INSERT INTO `role` VALUES (1, 'BARMAN');
INSERT INTO `role` VALUES (2, 'MANAGER');
INSERT INTO `role` VALUES (3, 'ADMIN');

INSERT INTO `account` VALUES (NULL, 'barman', 'barman', 1, 1);
INSERT INTO `account` VALUES (NULL, 'manager', 'manager', 2, 1);
INSERT INTO `account` VALUES (NULL, 'admin', 'admin', 3, 1);
