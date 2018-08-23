USE `cinema`;

CREATE TABLE `cinema`.`salle` (
    nums INT NOT NULL AUTO_INCREMENT,
	numc INT,
    taille_ecran INT,
    nbplaces INT,
    PRIMARY KEY (nums),
    FOREIGN KEY (numc) REFERENCES `cinema`.`cinema` (numc)
);