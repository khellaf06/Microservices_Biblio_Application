package fr.ifdauphine.khellafMassiLivre.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Livre {

    @Id
    @GeneratedValue
    private int id;
    private String isbn;
    private String auteur;
    private String titre;
    private String editeur;
    @Size(min=4,max = 4, message = "L'année de l'édition n'est pas valide")
    private int edition;

    public Livre(){}
    public Livre(int id, String isbn, String auteur, String titre, String editeur, int edition) {
        this.id = id;
        this.isbn = isbn;
        this.auteur = auteur;
        this.titre = titre;
        this.editeur = editeur;
        this.edition = edition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", auteur='" + auteur + '\'' +
                ", titre='" + titre + '\'' +
                ", editeur='" + editeur + '\'' +
                ", edition=" + edition +
                '}';
    }
}
