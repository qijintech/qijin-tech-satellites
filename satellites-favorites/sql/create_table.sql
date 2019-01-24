CREATE TABLE `fa_favorites` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `collect` tinyint(3) NOT NULL COMMENT '1表示收藏，0表示未收藏',
  `valid` tinyint(3) NOT NULL DEFAULT '1',
  `env` tinyint(3) NOT NULL DEFAULT '0',
  `channel` tinyint(3) NOT NULL DEFAULT '0',
  `version` bigint(20) NOT NULL DEFAULT '1',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_channel` (`user_id`,`channel`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;