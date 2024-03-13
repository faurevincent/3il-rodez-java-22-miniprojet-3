package model.tests;

import model.JeuDuPenduModel;
import model.exception.LettreInvalideException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JeuDuPenduModelTest {

    private JeuDuPenduModel jeuDuPenduModel;

    @Before
    public void setUp() throws Exception {
        jeuDuPenduModel = new JeuDuPenduModel();
    }

    @Test
    public void proposer_lettreInvalide(){
        assertThrows(LettreInvalideException.class, () -> {
            jeuDuPenduModel.proposer("2");
        });
    }

    @Test
    public void proposer_lettrePresente(){
        assertEquals(true, jeuDuPenduModel.proposer(Character.toString(jeuDuPenduModel.getMot().getMot().charAt(0))));
    }
}