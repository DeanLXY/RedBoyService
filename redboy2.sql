/*
SQLyog v10.2 
MySQL - 5.0.22-community-nt : Database - redboy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`redboy` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `redboy`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `fixedtel` varchar(20) default NULL,
  `provinceId` int(11) default NULL,
  `cityId` int(11) default NULL,
  `areaId` int(11) default NULL,
  `addressDetail` varchar(200) NOT NULL,
  `zipCode` varchar(20) default NULL,
  `userId` int(11) NOT NULL,
  `isDefault` int(4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 11264 kB';

/*Data for the table `address` */

insert  into `address`(`id`,`name`,`phoneNumber`,`fixedtel`,`provinceId`,`cityId`,`areaId`,`addressDetail`,`zipCode`,`userId`,`isDefault`) values (5,'老王','15866668888',NULL,1,1,1,'闵庄路3号红孩子','100195',0,0),(6,'习大大','18888888888',NULL,1,1,1,'长安街中南海1号','100195',0,0),(7,'小芳','13599996666',NULL,1,1,1,'中关村99号','100000',0,0),(8,'马化腾','15888889999',NULL,9,9,9,'腾讯大厦总裁办公室','100000',0,0),(9,'苏坤','13422221111',NULL,1,1,1,'郑州传智播客驻京办事处','100000',0,0),(10,'帅哥','13088138000',NULL,1,1,1,'神经病','100000',0,0);

/*Table structure for table `addressarea` */

DROP TABLE IF EXISTS `addressarea`;

