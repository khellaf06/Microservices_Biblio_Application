# Gestion d'une application afin de gérer le fonctionnement d'une Bibliotheque
Ce projet est pour bute : De mettre en pratique les techniques est les méthodes apprisent durant le cours Applications WEB Orientées Services à l'université Paris Dauphine.

Nos Objectif :
La réalisation d'une application sous forme de microservices permettante de gérer des emprunts de livres dans une bibliothéque.
  - un livre (id | ISBN | auteur | titre | editeur | edition)
  - un prêt (id | ISBN | lecteur | date_pret | date_retour)
  - un lecteur (id | genre | nom | prenom | date_naissance | adresse)
  
 
Technologies utilisées :
  - postman
  - Intellij
  - Tomcat
  - Docker pour l'isolation des microservices
  - Spring boot initializer

  * Maven
  * Docker Toolkit 
  * Java

  
Architecture de l'application bibliothéque:
   - Microservice-Livre : qui se charge de la gestion des livres
   - Microservice-Emprunt : qui se charge de la gestion des emprunts
   - Microservice-Lecteur : qui se charge de la gestion des lecteurs
   
   
 



