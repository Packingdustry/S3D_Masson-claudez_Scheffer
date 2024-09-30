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

    /**
     * supprime l'étudiant passé en paramètre du Groupe
     * @param etu etudiant à supprimer
     */
    public void suppEtu(Etudiant etu) throws EtudiantException {
        if (etudiants.contains(etu)) {
            etudiants.remove(etu);
        } else {
            throw new EtudiantException("L'étudiant n'est pas dans le groupe. ");
        }
    }

    public Formation getFormation() {
        return formation;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    /**
     * trie la liste d'étudiants dans l'ordre alphabétique.
     */
    public void triALpha() {
        this.etudiants.sort(new TriAlpha());
    }

    /**
     * trie la liste d'étudiants dans l'ordre alphabétique inverse (de Z à A).
     */
    public void triAntiAlpha() {
        this.etudiants.sort(new TriAntiAlpha());
    }
}
