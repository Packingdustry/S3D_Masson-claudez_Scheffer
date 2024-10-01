import java.util.Comparator;

public class TriParMerite implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant etu1, Etudiant etu2) {

        double moy1 = 0;
        try {
            moy1 = etu1.moyGeneral();
        } catch (FormationException e) {
            e.getMessage();
        }

        double moy2 = 0;
        try {
            moy2 = etu2.moyGeneral();
        } catch (FormationException e) {
            e.getMessage();
        }

        int res = 0;
        if (moy1 < moy2) {
            res = -1;
        } else if (moy1 > moy2) {
            res = 1;
        }
        return res;
    }
}
