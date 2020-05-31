DROP TABLE IF EXISTS lecteur;

CREATE TABLE lecteur (
                              id INT AUTO_INCREMENT  PRIMARY KEY ,
                              genre VARCHAR2(250) NOT NULL,
                              prenom VARCHAR(250) NOT NULL,
                              nom VARCHAR(250) DEFAULT NULL,
                              date_naissance VARCHAR(250) DEFAULT NULL,
                              adresse VARCHAR(250) DEFAULT NULL);


INSERT INTO lecteur VALUES ( 123,'M','Boukou','Elie','2000-01-01','12 rue des Lilas 75019 Paris');
INSERT INTO lecteur VALUES ( 124,'M','Djebbar','khellaf','1993-06-18','58 rue jean jaurés 93450 l ile saint denis');