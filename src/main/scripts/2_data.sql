USE `cocktailbar`;

INSERT INTO `role` VALUES (1, 'BARMAN');
INSERT INTO `role` VALUES (2, 'MANAGER');
INSERT INTO `role` VALUES (3, 'ADMIN');

INSERT INTO `account` (id, username, password, role_id, enabled) VALUES (NULL, 'barman', '$2y$12$MOrFfifjtcgBzRZLrMRZReSCMlVazb1hkR4vu2C4mo3GTg7Gt8HV6', 1, b'1');
INSERT INTO `account` (id, username, password, role_id, enabled) VALUES (NULL, 'manager', '$2y$12$Th3C8KbpFfwzNiMwvXvE/ewuV/cneX.VfqbiIO6JDif5TFi9rEjTG', 2, b'1');
INSERT INTO `account` (id, username, password, role_id, enabled) VALUES (NULL, 'admin', '$2y$12$K8WhwczqJBp94E4sEIijCOul9hL9io2dCMeI4O6196PzfxcvIJVla', 3, b'1');
