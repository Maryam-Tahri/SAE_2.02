import java.util.List;

public interface Graphe {
    public List<String> ListeNoeuds();
    public List<Arc> suivants(String n);
}
