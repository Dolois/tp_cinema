USE `cinema`;

SELECT genre, COUNT(genre) AS count 
FROM `cinema`.`film`
GROUP BY genre;