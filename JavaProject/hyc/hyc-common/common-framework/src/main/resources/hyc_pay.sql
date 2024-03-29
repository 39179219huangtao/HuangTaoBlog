# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 180.167.213.26 (MySQL 5.7.26)
# Database: mall_pay
# Generation Time: 2019-07-11 06:56:36 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table app
# ------------------------------------------------------------

DROP TABLE IF EXISTS `app`;

CREATE TABLE `app` (
  `id` varchar(50) NOT NULL COMMENT '应用编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '应用名',
  `notify_url` varchar(255) NOT NULL DEFAULT '' COMMENT '异步通知地址',
  `refund_notify_url` varchar(255) NOT NULL COMMENT '退款异步通知地址',
  `status` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='pay_app';

LOCK TABLES `app` WRITE;
/*!40000 ALTER TABLE `app` DISABLE KEYS */;

INSERT INTO `app` (`id`, `name`, `notify_url`, `refund_notify_url`, `status`, `create_time`, `update_time`)
VALUES
	('POd4RC6a','商城订单','cn.iocoder.mall.order.api.OrderService#updatePaySuccess#1.0.0','cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess#1.0.0',1,'2019-03-13 11:10:05','2019-05-17 14:02:45');

/*!40000 ALTER TABLE `app` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table notify_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `notify_log`;

CREATE TABLE `notify_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志编号，自增',
  `notify_id` int(11) NOT NULL COMMENT '通知编号',
  `request` varchar(5000) NOT NULL COMMENT '请求参数',
  `response` varchar(5000) NOT NULL COMMENT '响应结果',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='pay_transaction_notify_log';

LOCK TABLES `notify_log` WRITE;
/*!40000 ALTER TABLE `notify_log` DISABLE KEYS */;

INSERT INTO `notify_log` (`id`, `notify_id`, `request`, `response`, `status`, `create_time`, `update_time`)
VALUES
	(1,3,'{\"appId\":\"POd4RC6a\",\"id\":3,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderService#updatePaySuccess\",\"orderId\":\"135\",\"transactionId\":50}','success',2,'2019-04-27 00:44:12','2019-04-27 00:44:12'),
	(20,10,'{\"appId\":\"POd4RC6a\",\"id\":10,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess\",\"orderId\":\"135\",\"refundId\":10,\"transactionId\":50}','success',2,'2019-04-27 01:38:08','2019-04-27 01:38:08'),
	(41,11,'{\"appId\":\"POd4RC6a\",\"id\":11,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderService#updatePaySuccess\",\"orderId\":\"159\",\"transactionId\":108}','success',2,'2019-05-09 01:11:27','2019-05-09 01:11:27'),
	(42,12,'{\"appId\":\"POd4RC6a\",\"id\":12,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderService#updatePaySuccess\",\"orderId\":\"160\",\"transactionId\":109}','success',2,'2019-05-09 01:15:21','2019-05-09 01:15:21'),
	(46,20,'{\"appId\":\"POd4RC6a\",\"id\":20,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderService#updatePaySuccess\",\"orderId\":\"173\",\"transactionId\":121}','success',2,'2019-05-09 20:36:33','2019-05-09 20:36:33'),
	(47,21,'{\"appId\":\"POd4RC6a\",\"id\":21,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderService#updatePaySuccess\",\"orderId\":\"128\",\"transactionId\":43}','success',2,'2019-05-09 20:36:52','2019-05-09 20:36:52'),
	(48,22,'{\"appId\":\"POd4RC6a\",\"id\":22,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderService#updatePaySuccess\",\"orderId\":\"174\",\"transactionId\":122}','success',2,'2019-05-10 01:16:49','2019-05-10 01:16:49'),
	(49,23,'{\"appId\":\"POd4RC6a\",\"id\":23,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderService#updatePaySuccess\",\"orderId\":\"176\",\"transactionId\":123}','success',2,'2019-05-10 21:06:15','2019-05-10 21:06:15'),
	(50,31,'{\"appId\":\"POd4RC6a\",\"id\":31,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderService#updatePaySuccess#1.0.0\",\"orderId\":\"218\",\"transactionId\":137}','success',2,'2019-05-17 14:21:36','2019-05-17 14:21:36'),
	(51,28,'{\"appId\":\"POd4RC6a\",\"id\":28,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderService#updatePaySuccess\",\"orderId\":\"216\",\"transactionId\":135}','success',2,'2019-05-17 14:21:42','2019-05-17 14:21:42'),
	(58,32,'{\"appId\":\"POd4RC6a\",\"id\":32,\"notifyTimes\":0,\"notifyUrl\":\"cn.iocoder.mall.order.api.OrderService#updatePaySuccess#1.0.0\",\"orderId\":\"219\",\"transactionId\":138}','success',2,'2019-05-17 15:18:31','2019-05-17 15:18:31');

/*!40000 ALTER TABLE `notify_log` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table notify_task
# ------------------------------------------------------------

DROP TABLE IF EXISTS `notify_task`;

CREATE TABLE `notify_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号，自增',
  `app_id` varchar(50) NOT NULL COMMENT '应用编号',
  `status` tinyint(4) NOT NULL COMMENT '通知状态',
  `type` tinyint(4) NOT NULL COMMENT '类型',
  `next_notify_time` datetime DEFAULT NULL COMMENT '最后一次通知时间',
  `last_execute_time` datetime DEFAULT NULL COMMENT '最后执行时间',
  `notify_times` tinyint(4) NOT NULL COMMENT '当前通知次数',
  `max_notify_times` tinyint(4) NOT NULL COMMENT '最大可通知次数',
  `transaction` varchar(255) DEFAULT NULL COMMENT '支付数据',
  `refund` varchar(255) DEFAULT NULL COMMENT '退款数据',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='transaction_notify_task';

LOCK TABLES `notify_task` WRITE;
/*!40000 ALTER TABLE `notify_task` DISABLE KEYS */;

INSERT INTO `notify_task` (`id`, `app_id`, `status`, `type`, `next_notify_time`, `last_execute_time`, `notify_times`, `max_notify_times`, `transaction`, `refund`, `create_time`, `update_time`)
VALUES
	(1,'POd4RC6a',1,1,'2019-04-27 00:39:44',NULL,0,9,'{\"orderId\":\"133\",\"transactionExtensionId\":77,\"transactionId\":48}',NULL,'2019-04-27 00:39:31','2019-04-27 00:39:31'),
	(2,'POd4RC6a',1,1,'2019-04-27 00:43:28',NULL,0,9,'{\"orderId\":\"134\",\"transactionExtensionId\":78,\"transactionId\":49}',NULL,'2019-04-27 00:43:13','2019-04-27 00:43:13'),
	(3,'POd4RC6a',2,1,'2019-04-27 00:44:27','2019-04-27 00:44:12',1,9,'{\"orderId\":\"135\",\"transactionExtensionId\":79,\"transactionId\":50}',NULL,'2019-04-27 00:44:12','2019-04-27 00:44:12'),
	(4,'POd4RC6a',1,2,'2019-04-27 01:23:21',NULL,0,9,NULL,'{\"orderId\":\"135\",\"refundId\":6,\"transactionId\":50}','2019-04-27 01:23:05','2019-04-27 01:23:05'),
	(5,'POd4RC6a',1,2,'2019-04-27 01:24:54',NULL,0,9,NULL,'{\"orderId\":\"135\",\"refundId\":3,\"transactionId\":50}','2019-04-27 01:24:38','2019-04-27 01:24:38'),
	(6,'POd4RC6a',1,2,'2019-04-27 01:28:18',NULL,0,9,NULL,'{\"orderId\":\"135\",\"refundId\":7,\"transactionId\":50}','2019-04-27 01:28:03','2019-04-27 01:28:03'),
	(10,'POd4RC6a',2,2,'2019-04-27 01:38:14','2019-04-27 01:37:59',1,9,NULL,'{\"orderId\":\"135\",\"refundId\":10,\"transactionId\":50}','2019-04-27 01:37:59','2019-04-27 01:38:08'),
	(11,'POd4RC6a',2,1,'2019-05-09 01:11:01','2019-05-09 01:11:27',1,9,'{\"orderId\":\"159\",\"transactionExtensionId\":80,\"transactionId\":108}',NULL,'2019-05-09 01:10:46','2019-05-09 01:11:26'),
	(12,'POd4RC6a',2,1,'2019-05-09 01:15:24','2019-05-09 01:15:22',1,9,'{\"orderId\":\"160\",\"transactionExtensionId\":81,\"transactionId\":109}',NULL,'2019-05-09 01:15:12','2019-05-09 01:15:21'),
	(20,'POd4RC6a',2,1,'2019-05-09 20:36:31','2019-05-09 20:36:32',1,9,'{\"orderId\":\"173\",\"transactionExtensionId\":92,\"transactionId\":121}',NULL,'2019-05-09 20:36:16','2019-05-09 20:36:33'),
	(21,'POd4RC6a',2,1,'2019-05-09 20:37:08','2019-05-09 20:36:53',1,9,'{\"orderId\":\"128\",\"transactionExtensionId\":93,\"transactionId\":43}',NULL,'2019-05-09 20:36:52','2019-05-09 20:36:52'),
	(22,'POd4RC6a',2,1,'2019-05-10 01:17:05','2019-05-10 01:16:50',1,9,'{\"orderId\":\"174\",\"transactionExtensionId\":94,\"transactionId\":122}',NULL,'2019-05-10 01:16:49','2019-05-10 01:16:49'),
	(23,'POd4RC6a',2,1,'2019-05-10 21:06:31','2019-05-10 21:06:16',1,9,'{\"orderId\":\"176\",\"transactionExtensionId\":95,\"transactionId\":123}',NULL,'2019-05-10 21:06:15','2019-05-10 21:06:15'),
	(28,'POd4RC6a',2,1,'2019-05-17 14:08:15','2019-05-17 14:21:43',1,9,'{\"orderId\":\"216\",\"transactionExtensionId\":99,\"transactionId\":135}',NULL,'2019-05-17 14:07:59','2019-05-17 14:21:42'),
	(31,'POd4RC6a',2,1,'2019-05-17 14:21:39','2019-05-17 14:21:36',1,9,'{\"orderId\":\"218\",\"transactionExtensionId\":102,\"transactionId\":137}',NULL,'2019-05-17 14:21:24','2019-05-17 14:21:36'),
	(32,'POd4RC6a',2,1,'2019-05-17 15:18:46','2019-05-17 15:18:31',1,9,'{\"orderId\":\"219\",\"transactionExtensionId\":103,\"transactionId\":138}',NULL,'2019-05-17 15:18:31','2019-05-17 15:18:31');

/*!40000 ALTER TABLE `notify_task` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table refund
# ------------------------------------------------------------

DROP TABLE IF EXISTS `refund`;

CREATE TABLE `refund` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号，自增',
  `transaction_id` int(11) NOT NULL COMMENT '支付交易编号',
  `refund_code` varbinary(50) NOT NULL COMMENT '生成传输给第三方的退款号',
  `app_id` varchar(50) NOT NULL COMMENT '应用编号\n     *\n     * 不同业务线分配不同的 appId\n     * 举个例子，\n     * 1. 电商系统的订单，appId = 1024\n     * 2. 活动系统的订单，appId = 2048',
  `order_id` varchar(50) NOT NULL COMMENT '业务线的订单编号\n     *\n     * 1. 使用 String 的原因是，业务线可能使用 String 做为编号\n     * 2. 每个 appId 下，orderId 唯一',
  `create_ip` varchar(50) NOT NULL COMMENT '发起交易的 IP',
  `order_description` varchar(50) NOT NULL COMMENT '业务退款描述',
  `price` int(11) NOT NULL COMMENT '退款金额，单位：分。',
  `status` tinyint(4) NOT NULL COMMENT '退款状态\n     *\n     * @see cn.iocoder.mall.pay.api.constant.PayRefundStatus',
  `finish_time` datetime DEFAULT NULL COMMENT '回调业务线完成时间',
  `notify_url` varchar(255) NOT NULL COMMENT '异步通知地址',
  `extension_data` varchar(1024) DEFAULT NULL COMMENT '扩展内容\n     *\n     * 异步通知的时候填充回调的数据',
  `refund_channel` int(11) NOT NULL COMMENT '退款渠道',
  `refund_time` datetime DEFAULT NULL COMMENT '第三方退款成功的时间',
  `notify_time` datetime DEFAULT NULL COMMENT '收到第三方系统通知的时间\n     *\n     * 一般情况下，即第三方系统的异步通知',
  `trade_no` varchar(50) DEFAULT NULL COMMENT '第三方的流水号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='pay_refund';

LOCK TABLES `refund` WRITE;
/*!40000 ALTER TABLE `refund` DISABLE KEYS */;

INSERT INTO `refund` (`id`, `transaction_id`, `refund_code`, `app_id`, `order_id`, `create_ip`, `order_description`, `price`, `status`, `finish_time`, `notify_url`, `extension_data`, `refund_channel`, `refund_time`, `notify_time`, `trade_no`, `create_time`, `update_time`)
VALUES
	(1,47,'','POd4RC6a','132','127.0.0.1','测试下退款',1,1,NULL,'cn.iocoder.mall.order.api.OrderReturnService#updateRefundFinish',NULL,9999,NULL,NULL,NULL,'2019-04-26 16:16:21','2019-04-26 16:16:20'),
	(2,50,X'3230313930343237303035333035313832383232','POd4RC6a','135','127.0.0.1','测试下退款',1,1,NULL,'cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess',NULL,9999,NULL,NULL,NULL,'2019-04-27 00:53:05','2019-04-27 00:53:05'),
	(3,50,X'3230313930343237303131363537383432363937','POd4RC6a','135','127.0.0.1','测试下退款',1,3,NULL,'cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess','{\"id\":\"evt_400190427011658181610003\",\"created\":1556299018,\"livemode\":false,\"type\":\"refund.succeeded\",\"data\":{\"object\":{\"id\":\"re_9Oebj5LKmTmTmT0az9fTqPyP\",\"object\":\"refund\",\"order_no\":\"9Oebj5LKmTmTmT0az9fTqPyP\",\"amount\":1,\"created\":1556299018,\"succeed\":true,\"status\":\"succeeded\",\"time_succeed\":1556299018,\"description\":\"测试下退款\",\"failure_code\":null,\"failure_msg\":null,\"metadata\":{\"refundCode\":\"20190427011657842697\"},\"charge\":\"ch_y1iXjLnDS4G4OO4uT4a5C4W1\",\"charge_order_no\":\"20190427004410165545\",\"transaction_no\":\"201904270116584452782\",\"extra\":{}}},\"object\":\"event\",\"request\":\"iar_v1aTW19O0OO0f1ev5SGqLSK4\",\"pending_webhooks\":0}',9999,NULL,NULL,NULL,'2019-04-27 01:16:58','2019-04-27 01:24:38'),
	(4,50,X'3230313930343237303131393137333731303832','POd4RC6a','135','127.0.0.1','测试下退款',1,1,NULL,'cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess',NULL,9999,NULL,NULL,NULL,'2019-04-27 01:19:17','2019-04-27 01:19:17'),
	(5,50,X'3230313930343237303132313030383239363939','POd4RC6a','135','127.0.0.1','测试下退款',1,1,NULL,'cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess',NULL,9999,NULL,NULL,NULL,'2019-04-27 01:21:01','2019-04-27 01:21:00'),
	(6,50,X'3230313930343237303132333034363332363038','POd4RC6a','135','127.0.0.1','测试下退款',1,3,NULL,'cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess','{\"id\":\"evt_400190427012305181712903\",\"created\":1556299385,\"livemode\":false,\"type\":\"refund.succeeded\",\"data\":{\"object\":{\"id\":\"re_mTGGWLzD8SePCGWbX19KSSaP\",\"object\":\"refund\",\"order_no\":\"mTGGWLzD8SePCGWbX19KSSaP\",\"amount\":1,\"created\":1556299385,\"succeed\":true,\"status\":\"succeeded\",\"time_succeed\":1556299385,\"description\":\"测试下退款\",\"failure_code\":null,\"failure_msg\":null,\"metadata\":{\"refundCode\":\"20190427012304632608\"},\"charge\":\"ch_y1iXjLnDS4G4OO4uT4a5C4W1\",\"charge_order_no\":\"20190427004410165545\",\"transaction_no\":\"201904270123051790753\",\"extra\":{}}},\"object\":\"event\",\"request\":\"iar_rP80WDL4Ku9KOaXLCOmPWTKC\",\"pending_webhooks\":0}',9999,NULL,NULL,NULL,'2019-04-27 01:23:05','2019-04-27 01:23:05'),
	(7,50,X'3230313930343237303132383032383531333238','POd4RC6a','135','127.0.0.1','测试下退款',1,3,NULL,'cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess','{\"id\":\"evt_400190427012802341778702\",\"created\":1556299682,\"livemode\":false,\"type\":\"refund.succeeded\",\"data\":{\"object\":{\"id\":\"re_nrLmT85aTCyLeDyjv1LmH0e5\",\"object\":\"refund\",\"order_no\":\"nrLmT85aTCyLeDyjv1LmH0e5\",\"amount\":1,\"created\":1556299682,\"succeed\":true,\"status\":\"succeeded\",\"time_succeed\":1556299682,\"description\":\"测试下退款\",\"failure_code\":null,\"failure_msg\":null,\"metadata\":{\"refundCode\":\"20190427012802851328\"},\"charge\":\"ch_y1iXjLnDS4G4OO4uT4a5C4W1\",\"charge_order_no\":\"20190427004410165545\",\"transaction_no\":\"201904270128023511588\",\"extra\":{}}},\"object\":\"event\",\"request\":\"iar_1aXPePubTCm5GW1Ky5DajTyL\",\"pending_webhooks\":0}',9999,NULL,NULL,NULL,'2019-04-27 01:28:02','2019-04-27 01:28:03'),
	(8,50,X'3230313930343237303133343338323832343330','POd4RC6a','135','127.0.0.1','测试下退款',1,1,NULL,'cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess',NULL,9999,NULL,NULL,NULL,'2019-04-27 01:34:39','2019-04-27 01:34:38'),
	(9,50,X'3230313930343237303133363031363230353231','POd4RC6a','135','127.0.0.1','测试下退款',1,1,NULL,'cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess',NULL,9999,NULL,NULL,NULL,'2019-04-27 01:36:01','2019-04-27 01:36:01'),
	(10,50,X'3230313930343237303133373538363732313237','POd4RC6a','135','127.0.0.1','测试下退款',1,3,'2019-04-27 01:38:09','cn.iocoder.mall.order.api.OrderReturnService#updateRefundSuccess','{\"id\":\"evt_400190427013758341915902\",\"created\":1556300278,\"livemode\":false,\"type\":\"refund.succeeded\",\"data\":{\"object\":{\"id\":\"re_qLWXT4bnbXTG5u90i14Cmb1G\",\"object\":\"refund\",\"order_no\":\"qLWXT4bnbXTG5u90i14Cmb1G\",\"amount\":1,\"created\":1556300278,\"succeed\":true,\"status\":\"succeeded\",\"time_succeed\":1556300278,\"description\":\"测试下退款\",\"failure_code\":null,\"failure_msg\":null,\"metadata\":{\"refundCode\":\"20190427013758672127\"},\"charge\":\"ch_y1iXjLnDS4G4OO4uT4a5C4W1\",\"charge_order_no\":\"20190427004410165545\",\"transaction_no\":\"201904270137588767780\",\"extra\":{}}},\"object\":\"event\",\"request\":\"iar_fTKCeHLajbjPnb1inDj5mbf5\",\"pending_webhooks\":0}',9999,NULL,NULL,'test','2019-04-27 01:37:58','2019-05-08 18:27:26');

/*!40000 ALTER TABLE `refund` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table transaction
# ------------------------------------------------------------

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号，自增',
  `app_id` varchar(50) NOT NULL DEFAULT '' COMMENT '应用编号',
  `create_ip` varchar(50) NOT NULL DEFAULT '' COMMENT '发起交易的 IP',
  `order_id` varchar(50) NOT NULL DEFAULT '' COMMENT '业务线的订单编号',
  `order_subject` varchar(50) NOT NULL COMMENT '订单商品名',
  `order_description` varchar(50) NOT NULL COMMENT '订单商品描述',
  `order_memo` varchar(50) DEFAULT NULL COMMENT '订单备注',
  `price` int(11) NOT NULL COMMENT '支付金额，单位：分。',
  `status` tinyint(4) NOT NULL COMMENT '订单状态',
  `expire_time` datetime DEFAULT NULL COMMENT '交易过期时间',
  `finish_time` datetime DEFAULT NULL COMMENT '回调业务线完成时间',
  `notify_url` varchar(255) NOT NULL DEFAULT '' COMMENT '异步通知地址',
  `extension_id` int(11) DEFAULT NULL COMMENT '成功支付的交易拓展编号',
  `pay_channel` int(11) DEFAULT NULL COMMENT '支付成功的支付渠道',
  `payment_time` datetime DEFAULT NULL COMMENT '第三方支付成功的时间',
  `notify_time` datetime DEFAULT NULL COMMENT '收到第三方系统通知的时间',
  `trade_no` varchar(50) DEFAULT NULL COMMENT '第三方的流水号',
  `refund_total` int(11) DEFAULT '0' COMMENT '退款总金额',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_orderId_appId` (`app_id`,`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='pay_transaction';

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;

INSERT INTO `transaction` (`id`, `app_id`, `create_ip`, `order_id`, `order_subject`, `order_description`, `order_memo`, `price`, `status`, `expire_time`, `finish_time`, `notify_url`, `extension_id`, `pay_channel`, `payment_time`, `notify_time`, `trade_no`, `refund_total`, `create_time`, `update_time`)
VALUES
	(1,'POd4RC6a','127.0.0.1','1','商品名','商品描述','商品备注',10,2,'2019-03-13 13:36:32',NULL,'TODO',15,9999,'2019-03-13 17:30:21','2019-03-13 17:30:22','1285076745201903130468978518',4,'2019-03-13 13:36:32','2019-04-27 01:37:59'),
	(2,'POd4RC6a','127.0.0.1','2','商品名','商品描述','商品备注',10,2,'2019-03-14 16:08:14','2019-03-14 22:09:20','TODO',22,9999,'2019-03-14 16:13:58','2019-03-14 16:13:58','1282396661201903145620538794',4,'2019-03-14 16:08:15','2019-04-27 01:37:59'),
	(3,'POd4RC6a','127.0.0.1','91','kafka 实战','测试描述','测试备注',160,1,'2019-04-21 01:46:59',NULL,'TODO',NULL,NULL,NULL,NULL,NULL,4,'2019-04-20 23:47:01','2019-04-27 01:37:59'),
	(5,'POd4RC6a','127.0.0.1','92','农夫山泉','测试描述','测试备注',1000,1,'2019-04-21 04:13:47',NULL,'TODO',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 02:13:52','2019-04-27 01:37:59'),
	(8,'POd4RC6a','127.0.0.1','93','kafka 实战','测试描述','测试备注',160,1,'2019-04-21 04:15:14',NULL,'TODO',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 02:15:14','2019-04-27 01:37:59'),
	(9,'POd4RC6a','127.0.0.1','94','kafka 实战','测试描述','测试备注',160,1,'2019-04-21 04:15:17',NULL,'TODO',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 02:15:17','2019-04-27 01:37:59'),
	(10,'POd4RC6a','127.0.0.1','95','kafka 实战','测试描述','测试备注',160,1,'2019-04-21 04:17:24',NULL,'TODO',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 02:17:24','2019-04-27 01:37:59'),
	(11,'POd4RC6a','127.0.0.1','97','kafka 实战','测试描述','测试备注',160,2,'2019-04-21 16:22:49','2019-04-21 14:25:40','cn.iocoder.mall.pay.api.PayDemoService#updatePaySuccess',37,9999,'2019-04-21 14:23:04','2019-04-21 14:23:15','1214878818201904214744765608',4,'2019-04-21 14:22:49','2019-04-27 01:37:59'),
	(12,'POd4RC6a','127.0.0.1','98','kafka 实战','测试描述','测试备注',160,2,'2019-04-21 17:01:50',NULL,'cn.iocoder.mall.pay.api.PayDemoService#updatePaySuccess',38,9999,'2019-04-21 15:01:56','2019-04-21 15:01:57','1242451315201904216613366351',4,'2019-04-21 15:01:50','2019-04-27 01:37:59'),
	(13,'POd4RC6a','127.0.0.1','99','kafka 实战','测试描述','测试备注',160,2,'2019-04-21 17:05:21',NULL,'cn.iocoder.mall.order.api.OrderServicee#updatePaySuccess',39,9999,'2019-04-21 15:05:27','2019-04-21 15:05:28','1232163188201904219935216641',4,'2019-04-21 15:05:22','2019-04-27 01:37:59'),
	(14,'POd4RC6a','127.0.0.1','100','kafka 实战','测试描述','测试备注',160,1,'2019-04-21 17:06:08',NULL,'cn.iocoder.mall.order.api.OrderServicee#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 15:06:12','2019-04-27 01:37:59'),
	(17,'POd4RC6a','127.0.0.1','101','kafka 实战','测试描述','测试备注',160,1,'2019-04-21 17:06:30',NULL,'cn.iocoder.mall.order.api.OrderServicee#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 15:06:30','2019-04-27 01:37:59'),
	(18,'POd4RC6a','127.0.0.1','102','测试商品','测试描述','测试备注',100,2,'2019-04-21 17:10:39',NULL,'cn.iocoder.mall.order.api.OrderServicee#updatePaySuccess',40,9999,'2019-04-21 15:11:13','2019-04-21 15:11:14','1262352890201904219469841110',4,'2019-04-21 15:10:39','2019-04-27 01:37:59'),
	(19,'POd4RC6a','127.0.0.1','103','测试商品','测试描述','测试备注',100,2,'2019-04-21 17:14:17','2019-04-21 15:21:26','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',41,9999,'2019-04-21 15:14:22','2019-04-21 15:14:23','1248585474201904212137778537',4,'2019-04-21 15:14:17','2019-04-27 01:37:59'),
	(20,'POd4RC6a','127.0.0.1','104','测试商品','测试描述','测试备注',100,2,'2019-04-21 17:19:19','2019-04-21 15:20:16','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',42,9999,'2019-04-21 15:19:24','2019-04-21 15:19:25','1214125122201904212507946245',4,'2019-04-21 15:19:19','2019-04-27 01:37:59'),
	(21,'POd4RC6a','124.77.208.137','105','kafka 实战','测试描述','测试备注',160,1,'2019-04-21 20:59:24',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 18:59:24','2019-04-27 01:37:59'),
	(22,'POd4RC6a','124.77.208.137','106','kafka 实战','测试描述','测试备注',160,1,'2019-04-21 21:08:18',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 19:08:18','2019-04-27 01:37:59'),
	(23,'POd4RC6a','124.77.208.137','107','kafka 实战','测试描述','测试备注',160,1,'2019-04-21 21:22:19',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 19:22:19','2019-04-27 01:37:59'),
	(24,'POd4RC6a','124.77.208.137','109','测试商品','测试描述','测试备注',100,1,'2019-04-21 21:57:14',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 19:57:14','2019-04-27 01:37:59'),
	(25,'POd4RC6a','127.0.0.1','110','测试商品','测试描述','测试备注',100,2,'2019-04-21 22:17:04',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',54,9999,'2019-04-21 20:17:15','2019-04-21 20:17:19','1263683564201904219993710538',4,'2019-04-21 20:17:04','2019-04-27 01:37:59'),
	(26,'POd4RC6a','124.77.208.137','111','农夫山泉','测试描述','测试备注',1000,1,'2019-04-21 22:24:05',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-21 20:24:05','2019-04-27 01:37:59'),
	(27,'POd4RC6a','124.77.208.137','112','农夫山泉','测试描述','测试备注',1000,2,'2019-04-21 22:37:45','2019-04-22 19:32:35','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',63,9999,'2019-04-22 19:32:30','2019-04-22 19:32:31','1244224811201904228521103170',4,'2019-04-21 20:37:45','2019-04-27 01:37:59'),
	(28,'POd4RC6a','124.77.208.137','113','农夫山泉','测试描述','测试备注',1000,2,'2019-04-21 22:51:38','2019-04-22 19:35:58','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',64,9999,'2019-04-22 19:35:57','2019-04-22 19:35:58','1213285149201904222299145413',4,'2019-04-21 20:51:38','2019-04-27 01:37:59'),
	(29,'POd4RC6a','124.77.208.137','114','农夫山泉','测试描述','测试备注',1000,2,'2019-04-22 00:38:24','2019-04-21 22:38:34','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',60,9999,'2019-04-21 22:38:32','2019-04-21 22:38:33','1290815313201904211598433725',4,'2019-04-21 22:38:24','2019-04-27 01:37:59'),
	(30,'POd4RC6a','124.77.208.137','115','kafka 实战','测试描述','测试备注',160,2,'2019-04-22 01:29:21','2019-04-22 19:36:16','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',65,9999,'2019-04-22 19:36:15','2019-04-22 19:36:16','1245834775201904220995332009',4,'2019-04-21 23:29:21','2019-04-27 01:37:59'),
	(31,'POd4RC6a','127.0.0.1','118','kafka 实战','测试描述','测试备注',160,1,'2019-04-22 19:06:00',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-22 17:06:00','2019-04-27 01:37:59'),
	(32,'POd4RC6a','180.167.213.26','119','kafka 实战','测试描述','测试备注',160,1,'2019-04-22 21:31:53',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-22 19:31:57','2019-04-27 01:37:59'),
	(33,'POd4RC6a','180.167.213.26','120','kafka 实战','测试描述','测试备注',160,1,'2019-04-22 21:31:55',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-22 19:31:57','2019-04-27 01:37:59'),
	(37,'POd4RC6a','180.167.213.26','121','Oracle','测试描述','测试备注',44000,1,'2019-04-22 21:35:45',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-22 19:35:45','2019-04-27 01:37:59'),
	(38,'POd4RC6a','114.87.158.59','122','kafka 实战','测试描述','测试备注',160,2,'2019-04-22 22:51:39','2019-04-22 20:51:47','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',66,9999,'2019-04-22 20:51:45','2019-04-22 20:51:46','1209794355201904229853980782',4,'2019-04-22 20:51:39','2019-04-27 01:37:59'),
	(39,'POd4RC6a','127.0.0.1','124','kafka 实战','测试描述','测试备注',160,1,'2019-04-23 00:19:58',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-22 22:19:58','2019-04-27 01:37:59'),
	(40,'POd4RC6a','127.0.0.1','125','kafka 实战','测试描述','测试备注',160,1,'2019-04-23 00:21:26',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-22 22:21:26','2019-04-27 01:37:59'),
	(41,'POd4RC6a','127.0.0.1','126','kafka 实战','测试描述','测试备注',160,1,'2019-04-23 00:27:03',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-22 22:27:03','2019-04-27 01:37:59'),
	(42,'POd4RC6a','127.0.0.1','127','kafka 实战','测试描述','测试备注',10,1,'2019-04-23 00:28:21',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,4,'2019-04-22 22:28:21','2019-04-27 01:37:59'),
	(43,'POd4RC6a','127.0.0.1','128','kafka 实战','测试描述','测试备注',10,2,'2019-04-23 00:29:16','2019-05-09 20:36:53','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',93,9999,'2019-05-09 20:36:52','2019-05-09 20:36:53','1246649582201905091974572563',4,'2019-04-22 22:29:16','2019-05-09 20:36:52'),
	(44,'POd4RC6a','127.0.0.1','129','kafka 实战','测试描述','测试备注',10,2,'2019-04-23 00:37:18',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',106,9999,'2019-05-17 21:53:10','2019-05-17 21:53:13','1236273944201905178840991613',4,'2019-04-22 22:37:19','2019-05-17 21:53:13'),
	(45,'POd4RC6a','127.0.0.1','130','kafka 实战','测试描述','测试备注',10,2,'2019-04-23 00:37:23','2019-04-22 22:37:27','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',68,9999,'2019-04-22 22:37:25','2019-04-22 22:37:26','1257829370201904225516383887',4,'2019-04-22 22:37:23','2019-04-27 01:37:59'),
	(46,'POd4RC6a','124.77.208.137','131','kafka 实战','测试描述','测试备注',10,2,'2019-04-23 02:22:22','2019-04-23 00:22:28','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',69,9999,'2019-04-23 00:22:27','2019-04-23 00:22:27','1295079419201904238932409449',4,'2019-04-23 00:22:22','2019-04-27 01:37:59'),
	(47,'POd4RC6a','114.87.158.59','132','kafka 实战','测试描述','测试备注',10,2,'2019-04-23 12:03:50','2019-04-23 10:03:55','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',70,9999,'2019-04-23 10:03:53','2019-04-23 10:03:54','1244341374201904238178164740',4,'2019-04-23 10:03:50','2019-04-27 01:37:59'),
	(48,'POd4RC6a','127.0.0.1','133','Kafka 书籍汇总','测试描述','测试备注',10000,2,'2019-04-27 02:02:20',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',77,9999,'2019-04-27 00:39:25','2019-04-27 00:39:26','1298384458201904270239520896',4,'2019-04-27 00:02:20','2019-04-27 01:37:59'),
	(49,'POd4RC6a','127.0.0.1','134','Kafka 书籍汇总','测试描述','测试备注',10000,2,'2019-04-27 02:43:06',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',78,9999,'2019-04-27 00:43:09','2019-04-27 00:43:10','1230418317201904273841336004',4,'2019-04-27 00:43:06','2019-04-27 01:37:59'),
	(50,'POd4RC6a','127.0.0.1','135','Kafka 书籍汇总','测试描述','测试备注',10000,2,'2019-04-27 02:44:09','2019-04-27 00:44:12','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',79,9999,'2019-04-27 00:44:11','2019-04-27 00:44:12','1267784917201904270679599868',4,'2019-04-27 00:44:09','2019-04-27 01:37:59'),
	(51,'POd4RC6a','124.64.16.68','147','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:13:09',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(52,'POd4RC6a','124.64.16.68','149','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:13:15',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(53,'POd4RC6a','124.64.16.68','137','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:12:39',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(55,'POd4RC6a','124.64.16.68','140','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:12:43',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(57,'POd4RC6a','124.64.16.68','143','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:12:54',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(58,'POd4RC6a','124.64.16.68','148','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:13:10',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(59,'POd4RC6a','124.64.16.68','139','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:12:41',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(60,'POd4RC6a','124.64.16.68','138','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:12:40',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(62,'POd4RC6a','124.64.16.68','146','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:13:06',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(64,'POd4RC6a','124.64.16.68','150','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:13:17',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(66,'POd4RC6a','124.64.16.68','136','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:12:39',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:52'),
	(69,'POd4RC6a','124.64.16.68','144','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:12:56',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:53'),
	(74,'POd4RC6a','124.64.16.68','141','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:12:50',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:53'),
	(75,'POd4RC6a','124.64.16.68','145','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:12:56',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:53'),
	(87,'POd4RC6a','124.64.16.68','142','kafka 实战','测试描述','测试备注',10,1,'2019-04-29 16:12:53',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-04-29 14:13:52','2019-04-29 14:13:54'),
	(96,'POd4RC6a','175.170.177.201','154','Java','测试描述','测试备注',2100,1,'2019-05-07 16:16:30',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-07 14:16:57','2019-05-07 14:16:57'),
	(98,'POd4RC6a','175.170.177.201','153','Java','测试描述','测试备注',2100,1,'2019-05-07 16:16:30',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-07 14:16:57','2019-05-07 14:16:57'),
	(103,'POd4RC6a','175.170.177.201','152','Java','测试描述','测试备注',2100,1,'2019-05-07 16:16:29',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-07 14:16:57','2019-05-07 14:16:57'),
	(104,'POd4RC6a','175.170.177.201','151','Java','测试描述','测试备注',2100,1,'2019-05-07 16:16:26',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-07 14:16:57','2019-05-07 14:16:57'),
	(108,'POd4RC6a','127.0.0.1','159','kafka 实战第一版','测试描述','测试备注',8000000,2,'2019-05-09 03:10:41','2019-05-09 01:11:27','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',80,9999,'2019-05-09 01:10:45','2019-05-09 01:10:46','1233074780201905097390863780',0,'2019-05-09 01:10:41','2019-05-09 01:11:26'),
	(109,'POd4RC6a','127.0.0.1','160','kafka 实战第一版','测试描述','测试备注',8000000,2,'2019-05-09 03:15:01','2019-05-09 01:15:22','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',81,9999,'2019-05-09 01:15:04','2019-05-09 01:15:05','1250833692201905096709223973',0,'2019-05-09 01:15:01','2019-05-09 01:15:21'),
	(110,'POd4RC6a','124.77.208.137','162','我和僵尸有个约会','测试描述','测试备注',1000,1,'2019-05-09 03:46:57',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-09 01:47:05','2019-05-09 01:47:04'),
	(112,'POd4RC6a','124.77.208.137','161','我和僵尸有个约会','测试描述','测试备注',1000,1,'2019-05-09 03:46:55',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-09 01:47:05','2019-05-09 01:47:04'),
	(114,'POd4RC6a','124.77.208.137','163','我和僵尸有个约会','测试描述','测试备注',1000,1,'2019-05-09 03:47:03',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-09 01:47:05','2019-05-09 01:47:04'),
	(118,'POd4RC6a','124.77.208.137','164','kafka 实战第一版','测试描述','测试备注',8000000,1,'2019-05-09 03:47:25',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-09 01:47:25','2019-05-09 01:47:24'),
	(119,'POd4RC6a','180.167.213.26','165','kafka 实战第一版','测试描述','测试备注',8000000,1,'2019-05-09 18:52:09',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-09 16:52:10','2019-05-09 16:52:09'),
	(120,'POd4RC6a','180.167.213.26','172','kafka 实战第一版','测试描述','测试备注',8000000,1,'2019-05-09 22:36:06',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-09 20:36:08','2019-05-09 20:36:07'),
	(121,'POd4RC6a','180.167.213.26','173','kafka 实战第一版','测试描述','测试备注',8000000,2,'2019-05-09 22:36:10','2019-05-09 20:36:33','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',92,9999,'2019-05-09 20:36:15','2019-05-09 20:36:16','1282570853201905093087087066',0,'2019-05-09 20:36:10','2019-05-09 20:36:33'),
	(122,'POd4RC6a','124.77.208.137','174','MySQL','测试描述','测试备注',2000,2,'2019-05-10 03:16:45','2019-05-10 01:16:50','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',94,9999,'2019-05-10 01:16:49','2019-05-10 01:16:50','1291970499201905107161206456',0,'2019-05-10 01:16:45','2019-05-10 01:16:49'),
	(123,'POd4RC6a','36.157.157.77','176','Kafka 书籍汇总','测试描述','测试备注',10000,2,'2019-05-10 23:06:10','2019-05-10 21:06:16','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',95,9999,'2019-05-10 21:06:15','2019-05-10 21:06:16','1212622283201905104879541546',0,'2019-05-10 21:06:10','2019-05-10 21:06:15'),
	(124,'POd4RC6a','127.0.0.1','178','kafka 实战第一版','测试描述','测试备注',8000000,1,'2019-05-11 23:38:21',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-11 21:38:21','2019-05-11 21:38:21'),
	(125,'POd4RC6a','127.0.0.1','179','kafka 实战第一版','测试描述','测试备注',8000000,1,'2019-05-12 02:06:47',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-12 00:06:48','2019-05-12 00:06:47'),
	(126,'POd4RC6a','127.0.0.1','192','kafka 实战第一版','测试描述','测试备注',8000000,1,'2019-05-12 02:31:46',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-12 00:31:47','2019-05-12 00:31:46'),
	(127,'POd4RC6a','127.0.0.1','193','kafka 实战第一版','测试描述','测试备注',8000000,1,'2019-05-12 02:33:04',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-12 00:33:04','2019-05-12 00:33:04'),
	(128,'POd4RC6a','127.0.0.1','194','kafka 实战第一版','测试描述','测试备注',8000000,1,'2019-05-12 02:44:16',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-12 00:44:16','2019-05-12 00:44:15'),
	(129,'POd4RC6a','127.0.0.1','195','kafka 实战第一版','测试描述','测试备注',8000000,1,'2019-05-12 02:45:14',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-12 00:45:14','2019-05-12 00:45:13'),
	(130,'POd4RC6a','127.0.0.1','196','kafka 实战第一版','测试描述','测试备注',8000000,1,'2019-05-12 02:45:50',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-12 00:45:50','2019-05-12 00:45:50'),
	(131,'POd4RC6a','127.0.0.1','197','Kafka 书籍汇总','测试描述','测试备注',9000,1,'2019-05-12 20:38:32',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess',NULL,NULL,NULL,NULL,NULL,0,'2019-05-12 18:38:32','2019-05-12 18:38:32'),
	(135,'POd4RC6a','127.0.0.1','216','Oracle','测试描述','测试备注',5100,2,'2019-05-17 15:51:10','2019-05-17 14:21:43','cn.iocoder.mall.order.api.OrderService#updatePaySuccess',99,9999,'2019-05-17 14:07:59','2019-05-17 14:08:00','1237944221201905176411254284',0,'2019-05-17 13:51:10','2019-05-17 14:21:42'),
	(136,'POd4RC6a','127.0.0.1','217','测试商品','测试描述','测试备注',100,1,'2019-05-17 16:11:15',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess#1.0.0',NULL,NULL,NULL,NULL,NULL,0,'2019-05-17 14:11:15','2019-05-17 14:11:14'),
	(137,'POd4RC6a','127.0.0.1','218','测试商品','测试描述','测试备注',49,2,'2019-05-17 16:21:18','2019-05-17 14:21:36','cn.iocoder.mall.order.api.OrderService#updatePaySuccess#1.0.0',102,9999,'2019-05-17 14:21:23','2019-05-17 14:21:24','1251260284201905178089278479',0,'2019-05-17 14:21:18','2019-05-17 14:21:36'),
	(138,'POd4RC6a','127.0.0.1','219','测试商品','测试描述','测试备注',100,2,'2019-05-17 17:18:22','2019-05-17 15:18:31','cn.iocoder.mall.order.api.OrderService#updatePaySuccess#1.0.0',103,9999,'2019-05-17 15:18:25','2019-05-17 15:18:31','1238077140201905174038243362',0,'2019-05-17 15:18:22','2019-05-17 15:18:31'),
	(139,'POd4RC6a','127.0.0.1','220','Kafka 书籍汇总','测试描述','测试备注',9000,2,'2019-05-17 19:46:31',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess#1.0.0',104,9999,'2019-05-17 17:46:35','2019-05-17 17:46:36','1260724063201905176222820798',0,'2019-05-17 17:46:31','2019-05-17 17:46:35'),
	(140,'POd4RC6a','127.0.0.1','221','kafka 实战第一版','测试描述','测试备注',16000091,2,'2019-05-17 19:58:51',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess#1.0.0',105,9999,'2019-05-17 17:58:56','2019-05-17 17:58:57','1202342004201905174959338102',0,'2019-05-17 17:58:51','2019-05-17 17:58:56'),
	(141,'POd4RC6a','124.77.208.137','223','Java','测试描述','测试备注',5100,1,'2019-05-18 22:26:59',NULL,'cn.iocoder.mall.order.api.OrderService#updatePaySuccess#1.0.0',NULL,NULL,NULL,NULL,NULL,0,'2019-05-18 20:27:00','2019-05-18 20:27:00');

/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table transaction_extension
# ------------------------------------------------------------

DROP TABLE IF EXISTS `transaction_extension`;

CREATE TABLE `transaction_extension` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号，自增',
  `transaction_id` int(11) NOT NULL COMMENT '交易编号}',
  `pay_channel` int(11) NOT NULL COMMENT '选择的支付渠道',
  `transaction_code` varchar(50) NOT NULL COMMENT '生成传输给第三方的订单号',
  `extension_data` varchar(1024) DEFAULT NULL COMMENT '扩展内容',
  `create_ip` varchar(50) NOT NULL COMMENT '发起交易的 IP',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_transaction_code` (`transaction_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='transaction_extension';

LOCK TABLES `transaction_extension` WRITE;
/*!40000 ALTER TABLE `transaction_extension` DISABLE KEYS */;

INSERT INTO `transaction_extension` (`id`, `transaction_id`, `pay_channel`, `transaction_code`, `extension_data`, `create_ip`, `status`, `create_time`, `update_time`)
VALUES
	(1,1,9999,'20190313143449394595',NULL,'127.0.0.1',1,'2019-03-13 14:34:49','2019-03-13 14:34:49'),
	(2,1,9999,'20190313143626850384',NULL,'127.0.0.1',1,'2019-03-13 14:36:26','2019-03-13 14:36:26'),
	(3,1,9999,'20190313143709988585',NULL,'127.0.0.1',1,'2019-03-13 14:37:09','2019-03-13 14:37:09'),
	(4,1,9999,'20190313170637270597',NULL,'127.0.0.1',1,'2019-03-13 17:06:37','2019-03-13 17:06:37'),
	(5,1,9999,'20190313171109616337',NULL,'127.0.0.1',1,'2019-03-13 17:11:09','2019-03-13 17:11:09'),
	(6,1,9999,'20190313171241800588',NULL,'127.0.0.1',1,'2019-03-13 17:12:41','2019-03-13 17:12:41'),
	(7,1,9999,'20190313171503236852',NULL,'127.0.0.1',1,'2019-03-13 17:15:03','2019-03-13 17:15:03'),
	(8,1,9999,'20190313171700279790',NULL,'127.0.0.1',1,'2019-03-13 17:17:00','2019-03-13 17:17:00'),
	(9,1,9999,'20190313171824113222',NULL,'127.0.0.1',1,'2019-03-13 17:18:24','2019-03-13 17:18:24'),
	(10,1,9999,'20190313171953205276',NULL,'127.0.0.1',1,'2019-03-13 17:19:53','2019-03-13 17:19:53'),
	(11,1,9999,'20190313172111877048',NULL,'127.0.0.1',1,'2019-03-13 17:21:11','2019-03-13 17:21:11'),
	(12,1,9999,'20190313172339490890','{\"id\":\"evt_400190313172341499184603\",\"created\":1552469021,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_OunLWDSKS8KO5ezfb1i9uLSC\",\"object\":\"charge\",\"created\":1552469020,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190313172339490890\",\"client_ip\":\"127.0.0.1\",\"amount\":10,\"amount_settle\":10,\"currency\":\"cny\",\"subject\":\"商品名\",\"body\":\"商品描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1552469021,\"time_expire\":1552476220,\"time_settle\":null,\"transaction_no\":\"1259319182201903139181631168\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_OunLWDSKS8KO5ezfb1i9uLSC/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"商品备注\"}},\"object\":\"event\",\"request\":\"iar_4WLiHCajnjbTrXbb1OXnjnPG\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-03-13 17:23:39','2019-03-13 17:23:41'),
	(13,1,9999,'20190313172431242571',NULL,'127.0.0.1',1,'2019-03-13 17:24:31','2019-03-13 17:24:31'),
	(14,1,9999,'20190313172707704111',NULL,'127.0.0.1',1,'2019-03-13 17:27:07','2019-03-13 17:27:07'),
	(15,1,9999,'20190313173019968025','{\"id\":\"evt_400190313173021499408903\",\"created\":1552469421,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_GmT4W94uvPOO4q9ibDa1Sm5O\",\"object\":\"charge\",\"created\":1552469419,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190313173019968025\",\"client_ip\":\"127.0.0.1\",\"amount\":10,\"amount_settle\":10,\"currency\":\"cny\",\"subject\":\"商品名\",\"body\":\"商品描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1552469421,\"time_expire\":1552476619,\"time_settle\":null,\"transaction_no\":\"1285076745201903130468978518\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_GmT4W94uvPOO4q9ibDa1Sm5O/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"商品备注\"}},\"object\":\"event\",\"request\":\"iar_vfHyL0r58yvPrH0e9C084GGO\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-03-13 17:30:19','2019-03-13 17:30:21'),
	(16,2,9999,'20190314160852733791',NULL,'127.0.0.1',1,'2019-03-14 16:08:52','2019-03-14 16:08:52'),
	(17,2,9999,'20190314161024311302',NULL,'127.0.0.1',1,'2019-03-14 16:10:24','2019-03-14 16:10:24'),
	(18,2,9999,'20190314161232723387',NULL,'127.0.0.1',1,'2019-03-14 16:12:32','2019-03-14 16:12:32'),
	(19,2,9999,'20190314161232883479',NULL,'127.0.0.1',1,'2019-03-14 16:12:32','2019-03-14 16:12:32'),
	(20,2,9999,'20190314161232705499',NULL,'127.0.0.1',1,'2019-03-14 16:12:32','2019-03-14 16:12:32'),
	(21,2,9999,'20190314161232832483',NULL,'127.0.0.1',1,'2019-03-14 16:12:32','2019-03-14 16:12:32'),
	(22,2,9999,'20190314161353474808','{\"id\":\"evt_400190314161358532476503\",\"created\":1552551238,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_GK8Cm5vj1m1OK0evD4DKWbzL\",\"object\":\"charge\",\"created\":1552551233,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190314161353474808\",\"client_ip\":\"127.0.0.1\",\"amount\":10,\"amount_settle\":10,\"currency\":\"cny\",\"subject\":\"商品名\",\"body\":\"商品描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1552551238,\"time_expire\":1552558433,\"time_settle\":null,\"transaction_no\":\"1282396661201903145620538794\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_GK8Cm5vj1m1OK0evD4DKWbzL/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"商品备注\"}},\"object\":\"event\",\"request\":\"iar_jvbj5KSS4Sy1KmzHGGOaPe5S\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-03-14 16:13:53','2019-03-14 16:13:58'),
	(23,3,9999,'20190421014711249244',NULL,'127.0.0.1',1,'2019-04-21 01:47:11','2019-04-21 01:47:11'),
	(24,3,9999,'20190421014735167627',NULL,'127.0.0.1',1,'2019-04-21 01:47:35','2019-04-21 01:47:35'),
	(25,3,9999,'20190421014758838219',NULL,'127.0.0.1',1,'2019-04-21 01:47:58','2019-04-21 01:47:58'),
	(26,3,9999,'20190421014819399499',NULL,'127.0.0.1',1,'2019-04-21 01:48:19','2019-04-21 01:48:19'),
	(27,3,9999,'20190421015427658470',NULL,'127.0.0.1',1,'2019-04-21 01:54:27','2019-04-21 01:54:27'),
	(28,3,9999,'20190421015436543822',NULL,'127.0.0.1',1,'2019-04-21 01:54:37','2019-04-21 01:54:37'),
	(29,3,9999,'20190421015615102559',NULL,'127.0.0.1',1,'2019-04-21 01:56:15','2019-04-21 01:56:15'),
	(30,3,9999,'20190421015623565992',NULL,'127.0.0.1',1,'2019-04-21 01:56:23','2019-04-21 01:56:23'),
	(31,3,9999,'20190421015811819687',NULL,'127.0.0.1',1,'2019-04-21 01:58:11','2019-04-21 01:58:11'),
	(32,3,9999,'20190421015910105184',NULL,'127.0.0.1',1,'2019-04-21 01:59:10','2019-04-21 01:59:10'),
	(33,3,9999,'20190421015930928739',NULL,'127.0.0.1',1,'2019-04-21 01:59:30','2019-04-21 01:59:30'),
	(34,3,9999,'20190421020334246354',NULL,'127.0.0.1',1,'2019-04-21 02:03:34','2019-04-21 02:03:34'),
	(35,3,9999,'20190421021251245269',NULL,'127.0.0.1',1,'2019-04-21 02:12:51','2019-04-21 02:12:51'),
	(36,10,9999,'20190421021728641632',NULL,'127.0.0.1',1,'2019-04-21 02:17:28','2019-04-21 02:17:28'),
	(37,11,9999,'20190421142300962227','{\"id\":\"evt_400190421142304143197602\",\"created\":1555827784,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_4qTib5zrHePSWzPyv5mjTunT\",\"object\":\"charge\",\"created\":1555827780,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190421142300962227\",\"client_ip\":\"127.0.0.1\",\"amount\":160,\"amount_settle\":160,\"currency\":\"cny\",\"subject\":\"kafka 实战\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555827784,\"time_expire\":1555834980,\"time_settle\":null,\"transaction_no\":\"1214878818201904214744765608\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_4qTib5zrHePSWzPyv5mjTunT/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_XX184OWrHuvLm1uT84KSm1a5\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-21 14:23:00','2019-04-21 14:23:11'),
	(38,12,9999,'20190421150154263163','{\"id\":\"evt_400190421150156144555702\",\"created\":1555830116,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_0y9i9SGaHyX9u14mT0m9qb58\",\"object\":\"charge\",\"created\":1555830114,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190421150154263163\",\"client_ip\":\"127.0.0.1\",\"amount\":160,\"amount_settle\":160,\"currency\":\"cny\",\"subject\":\"kafka 实战\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555830116,\"time_expire\":1555837314,\"time_settle\":null,\"transaction_no\":\"1242451315201904216613366351\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_0y9i9SGaHyX9u14mT0m9qb58/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_m5ifTOGCWjzTP8mbn5WvfzfD\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-21 15:01:54','2019-04-21 15:01:57'),
	(39,13,9999,'20190421150525625103','{\"id\":\"evt_400190421150527957166903\",\"created\":1555830327,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_ePGqLSWLCqjHS8GKuPan1Gi9\",\"object\":\"charge\",\"created\":1555830326,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190421150525625103\",\"client_ip\":\"127.0.0.1\",\"amount\":160,\"amount_settle\":160,\"currency\":\"cny\",\"subject\":\"kafka 实战\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555830327,\"time_expire\":1555837526,\"time_settle\":null,\"transaction_no\":\"1232163188201904219935216641\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_ePGqLSWLCqjHS8GKuPan1Gi9/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_TOmXv11yznr9X1q9SSvbvrH4\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-21 15:05:25','2019-04-21 15:05:28'),
	(40,18,9999,'20190421151112297666','{\"id\":\"evt_400190421151113957401603\",\"created\":1555830673,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_KCWL84nffXX5yjTK48eXD8a1\",\"object\":\"charge\",\"created\":1555830672,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190421151112297666\",\"client_ip\":\"127.0.0.1\",\"amount\":100,\"amount_settle\":100,\"currency\":\"cny\",\"subject\":\"测试商品\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555830673,\"time_expire\":1555837872,\"time_settle\":null,\"transaction_no\":\"1262352890201904219469841110\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_KCWL84nffXX5yjTK48eXD8a1/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_COirb1GefXvTD40aH0ufDGi9\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-21 15:11:12','2019-04-21 15:11:14'),
	(41,19,9999,'20190421151421784758','{\"id\":\"evt_400190421151423144979702\",\"created\":1555830862,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_Tqj9uT1mHm144CyvH8rP4y90\",\"object\":\"charge\",\"created\":1555830861,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190421151421784758\",\"client_ip\":\"127.0.0.1\",\"amount\":100,\"amount_settle\":100,\"currency\":\"cny\",\"subject\":\"测试商品\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555830862,\"time_expire\":1555838061,\"time_settle\":null,\"transaction_no\":\"1248585474201904212137778537\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_Tqj9uT1mHm144CyvH8rP4y90/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_DOefD0inTiz5bbnvv11i1O04\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-21 15:14:21','2019-04-21 15:14:23'),
	(42,20,9999,'20190421151923205372','{\"id\":\"evt_400190421151924957716203\",\"created\":1555831164,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_HOuvfD4SCCCCzfHOuHzPqbrP\",\"object\":\"charge\",\"created\":1555831163,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190421151923205372\",\"client_ip\":\"127.0.0.1\",\"amount\":100,\"amount_settle\":100,\"currency\":\"cny\",\"subject\":\"测试商品\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555831164,\"time_expire\":1555838363,\"time_settle\":null,\"transaction_no\":\"1214125122201904212507946245\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_HOuvfD4SCCCCzfHOuHzPqbrP/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_mr1G4Gy1ubbDDGWPGOibXTO8\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-21 15:19:23','2019-04-21 15:19:25'),
	(43,21,9999,'20190421185933879667',NULL,'124.77.208.137',1,'2019-04-21 18:59:33','2019-04-21 18:59:33'),
	(44,21,9999,'20190421190040275638',NULL,'124.77.208.137',1,'2019-04-21 19:00:40','2019-04-21 19:00:40'),
	(45,21,9999,'20190421190049129322',NULL,'124.77.208.137',1,'2019-04-21 19:00:49','2019-04-21 19:00:49'),
	(46,21,9999,'20190421190148386359',NULL,'124.77.208.137',1,'2019-04-21 19:01:48','2019-04-21 19:01:48'),
	(47,21,9999,'20190421190156394078',NULL,'124.77.208.137',1,'2019-04-21 19:01:56','2019-04-21 19:01:56'),
	(48,21,9999,'20190421190202674025',NULL,'124.77.208.137',1,'2019-04-21 19:02:02','2019-04-21 19:02:02'),
	(49,21,9999,'20190421190325916992',NULL,'124.77.208.137',1,'2019-04-21 19:03:25','2019-04-21 19:03:25'),
	(50,22,9999,'20190421190820811877',NULL,'124.77.208.137',1,'2019-04-21 19:08:20','2019-04-21 19:08:20'),
	(51,23,9999,'20190421192223484940',NULL,'124.77.208.137',1,'2019-04-21 19:22:23','2019-04-21 19:22:23'),
	(52,24,9999,'20190421195724705545',NULL,'124.77.208.137',1,'2019-04-21 19:57:24','2019-04-21 19:57:24'),
	(53,24,9999,'20190421200329944775',NULL,'124.77.208.137',1,'2019-04-21 20:03:29','2019-04-21 20:03:29'),
	(54,25,9999,'20190421201713787629','{\"id\":\"evt_400190421201715971291603\",\"created\":1555849035,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_90Smv5KaXXHGyDynDOzDe9eD\",\"object\":\"charge\",\"created\":1555849034,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190421201713787629\",\"client_ip\":\"127.0.0.1\",\"amount\":100,\"amount_settle\":100,\"currency\":\"cny\",\"subject\":\"测试商品\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555849035,\"time_expire\":1555856234,\"time_settle\":null,\"transaction_no\":\"1263683564201904219993710538\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_90Smv5KaXXHGyDynDOzDe9eD/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_LCS8uDPajzP8v94yfDKurfvP\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-21 20:17:13','2019-04-21 20:17:19'),
	(55,24,9999,'20190421201835497879',NULL,'124.77.208.137',1,'2019-04-21 20:18:35','2019-04-21 20:18:35'),
	(56,24,9999,'20190421202220830224',NULL,'124.77.208.137',1,'2019-04-21 20:22:20','2019-04-21 20:22:20'),
	(57,26,9999,'20190421202410194081',NULL,'124.77.208.137',1,'2019-04-21 20:24:10','2019-04-21 20:24:10'),
	(58,27,9999,'20190421203748920380',NULL,'124.77.208.137',1,'2019-04-21 20:37:48','2019-04-21 20:37:48'),
	(59,28,9999,'20190421205144641928',NULL,'124.77.208.137',1,'2019-04-21 20:51:44','2019-04-21 20:51:44'),
	(60,29,9999,'20190421223828915607','{\"id\":\"evt_400190421223832162174102\",\"created\":1555857512,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_1innTSWL88C4Lybvj5qDWn5G\",\"object\":\"charge\",\"created\":1555857510,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190421223828915607\",\"client_ip\":\"124.77.208.137\",\"amount\":1000,\"amount_settle\":1000,\"currency\":\"cny\",\"subject\":\"农夫山泉\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555857512,\"time_expire\":1555864710,\"time_settle\":null,\"transaction_no\":\"1290815313201904211598433725\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_1innTSWL88C4Lybvj5qDWn5G/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_Cy5eXDK8SqDOn9Siv1n5Cm5K\",\"pending_webhooks\":0}','124.77.208.137',2,'2019-04-21 22:38:28','2019-04-21 22:38:32'),
	(61,27,9999,'20190422193220947110',NULL,'180.167.213.26',1,'2019-04-22 19:32:20','2019-04-22 19:32:20'),
	(62,27,9999,'20190422193220963179',NULL,'180.167.213.26',1,'2019-04-22 19:32:20','2019-04-22 19:32:20'),
	(63,27,9999,'20190422193228831286','{\"id\":\"evt_400190422193230188658202\",\"created\":1555932750,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_88KOiLK0SCKC9yjDyHbXTGi9\",\"object\":\"charge\",\"created\":1555932748,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190422193228831286\",\"client_ip\":\"180.167.213.26\",\"amount\":1000,\"amount_settle\":1000,\"currency\":\"cny\",\"subject\":\"农夫山泉\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555932750,\"time_expire\":1555939948,\"time_settle\":null,\"transaction_no\":\"1244224811201904228521103170\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_88KOiLK0SCKC9yjDyHbXTGi9/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_OivrT0mDC0S0ebH084WfDurH\",\"pending_webhooks\":0}','180.167.213.26',2,'2019-04-22 19:32:28','2019-04-22 19:32:30'),
	(64,28,9999,'20190422193555407790','{\"id\":\"evt_400190422193557007553903\",\"created\":1555932957,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_bnHaj9OCCmHO0COi10PC84yH\",\"object\":\"charge\",\"created\":1555932956,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190422193555407790\",\"client_ip\":\"180.167.213.26\",\"amount\":1000,\"amount_settle\":1000,\"currency\":\"cny\",\"subject\":\"农夫山泉\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555932957,\"time_expire\":1555940156,\"time_settle\":null,\"transaction_no\":\"1213285149201904222299145413\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_bnHaj9OCCmHO0COi10PC84yH/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_DmDWfDTKm5G48S4e1CzrLCqL\",\"pending_webhooks\":0}','180.167.213.26',2,'2019-04-22 19:35:55','2019-04-22 19:35:57'),
	(65,30,9999,'20190422193613519208','{\"id\":\"evt_400190422193615007567003\",\"created\":1555932975,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_Wr5ibDPO8CSCyv58OKzvz5SS\",\"object\":\"charge\",\"created\":1555932973,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190422193613519208\",\"client_ip\":\"180.167.213.26\",\"amount\":160,\"amount_settle\":160,\"currency\":\"cny\",\"subject\":\"kafka 实战\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555932975,\"time_expire\":1555940173,\"time_settle\":null,\"transaction_no\":\"1245834775201904220995332009\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_Wr5ibDPO8CSCyv58OKzvz5SS/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_f5efrHa948CSrXnfHSSe5aDC\",\"pending_webhooks\":0}','180.167.213.26',2,'2019-04-22 19:36:13','2019-04-22 19:36:15'),
	(66,38,9999,'20190422205144153198','{\"id\":\"evt_400190422205145191862702\",\"created\":1555937505,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_94GyH4ePiTKOurLmzPjvHyfD\",\"object\":\"charge\",\"created\":1555937504,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190422205144153198\",\"client_ip\":\"114.87.158.59\",\"amount\":160,\"amount_settle\":160,\"currency\":\"cny\",\"subject\":\"kafka 实战\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555937505,\"time_expire\":1555944704,\"time_settle\":null,\"transaction_no\":\"1209794355201904229853980782\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_94GyH4ePiTKOurLmzPjvHyfD/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_ujPebL4uXzfDDKyvP8OinDaD\",\"pending_webhooks\":0}','114.87.158.59',2,'2019-04-22 20:51:44','2019-04-22 20:51:46'),
	(67,43,9999,'20190422222919577859',NULL,'127.0.0.1',1,'2019-04-22 22:29:19','2019-04-22 22:29:19'),
	(68,45,9999,'20190422223724521213','{\"id\":\"evt_400190422223726196045502\",\"created\":1555943845,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_vfXjrLzfvzv1D8aD0GvHW5mH\",\"object\":\"charge\",\"created\":1555943844,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190422223724521213\",\"client_ip\":\"127.0.0.1\",\"amount\":10,\"amount_settle\":10,\"currency\":\"cny\",\"subject\":\"kafka 实战\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555943845,\"time_expire\":1555951044,\"time_settle\":null,\"transaction_no\":\"1257829370201904225516383887\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_vfXjrLzfvzv1D8aD0GvHW5mH/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_1CCSmHmjnT4San5yD44SmDiH\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-22 22:37:24','2019-04-22 22:37:26'),
	(69,46,9999,'20190423002223556779','{\"id\":\"evt_400190423002227198896602\",\"created\":1555950147,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_ifn1y5bDqjL0rbTe54eLazPC\",\"object\":\"charge\",\"created\":1555950144,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190423002223556779\",\"client_ip\":\"124.77.208.137\",\"amount\":10,\"amount_settle\":10,\"currency\":\"cny\",\"subject\":\"kafka 实战\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555950147,\"time_expire\":1555957344,\"time_settle\":null,\"transaction_no\":\"1295079419201904238932409449\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_ifn1y5bDqjL0rbTe54eLazPC/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_LKKun1S4KGS4L4Cmv980iznL\",\"pending_webhooks\":0}','124.77.208.137',2,'2019-04-23 00:22:23','2019-04-23 00:22:27'),
	(70,47,9999,'20190423100352158401','{\"id\":\"evt_400190423100354205607502\",\"created\":1555985033,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_DCGyXTmDGuHKb1C0yTzjPOGC\",\"object\":\"charge\",\"created\":1555985032,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190423100352158401\",\"client_ip\":\"114.87.158.59\",\"amount\":10,\"amount_settle\":10,\"currency\":\"cny\",\"subject\":\"kafka 实战\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1555985033,\"time_expire\":1555992232,\"time_settle\":null,\"transaction_no\":\"1244341374201904238178164740\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_DCGyXTmDGuHKb1C0yTzjPOGC/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_4e9mPODW5ujPqLen5OOmvL8S\",\"pending_webhooks\":0}','114.87.158.59',2,'2019-04-23 10:03:52','2019-04-23 10:03:54'),
	(71,48,9999,'20190427000222965600',NULL,'127.0.0.1',1,'2019-04-27 00:02:22','2019-04-27 00:02:22'),
	(72,48,9999,'20190427001401428599',NULL,'127.0.0.1',1,'2019-04-27 00:14:01','2019-04-27 00:14:01'),
	(73,48,9999,'20190427002729520230',NULL,'127.0.0.1',1,'2019-04-27 00:27:29','2019-04-27 00:27:29'),
	(74,48,9999,'20190427003029372252',NULL,'127.0.0.1',1,'2019-04-27 00:30:29','2019-04-27 00:30:29'),
	(75,48,9999,'20190427003306933611',NULL,'127.0.0.1',1,'2019-04-27 00:33:06','2019-04-27 00:33:06'),
	(76,48,9999,'20190427003703859860',NULL,'127.0.0.1',1,'2019-04-27 00:37:03','2019-04-27 00:37:03'),
	(77,48,9999,'20190427003923419775','{\"id\":\"evt_400190427003925180938603\",\"created\":1556296765,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_CGiLSC1OSubPOGSS0Ofv9urT\",\"object\":\"charge\",\"created\":1556296763,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190427003923419775\",\"client_ip\":\"127.0.0.1\",\"amount\":10000,\"amount_settle\":10000,\"currency\":\"cny\",\"subject\":\"Kafka 书籍汇总\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1556296765,\"time_expire\":1556303963,\"time_settle\":null,\"transaction_no\":\"1298384458201904270239520896\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_CGiLSC1OSubPOGSS0Ofv9urT/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_Lu14aDujv5i9OKyTa9jDGKm9\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-27 00:39:23','2019-04-27 00:39:25'),
	(78,49,9999,'20190427004307995529','{\"id\":\"evt_400190427004309341045702\",\"created\":1556296989,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_ebH8u5a9mzL80qDqzP8qPybP\",\"object\":\"charge\",\"created\":1556296988,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190427004307995529\",\"client_ip\":\"127.0.0.1\",\"amount\":10000,\"amount_settle\":10000,\"currency\":\"cny\",\"subject\":\"Kafka 书籍汇总\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1556296989,\"time_expire\":1556304188,\"time_settle\":null,\"transaction_no\":\"1230418317201904273841336004\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_ebH8u5a9mzL80qDqzP8qPybP/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_GebHeP1effjL0OSOqDzLurHG\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-27 00:43:07','2019-04-27 00:43:10'),
	(79,50,9999,'20190427004410165545','{\"id\":\"evt_400190427004411341065302\",\"created\":1556297051,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_y1iXjLnDS4G4OO4uT4a5C4W1\",\"object\":\"charge\",\"created\":1556297050,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190427004410165545\",\"client_ip\":\"127.0.0.1\",\"amount\":10000,\"amount_settle\":10000,\"currency\":\"cny\",\"subject\":\"Kafka 书籍汇总\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1556297051,\"time_expire\":1556304250,\"time_settle\":null,\"transaction_no\":\"1267784917201904270679599868\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_y1iXjLnDS4G4OO4uT4a5C4W1/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_0GW50C9mfnjLLuX5WDWXHGmD\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-04-27 00:44:10','2019-04-27 00:44:12'),
	(80,108,9999,'20190509011042450885','{\"id\":\"evt_400190509011045619413203\",\"created\":1557335445,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_XXzbn1Dy9aDC5KmDKCan948S\",\"object\":\"charge\",\"created\":1557335443,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190509011042450885\",\"client_ip\":\"127.0.0.1\",\"amount\":8000000,\"amount_settle\":8000000,\"currency\":\"cny\",\"subject\":\"kafka 实战第一版\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1557335445,\"time_expire\":1557342643,\"time_settle\":null,\"transaction_no\":\"1233074780201905097390863780\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_XXzbn1Dy9aDC5KmDKCan948S/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_m1C4y544uXP4Ki9ynPzLuDmT\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-05-09 01:10:42','2019-05-09 01:10:45'),
	(81,109,9999,'20190509011502710906','{\"id\":\"evt_400190509011504729638202\",\"created\":1557335704,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_r980OOKKqjj9ebz984i1SSKO\",\"object\":\"charge\",\"created\":1557335703,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190509011502710906\",\"client_ip\":\"127.0.0.1\",\"amount\":8000000,\"amount_settle\":8000000,\"currency\":\"cny\",\"subject\":\"kafka 实战第一版\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1557335704,\"time_expire\":1557342903,\"time_settle\":null,\"transaction_no\":\"1250833692201905096709223973\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_r980OOKKqjj9ebz984i1SSKO/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_KOK4q5Hq58uDz9SqvHnjnHK8\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-05-09 01:15:02','2019-05-09 01:15:04'),
	(82,118,9999,'20190509014731728684',NULL,'124.77.208.137',1,'2019-05-09 01:47:31','2019-05-09 01:47:31'),
	(83,118,9999,'20190509014734127033',NULL,'124.77.208.137',1,'2019-05-09 01:47:34','2019-05-09 01:47:34'),
	(84,118,9999,'20190509014743271427',NULL,'124.77.208.137',1,'2019-05-09 01:47:43','2019-05-09 01:47:43'),
	(85,118,9999,'20190509014808891687',NULL,'124.77.208.137',1,'2019-05-09 01:48:08','2019-05-09 01:48:08'),
	(86,118,9999,'20190509014918834609',NULL,'124.77.208.137',1,'2019-05-09 01:49:18','2019-05-09 01:49:18'),
	(87,118,9999,'20190509015941283303',NULL,'124.77.208.137',1,'2019-05-09 01:59:41','2019-05-09 01:59:41'),
	(88,118,9999,'20190509020004222701',NULL,'124.77.208.137',1,'2019-05-09 02:00:04','2019-05-09 02:00:04'),
	(89,118,9999,'20190509021519467773',NULL,'124.77.208.137',1,'2019-05-09 02:15:19','2019-05-09 02:15:19'),
	(90,118,9999,'20190509021530357934',NULL,'124.77.208.137',1,'2019-05-09 02:15:30','2019-05-09 02:15:30'),
	(91,118,9999,'20190509021836294470',NULL,'124.77.208.137',1,'2019-05-09 02:18:36','2019-05-09 02:18:36'),
	(92,121,9999,'20190509203612807739','{\"id\":\"evt_400190509203615751975302\",\"created\":1557405375,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_zn1GOCP4O0SKqnrjDSXnDCKK\",\"object\":\"charge\",\"created\":1557405373,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190509203612807739\",\"client_ip\":\"180.167.213.26\",\"amount\":8000000,\"amount_settle\":8000000,\"currency\":\"cny\",\"subject\":\"kafka 实战第一版\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1557405375,\"time_expire\":1557412573,\"time_settle\":null,\"transaction_no\":\"1282570853201905093087087066\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_zn1GOCP4O0SKqnrjDSXnDCKK/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_S4KOW1rPSWvP9ub9e1yr1yvP\",\"pending_webhooks\":0}','180.167.213.26',2,'2019-05-09 20:36:12','2019-05-09 20:36:16'),
	(93,43,9999,'20190509203651468523','{\"id\":\"evt_400190509203652644368603\",\"created\":1557405412,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_jbTi1GWnXDm5q5O8K8aD0Ga1\",\"object\":\"charge\",\"created\":1557405411,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190509203651468523\",\"client_ip\":\"180.167.213.26\",\"amount\":10,\"amount_settle\":10,\"currency\":\"cny\",\"subject\":\"kafka 实战\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1557405412,\"time_expire\":1557412611,\"time_settle\":null,\"transaction_no\":\"1246649582201905091974572563\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_jbTi1GWnXDm5q5O8K8aD0Ga1/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_4GmDK0y5qrz5XXDGqTvPaD88\",\"pending_webhooks\":0}','180.167.213.26',2,'2019-05-09 20:36:51','2019-05-09 20:36:52'),
	(94,122,9999,'20190510011647326787','{\"id\":\"evt_400190510011649652251803\",\"created\":1557422209,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_0uLqfPbjfrr1D0aHKGWnj1iH\",\"object\":\"charge\",\"created\":1557422208,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190510011647326787\",\"client_ip\":\"124.77.208.137\",\"amount\":2000,\"amount_settle\":2000,\"currency\":\"cny\",\"subject\":\"MySQL\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1557422209,\"time_expire\":1557429408,\"time_settle\":null,\"transaction_no\":\"1291970499201905107161206456\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_0uLqfPbjfrr1D0aHKGWnj1iH/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_4mPurPL8iL08GWPGG8ab9GeP\",\"pending_webhooks\":0}','124.77.208.137',2,'2019-05-10 01:16:47','2019-05-10 01:16:49'),
	(95,123,9999,'20190510210612719222','{\"id\":\"evt_400190510210615783991802\",\"created\":1557493575,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_mXf1O4SyvXT0GibXzHbPCqP0\",\"object\":\"charge\",\"created\":1557493572,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190510210612719222\",\"client_ip\":\"36.157.157.77\",\"amount\":10000,\"amount_settle\":10000,\"currency\":\"cny\",\"subject\":\"Kafka 书籍汇总\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1557493575,\"time_expire\":1557500772,\"time_settle\":null,\"transaction_no\":\"1212622283201905104879541546\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_mXf1O4SyvXT0GibXzHbPCqP0/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_bPunrDunXLeDHKqvj1X10eXD\",\"pending_webhooks\":0}','36.157.157.77',2,'2019-05-10 21:06:12','2019-05-10 21:06:15'),
	(96,135,9999,'20190517135117663197',NULL,'127.0.0.1',1,'2019-05-17 13:51:17','2019-05-17 13:51:17'),
	(97,135,9999,'20190517140503866719',NULL,'127.0.0.1',1,'2019-05-17 14:05:03','2019-05-17 14:05:03'),
	(98,135,9999,'20190517140536745409',NULL,'127.0.0.1',1,'2019-05-17 14:05:36','2019-05-17 14:05:36'),
	(99,135,9999,'20190517140757513074','{\"id\":\"evt_400190517140759977398602\",\"created\":1558073279,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_uHWPO04yDOaPC0KO8SfzTezT\",\"object\":\"charge\",\"created\":1558073277,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190517140757513074\",\"client_ip\":\"127.0.0.1\",\"amount\":5100,\"amount_settle\":5100,\"currency\":\"cny\",\"subject\":\"Oracle\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1558073279,\"time_expire\":1558080477,\"time_settle\":null,\"transaction_no\":\"1237944221201905176411254284\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_uHWPO04yDOaPC0KO8SfzTezT/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_ezH8KKyLqbvHyLCOe99afHyH\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-05-17 14:07:57','2019-05-17 14:07:59'),
	(100,136,9999,'20190517141116112692',NULL,'127.0.0.1',1,'2019-05-17 14:11:16','2019-05-17 14:11:16'),
	(101,136,9999,'20190517141134246238',NULL,'127.0.0.1',1,'2019-05-17 14:11:34','2019-05-17 14:11:34'),
	(102,137,9999,'20190517142120192407','{\"id\":\"evt_400190517142123977787502\",\"created\":1558074083,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_TqnnL0bDGavDqTuLm104GGe1\",\"object\":\"charge\",\"created\":1558074081,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190517142120192407\",\"client_ip\":\"127.0.0.1\",\"amount\":49,\"amount_settle\":49,\"currency\":\"cny\",\"subject\":\"测试商品\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1558074083,\"time_expire\":1558081281,\"time_settle\":null,\"transaction_no\":\"1251260284201905178089278479\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_TqnnL0bDGavDqTuLm104GGe1/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_K88mTK9effbPWLKqb904yvb1\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-05-17 14:21:20','2019-05-17 14:21:24'),
	(103,138,9999,'20190517151823411548','{\"id\":\"evt_400190517151825979403302\",\"created\":1558077505,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_Ku1CW58OazTSiDSubPCiTavH\",\"object\":\"charge\",\"created\":1558077504,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190517151823411548\",\"client_ip\":\"127.0.0.1\",\"amount\":100,\"amount_settle\":100,\"currency\":\"cny\",\"subject\":\"测试商品\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1558077505,\"time_expire\":1558084704,\"time_settle\":null,\"transaction_no\":\"1238077140201905174038243362\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_Ku1CW58OazTSiDSubPCiTavH/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_8Si1SSir5e541Sy5aPOejDeL\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-05-17 15:18:23','2019-05-17 15:18:31'),
	(104,139,9999,'20190517174632416407','{\"id\":\"evt_400190517174635904140803\",\"created\":1558086395,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_yzbDWLeXTWH01yvv5Su9GGa9\",\"object\":\"charge\",\"created\":1558086393,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190517174632416407\",\"client_ip\":\"127.0.0.1\",\"amount\":9000,\"amount_settle\":9000,\"currency\":\"cny\",\"subject\":\"Kafka 书籍汇总\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1558086395,\"time_expire\":1558093593,\"time_settle\":null,\"transaction_no\":\"1260724063201905176222820798\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_yzbDWLeXTWH01yvv5Su9GGa9/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_48SqjLvfzfz1bfLW90bPy18O\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-05-17 17:46:32','2019-05-17 17:46:35'),
	(105,140,9999,'20190517175854957934','{\"id\":\"evt_400190517175856904559303\",\"created\":1558087136,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_qrvPS0GaH0C0TGGSK8vvvfb9\",\"object\":\"charge\",\"created\":1558087134,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190517175854957934\",\"client_ip\":\"127.0.0.1\",\"amount\":16000091,\"amount_settle\":16000091,\"currency\":\"cny\",\"subject\":\"kafka 实战第一版\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1558087136,\"time_expire\":1558094334,\"time_settle\":null,\"transaction_no\":\"1202342004201905174959338102\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_qrvPS0GaH0C0TGGSK8vvvfb9/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_e540i9qPWnr1uTmXTO1mT0CK\",\"pending_webhooks\":0}','127.0.0.1',2,'2019-05-17 17:58:54','2019-05-17 17:58:56'),
	(106,44,9999,'20190517215305289190','{\"id\":\"evt_400190517215310992207402\",\"created\":1558101190,\"livemode\":false,\"type\":\"charge.succeeded\",\"data\":{\"object\":{\"id\":\"ch_eHi1a10SCKyLqv18CCbXvH0O\",\"object\":\"charge\",\"created\":1558101187,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_aTyfXDjrvzDSbLuz\",\"channel\":\"wx_pub\",\"order_no\":\"20190517215305289190\",\"client_ip\":\"124.77.208.137\",\"amount\":10,\"amount_settle\":10,\"currency\":\"cny\",\"subject\":\"kafka 实战\",\"body\":\"测试描述\",\"extra\":{\"open_id\":\"just_for_test\",\"bank_type\":\"your bank type\"},\"time_paid\":1558101190,\"time_expire\":1558108387,\"time_settle\":null,\"transaction_no\":\"1236273944201905178840991613\",\"refunds\":{\"object\":\"list\",\"url\":\"/v1/charges/ch_eHi1a10SCKyLqv18CCbXvH0O/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"测试备注\"}},\"object\":\"event\",\"request\":\"iar_m1WDSKTe9K40LGCqzT1eP0C0\",\"pending_webhooks\":0}','124.77.208.137',2,'2019-05-17 21:53:05','2019-05-17 21:53:13');

/*!40000 ALTER TABLE `transaction_extension` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table undo_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `undo_log`;

CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
