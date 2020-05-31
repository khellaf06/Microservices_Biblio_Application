package fr.ifdauphine.khellafMassiLecteur.controller;

import fr.ifdauphine.khellafMassiLecteur.dao.LecteurDao;
import fr.ifdauphine.khellafMassiLecteur.model.Lecteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//      http://localhost:9090/Lecteurs pour afficher tout les lecteurs
//      http://localhost:9090/Lecteurs/{id} pour accéder au lecteur associés à l'id "id"
//      http://localhost:9090/Lecteur/nom={nom}&prenom={prenom} pour afficher un lecteur passocié au nom "{nom}" et au prenom "{prenom}"
//      http://localhost:9090/Lecteur/date_naissance={date_naissance} pour accéder au lecteurs associés a la date de naissance "{date_naissance}"
//      http://localhost:9090/Lecteurs/delete={id} pour supprimer le lecteur de l'id "{id}"

@RestController
public class LecteurController {

    @Autowired
    private LecteurDao lecteurDao;

    //Lecteurs
    @GetMapping(value = "/Lecteurs")
    public List<Lecteur> afficherLecteurs(){
        return lecteurDao.findAll();
    }

    //Lecteurs/{id}
    @GetMapping(value = "Lecteurs/{id}")
    public Lecteur afficherUnLecteur(@PathVariable int id) throws LecteurIntrouvableException {
        Lecteur lecteur = lecteurDao.findById(id);
        if (lecteur==null) throw new LecteurIntrouvableException("Le lecteur demande est introuvable");
        return lecteur;
    }

   @GetMapping(value = "Lecteur/nom={nom}&prenom={prenom}")
    public Lecteur trouverLecteurParNomEtPrenom(@PathVariable String nom, @PathVariable String prenom) throws LecteurIntrouvableException {
       Lecteur lecteur = lecteurDao.findByNomAndPrenom(nom,prenom);
       if (lecteur==null) throw new LecteurIntrouvableException("Le lecteur demande est introuvable");
       return lecteur;
    }

    /*@GetMapping(value = "Lecteur/date_naissance={date_naissance}")
    public Lecteur findBydate_naissance(@PathVariable String date_naissance){
        return lecteurDao.findBydate_naissance(date_naissance);
    }*/

    @PostMapping(value = "/Lecteurs")
    public ResponseEntity<Void> ajouterLcteur(Lecteur lecteur){

        Lecteur lecteur1 = lecteurDao.save(lecteur);

        if (lecteur==null){
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.
                        fromCurrentRequest().
                        path("/{id}").buildAndExpand(lecteur1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "Lecteurs/delete={id}")
    public void supprimerLecteur(@PathVariable int id){
        lecteurDao.deleteById(id);
    }
}
