package fr.ifdauphine.khellafMassiLivre.dao;
import fr.ifdauphine.khellafMassiLivre.model.Livre;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface LivreDao  extends JpaRepository<Livre, Integer>{

    List<Livre> findAll();
    Livre findById(int id);
    Livre findByIsbn(String isbn);
    List<Livre> findByAuteur(String auteur);
    Livre findByTitre(String titre);
    List<Livre> findByEditeur(String editeur);
    List<Livre> findByEdition(int edition);
    void deleteById(int id);
}
