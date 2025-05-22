import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GrapheListe graph = new GrapheListe();

        graph.ajouterNoeud("A");
        graph.ajouterNoeud("B");
        graph.ajouterNoeud("C");
        graph.ajouterNoeud("D");
        graph.ajouterNoeud("E");

        graph.ajouterArc("A", "B", 12);
        graph.ajouterArc("A", "D", 87);
        graph.ajouterArc("B", "E", 11);
        graph.ajouterArc("C", "A", 10);
        graph.ajouterArc("D", "C", 10);
        graph.ajouterArc("D", "B", 23);
        graph.ajouterArc("E", "D", 43);

        System.out.println(graph.toString());


    }
}