CREATE TABLE `cm_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '评论用户id',
  `base_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '回复大楼基层id',
  `append_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '追加评论的id',
  `reply_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '被回复的评论id',
  `content` varchar(255) NOT NULL DEFAULT '''''' COMMENT '评论内容',
  `channel` tinyint(3) NOT NULL DEFAULT '0' COMMENT '渠道',
  `env` tinyint(3) NOT NULL DEFAULT '0' COMMENT '环境',
  `valid` tinyint(3) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`user_id`),
  KEY `idx_base` (`base_id`),
  KEY `idx_append` (`append_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `cm_comment_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) NOT NULL,
  `pic` varchar(255) NOT NULL DEFAULT '',
  `channel` tinyint(3) NOT NULL DEFAULT '0',
  `env` tinyint(3) NOT NULL DEFAULT '0',
  `valid` tinyint(3) NOT NULL DEFAULT '1',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_comment` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;