USE `cinema`;

SELECT annee, genre, COUNT(genre) AS nb 
FROM `cinema`.`film`
WHERE annee = 1960
GROUP BY genre;