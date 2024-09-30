import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupeTest {
    public Formation f;
    public Groupe g;
    @BeforeEach
    public void init(){
        this.f = new Formation("Informatique");
        f.ajouter("Archi",2);
        f.ajouter("System",3);
        f.ajouter("Dev web",1);
        f.ajouter("Base Prog",2);
        f.ajouter("Algo",4);
        this.g = new Groupe(f);
    }

    @Test
    public void testAjout() throws FormationException {
        Etudiant e1 = new Etudiant(new Identite("001","sch","Benj"),f);
        Etudiant e2 = new Etudiant(new Identite("002","sch","Benj"),new Formation("GE2I"));
        g.adjEtu(e1);
        Etudiant e = g.getEtudiants().get(0);
        assertEquals(e1,e);
        FormationException f = assertThrows(
                FormationException.class , ()->  g.adjEtu(e2)
        );
    }

    @Test
    public void testSupr() throws FormationException, EtudiantException {
        Etudiant e1 = new Etudiant(new Identite("001","sch","Benj"),f);
        Etudiant e2 = new Etudiant(new Identite("002","sch","Benj"),new Formation("GE2I"));
        g.adjEtu(e1);
        Etudiant e = g.getEtudiants().get(0);
        assertEquals(e,e1);
        g.suppEtu(e1);
        EtudiantException e3 = assertThrows(EtudiantException.class,()->g.suppEtu(e2));
    }

    @Test
    public void testTriAlpha() throws FormationException{
        Etudiant e1 = new Etudiant(new Identite("001", "Masson", "Aloïs"), f);
        Etudiant e2 = new Etudiant(new Identite("002", "Dupont", "Pierre"), f);
        Etudiant e3 = new Etudiant(new Identite("003", "Dupont", "Jean"), f);
        g.adjEtu(e1);
        g.adjEtu(e2);
        g.adjEtu(e3);

        g.triALpha();
        assertEquals(e3, g.getEtudiants().get(0));
        assertEquals(e2, g.getEtudiants().get(1));
        assertEquals(e1, g.getEtudiants().get(2));

        g.triAntiAlpha();
        assertEquals(e3, g.getEtudiants().get(2));
        assertEquals(e2, g.getEtudiants().get(1));
        assertEquals(e1, g.getEtudiants().get(0));

    }
}