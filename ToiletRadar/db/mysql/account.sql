DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `wx_photo` varchar(100) NOT NULL,
  `wx_name` varchar(25) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `identity` varchar(20) NOT NULL,
  `delete_status` tinyint(1) unsigned NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;