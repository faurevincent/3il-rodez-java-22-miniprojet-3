package view;

import controler.JeuDuPenduControler;
import model.JeuDuPenduModel;

import javax.swing.*;

/**
 * Vue du pendu
 */
public class JeuDuPenduVue extends JPanel{

    private JeuDuPenduControler controler;

    public JeuDuPenduVue(JeuDuPenduControler controler) {
        this.controler = controler;

    }
}
