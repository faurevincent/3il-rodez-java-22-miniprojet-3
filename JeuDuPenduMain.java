import controler.JeuDuPenduControler;
import model.JeuDuPenduModel;
import view.JeuDuPenduVue;

public class JeuDuPenduMain {

    public static void main(String[] args){
        JeuDuPenduModel jeuDuPenduModel = new JeuDuPenduModel();
        JeuDuPenduControler jeuDuPenduControler = new JeuDuPenduControler(jeuDuPenduModel);
        JeuDuPenduVue jeuDuPenduVue = new JeuDuPenduVue();
    }
}
