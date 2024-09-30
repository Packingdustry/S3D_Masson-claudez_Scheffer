import java.util.Comparator;

public class TriAntiAlpha implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant etu1, Etudiant etu2) {
        String nom1 = etu1.getId().getNom();
        String nom2 = etu2.getId().getNom();
        String prenom1 = etu1.getId().getPrenom();
        String prenom2 = etu2.getId().getPrenom();
        if (nom1.equals(nom2)) {
            return -prenom1.compareTo(prenom2);
        } else {
            return -nom1.compareTo(nom2);
        }
    }
}
