import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GrapheListe graph = new GrapheListe();

        graph.ListeNoeuds().add("A");
        graph.ListeNoeuds().add("B");
        graph.ListeNoeuds().add("C");
        graph.ListeNoeuds().add("D");
        graph.ListeNoeuds().add("E");

        graph.ajouterArc("A", "B", 12);
        graph.ajouterArc("A", "D", 87);
        graph.ajouterArc("B", "E", 11);
        graph.ajouterArc("C", "A", 10);
        graph.ajouterArc("D", "C", 10);
        graph.ajouterArc("D", "B", 23);
        graph.ajouterArc("E", "D", 43);
    }
}