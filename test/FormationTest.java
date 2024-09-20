import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormationTest {
    public Formation f;
    @BeforeEach
    void setUp() {
        this.f = new Formation("1");

    }
    @Test
    void ajouter() {
        //test d'ajout simple
        f.ajouter("Math",1);
        assertEquals(f.getMatEnseign().get("Math"),1.00);
        //test d'ajout de la meme matière le coef est censé etre le meme que le premier
        f.ajouter("Math",2);
        assertEquals(f.getMatEnseign().get("Math"),1.00);
    }

    @Test
    void modifier() {
        //Modif simple
        f.ajouter("Math",1);
        f.modifier("Math",2);
        assertEquals(f.getMatEnseign().get("Math"),2.00);
        //modifier quelque chose qui n'existe pas
        f.modifier("English",3);
        assertEquals(f.getMatEnseign().get("English"),null);
    }

    @Test
    void supprimer() {
        f.ajouter("Math",1);
        f.ajouter("English",2);
        //suppression simple
        f.supprimer("Math");
        assertEquals(f.getMatEnseign().get("Math"),null);
        //suppression simple
        f.supprimer("English");
        assertEquals(f.getMatEnseign().get("English"),null);

    }

    @Test
    void accesCoeff() {
        f.ajouter("Math",1);
        f.ajouter("English",2);
        //acces simple
        assertEquals(f.accesCoeff("Math"),1.00);
        assertEquals(f.accesCoeff("English"),2.00);
        //acces non existant
        assertEquals(f.accesCoeff("Histoire"),null);
    }
}