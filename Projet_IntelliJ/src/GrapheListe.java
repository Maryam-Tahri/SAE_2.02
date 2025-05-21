import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    public void ajouterArc(String depart, String destination, double count){
        throw new Error("TODO");
    }

    public int getIndice(String n){
        for (int i = 0; i < this.noeuds.size(); i++) {
            if (this.noeuds.get(i).equals(n)){
                return i;
            }
        }
        return -1;
    }

    public List<String> ListeNoeuds(){
        return this.noeuds;
    }

    public List<Arc> suivants(String s){
        int ind = getIndice(s);
        return adjacence.get(ind).getArcs();
    }
}
