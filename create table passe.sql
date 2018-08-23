USE `cinema`;

CREATE TABLE `cinema`.`passe` (
	numpasse INT NOT NULL AUTO_INCREMENT,
	numf INT,
	numc INT,
	nums INT,
	date_deb DATE,
    date_fin DATE,
	horaire VARCHAR(5),
	prix DOUBLE,
    PRIMARY KEY (numpasse),
	FOREIGN KEY (numf) REFERENCES `cinema`.`film` (numf),
    FOREIGN KEY (numc) REFERENCES `cinema`.`cinema` (numc),
    FOREIGN KEY (nums) REFERENCES `cinema`.`salle` (nums)
);