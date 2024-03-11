package model;

public class Mot {

    private String mot;

    private String definition;

    public Mot(String mot, String definition) {
        this.mot = mot;
        this.definition = definition;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
