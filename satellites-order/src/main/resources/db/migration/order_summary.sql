create table if not exists order_summary
(
	id bigint unsigned auto_increment comment 'ID'
		primary key,
	former_order_id bigint unsigned default '0' not null comment '拆单前的原订单ID',
	order_no varchar(60) not null comment '订单号',
	acct_id bigint unsigned not null comment '账号ID',
	customer_id bigint unsigned not null comment '客户ID',
	customer_name varchar(255) not null comment '客户名称',
	poi_id bigint unsigned default '0' not null comment '门店ID',
	poi_name varchar(255) not null comment '门店名称',
	poi_type tinyint default '1' not null comment '门店类型：1-总店，2-分店',
	recipient_info_id bigint unsigned not null comment '配送（地址）信息ID',
	remark varchar(1024) default '' not null comment '订单备注',
	cancel_excuse varchar(1204) default '' not null comment '取消原因',
	cancel_remark varchar(1024) default '' not null comment '订单取消备注',
	reject_excuse varchar(1024) default '' not null comment '拒单原因（保留）',
	city_id int not null comment '城市ID',
	status smallint(10) not null comment '订单状态：10-待支付，15-未接单，19-接单中，20-已接单，55-已发货，60-已送达，89-取消中，90-已取消',
	payment_type tinyint not null comment '支付类型：1-在线支付',
	payment_method tinyint default '-1' null comment '结款渠道: 1-微信，2-支付宝，3-余额,4-组合支付,5-线下付款',
	payment_status tinyint default '0' null comment '结款状态：0-未结款，1-已结款',
	paid_time datetime null comment '结款时间',
	payment_id int(11) unsigned null comment '（在线支付）支付单ID',
	origin_amount decimal(12,2) default '999999.00' not null comment ' 订单原价总金额',
	total_amount decimal(12,2) default '999999.00' not null comment '订单（优惠前）销售价总金额',
	order_amount decimal(12,2) default '999999.00' not null comment '订单（优惠后）实际金额',
	reduced_amount decimal(12,2) default '0.00' not null comment '订单优惠金额',
	order_type tinyint default '1' not null comment '订单类型:1-自下单，2-换货订单',
	source tinyint default '0' not null comment '订单来源：0-未定义，1-WeChat，2-客服代下单',
	version smallint(10) default '1' null comment '订单版本',
	valid tinyint default '1' null comment '是否有效：1-有效，0-无效',
	creator_id int(11) unsigned default '0' null comment '代下单时下单人ID',
	ctime datetime default CURRENT_TIMESTAMP null comment '创建时间',
	utime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
	constraint uk_order_no
		unique (order_no)
)
comment '订单表' charset=utf8mb4
;

create index idx_customer_poi_id
	on order_summary (customer_id)
;

create index idx_poi_id_channel_id
	on order_summary (poi_id)
;

