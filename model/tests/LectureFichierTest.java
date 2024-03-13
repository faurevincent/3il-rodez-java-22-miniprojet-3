package model.tests;

import model.utils.LectureFichier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LectureFichierTest {

    @Test
    void lecture() {
        LectureFichier lectureFichier = new LectureFichier();
        lectureFichier.lecture();
        assertEquals("agenda", lectureFichier.getMots().get(1).getMot());
        assertEquals("document que vous oubliez systématiquement de consulter jusqu'à la veille des examens", lectureFichier.getMots().get(1).getDefinition());
    }
}