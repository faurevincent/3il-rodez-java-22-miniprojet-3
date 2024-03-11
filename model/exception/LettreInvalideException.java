package model.exception;

public class LettreInvalideException extends IllegalArgumentException{

    public LettreInvalideException() {
    }

    public LettreInvalideException(String s) {
        super(s);
    }
}
