package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class JeuDuPenduModel {

    private final int NBR_ERREUR_POSSIBLE = 11;

    /**
     * Mot de la partie
     */
    private Mot mot;

    /**
     * Lettre proposer
     */
    private List<String> erreur;

    /**
     * Lettre trouver
     */
    private List<String> trouvee;

    /**
     * Etat de la partie (False -> Perdu, True -> Gagner et Null -> En cours)
     */
    private Boolean etat;

    /**
     * Données du fichier
     */
    private LectureFichier lectureFichier;

    /**
     * Créer une partie du Jeu du pendu
     */
    public JeuDuPenduModel() {
        lectureFichier = new LectureFichier();
        lectureFichier.lecture();
        mot = motAleatoire();
        erreur = new ArrayList<>();
        trouvee = new ArrayList<>();
    }

    public Mot getMot() {
        return mot;
    }

    public void setMot(Mot mot) {
        this.mot = mot;
    }

    public List<String> getErreur() {
        return erreur;
    }

    public void setErreur(List<String> erreur) {
        this.erreur = erreur;
    }

    public List<String> getTrouvee() {
        return trouvee;
    }

    public void setTrouvee(List<String> trouvee) {
        this.trouvee = trouvee;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    /**
     * Renvoie un mot aléatoire
     * @return un mot
     */
    private Mot motAleatoire(){
        return lectureFichier.getMots().get(nombreAleatoire());
    }

    /**
     * Renvoie un entier aléatoire entre 1 et le nombre de mot présent dans le fichier
     * @return un entier aléatoire
     */
    private int nombreAleatoire(){
        Random random = new Random();
        return random.nextInt(lectureFichier.getTaille());
    }

    public void proposer(String lettre){
        if(mot.getMot().contains(lettre)){
            trouvee.add(lettre);
        }else{
            erreur.add(lettre);
        }
    }
}
