USE `cinema`;

CREATE TABLE `cinema`.`cinema` (
	numc INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR(60),
    adresse VARCHAR(60),
    ville VARCHAR(60),
    telephone VARCHAR(20),
    compagnie VARCHAR(60),
    PRIMARY KEY (numc)
);