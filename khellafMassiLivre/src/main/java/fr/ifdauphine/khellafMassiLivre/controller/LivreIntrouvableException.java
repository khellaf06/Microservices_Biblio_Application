package fr.ifdauphine.khellafMassiLivre.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LivreIntrouvableException extends Throwable {
    public LivreIntrouvableException(String s) {
        super(s);
    }
}
