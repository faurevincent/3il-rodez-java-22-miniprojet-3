package model;

import model.entity.Mot;
import model.exception.LettreInvalideException;
import model.utils.LectureFichier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JeuDuPenduModel {

    public static final int NBR_ERREUR_POSSIBLE = 11;

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

    /**
     * Le joueur propose une lettre
     * @param lettre
     * @return true si la lettre est presente
     */
    public boolean proposer(String lettre) throws LettreInvalideException{
        lettre = lettre.toLowerCase();
        estValide(lettre);
        boolean estTrouvee = false;

        if(mot.getMot().contains(lettre)){
            trouvee.add(lettre);
            if(trouvee.size() == mot.getMot().length()){
                etat = Boolean.TRUE;
            }
            estTrouvee = true;
        }else{
            erreur.add(lettre);
            if(erreur.size() == mot.getMot().length()){
                etat = Boolean.FALSE;
            }
        }

        return estTrouvee;
    }

    /**
     * Verification de la lettre en entrée
     * @param lettre
     * @throws LettreInvalideException si la lettre est invalide
     */
    private void estValide(String lettre) throws LettreInvalideException{
        Pattern pattern = Pattern.compile("[a-zé-]");
        Matcher matcher = pattern.matcher(lettre);

        if (!matcher.matches()) {
            throw new LettreInvalideException("La lettre " + lettre + " est invalide");
        }
    }
}
