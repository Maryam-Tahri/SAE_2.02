public class Arc {
    private String dest;
    private double cout;
    private String ligne;

    /**
     * Constructeur qui prend en paramètre la destination et le cout d'un arc
     *
     * @param dest
     * @param cout
     */
    public Arc(String dest, double cout) {
        this.dest = dest;
        if (cout > 0) {
            this.cout = cout;
        }
        this.ligne = "Aucune"; // pas de ligne
    }

    /**
     * Constructeur qui prend en paramètre la destination et le cout d'un arc et le numéro de ligne
     *
     * @param dest
     * @param cout
     * @param ligne
     */
    public Arc(String dest, double cout, String ligne) {
        this.dest = dest;
        this.cout = cout;
        this.ligne = ligne;
    }

    /**
     * Méthode qui renvoie le numéro de ligne de l'arc
     *
     * @return String
     */
    public String getLigne() {
        return ligne;
    }

    /**
     * Méthode qui renvoie la destination de l'arc
     *
     * @return String
     */
    public String getDest() {
        return dest;
    }

    /**
     * Méthode qui renvoie la pondération de l'arc
     *
     * @return
     */
    public double getCout() {
        return cout;
    }

    /**
     * Méthode qui renvoie l'affichage de l'arc
     *
     * @return
     */
    public String toString() {
        return "(" + dest + ", " + cout + ", ligne " + ligne + ")";
    }
}