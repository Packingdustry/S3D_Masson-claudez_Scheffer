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

    public double moyGroupe(String name) throws FormationException {
        double moyenne = 0;
        int diviseur = etudiants.size();
        if(!etudiants.isEmpty()){
            if(formation.accesCoeff(name)!=null){
                for(int i = 0 ;i<etudiants.size();i++){
                    if(etudiants.get(i).calculerMoyen(name) == -1){
                        diviseur--;
                    }else{
                        moyenne += etudiants.get(i).calculerMoyen(name);
                    }
                }
            }else{
                throw new FormationException("La matiere n'est pas dans la formation");
            }
        }else{
            throw new IllegalAccessError("La liste est vide");
        }
        return moyenne/diviseur;
    }

    public double moyGeneral() throws FormationException {
        double moyenne = 0 ;
        if(!etudiants.isEmpty()){
            for(int i = 0 ;i<etudiants.size();i++){
                moyenne += etudiants.get(i).moyGeneral();
            }
        }
        return moyenne/etudiants.size();
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

    /**
     * trie la liste d'étudiants dans l'ordre de leurs résultats.
     */
    public void triParMerite() {
        this.etudiants.sort(new TriParMerite());
    }
}
