use community;
create table `view` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`board_id` BIGINT(20) NOT NULL,
`viewer` VARCHAR(20) NOT NULL,
`viewed_at` TIMESTAMP NOT NULL,
PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;