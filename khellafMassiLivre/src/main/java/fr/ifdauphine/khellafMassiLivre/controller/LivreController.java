package fr.ifdauphine.khellafMassiLivre.controller;

import fr.ifdauphine.khellafMassiLivre.dao.LivreDao;
import fr.ifdauphine.khellafMassiLivre.model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

//      http://localhost:9091/Livres pour afficher tout les livres
//      http://localhost:9091/Livres/{id} pour accéder au livre associés à l'id "id"
//      http://localhost:9091/Prets/isbn={isbn} pour afficher un livre par isbn "{isbn}"
//      http://localhost:9091/Livres/auteur{auteur} pour accéder au livre associés a l'auteur "{auteur}"
//      http://localhost:9091/Livres/titre={titre} pour accéder au livres avec le titre "{titre}"
//      http://localhost:9091/Livres/editeur={editeur} pour accéder à la liste de tous les livres avec l'editeur "{editeur}"
//      http://localhost:9091/Livres/delete={id} pour supprimer le livre de l'id "{id}"

@RestController
public class LivreController {

    @Autowired
    private LivreDao livreDao;

    //Livres
    @GetMapping(value = "Livres")
    public List<Livre> listeLivres (){
        return livreDao.findAll();
    }

    //Livre/{id]
    @GetMapping(value = "Livres/{id}")
    public Livre afficherUnLivre(@PathVariable int id) throws LivreIntrouvableException {
        Livre livre = livreDao.findById(id);
        if( livre == null) throw new LivreIntrouvableException("Le livre demandé n'existe pas");

        return livre;
    }

    @GetMapping(value = "Livres/isbn={isbn}")
    public Livre findByIsbn(@PathVariable String isbn) throws LivreIntrouvableException {
        Livre livre = livreDao.findByIsbn(isbn);
        if( livre == null) throw new LivreIntrouvableException("Le livre demandé n'existe pas");
        return livre;
    }

    @GetMapping(value = "Livres/auteur{auteur}")
    public List<Livre> findByAuteur(@PathVariable String auteur) throws LivreIntrouvableException {
        List<Livre> livres = livreDao.findByAuteur(auteur);
        if( livres == null) throw new LivreIntrouvableException("Le livre demandé n'existe pas");
        return livres;
    }

    @GetMapping(value = "Livres/titre={titre}")
    public Livre findByTitre(@PathVariable String titre) throws LivreIntrouvableException {
        Livre livre = livreDao.findByTitre(titre);
        if( livre == null) throw new LivreIntrouvableException("Le livre demandé n'existe pas");
        return livre;
    }

    @GetMapping(value = "Livres/editeur={editeur}")
    public List<Livre> findByEditeur(@PathVariable String editeur) throws LivreIntrouvableException {
        List<Livre> livres = livreDao.findByEditeur(editeur);
        if( livres == null) throw new LivreIntrouvableException("Le livre demandé n'existe pas");
        return livres;
    }

    @GetMapping(value = "Livres/edition={edition}")
    public List<Livre> findByEdition(@PathVariable int edition) throws LivreIntrouvableException {
        List<Livre> livres = livreDao.findByEdition(edition);
        if( livres == null) throw new LivreIntrouvableException("Le livre demandé n'existe pas");
        return livres;
    }

    @PostMapping(value ="/Livres")
    public ResponseEntity<Void> ajouterLivre(@RequestBody Livre livre){
        Livre livre1 = livreDao.save(livre);

        if (livre==null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(livre1.getIsbn())
                        .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "Livres/delete={id}")
    public void supprimerLivre(@PathVariable int id){
        livreDao.deleteById(id);
    }
}
