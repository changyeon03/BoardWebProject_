use community;
CREATE table `message` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`from_account` TEXT NOT NULL,
`to_account` TEXT NOT NULL,
`content` TEXT NOT NULL,
`sent_at` TIMESTAMP NOT NULL DEFAULT NOW(),
PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;