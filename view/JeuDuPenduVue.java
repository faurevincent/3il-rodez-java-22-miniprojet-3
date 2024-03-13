package view;

import controler.JeuDuPenduControler;
import model.JeuDuPenduModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JeuDuPenduVue extends JPanel{

    private JeuDuPenduControler controler;

    public JeuDuPenduVue(JeuDuPenduControler controler) {
        this.controler = controler;

    }
}
