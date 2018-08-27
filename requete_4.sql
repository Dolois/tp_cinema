USE `cinema`;

SELECT titre, annee, budget 
FROM `cinema`.`film`
WHERE genre = 'Science-fiction'
AND budget > 5;