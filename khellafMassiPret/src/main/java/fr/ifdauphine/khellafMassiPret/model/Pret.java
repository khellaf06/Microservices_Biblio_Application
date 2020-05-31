package fr.ifdauphine.khellafMassiPret.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pret {

    @Id
    @GeneratedValue
    private int id;
    private String ISBN;
    private int lecteur;
    private String date_pret;
    private String date_retour;


    public Pret(){

    }

    public Pret(int id, String ISBN, int lecteur, String date_pret, String date_retour) {
        this.id = id;
        this.ISBN = ISBN;
        this.lecteur = lecteur;
        this.date_pret = date_pret;
        this.date_retour = date_retour;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String genre) {
        this.ISBN = genre;
    }

    public int getLecteur() {
        return lecteur;
    }

    public void setLecteur(int lecteur) {
        this.lecteur = lecteur;
    }

    public String getDate_pret() {
        return date_pret;
    }

    public void setDate_pret(String prenom) {
        this.date_pret = prenom;
    }

    public String getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(String date_naissence) {
        this.date_retour = date_naissence;
    }



    @Override
    public String toString() {
        return "Lecteur{" +
                "id=" + id +
                ", genre='" + ISBN + '\'' +
                ", nom='" + lecteur + '\'' +
                ", prenom='" + date_pret + '\'' +
                ", date_naissence='" + date_retour + '\'' +
                '}';
    }
}
