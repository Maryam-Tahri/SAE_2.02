import java.util.ArrayList;

public class GrapheListe implements Graphe{
    private ArrayList<String> Noeuds;
    private ArrayList<Arcs> adjacence;

    public void ajouterArc(String depart, String destination, double count){
        throw new Error("TODO");
    }

    public int getIndice(String n){
        for (int i = 0; i < Noeuds.size(); i++) {
            if (Noeuds.get(i).equals(n)){
                return i;
            }
        }
        return -1;
    }
}
