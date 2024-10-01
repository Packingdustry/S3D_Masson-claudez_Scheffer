import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupeTest {
    public Formation f;
    public Groupe g;
    public Etudiant e,e1,e2;
    @BeforeEach
    public void init() throws NoteException, FormationException {
        this.f = new Formation("Informatique");
        f.ajouter("Reseau",1);
        f.ajouter("Dev web",1);
        f.ajouter("Algo",2);
        this.g = new Groupe(f);
        e = new Etudiant(new Identite("1","Robert","Alfred"),f);
        e1 = new Etudiant(new Identite("2","Soa","Astrid"),f);
        e2 = new Etudiant(new Identite("3","Green","Thomas"),f);
       e.ajouterNote("Dev web",12);
       e.ajouterNote("Dev web",10);
       e.ajouterNote("Dev web",11);
       e.ajouterNote("Dev web",15);

       e.ajouterNote("Reseau",12);
       e.ajouterNote("Reseau",10);
       e.ajouterNote("Reseau",11);

       e.ajouterNote("Algo",9);
       e.ajouterNote("Algo",8);
       e.ajouterNote("Algo",10);

       e1.ajouterNote("Dev web",9);
       e1.ajouterNote("Dev web",8);
       e1.ajouterNote("Dev web",10);

        e1.ajouterNote("Reseau",9);
        e1.ajouterNote("Reseau",8);
        e1.ajouterNote("Reseau",10);

        e2.ajouterNote("Dev web",12);
        e2.ajouterNote("Dev web",10);
        e2.ajouterNote("Dev web",11);

        e2.ajouterNote("Reseau",12);
        e2.ajouterNote("Reseau",10);
        e2.ajouterNote("Reseau",11);

        e2.ajouterNote("Algo",9);
        e2.ajouterNote("Algo",8);
        e2.ajouterNote("Algo",10);
        g.adjEtu(e);
        g.adjEtu(e1);
        g.adjEtu(e2);
    }
    @Test
    public void testAjout() throws FormationException {
        Etudiant e1 = new Etudiant(new Identite("001","sch","Benj"),f);
        Etudiant e2 = new Etudiant(new Identite("002","sch","Benj"),new Formation("GE2I"));
        g.adjEtu(e1);
        //Etudiant e = g.getEtudiants().get(0);
        //assertEquals(e,e1);
        FormationException f = assertThrows(
                FormationException.class , ()->  g.adjEtu(e2)
        );
    }

    @Test
    public void testSupr() throws FormationException, EtudiantException {
        Etudiant e1 = new Etudiant(new Identite("001","sch","Benj"),f);
        Etudiant e2 = new Etudiant(new Identite("002","sch","Benj"),new Formation("GE2I"));
        g.adjEtu(e1);
        //Etudiant e = g.getEtudiants().get(0);
        //assertEquals(e,e1);
        g.suppEtu(e1);
        EtudiantException e3 = assertThrows(EtudiantException.class,()->g.suppEtu(e2));
    }
    @Test
    public void testMoy() throws FormationException {
        double d = g.moyGroupe("Dev web");
        assertEquals(d,10.666666666666666);
        d = g.moyGroupe("Reseau");
        assertEquals(d,10.333333333333334);
        d= g.moyGroupe("Algo");
        assertEquals(d,9);
    }

    @Test
    public void testMoyG() throws FormationException {
        double d = g.moyGeneral();
        assertEquals(d,9.75);
    }

    @Test
    public void testTriAlpha() throws FormationException{


        g.triALpha();
        assertEquals(e2, g.getEtudiants().get(0));
        assertEquals(e, g.getEtudiants().get(1));
        assertEquals(e1, g.getEtudiants().get(2));

        g.triAntiAlpha();
        assertEquals(e1, g.getEtudiants().get(2));
        assertEquals(e, g.getEtudiants().get(1));
        assertEquals(e2, g.getEtudiants().get(0));

    }
}