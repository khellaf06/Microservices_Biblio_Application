package fr.ifdauphine.khellafMassiPret.controller;

import fr.ifdauphine.khellafMassiPret.dao.PretDao;
import fr.ifdauphine.khellafMassiPret.model.Pret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//      http://localhost:9092/Prets pour afficher tout les emprunts
//      http://localhost:9092/Prets/{id} pour accéder à l'emprunt associés à l'id "id"
//      http://localhost:9092/Prets/isbn={isbn} pour afficher un pret par isbn "{isbn}"
//      http://localhost:9092/Prets/lecteur={lecteur} pour accéder a l'emprunt associés au lecteut "{lecteur}"
//      http://localhost:9092/Prets/datePret={datePret} pour accéder à la liste de tous les prets avec la date de pret "{pret}"
//      http://localhost:9092/Prets/dateRetour={dateRetour} pour accéder à la liste de tous les prets avec la date de retour "{retour}"
//      http://localhost:9092/Prets/delete={id} pour supprimer le pret de l'id "{id}"


@RestController
public class PretController {

    @Autowired
    private PretDao pretDao;

    //Prets
    @GetMapping(value = "/Prets")
    public List<Pret> afficherPrets(){
        return pretDao.findAll();
    }

    //Lecteurs/{id}
    @GetMapping(value = "Prets/{id}")
    public Pret afficherUnPret(@PathVariable int id) throws PretIntrouvableExecption {
        Pret pret= pretDao.findById(id);
        if (pret==null) throw new PretIntrouvableExecption("Le pret demandé est introuvable");
        return pret;
    }

    @GetMapping(value = "Prets/isbn={isbn}")
    public List<Pret> findByISBN(@PathVariable String isbn) throws PretIntrouvableExecption {
        List<Pret> pret=pretDao.findByISBN(isbn);
        if (pret==null) throw new PretIntrouvableExecption("Le pret demandé est introuvable");
        return pret;
    }

    @GetMapping(value = "Prets/lecteur={lecteur}")
    public List<Pret> findByLecteur(@PathVariable int lecteur) throws PretIntrouvableExecption {
        List<Pret> pret=pretDao.findByLecteur(lecteur);
        if (pret==null) throw new PretIntrouvableExecption("Le pret demandé est introuvable");
        return pret;
    }

    /*@GetMapping(value = "Prets/datePret={datePret}")
    public List<Pret> findByDate_pret(@PathVariable String datePret){
        return pretDao.findByDate_pret(datePret);
    }

    @GetMapping(value = "Prets/dateRetour={dateRetour}")
    public List<Pret> findByDAndDate_retour(@PathVariable String dateRetour){
        return pretDao.findByDate_retour(dateRetour);
    }*/

    @PostMapping(value = "/Prets")
    public ResponseEntity<Void> ajouterPret(Pret Pret){

        Pret Pret1 = pretDao.save(Pret);

        if (Pret==null){
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.
                        fromCurrentRequest().
                        path("/{id}").buildAndExpand(Pret1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "Prets/delete={id}")
    public void supprimerPret(@PathVariable int id){
        pretDao.deleteById(id);
    }
}
