package model.exception;

/**
 * Lever si une Lettre est invalide
 */
public class LettreInvalideException extends IllegalArgumentException{

    public LettreInvalideException() {
    }

    public LettreInvalideException(String s) {
        super(s);
    }
}
