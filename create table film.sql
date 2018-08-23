USE `cinema`;

CREATE TABLE `cinema`.`film` (
	numf INT NOT NULL AUTO_INCREMENT,
	titre VARCHAR(60),
    genre VARCHAR(50),
	annee INT,
    longueur INT,
	budget DOUBLE,
	realisateur VARCHAR(60),
	salaire_real DOUBLE,
    PRIMARY KEY (numf)
);