package controler;

import model.JeuDuPenduModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Controler du jeu du pendu
 */
public class JeuDuPenduControler {

    /**
     * Model du jeu
     */
    private JeuDuPenduModel jeuDuPenduModel;

    /**
     * Label qui contient le mot à découvrir
     */
    private JLabel motADecouvrir;

    /**
     * Label de la defintion du mot
     */
    private JLabel defintion;

    /**
     * Bouton pour afficher la definition
     */
    private JButton afficherDefinition;

    /**
     * Zone de saisie
     */
    private JTextField zoneSaisie;

    /**
     * Tableau des lettres déjà proposée
     */
    private JLabel lettreDejaProposer;

    /**
     * Label des tentatives restante
     */
    private JLabel tentativeRestante;

    public JeuDuPenduControler(JeuDuPenduModel jeuDuPenduModel) {
        this.jeuDuPenduModel = jeuDuPenduModel;

        motADecouvrir = new JLabel(composerMotAdecouvrir());
        defintion = new JLabel(this.jeuDuPenduModel.getMot().getDefinition());
        defintion.setVisible(false);

        afficherDefinition = new JButton("Afficher définition");
        afficherDefinition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(defintion.isVisible()){
                    defintion.setVisible(false);
                    afficherDefinition.setText("Afficher définition");
                }else{
                    defintion.setVisible(true);
                    afficherDefinition.setText("Ne plus afficher la definition");
                }
            }
        });

        zoneSaisie = new JTextField();
        lettreDejaProposer = new JLabel("Lettre déjà proposées : ");
        tentativeRestante = new JLabel("Tentative restante : " +  JeuDuPenduModel.NBR_ERREUR_POSSIBLE);
        zoneSaisie.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                boolean estTrouvee = jeuDuPenduModel.proposer(Character.toString(e.getKeyChar()));

                if(estTrouvee){
                    motADecouvrir.setText(composerMotAdecouvrir());
                }else{
                    lettreDejaProposer.setText("Lettre déjà proposées : " + jeuDuPenduModel.getErreur().toString());
                    tentativeRestante.setText("Tentative restantes : " + (JeuDuPenduModel.NBR_ERREUR_POSSIBLE - jeuDuPenduModel.getErreur().size()));
                }
                if(jeuDuPenduModel.getEtat() != null){
                    if(jeuDuPenduModel.getEtat().equals(Boolean.TRUE)){
                        JOptionPane.showMessageDialog(null, "Vous avez gagner !");
                    }else{
                        JOptionPane.showMessageDialog(null, "Vous avez perdu !");
                    }
                }
            }
        });
    }

    /**
     * Compose le label du mot à découvrir
     * @return la composition
     */
    private String composerMotAdecouvrir(){
        String mot = "";
        for(int index = 0; index < jeuDuPenduModel.getMot().getMot().length(); index++){
            if(jeuDuPenduModel.getTrouvee().contains(Character.toString(jeuDuPenduModel.getMot().getMot().charAt(index)))){
                mot += jeuDuPenduModel.getMot().getMot().charAt(index);
            }else{
                mot += "_";
            }
        }
        return mot;
    }

    public JLabel getDefintion() {
        return defintion;
    }

    public JTextField getZoneSaisie() {
        return zoneSaisie;
    }

    public JLabel getLettreDejaProposer() {
        return lettreDejaProposer;
    }

    public JLabel getTentativeRestante() {
        return tentativeRestante;
    }

    public JLabel getMotADecouvrir() {
        return motADecouvrir;
    }

    public JButton getAfficherDefinition() {
        return afficherDefinition;
    }
}
