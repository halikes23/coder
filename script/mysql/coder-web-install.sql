use mysql ;
create user 'coder'@'%' identified by 'coder' ;
create user 'coder'@'localhost' identified by 'coder' ;

create database coder ;
grant all on coder.* to 'coder'@'%' ;
grant all on coder.* to 'coder'@'localhost' ;

use coder ;

CREATE TABLE `coder`.`i_interface_file` (
	`if_id` INT NOT NULL AUTO_INCREMENT,
	`file_path` VARCHAR(45) NULL,
	`interface_name` VARCHAR(45) NULL,
	PRIMARY KEY (`if_id`)
);

