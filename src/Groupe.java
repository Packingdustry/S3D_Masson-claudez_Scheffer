import java.util.ArrayList;
import java.util.List;

public class Groupe {
    Formation formation;
    List<Etudiant> etudiants;

    public Groupe(Formation f) {
        this.formation = f;
        etudiants = new ArrayList<>();
    }

    /**
     * ajoute un étudiant au groupe, ssi celui-ci est de la même formation
     * @param etu etudiant à ajouter
     */
    public void adjEtu(Etudiant etu) throws FormationException {
        if (etu.getFormation().equals(formation)) {
            etudiants.add(etu);
        } else {
            throw new FormationException("L'étudiant n'est pas dans la formation du groupe. ");
        }
    }
}
