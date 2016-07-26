
create database jewel;

use jewel;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) default charset=utf8;

create table code_type (
  `type` int auto_increment primary key comment '类型',
  `name` varchar(100) comment '名称',
  `remark` varchar(200) comment '备注',
  `valid` int comment '有效 0：无效 1：有效'
)  default charset=utf8 comment '代码类型';


create table code_value (
  `id` int auto_increment primary key comment 'id',
  `type` int comment '类型',
  `value` int comment '值',
  `name` varchar(100) comment '名称',
  `order` int comment '顺序',
  `remark` varchar(200) comment '备注',
  `valid` int comment '有效 0：无效 1：有效'
)  default charset=utf8 comment '代码值';



create table fun_invest (
  `id` int auto_increment primary key comment 'id',
  `type` int comment '类型',
  `fun_team` int comment 'fun_team',
  `role` int comment 'role',
  `pre_concept` decimal(15,4) default 0 comment '',
  `concept` decimal(15,4) default 0 comment '',
  `plan` decimal(15,4) default 0  comment '',
  `dev` decimal(15,4) default 0 comment '',
  `sdv` decimal(15,4) default 0 comment '',
  `sit` decimal(15,4) default 0 comment '',
  `svt` decimal(15,4) default 0 comment '',
  `valid` int default 0 comment '有效'
) default charset=utf8 comment 'fun-incest';

create table project_type (
  `id` int auto_increment primary key comment 'id',
  `name` varchar(100) comment '类型',
  `remark` varchar(200) comment '备注',
  `valid` int default 0 comment '有效 0 无效 1有效'
) default charset=utf8 comment 'project type';
