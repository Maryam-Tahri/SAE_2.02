import java.util.ArrayList;
import java.util.List;

public class Arcs {
    List<Arc> arcs;

    public Arcs() {
        arcs = new ArrayList<Arc>();
    }

    public void ajouterArc(Arc a) {
        arcs.add(a);
    }

    public List<Arc> getArcs() {
        return arcs;
    }
}
