import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class FormationTest {
    public Formation f;
    @BeforeEach
    void setUp() {
        this.f = new Formation("1");

    }
    @org.junit.jupiter.api.Test
    void ajouter() {
        //test d'ajout simple
        f.ajouter("Math",1);
        assertEquals(f.getMap().get("Math"),1.00);
        //test d'ajout de la meme matière le coef est censé etre le meme que le premier
        f.ajouter("Math",2);
        assertEquals(f.getMap().get("Math"),1.00);
    }

    @org.junit.jupiter.api.Test
    void modifier() {
        f.ajouter("Math",1);
        f.modifier("Math",2);
        assertEquals(f.getMap().get("Math"),2.00);
        f.modifier("English",3);
        assertEquals(f.getMap().get("English"),null);
    }

    @org.junit.jupiter.api.Test
    void supprimer() {
    }

    @org.junit.jupiter.api.Test
    void accesCoeff() {
    }
}