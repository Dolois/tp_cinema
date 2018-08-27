USE `cinema`;

SELECT f.realisateur, f.titre, f.genre, p.nom, p.prenom
FROM `cinema`.`film` f
INNER JOIN `cinema`.`distribution` d ON d.numf = f.numf
INNER JOIN `cinema`.`acteur` a ON a.numa =d.numa
INNER JOIN `cinema`.personne p ON p.nump = a.nump
WHERE f.realisateur = 'Steven Spielberg';