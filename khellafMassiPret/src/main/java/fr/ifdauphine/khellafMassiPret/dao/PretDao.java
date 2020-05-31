package fr.ifdauphine.khellafMassiPret.dao;

import fr.ifdauphine.khellafMassiPret.model.Pret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PretDao extends JpaRepository<Pret,Integer> {

    List<Pret> findAll();
    Pret findById(int id);
    List<Pret> findByISBN(String isbn);
    List<Pret> findByLecteur(int lecteur);
    //List<Pret> findByDate_pret(String datePret);
    //List<Pret> findByDate_retour(String dateRetour);
    void deleteById(int id);

}
