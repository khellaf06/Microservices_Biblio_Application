package fr.ifdauphine.khellafMassiLecteur.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LecteurIntrouvableException extends Throwable {
    public LecteurIntrouvableException(String msg) {
        super(msg);
    }
}