CREATE TABLE `addressarea` (
  `id` int(11) NOT NULL auto_increment,
  `value` varchar(50) collate utf8_bin NOT NULL,
  `parentId` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `addressarea` */

insert  into `addressarea`(`id`,`value`,`parentId`) values (1,'北京市',0),(2,'海淀区',1),(3,'朝阳区',1),(4,'丰台区',1),(5,'广东省',0),(6,'广州市',5),(7,'广州一区',6),(8,'广州二区',6),(9,'深圳市',5),(10,'深圳一区',9),(11,'深圳二区',9),(12,'山东省',0),(13,'济南市',12),(14,'济南一区',13),(15,'济南二区',13),(16,'青岛市',12),(17,'青岛一区',16),(18,'青岛二区',16);

/*Table structure for table `brandinfo` */

DROP TABLE IF EXISTS `brandinfo`;

CREATE TABLE `brandinfo` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(40) collate utf8_bin default NULL,
  `pic` varchar(40) collate utf8_bin default NULL,
  `recommendid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `brandinfo` */

insert  into `brandinfo`(`id`,`name`,`pic`,`recommendid`) values (1,'周生生','/images/brand/zhoushengsheng.png',1),(2,'雅培','/images/brand/yapei.png',1),(3,'钢铁侠奶粉','/images/brand/3.jpg',1),(4,'喜羊羊','/images/brand/4.jpg',2),(5,'灰太狼','/images/brand/5.jpg',2),(6,NULL,'/images/brand/6.jpg',3);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `isleafnode` tinyint(1) NOT NULL default '0',
  `name` varchar(45) NOT NULL default '',
  `parentid` int(10) unsigned NOT NULL default '0',
  `pic` varchar(45) NOT NULL default '',
  `t` varchar(45) NOT NULL default '',
  `level` int(10) unsigned NOT NULL default '0',
  `version` varchar(20) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`isleafnode`,`name`,`parentid`,`pic`,`t`,`level`,`version`) values (1,0,'孕妈专区',0,'/images/category/category1.png','妈妈专区,祛纹纤体',1,'1'),(2,0,'婴幼食品',0,'/images/category/category2.png','奶粉辅食,婴幼儿营养',1,'1'),(3,0,'宝宝用品',0,'/images/category/category3.png','尿裤喂养,用品纸巾',1,'0'),(4,0,'玩具童车',0,'/images/category/category4.png','婴儿床椅,婴儿车',1,'0'),(5,0,'寝具服饰',0,'/images/category/category5.png','童鞋婴,幼儿服饰',1,'0'),(11,0,'孕养营养品/奶粉',1,'','',2,'0'),(12,0,'孕妇内衣',1,'','',2,'0'),(13,0,'孕妇服饰',1,'','',2,'0'),(14,0,'防辐射',1,'','',2,'0'),(15,0,'胎心仪/孕妇枕',1,'','',2,'0'),(16,0,'妈妈个人护理',1,'','',2,'0'),(17,0,'母乳喂养用品',1,'','',2,'0'),(18,0,'祛纹/纤体塑身',1,'','',3,'0'),(101,1,'面部护理',16,'','',3,'0'),(102,1,'洁牙护齿',16,'','',3,'0'),(103,1,'身体护理',16,'','',3,'0'),(104,1,'卫生巾',16,'','',3,'0'),(105,1,'产褥/护理垫',16,'','',3,'0'),(106,1,'眼部护理',16,'','',3,'0'),(107,1,'洗手液',16,'','',3,'0'),(108,1,'洗护套装',16,'','',3,'0');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(45) NOT NULL default '',
  `content` varchar(255) NOT NULL default '',
  `username` varchar(45) NOT NULL default '',
  `time` varchar(40) NOT NULL default '0000-00-00 00:00:00',
  `productid` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`title`,`content`,`username`,`time`,`productid`) values (1,'东西不错','东西不错','啤酒','2001-12-24 23:00:00',1020),(2,'东西不错','东西不错','小灰灰','2001-12-24 23:00:00',1),(3,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(4,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(5,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(6,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(7,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(8,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(9,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(10,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(11,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(12,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(13,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(14,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(15,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(16,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(17,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(18,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(19,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(20,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(21,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(22,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',1),(23,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',2),(24,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',2),(25,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',2),(26,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',2),(27,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',2),(28,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',2),(29,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',2),(30,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',2),(31,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',2),(32,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',3),(33,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',3),(34,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',3),(35,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',3),(36,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(37,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(38,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(39,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(40,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(41,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(42,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(43,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(44,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(45,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(46,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(47,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(48,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',4),(49,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',5),(50,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',5),(51,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',5),(52,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',5),(53,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',5),(54,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',5),(55,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',5),(56,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',5),(57,'好评,32个赞!','好评','匿名','2016年4月8日 12:29:00',5);

/*Table structure for table `deliveryinfo` */

DROP TABLE IF EXISTS `deliveryinfo`;

CREATE TABLE `deliveryinfo` (
  `id` int(11) NOT NULL auto_increment,
  `type` varchar(50) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `deliveryinfo` */

insert  into `deliveryinfo`(`id`,`type`) values (1,'周一至周五送货 '),(2,'双休日及公众假期送货'),(3,'时间不限，工作日双休日及公众假期均可送货');

/*Table structure for table `favorites` */

DROP TABLE IF EXISTS `favorites`;

CREATE TABLE `favorites` (
  `id` int(11) NOT NULL auto_increment,
  `userid` int(11) default NULL,
  `productid` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `favorites` */

insert  into `favorites`(`id`,`userid`,`productid`) values (22,2,3),(23,2,3),(24,2,2),(25,2,5),(26,2,1021),(27,2,101211),(28,2,1020),(29,2,4),(30,2,3),(31,2,2),(32,2,1021),(33,2,3),(34,2,3),(35,2,3),(36,2,2),(37,2,2),(38,2,2),(39,25,2),(40,2,4);

/*Table structure for table `help` */

DROP TABLE IF EXISTS `help`;

CREATE TABLE `help` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(25) NOT NULL default '',
  `version` int(10) NOT NULL default '0',
  `state` varchar(10) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `help` */

insert  into `help`(`id`,`title`,`version`,`state`) values (1,'如何派送',2,'1'),(2,'帮助2',2,'0'),(3,'帮助3',2,'1');

/*Table structure for table `help_detail` */

DROP TABLE IF EXISTS `help_detail`;

CREATE TABLE `help_detail` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `help_id` int(10) unsigned NOT NULL default '0',
  `title` varchar(20) NOT NULL default '',
  `content` varchar(255) NOT NULL default '',
  `state` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `help_detail` */

/*Table structure for table `homebanner` */

DROP TABLE IF EXISTS `homebanner`;

CREATE TABLE `homebanner` (
  `id` int(100) NOT NULL auto_increment,
  `title` varchar(100) collate utf8_bin default NULL,
  `pic` varchar(100) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `homebanner` */

insert  into `homebanner`(`id`,`title`,`pic`) values (1,'活动一','/images/home/image1.jpg'),(2,'活动二','/images/home/image2.jpg'),(3,'活动三','/images/home/image3.jpg'),(4,'活动四','/images/home/image4.jpg'),(5,'活动五','/images/home/image5.jpg');

/*Table structure for table `invoiceinfo` */

DROP TABLE IF EXISTS `invoiceinfo`;

CREATE TABLE `invoiceinfo` (
  `userId` int(11) NOT NULL,
  `title` varchar(20) default NULL,
  `content` varchar(100) default NULL,
  `id` int(11) NOT NULL auto_increment,
  `orderid` int(11) default NULL COMMENT '发票对应的订单',
  `type` int(1) default NULL COMMENT '发票的type,1个人,2公司',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `invoiceinfo` */

insert  into `invoiceinfo`(`userId`,`title`,`content`,`id`,`orderid`,`type`) values (1,'公司单位','啤酒饮料,矿泉水',1,NULL,NULL),(2,'个人','泡面Bear,火腿肠 了 ',2,NULL,NULL),(1,'秦守','前排围观',3,1,1),(1,'参数太多了','gogogogoogogogogoo',4,20,1),(1,'北京红孩子互联科技有限公司','0',5,22,0),(1,'北京红孩子互联科技有限公司','0',6,23,0),(1,'北京红孩子互联科技有限公司','0',7,24,0),(1,'北京红孩子互联科技有限公司','0',8,25,0),(1,'北京红孩子互联科技有限公司','1',9,29,1),(1,'北京红孩子互联科技有限公司','1',10,30,1),(1,'北京红孩子互联科技有限公司','1',11,31,1),(1,'北京红孩子互联科技有限公司','1',12,32,1),(2,'北京红孩子互联科技有限公司','0',13,33,0),(2,'北京红孩子互联科技有限公司','4',14,34,1),(2,'北京红孩子互联科技有限公司','1',15,35,2),(2,'北京红孩子互联科技有限公司','3',16,36,0),(2,'北京红孩子互联科技有限公司','3',17,37,0),(2,'北京红孩子互联科技有限公司','1',18,38,0),(2,'北京红孩子互联科技有限公司','0',19,39,2),(2,'北京红孩子互联科技有限公司','1',20,40,2),(2,'北京红孩子互联科技有限公司','1',21,41,2),(2,'北京红孩子互联科技有限公司','0',22,42,1),(2,'北京红孩子互联科技有限公司','1',23,43,2),(2,'北京红孩子互联科技有限公司','0',24,44,0),(2,'北京红孩子互联科技有限公司','0',25,45,0),(2,'北京红孩子互联科技有限公司','1',26,46,2),(2,'北京红孩子互联科技有限公司','0',27,47,0),(2,'北京红孩子互联科技有限公司','0',28,48,0),(2,'北京红孩子互联科技有限公司','0',29,49,0),(2,'北京红孩子互联科技有限公司','0',30,50,0),(2,'北京红孩子互联科技有限公司','0',31,51,0),(2,'北京红孩子互联科技有限公司','0',32,52,0),(2,'北京红孩子互联科技有限公司','1',33,53,0),(2,'北京红孩子互联科技有限公司','0',34,54,0),(2,'北京红孩子互联科技有限公司','1',35,55,0),(2,'北京红孩子互联科技有限公司','0',36,56,0),(2,'北京红孩子互联科技有限公司','3',37,57,2),(2,'北京红孩子互联科技有限公司','2',38,58,2),(2,'北京红孩子互联科技有限公司','0',39,59,0),(2,'北京红孩子互联科技有限公司','1',40,60,2),(2,'北京红孩子互联科技有限公司','1',41,61,0),(2,'北京红孩子互联科技有限公司','2',42,62,2),(2,'北京红孩子互联科技有限公司','1',43,63,2),(2,'北京红孩子互联科技有限公司','1',44,64,2),(2,'北京红孩子互联科技有限公司','2',45,65,2),(2,'北京红孩子互联科技有限公司','2',46,66,0),(13,'北京红孩子互联科技有限公司','1',47,67,0),(2,'个人','泡面Bear,火腿肠 了 ',48,69,1),(2,'个人','泡面Bear,火腿肠 了 ',49,70,1),(2,'北京红孩子互联科技有限公司','0',50,71,2),(2,'北京红孩子互联科技有限公司','0',51,72,2),(2,'个人','泡面Bear,火腿肠 了 ',52,74,1),(2,'个人','泡面Bear,火腿肠 了 ',53,75,1),(2,'个人','泡面Bear,火腿肠 了 ',54,76,1),(2,'个人','泡面Bear,火腿肠 了 ',55,77,1),(2,'个人','泡面Bear,火腿肠 了 ',56,78,1),(2,'北京红孩子互联科技有限公司','0',57,79,1),(2,'北京红孩子互联科技有限公司','0',58,80,1),(2,'个人','泡面Bear,火腿肠 了 ',59,81,1),(2,'个人','泡面Bear,火腿肠 了 ',60,82,1);

/*Table structure for table `logistics` */

DROP TABLE IF EXISTS `logistics`;

CREATE TABLE `logistics` (
  `id` int(11) NOT NULL,
  `expressWay` varchar(20) collate utf8_bin NOT NULL COMMENT '发货方式',
  `company` varchar(200) collate utf8_bin NOT NULL COMMENT '物流公司',
  `logisticsNum` varchar(50) collate utf8_bin default NULL COMMENT '物流编号',
  `transportNum` varchar(255) collate utf8_bin default NULL COMMENT '运单编号',
  `orderid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `logistics` */

insert  into `logistics`(`id`,`expressWay`,`company`,`logisticsNum`,`transportNum`,`orderid`) values (1,'牛牛快递','牛牛快递有限公司','NN10220202211','120022200222',1),(2,'姚姐快递','姚姚快递有限公司','YJ10220202021','120023023023',2);

/*Table structure for table `logistics_follow` */

DROP TABLE IF EXISTS `logistics_follow`;

CREATE TABLE `logistics_follow` (
  `orderid` int(11) default NULL,
  `followinfo` varchar(200) collate utf8_bin default NULL,
  `num` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `logistics_follow` */

insert  into `logistics_follow`(`orderid`,`followinfo`,`num`) values (1,'2013-10-27 14:25:23 上海航空转接点',1),(1,'2013-10-28 18:55:26 上海嘉定公司 露洲服务部KH发往豫SE1467',2),(1,'2013-10-28 20:45:11 北京中转站',3),(1,'2013-10-28 21:34:48 北京中转站进行中转,并发往北京丰台区广安门公司',4),(1,'2013-10-28 23:36:16 北京丰台区广安门公司派送,由钱树彬 签收',5),(2,'2013-10-28 18:55:26 北京嘉定公司 露洲服务部的波多野结衣发往豫DE2929',1),(2,'2013-10-28 20:45:11 郑州中转站',2),(2,'2013-10-28 21:34:48 郑州中转站进行中转,并发往郑州天安门公司',3),(2,'2013-10-28 23:36:16 郑州天安门公司派送,由瑶瑶 签收',4),(3,'2013-10-28 18:55:26 河南蛋定公司 露洲服务部的小仓老师发往豫DE2929',1),(3,'2013-10-28 23:36:16 河南蛋定公司,由姚志远 签收',4);

/*Table structure for table `orderinfo` */

DROP TABLE IF EXISTS `orderinfo`;

CREATE TABLE `orderinfo` (
  `orderid` int(11) NOT NULL auto_increment COMMENT '主键id',
  `status` int(11) default NULL COMMENT '订单显示状态：1未处理、2交易成功、3已完成、4已取消',
  `time` varchar(20) collate utf8_bin default NULL COMMENT '下单时间',
  `price` double default NULL COMMENT '订单金额',
  `flag` int(11) default NULL COMMENT '订单标识，1=>可删除可修改:未支付 2=>不可修改：不是未支付 3=>已完成、4：已取消',
  `userid` int(11) default NULL COMMENT '用户id，与用户表的主键关联',
  `productinfos` varchar(200) collate utf8_bin default NULL COMMENT '多个商品的id，以逗号分隔',
  `paymenttypeid` int(11) default NULL,
  `deliveryid` int(11) default NULL,
  `addressid` int(11) default NULL,
  PRIMARY KEY  (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `orderinfo` */

insert  into `orderinfo`(`orderid`,`status`,`time`,`price`,`flag`,`userid`,`productinfos`,`paymenttypeid`,`deliveryid`,`addressid`) values (9,4,'2016-01-28',100,4,2,'101211:2:2,3|10211:2:4,3',2,1,1),(10,2,'2016-01-28',100,2,2,'101211:2:2,3|10211:2:4,3',3,2,2),(11,3,'2016-01-28',100,2,2,'101211:2:2,3|10211:2:4,3',1,3,1),(12,2,'2016-01-28',100,2,2,'101211:2:2,3|10211:2:4,3',2,1,2),(13,1,'2016-01-28',100,2,2,'101211:2:2,3|10211:2:4,3',3,2,1),(14,4,'2016-01-28',100,4,2,'101211:2:2,3|10211:2:4,3',1,3,2),(15,3,'2016-01-28',100,2,2,'101211:2:2,3|10211:2:4,3',2,1,1),(16,2,'2016-01-28',100,2,2,'101211:2:2,3|10211:2:4,3',3,3,3),(17,1,'2016-01-28',1009,1,1,'101211:2:2,3|10211:2:4,3',1,1,1),(18,1,'2016-01-28',156,1,1,'101211:2:2,3|10211:2:4,3',1,3,1),(19,1,'2016-01-28',156,1,1,'101211:2:2,3|10211:2:4,3',1,3,1),(20,1,'2016-01-28',156,1,1,'101211:2:2,3|10211:2:4,3',1,3,1),(21,1,'2016-01-28',234,1,NULL,'5:3:1,2',3,1,2),(22,1,'2016-01-28',234,1,1,'5:3:1,2',0,0,2),(23,1,'2016-01-28',234,1,1,'5:3:1,2',0,0,2),(24,1,'2016-01-28',156,1,1,'2:2',0,0,2),(25,1,'2016-01-28',156,1,1,'2:2',0,0,2),(26,1,'2016-01-28',78,1,NULL,'2:1',1,1,2),(27,1,'2016-01-28',78,1,NULL,'2:1',1,1,2),(28,1,'2016-01-28',78,1,NULL,'2:1',1,1,2),(29,1,'2016-01-28',78,1,1,'2:1',1,1,2),(30,1,'2016-01-28',78,1,1,'3:1',1,1,2),(31,1,'2016-01-28',156,1,1,'4:2',1,1,2),(32,1,'2016-01-28',78,1,1,'2:1',1,1,2),(33,1,'2016-01-28',78,1,2,'2:1',0,0,2),(34,1,'2016-01-28',156,1,2,'2:2',0,3,2),(35,1,'2016-01-28',78,1,2,'4:2|3:1',2,2,9),(36,1,'2016-01-28',78,1,2,'2:3|1010:2|3:1|4:1|1021:1|5:1',1,2,4),(37,1,'2016-01-28',234,1,2,'2:3',0,0,4),(38,1,'2016-01-28',78,1,2,'2:3|3:1',2,2,4),(39,1,'2016-01-28',78,1,2,'2:3|3:1',1,2,11),(40,1,'2016-01-28',78,1,2,'2:1',1,2,4),(41,1,'2016-01-28',78,1,2,'3:1',2,2,10),(42,1,'2016-01-28',78,1,2,'2:1',3,1,10),(43,4,'2016-01-28',234,4,2,'2:3',2,3,10),(44,1,'2016-01-28',468,1,2,'3:6',1,2,4),(45,1,'2016-01-28',78,1,2,'2:1',3,2,4),(46,1,'2016-01-28',390,1,2,'3:5',2,2,11),(47,1,'2016-01-28',78,1,2,'3:1',2,1,10),(48,1,'2016-01-28',78,1,2,'3:1',1,1,4),(49,1,'2016-01-28',78,1,2,'2:1',2,2,4),(50,1,'2016-01-28',78,1,2,'10211:1|2:1|3:1|1020:1|4:3|1021:1',2,1,10),(51,1,'2016-01-28',390,1,2,'3:5',1,1,4),(52,4,'2016-01-28',234,4,2,'1021:1|2:2|3:3',2,2,11),(53,1,'2016-01-28',390,1,2,'1021:1|2:3|3:5',2,2,11),(54,4,'2016-01-28',1014,4,2,'3:13',1,1,10),(55,4,'2016-01-28',468,4,2,'2:6',2,2,11),(56,4,'2016-01-28',312,4,2,'2:4',1,1,11),(57,1,'2016-01-28',156,1,2,'2:1|3:2',2,2,11),(58,4,'2016-01-28',78,4,2,'1020:1|2:1',1,1,11),(59,4,'2016-01-28',156,4,2,'3:2',1,1,13),(60,4,'2016-01-28',78,4,2,'2:1',2,2,13),(61,4,'2016-01-28',156,4,2,'2:2',1,2,13),(62,1,'2016-01-28',78,1,2,'2:1',2,3,13),(63,1,'2016-01-28',78,1,2,'2:1',2,2,13),(64,1,'2016-01-28',78,1,2,'2:1',2,2,13),(65,1,'2016-01-28',78,1,2,'2:1',1,2,11),(66,1,'2016-01-28',78,1,2,'1021:11|3:1',1,1,4),(67,1,'2016-01-28',780,1,13,'3:10',1,1,4),(68,1,'2016-03-15',156,1,1,'101211:2:2,3|10211:2:4,3',1,1,2),(69,1,'2016-03-15',156,1,2,'101211:2:2,3|10211:2:4,3',0,2,2),(70,1,'2016-03-15',156,1,2,'101211:2:2,3|10211:2:4,3',0,2,2),(71,1,'2016-03-15',156,1,2,'101211:2:2,3|10211:2:4,3',0,2,3),(72,1,'2016-03-15',156,1,2,'101211:2:2,3|10211:2:4,3',0,2,3),(73,1,'2016-03-16',156,1,1,'101211:2:2,3|10211:2:4,3',1,1,2),(74,1,'2016-03-16',156,1,2,'101211:2:2,3|10211:2:4,3',0,2,2),(75,1,'2016-03-16',156,1,2,'101211:2:2,3|10211:2:4,3',0,2,2),(76,1,'2016-03-16',156,1,2,'101211:2:2,3|10211:2:4,3',0,2,2),(77,1,'2016-03-16',156,1,2,'101211:2:2,3|10211:2:4,3',0,2,2),(78,1,'2016-03-16',156,1,2,'101211:2:2,3|10211:2:4,3',0,2,3),(79,1,'2016-03-16',156,1,2,'101211:2:2,3|10211:2:4,3',1,2,2),(80,1,'2016-03-16',156,1,2,'101211:2:2,3|10211:2:4,3',1,2,2),(81,1,'2016-03-16',156,1,2,'101211:2:2,3|10211:2:4,3',1,2,5),(82,1,'2016-03-16',156,1,2,'101211:2:2,3|10211:2:4,3',0,3,5);

/*Table structure for table `orderinfo2` */

DROP TABLE IF EXISTS `orderinfo2`;

CREATE TABLE `orderinfo2` (
  `orderid` int(11) NOT NULL auto_increment COMMENT '主键id',
  `status` int(11) default NULL COMMENT '订单显示状态：1未处理、2交易成功、3已完成、4已取消',
  `time` varchar(20) collate utf8_bin default NULL COMMENT '下单时间',
  `price` double default NULL COMMENT '订单金额',
  `flag` int(11) default NULL COMMENT '订单标识，1=>可删除可修改:未支付 2=>不可修改：不是未支付 3=>已完成、4：已取消',
  `userid` int(11) default NULL COMMENT '用户id，与用户表的主键关联',
  `productinfos` varchar(200) collate utf8_bin default NULL COMMENT '多个商品的id，以逗号分隔',
  `paymenttypeid` int(11) default NULL,
  `deliveryid` int(11) default NULL,
  `addressid` int(11) default NULL,
  PRIMARY KEY  (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `orderinfo2` */

insert  into `orderinfo2`(`orderid`,`status`,`time`,`price`,`flag`,`userid`,`productinfos`,`paymenttypeid`,`deliveryid`,`addressid`) values (11,3,'2013-09-02',100,2,110,NULL,1,NULL,NULL),(16,2,'2013-10-06',100,2,110,NULL,3,NULL,NULL);

/*Table structure for table `paymenttype` */

DROP TABLE IF EXISTS `paymenttype`;

CREATE TABLE `paymenttype` (
  `id` int(11) NOT NULL auto_increment,
  `type` varchar(50) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `paymenttype` */

insert  into `paymenttype`(`id`,`type`) values (1,'货到付款'),(2,'POS机刷卡'),(3,'支付宝');

/*Table structure for table `pic` */

DROP TABLE IF EXISTS `pic`;

CREATE TABLE `pic` (
  `id` int(11) NOT NULL auto_increment,
  `picurl` varchar(200) collate utf8_bin default NULL,
  `relatedid` int(11) default NULL,
  `type` tinyint(1) default NULL,
  `flay` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `pic` */

insert  into `pic`(`id`,`picurl`,`relatedid`,`type`,`flay`) values (1,'/images/lijingshan/product_01.jpg',0,NULL,NULL),(2,'/images/lijingshan/product_04.jpg',0,NULL,NULL),(3,'/images/lijingshan/product_05.jpg',1102539,0,NULL),(4,'/images/lijingshan/product_04.jpg',1102539,0,NULL),(5,'/images/lijingshan/product_02.jpg',1102539,0,NULL),(6,'/images/lijingshan/product_03.jpg',1,0,NULL),(7,'/images/lijingshan/product_01.jpg',1102539,0,NULL),(8,'/images/lijingshan/product_02.jpg',1021,0,NULL),(9,'/images/lijingshan/product_04.jpg',1102539,0,NULL),(10,'/images/lijingshan/product_01.jpg',1102539,0,NULL),(11,'/images/lijingshan/product_01.jpg',1102539,0,NULL),(12,'/images/lijingshan/product_01.jpg',1102539,1,NULL),(13,'/images/lijingshan/product_01.jpg',1102539,1,NULL),(14,'/images/lijingshan/product_01.jpg',1021,1,NULL),(15,'/images/lijingshan/product_01.jpg',1102539,1,NULL),(16,'/images/lijingshan/product_01.jpg',1,1,NULL),(17,'/images/lijingshan/product_01.jpg',1,1,NULL),(18,'/images/lijingshan/product_01.jpg',1102539,1,NULL),(19,'/images/lijingshan/product_01.jpg',1021,NULL,NULL),(20,'/images/lijingshan/product_01.jpg',1021,NULL,NULL);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL default '',
  `marketprice` double NOT NULL default '0',
  `price` double NOT NULL default '0',
  `commentcount` int(10) unsigned NOT NULL default '0',
  `lefttime` varchar(100) NOT NULL,
  `score` int(45) NOT NULL default '0',
  `available` tinyint(1) NOT NULL default '0',
  `buylimit` varchar(100) NOT NULL default '0',
  `productprom` varchar(255) NOT NULL default '',
  `inventoryarea` varchar(45) NOT NULL default '',
  `productproperty` varchar(255) NOT NULL default '',
  `color` varchar(45) NOT NULL default '',
  `size` varchar(45) NOT NULL default '',
  `productdesc` varchar(45) NOT NULL default '',
  `listfilter` varchar(45) NOT NULL default '',
  `islimitbuy` tinyint(1) NOT NULL default '0',
  `isnewproduct` tinyint(1) NOT NULL default '0',
  `ishotproduct` tinyint(1) NOT NULL default '0',
  `isgift` tinyint(1) NOT NULL default '0',
  `topicid` int(10) unsigned NOT NULL default '0',
  `brandid` int(10) unsigned NOT NULL default '0',
  `categoryid` int(10) unsigned NOT NULL default '0',
  `pic` varchar(255) NOT NULL default '',
  `sales` int(10) unsigned NOT NULL default '0',
  `limitprice` double default NULL,
  `number` int(11) default NULL,
  `searchkey` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`marketprice`,`price`,`commentcount`,`lefttime`,`score`,`available`,`buylimit`,`productprom`,`inventoryarea`,`productproperty`,`color`,`size`,`productdesc`,`listfilter`,`islimitbuy`,`isnewproduct`,`ishotproduct`,`isgift`,`topicid`,`brandid`,`categoryid`,`pic`,`sales`,`limitprice`,`number`,`searchkey`) values (0,'QQ糖',0,0,0,'0',0,0,'0','','','','','','此商品为测试商品,暂无商品描述信息','',0,0,0,1,0,0,0,'/images/10.jpg',0,NULL,98,NULL),(2,'三鹿    ',79,78,23,'3600',111,0,'20','','','','','','此商品为测试商品,暂无商品描述信息','',1,1,0,1,1,0,1,'/images/11.jpg',100,20,998,NULL),(3,'伊利QQ星',79,78,1,'3600',444,0,'5678','','','','','','此商品为测试商品,暂无商品描述信息','',1,1,1,0,1,0,1,'/images/12.jpg',100,4,3333,NULL),(4,'特仑苏  ',79,78,55555,'3600',0,0,'20','','','','','','此商品为测试商品,暂无商品描述信息','',1,0,0,0,0,0,1,'/images/13.jpg',100,33,11,NULL),(5,'伊利金装',79,78,11,'3600',111,0,'20','','','','','','此商品为测试商品,暂无商品描述信息','',1,0,0,0,0,0,1,'/images/14.jpg',100,4,33,NULL),(1010,'雅培金装  ',234,231,6789876,'3600',12,0,'20','','','','','','此商品为测试商品,暂无商品描述信息','',1,0,0,1,0,0,0,'/images/15.jpg',345678,111,222,'222'),(1020,'你妹牌饼干 ',79,78,22453,'0',20,0,'0','','','','','','此商品为测试商品,暂无商品描述信息','',0,0,0,1,0,0,1,'/images/16.jpg',100,22,7,NULL),(1021,'七度空间 ',79,78,232,'3600',10,0,'33','','','','','','此商品为测试商品,暂无商品描述信息','',1,0,0,0,0,0,1,'/images/10.jpg',100,23,111,NULL),(10211,'护舒宝   ',79,78,23,'0',0,1,'0','','','','','','此商品为测试商品,暂无商品描述信息','',0,0,0,1,1,0,1,'/images/1.bmp',100,NULL,99,NULL),(101211,'可比克',79,78,22453,'0',20,1,'0','','','','','','此商品为测试商品,暂无商品描述信息','',0,0,0,1,0,0,1,'/images/10.jpg',100,NULL,7,NULL),(1102542,'超人内裤',333,332,0,'3600',0,0,'100','','','','','','此商品为测试商品,暂无商品描述信息','',1,0,0,0,0,0,0,'/images/10.jpg',0,44,77,NULL),(1102543,'',0,0,0,'',0,0,'0','','','','','','此商品为测试商品,暂无商品描述信息','',0,0,0,0,0,0,0,'',0,NULL,NULL,NULL);

/*Table structure for table `product_property` */

DROP TABLE IF EXISTS `product_property`;

CREATE TABLE `product_property` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `prodkey` varchar(45) NOT NULL default '',
  `prodvalue` varchar(45) NOT NULL default '',
  `prodid` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_property` */

insert  into `product_property`(`id`,`prodkey`,`prodvalue`,`prodid`) values (1,'大小','M',1),(2,'颜色','蓝色',1);

/*Table structure for table `productprom` */

DROP TABLE IF EXISTS `productprom`;

CREATE TABLE `productprom` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `prodid` int(10) unsigned NOT NULL default '0',
  `prominfo` varchar(255) collate utf8_bin NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `productprom` */

insert  into `productprom`(`id`,`prodid`,`prominfo`) values (1,1,'促销信息1'),(2,10211,'促销信息2'),(3,1,'信息1'),(4,1102539,'信息2'),(5,1021,'促销信息2'),(6,1021,'促销信息2');

/*Table structure for table `recommendbrand` */

DROP TABLE IF EXISTS `recommendbrand`;

CREATE TABLE `recommendbrand` (
  `id` int(11) NOT NULL auto_increment,
  `selection` varchar(20) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `recommendbrand` */

insert  into `recommendbrand`(`id`,`selection`) values (1,'孕妈专区'),(2,'营养食品');

/*Table structure for table `search_keywords` */

DROP TABLE IF EXISTS `search_keywords`;

CREATE TABLE `search_keywords` (
  `id` int(11) NOT NULL auto_increment,
  `searchkeyword` varchar(40) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `search_keywords` */

insert  into `search_keywords`(`id`,`searchkeyword`) values (1,'羽绒服'),(2,'学习机'),(3,'早餐奶'),(4,'生活用品');

/*Table structure for table `shoppingcart` */

DROP TABLE IF EXISTS `shoppingcart`;

CREATE TABLE `shoppingcart` (
  `id` int(11) NOT NULL auto_increment,
  `userid` int(11) NOT NULL,
  `s` varchar(200) collate utf8_bin NOT NULL,
  `k` varchar(200) collate utf8_bin NOT NULL,
  `u` varchar(200) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `shoppingcart` */

insert  into `shoppingcart`(`id`,`userid`,`s`,`k`,`u`) values (5,2,'3','1','1'),(6,2,'5','1','1'),(7,2,'3','1','1'),(8,2,'3','1','1'),(9,2,'5','1','1'),(10,2,'2','1','1'),(11,2,'2','1','1'),(12,2,'5','1','1'),(13,2,'5','1','1'),(14,2,'2','1','1'),(15,2,'2','1','1'),(16,2,'3','1','1'),(17,2,'3','1','1'),(18,2,'3','1','1'),(19,2,'3','1','1'),(20,2,'3','1','1'),(21,2,'3','1','1'),(22,2,'3','1','1'),(23,2,'4','1','1'),(24,2,'3','1','1'),(25,2,'2','1','1'),(26,2,'3','1','1'),(27,2,'3','1','1'),(28,2,'3','1','1'),(29,2,'3','1','1'),(30,2,'3','1','1'),(31,2,'3','1','1'),(32,2,'2','1','1'),(33,2,'2','1','1'),(34,2,'2','1','1'),(35,2,'2','1','1'),(36,2,'101211','1','1'),(37,2,'3','1','1'),(38,2,'2','1','1'),(39,2,'2','1','1'),(40,2,'4','1','1'),(41,2,'2','1','1'),(42,2,'2','1','1'),(43,2,'4','1','1'),(44,2,'5','1','1'),(45,2,'2','1','1'),(46,2,'4','1','1'),(47,2,'3','4','1'),(48,2,'4','1','1'),(49,2,'3','1','1'),(50,2,'2','1','1'),(51,2,'3','1','1'),(52,25,'2','1','1'),(53,25,'2','12','1'),(54,2,'2','1','1'),(55,2,'3','1','1'),(56,25,'2','1','1'),(57,2,'2','1','1'),(58,2,'3','1','1'),(59,2,'4','1','1'),(60,2,'1020','1','1'),(61,2,'1021','1','1'),(62,2,'101211','1','1'),(63,2,'2','1','1'),(64,2,'101211','1','1'),(65,2,'10211','1','1'),(66,2,'10211','1','1'),(67,2,'1021','1','1'),(68,2,'1020','1','1'),(69,2,'10211','1','1'),(70,2,'2','1','1'),(71,2,'10211','1','1'),(72,2,'3','1','1'),(73,2,'3','1','1'),(74,2,'3','1','1'),(75,2,'101211','1','1'),(76,2,'2','1','1'),(77,2,'3','1','1'),(78,2,'5','1','1');

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `picurl` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `topic` */

insert  into `topic`(`id`,`title`,`picurl`) values (1,'暖奶器/保温杯壶/浴室用品特价5折起','/images/topic'),(2,'年货礼全齐备','/images/topic'),(3,'如何刷两颗小牙','/images/topic'),(4,'子雅贝贝全场 双重优惠好礼巨献','/images/topic');

/*Table structure for table `totalinfo` */

DROP TABLE IF EXISTS `totalinfo`;

CREATE TABLE `totalinfo` (
  `id` int(11) NOT NULL auto_increment COMMENT '订单总计信息id',
  `totalcount` int(11) default NULL COMMENT '商品数量总计',
  `totalprice` double default NULL COMMENT '总计金额',
  `totalpoint` int(11) default NULL COMMENT '商城总积分',
  `freight` double default NULL COMMENT '运费',
  `promcut` double default NULL COMMENT '促销减钱',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `totalinfo` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` int(11) NOT NULL auto_increment,
  `username` varchar(100) NOT NULL default '',
  `password` varchar(255) NOT NULL default '',
  `bonus` int(11) default NULL,
  `level` varchar(10) default NULL,
  `usersession` varchar(255) default NULL,
  `ordercount` int(11) default NULL,
  `favoritescount` int(11) default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userid`,`username`,`password`,`bonus`,`level`,`usersession`,`ordercount`,`favoritescount`) values (1,'xiaowen@redbaby.com.cn','123456',3002,'金卡','MD5',20,12),(2,'qwe','123',101,'普通用户',NULL,20,20),(3,'sss','111',NULL,NULL,NULL,0,0),(6,'qwqqe','123',NULL,NULL,NULL,NULL,NULL),(7,'asd','123',NULL,NULL,NULL,NULL,NULL),(8,'','',NULL,NULL,NULL,NULL,NULL),(9,'er','er',NULL,NULL,NULL,NULL,NULL),(10,'sa','123',NULL,NULL,NULL,NULL,NULL),(11,'root','1',NULL,NULL,NULL,NULL,NULL),(12,'itcastz10','admin',NULL,NULL,NULL,NULL,NULL),(13,'itcast','admin',NULL,NULL,NULL,NULL,NULL),(14,'zzz','admin',NULL,NULL,NULL,NULL,NULL),(15,'ljy','123',NULL,NULL,NULL,NULL,NULL),(16,'123','123',NULL,NULL,NULL,NULL,NULL),(17,'123123','123',NULL,NULL,NULL,NULL,NULL),(18,'a1','a1',NULL,NULL,NULL,NULL,NULL),(19,'a2','a2',NULL,NULL,NULL,NULL,NULL),(20,'44444','123',NULL,NULL,NULL,NULL,NULL),(21,'1234','1234',NULL,NULL,NULL,NULL,NULL),(22,'username','password',NULL,NULL,NULL,NULL,NULL),(23,'datang','123',NULL,NULL,NULL,NULL,NULL),(24,'ch','ch',NULL,NULL,NULL,NULL,NULL),(25,'ch01001','ch',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `user2` */

DROP TABLE IF EXISTS `user2`;

CREATE TABLE `user2` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user2` */

/*Table structure for table `version` */

DROP TABLE IF EXISTS `version`;

CREATE TABLE `version` (
  `new` tinyint(11) default NULL,
  `version` int(255) NOT NULL,
  `force` tinyint(11) default NULL,
  `url` varchar(255) default NULL,
  PRIMARY KEY  (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `version` */

insert  into `version`(`new`,`version`,`force`,`url`) values (0,1,0,'http://');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
