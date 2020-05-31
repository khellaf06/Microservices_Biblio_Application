DROP TABLE IF EXISTS livre;

CREATE TABLE livre (
                         id INT AUTO_INCREMENT  PRIMARY KEY ,
                         isbn VARCHAR2(250) NOT NULL,
                         auteur VARCHAR(250) NOT NULL,
                         titre VARCHAR(250) DEFAULT NULL,
                         editeur VARCHAR(250) DEFAULT NULL,
                         edition INT(4) DEFAULT NULL);
INSERT INTO livre VALUES(1,'9782081416000', 'Emile Zola', 'Germinal', 'Flammarion',2017);
INSERT INTO livre VALUES(2,'5786081416110', 'Paulo Coelho', 'Alquimista', 'Planeta',1988);