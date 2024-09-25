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
    public void testAjout(){
        Etudiant e1 = new Etudiant(new Identite("001","sch","Benj"),f);
        Etudiant e2 = new Etudiant(new Identite("002","sch","Benj"),new Formation("GE2I"));
        g.adjEtu(e1);

        FormationException f = assertThrows(
                FormationException.class , ()->  g.adjEtu(e2)
        );
    }

    @Test
    public void testSupr(){
        Etudiant e1 = new Etudiant(new Identite("001","sch","Benj"),f);
        Etudiant e2 = new Etudiant(new Identite("002","sch","Benj"),new Formation("GE2I"));
        g.adjEtu(e1);
        g.suppEtu(e1);
        EtudiantException e = assertThrows(EtudiantException.class,()->g.suppEtu(e2));
    }
}