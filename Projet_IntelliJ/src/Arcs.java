import java.util.ArrayList;
import java.util.List;

public class Arcs {
    List<Arc> arcs;

    /**
     * Constructeur par défaut de l'objet
     */
    public Arcs() {
        arcs = new ArrayList<Arc>();
    }

    /**
     * Méthode d'ajout d'un arc
     *
     * @param a
     */
    public void ajouterArc(Arc a) {
        arcs.add(a);
    }

    /**
     * Méthode de renvoie de la liste des arc
     *
     * @return
     */
    public List<Arc> getArcs() {
        return arcs;
    }
}
