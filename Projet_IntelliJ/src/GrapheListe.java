import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    public GrapheListe() {
        noeuds = new ArrayList<String>();
        adjacence = new ArrayList<Arcs>();
    }

    public void ajouterArc(String depart, String destination, double count) {
        int ind1 = getIndice(depart);
        int ind2 = getIndice(destination);
        if (ind1 == -1) {
            noeuds.add(depart);
        }
        if (ind2 == -1) {
            noeuds.add(destination);
        }
        Arc a = new Arc(destination, count);
        ind1 = getIndice(depart);
        Arcs as = adjacence.get(ind1);
        as.ajouterArc(a);

    }


    public int getIndice(String n) {
        for (int i = 0; i < this.noeuds.size(); i++) {
            if (this.noeuds.get(i).equals(n)) {
                return i;
            }
        }
        return -1;
    }

    public List<String> ListeNoeuds() {
        return this.noeuds;
    }

    public List<Arc> suivants(String s) {
        int ind = getIndice(s);
        return adjacence.get(ind).getArcs();
    }

    public void ajouterNoeud(String n){
        noeuds.add(n);
    }
}
