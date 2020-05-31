package fr.ifdauphine.khellafMassiLecteur.dao;

import fr.ifdauphine.khellafMassiLecteur.model.Lecteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecteurDao extends JpaRepository<Lecteur,Integer> {

    List<Lecteur> findAll();
    Lecteur findById(int id);
    Lecteur findByNomAndPrenom(String nom,String prenom);
    //Lecteur findBydate_naissance(String dateNaissance);
    void deleteById(int id);


}
