import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.Normalizer;

import static org.junit.jupiter.api.Assertions.*;

public class EtudiantTest {
    Etudiant etu;

    @BeforeEach
    public void initialisation() {
        Identite id = new Identite("1234", "Dupont", "Paul");
        Formation f = new Formation("BUT Informatique");
        f.ajouter("maths", 2.0);
        f.ajouter("qualite de dev", 1.5);
        f.ajouter("communication", 1);
        etu = new Etudiant(id, f);
    }

    @Test
    public void testAjouterNote() throws FormationException, NoteException {
        etu.ajouterNote("maths", 11.5);
        assertEquals(11.5, etu.getResultat().get("maths").getFirst(), "La note de maths devrait être 11.5");
        assertEquals(1, etu.getResultat().get("maths").size(), "Il ne devrait y avoir qu'une note en maths");

        etu.ajouterNote("maths", 9);
        assertEquals(11.5, etu.getResultat().get("maths").getFirst(), "La note de maths devrait être 11.5");
        assertEquals(9, etu.getResultat().get("maths").get(1), "La deuxième note de maths devrait être 9");
        assertEquals(2, etu.getResultat().get("maths").size(), "Il devrait y avoir deux notes en maths");

        FormationException fe = assertThrows(
                FormationException.class,
                () -> {etu.ajouterNote("Chinois", 10);}
        );

        NoteException ne1 = assertThrows(
                NoteException.class,
                () -> {etu.ajouterNote("maths", -10);}
        );

        NoteException ne2 = assertThrows(
                NoteException.class,
                () -> {etu.ajouterNote("maths", 21);}
        );
    }

    @Test
    public void testCalculerMoyen() throws FormationException, NoteException {
        etu.ajouterNote("maths", 11.5);
        etu.ajouterNote("maths", 9);

        double moyMaths = etu.calculerMoyen("maths");
        assertEquals(10.25, moyMaths, "La moyenne de maths devrait être 10.25");

        double moyCom = etu.calculerMoyen("communication");
        assertEquals(-1, moyCom, "La moyenne devrait être -1 car il n'y a pas de notes dans la matière. ");

        FormationException fe = assertThrows(
                FormationException.class,
                () -> {etu.calculerMoyen("Chinois");}
        );
    }

    @Test
    public void testMoyGeneral() throws FormationException, NoteException{
        etu.ajouterNote("maths", 11);
        etu.ajouterNote("maths", 9);
        etu.ajouterNote("communication", 16);

        double moy = etu.moyGeneral();
        assertEquals(12, moy, "La moyenne générale devrait être de 12. ");
    }
}