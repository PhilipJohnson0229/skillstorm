CREATE SCHEMA `inventory` ;

CREATE TABLE `inventory`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);



Insert into item(name)values('plumbus');
Insert into item(name)values('Razort');
Insert into item(name)values('Remote');
Insert into item(name)values('Nintendo Switch');
Insert into item(name)values('Bird Food');
Insert into item(name)values('Floppy Disc Set');

select * from item;