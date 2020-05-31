DROP TABLE IF EXISTS Pret;

CREATE TABLE Pret (
                         id INT AUTO_INCREMENT  PRIMARY KEY ,
                         ISBN VARCHAR2(250) NOT NULL,
                         lecteur INT NOT NULL,
                         date_pret VARCHAR(250) DEFAULT NULL,
                         date_retour VARCHAR(250) DEFAULT NULL);

INSERT INTO Pret VALUES ( 12345,'97820814116000',123,'14/05/2020','14/06/2020');
INSERT INTO Pret VALUES ( 12346,'87813844616000',124,'21/05/2020','12/07/2020');