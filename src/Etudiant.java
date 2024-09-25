import java.util.*;

public class Etudiant {
    /**
     * L'étudiant est caractérisé par un objet identité
     * une formation
     * et une map qui pour une matière donner donne la liste des notes de cette matière
     */
    private Identite id;
    private Formation formation;
    private Map<String, ArrayList<Double>> resultat;

    /**
     * Constructeur d'un etudiant qui lui affecte une identité et une formation
     * Et genere une map vide
     * @param id identité
     * @param f formation
     */
    public Etudiant(Identite id,Formation f){
        this.id = id;
        this.formation = f;
        this.resultat = new HashMap<String, ArrayList<Double>>();
    }

    /**
     * Method d'ajouts d'une note
     * Renvoie des exceptions si :
     * - La note n'est pas entre 0 et 20
     * - La matire n'est pas dans la formation
     * @param n Nom de la matière
     * @param note Note a ajouter
     * @throws NoteException Exception sur la note
     * @throws FormationException Exception sur la formation
     */
    public void ajouterNote(String n, double note) throws NoteException, FormationException {
        if(note>0 && note<=20){
            if(this.formation.accesCoeff(n)!=null){
                if(!resultat.containsKey(n)){
                    ArrayList<Double> a = new ArrayList<Double>();
                    a.add(note);
                    resultat.put(n,a);
                }else{
                    resultat.get(n).add(note);
                }
            }else{
                throw new FormationException(n + "\nCette matière n'est pas dans la formation.");
            }
        }else{
            throw new NoteException(String.valueOf(note) + "\nCette note n'est pas entre 0 et 20.");
        }
    }

    /**
     * Cette méthode calcule la moyen pour une matière donner
     * Elle throw une exception si la matière n'est pas dans la formation
     * Et retourne -1 si il n'y a pas de note
     * @param nom matière
     * @return double
     * @throws FormationException
     */
    public double calculerMoyen(String nom) throws FormationException {
        double moy = 0;
        if(this.formation.accesCoeff(nom)!=null){
            if(resultat.containsKey(nom)){
                ArrayList<Double> notes = resultat.get(nom);
                for(int i =0;i<notes.size();i++){
                 moy += notes.get(i);
                }
                moy = moy / notes.size();
            }else{
                moy =-1;
            }
        }else{
            throw new FormationException(nom +"\nCette matière n'est pas dans la formation de l'étudiant");
        }
        return moy;
    }

    /**
     * Methode qui calcule la moyenne general de l'élève avec les coefs
     * La methode recupère la moyenne par matière la multiplie par son coef
     * Et divise le total par la somme les coefs
     * @return
     * @throws FormationException
     */
    public double moyGeneral() throws FormationException {
        double moy = 0;
        double div = 0;
        Collection<String> c = resultat.keySet();
        Iterator<String> it = c.iterator();
        while(it.hasNext()){
            String nom = it.next();
            double coef = this.formation.accesCoeff(nom);
            if(calculerMoyen(nom)!=-1){
                div +=coef;
                moy += calculerMoyen(nom) * coef;
            }
        }
        return moy/div;
    }

    /**
     * Getter ID
     * @return Identite
     */

    public Identite getId() {
        return id;
    }

    /**
     * Getter formation
     * @return Formation
     */

    public Formation getFormation() {
        return formation;
    }

    /**
     *Getter Map
     * @return Map
     */

    public Map<String, ArrayList<Double>> getResultat() {
        return resultat;
    }
}
