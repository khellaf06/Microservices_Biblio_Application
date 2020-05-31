package fr.ifdauphine.khellafMassiPret.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PretIntrouvableExecption extends Throwable {
    public PretIntrouvableExecption(String msg) {
        super(msg);
    }
}
