import java.util.HashMap;
import java.util.Map;

public class Formation {
    /**
     * id : identifiant de la formation
     * matEnseign : hashMap associant les matières de la formation à leurs coefficients.
     */
    private String id;
    private Map<String, Double> matEnseign;

    public Formation(String nom) {
        this.id = nom;
        this.matEnseign = new HashMap<>();
    }

    /**
     * ajoute une matière à la formation si celle-ci n'existe pas, sinon rien ne se passe
     * @param matiere matière à ajouter
     * @param coeff coefficient de la matière dans la formation
     */
    public void ajouter(String matiere, double coeff) {
        if (!this.matEnseign.containsKey(matiere))
            this.matEnseign.put(matiere, coeff);
    }

    /**
     * modifie une matière de la formation si celle-ci existe déjà, sinon rien ne se passe
     * @param matiere matière à ajouter
     * @param coeff coefficient de la matière dans la formation
     */
    public void modifier(String matiere, double coeff) {
        if (this.matEnseign.containsKey(matiere))
            this.matEnseign.put(matiere, coeff);
    }

    /**
     * retire une matière de la formation
     * @param matiere matière à retirer
     */
    public void supprimer(String matiere) {
        this.matEnseign.remove(matiere);
    }

    public String getId() {
        return id;
    }

    public Map<String, Double> getMatEnseign() {
        return matEnseign;
    }

    /**
     * Renvoie le coeff associé à une matière. Si elle n'existe pas, renvoie null
     * @param matiere matière dont on cherche le coeff
     * @return coeff recherché
     */
    public Double accesCoeff(String matiere) {
        return matEnseign.get(matiere);
    }

    @Override
    public boolean equals(Object o) {
        boolean res = true;
        Formation f = (Formation) o;
        if (!this.id.equals(f.getId())) {
            return false;
        } else {
            if (matEnseign.size() != f.getMatEnseign().size()) {
                return false;
            }
            for (String matiere: matEnseign.keySet()) {
                if (!matEnseign.get(matiere).equals(f.getMatEnseign().get(matiere))) {
                    return false;
                }
            }
        }
        return true;
    }
}
