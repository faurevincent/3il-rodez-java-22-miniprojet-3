import controler.JeuDuPenduControler;
import model.JeuDuPenduModel;
import view.JeuDuPenduVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JeuDuPenduMain {

    public static void main(String[] args){
        JeuDuPenduModel jeuDuPenduModel = new JeuDuPenduModel();
        JeuDuPenduControler controler = new JeuDuPenduControler(jeuDuPenduModel);
        JeuDuPenduVue jeuDuPenduVue = new JeuDuPenduVue(controler);

        // Création de la fenêtre Swing
        JFrame frame = new JFrame("Jeu du pendu");
        frame.setSize(800, 400); // Taille de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture de l'application lors de la fermeture de la fenêtre

        frame.add(jeuDuPenduVue);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new Label("JEU DU PENDU"));
        panel.add(controler.getAfficherDefinition());
        panel.add(controler.getDefintion());
        panel.add(controler.getMotADecouvrir());
        panel.add(controler.getZoneSaisie());
        panel.add(controler.getLettreDejaProposer());
        panel.add(controler.getTentativeRestante());


        JButton rejouer = new JButton("Rejouer");
        rejouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                main(new String[0]);
            }
        });

        panel.add(rejouer);
        frame.add(panel);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
