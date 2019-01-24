INSERT INTO `user_account` (`id`, `user_name`, `password`, `source`, `openid`, `channel`, `env`, `valid`, `ctime`, `utime`)
VALUES
	(1, 'UnitTest', '$2a$11$3o0J/HzSaWt8of4BgvAK1u4hxLm3t4Q3aXrWquTeDv3s2G1bMystu', 1, '\'\'', 0, 0, 1, NOW(), NOW());

INSERT INTO `user_info` (`id`, `user_id`, `nickname`, `avatar`, `sex`, `email`, `phone`, `address`, `birthday`, `slogan`, `channel`, `env`, `valid`, `ctime`, `utime`)
VALUES
	(1, 1, '\'\'', '\'\'', 0, '\'\'', '18810442532', '\'\'', '\'\'', '\'\'', 0, 0, 1, NOW(), NOW());

