-- 创建user表
-- 王凯琦


CREATE TABLE `wang`.`user`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) NULL,
  `password` varchar(255) NULL,
  `phone` varchar(255) NULL,
  `sex` varchar(255) NULL,
  `age` int(0) NULL,
  `note` varchar(255) NULL,
  `email` varchar(255) NULL,
  PRIMARY KEY (`id`)
);