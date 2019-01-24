CREATE TABLE `user_account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL DEFAULT '' COMMENT '登录账号，可能是email，手机号等',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码加密值',
  `source` tinyint(3) NOT NULL COMMENT '注册来源',
  `openid` varchar(255) NOT NULL DEFAULT '''''' COMMENT '微信平台的openid',
  `channel` tinyint(3) NOT NULL,
  `env` tinyint(3) NOT NULL DEFAULT '0',
  `valid` tinyint(3) NOT NULL DEFAULT '1',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_channel` (`user_name`,`channel`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `nickname` varchar(45) NOT NULL DEFAULT '''''',
  `avatar` varchar(255) NOT NULL DEFAULT '''''',
  `sex` tinyint(3) NOT NULL DEFAULT '0',
  `email` varchar(255) NOT NULL DEFAULT '''''',
  `phone` varchar(30) NOT NULL DEFAULT '''''',
  `address` varchar(255) NOT NULL DEFAULT '''''',
  `birthday` varchar(45) NOT NULL DEFAULT '''''',
  `slogan` varchar(255) NOT NULL DEFAULT '''''',
  `channel` tinyint(3) NOT NULL,
  `env` tinyint(3) NOT NULL DEFAULT '0',
  `valid` tinyint(3) NOT NULL DEFAULT '1',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_uid` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;