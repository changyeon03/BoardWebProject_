use community;
CREATE table `msg` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`fromid` BIGINT(20) NOT NULL,
`toid` BIGINT(20) NOT NULL,
`sent_at` TIMESTAMP NOT NULL DEFAULT NOW(),
PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;