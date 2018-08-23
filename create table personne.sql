USE `cinema`;

CREATE TABLE `cinema`.`personne` (
	nump INT NOT NULL AUTO_INCREMENT,
	prenom VARCHAR(60),
	nom VARCHAR(60),
	datenais DATE,
	nationalite VARCHAR(60),
	adresse VARCHAR(60),
	ville VARCHAR(60),
	telephone VARCHAR(20),
	PRIMARY KEY (nump)
);