import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    public GrapheListe() {
        noeuds = new ArrayList<>(10);
        adjacence = new ArrayList<>(10);
    }

    public void ajouterArc(String depart, String destination, double count) {
        int ind1 = getIndice(depart);
        int ind2 = getIndice(destination);

        if (ind1 == -1) {
            ajouterNoeud(depart);
            ind1 = getIndice(depart);
        }
        if (ind2 == -1) {
            ajouterNoeud(destination);
            ind2 = getIndice(destination);
        }
        System.out.println(ind1 + " " + ind2);
        Arc a = new Arc(destination, count);
        Arcs as = adjacence.get(ind1);
        as.ajouterArc(a);
    }


    public int getIndice(String n) {
        for (int i = 0; i < this.noeuds.size()-1; i++) {
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

    public void ajouterNoeud(String n) {
        if (!noeuds.contains(n)) {
            noeuds.add(n);
            adjacence.add(new Arcs()); // Initialize an Arcs object for the new node
        }
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < this.noeuds.size(); i++) {
            res += this.noeuds.get(i) + " -> ";
            if (!(adjacence.isEmpty())){
                List<Arc> as = adjacence.get(i).getArcs();
                for (int j = 0; j < as.size(); j++) {
                    res += as.get(j).toString() + " ";
                }
                res += "\n";
            }
        }
        return res;
    }
}
