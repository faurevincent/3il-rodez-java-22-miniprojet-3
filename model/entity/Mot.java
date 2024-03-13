package model.entity;

/**
 * Un mot est composé du mot et de sa définition
 */
public class Mot {

    /**
     * Le mot
     */
    private String mot;

    /**
     * Définition du mot
     */
    private String definition;

    /**
     * Construit un mot
     * @param mot
     * @param definition
     */
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
