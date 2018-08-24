## Travaux Pratique du Projet cinéma
-------------------------------
#### Création d'une database cinema

#### Créations des tables suivantes :

#### 1) film (<u>numf</u>, titre, genre, annee, longueur, budget, realisateur, salaire_real)
#### 2) personne (nump, prenom, nom, datenais, nationalite, adresse, ville, telephone)
#### 3) cinema (numc, nom, adresse, ville, telephone, compagnie)
#### 4) acteur (numa, agent, specialite, taille, poids, #nump)
#### 5) distribution (numd, role, salaire, #numa, #numf)
#### 6) salle (nums, taille_ecran, nbplaces, #numc)
#### 7) passe (numpasse, date_deb, date_fin, horaire, prix, #numf, #numc, #nums)
-------------------------------
#### Ecrire un programme Java
#### avec création d'une méthode pour la connection
#### avec création d'une méthode pour chaque requête SQL
#### avec création d'une méthode pour la déconnection
-------------------------------
#### Requête n° 1 - Retrouver la liste de tous les films
#### Requête n° 2 - Retrouver la liste des films dont la longueur dépasse 180 minutes
#### Requête n° 3 - Donner la liste de tous les genres de film
#### Requête n° 4 - Trouver le titre et l'année des films de Science-fiction dont le budget dépasse 5.000.000 $
#### Requête n° 5 - Donner le nombre de films par genre
#### Requête n° 6 - Donner le nombre de films de 1960 par genre
#### Requête n° 7 - Trouver le titre des films réalisés par Roman Polanski
#### Requête n° 8 - Quels sont les acteurs comiques (nom, prénom) qui ont joués dans un film de Spielberg
#### Requête n° 9 - Trouver le titre et l'année du film le plus long
#### Requête n° 10 - Nom et prénom des acteurs qui ont joués Gavroche dans les différentes versions des Misérables
####                 avec les dates correspondantes
#### Requête n° 11 - Donner le nom et prénom des réalisateurs qui ont joués dans au moins un de leurs propres films
