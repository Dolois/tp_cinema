USE `cinema`;

CREATE TABLE `cinema`.`distribution` (
	numd INT NOT NULL AUTO_INCREMENT,
	numf INT,
	numa INT,
	role VARCHAR(60),
	salaire DOUBLE,
	PRIMARY KEY (numd),
	FOREIGN KEY (numf) REFERENCES `cinema`.`film` (numf),
	FOREIGN KEY (numa) REFERENCES `cinema`.`acteur` (numa)
);