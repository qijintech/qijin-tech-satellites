  CREATE TABLE `order_delivery_info` (
      `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
      `order_id` bigint(20) unsigned NOT NULL COMMENT '订单ID',
      `order_no` varchar(60) NOT NULL COMMENT '订单号',
      `recipient_name` varchar(255) NOT NULL COMMENT '收货人（联系人）',
      `recipient_tel` varchar(128) NOT NULL COMMENT '收货人联系电话',
      `recipient_addr` varchar(512) NOT NULL COMMENT '收货地址',
      `express_no` varchar(1024) DEFAULT NULL COMMENT '快递单号',
      `valid` tinyint(4) DEFAULT '1' COMMENT '是否有效：1-有效，0-无效',
      `ctime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `utime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
      PRIMARY KEY (`id`),
      UNIQUE KEY `uk_order_no` (`order_no`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='订单配送信息表';