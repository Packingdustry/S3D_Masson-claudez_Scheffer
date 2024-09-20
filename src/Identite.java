public class Identite {

    /**
     * NIP indentifiant unique
     * nom, prenom de l'étudiant
     */
    private String NIP,nom,prenom;

    /**
     * Constructeur qui remplit les attributs
     * @param NIP NIP
     * @param n nom
     * @param p prenom
     */
    public Identite(String NIP,String n, String p) {
        this.NIP = NIP;
        this.nom = n;
        this.prenom = p;
    }

    /**
     * Methode equals qui retourne true si le NIP le nom et le prenom sont egaux
     * a l'objet passer en parametre
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Identite) {
            Identite e =  (Identite) obj;
            if(this.NIP.equals(e.NIP)&&this.nom.equals(e.nom)&&this.prenom.equals(e.prenom)){
                return true;
            }
        }
        return false;
    }
}
