package controler;

import model.JeuDuPenduModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JeuDuPenduControler {

    private JeuDuPenduModel jeuDuPenduModel;

    private JLabel motADecouvrir;

    private JLabel defintion;

    private JButton afficherDefinition;

    private JTextField zoneSaisie;

    private JLabel lettreDejaProposer;

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
                    if(jeuDuPenduModel.getEtat() != null && jeuDuPenduModel.getEtat()){
                        JOptionPane.showMessageDialog(null, "Vous avez gagner !");
                    }
                }else{
                    lettreDejaProposer.setText("Lettre déjà proposées : " + jeuDuPenduModel.getErreur().toString());
                    tentativeRestante.setText("Tentative restantes : " + (JeuDuPenduModel.NBR_ERREUR_POSSIBLE - jeuDuPenduModel.getErreur().size()));
                    if(jeuDuPenduModel.getEtat() != null && !jeuDuPenduModel.getEtat()){
                        JOptionPane.showMessageDialog(null, "Vous avez perdu !");
                    }
                }
            }
        });
    }

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
