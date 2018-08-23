USE `cinema`;

CREATE TABLE `cinema`.`acteur` (
	numa INT NOT NULL AUTO_INCREMENT,
	nump INT,
	agent VARCHAR(50),
    specialite VARCHAR(50),
    taille INT,
	poids INT,
    PRIMARY KEY (numa),
	FOREIGN KEY (nump) REFERENCES `cinema`.`personne` (nump)
);