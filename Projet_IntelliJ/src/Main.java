import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GrapheListe graph = new GrapheListe();

        graph.ajouterArc("A", "B", 12);
        graph.ajouterArc("A", "D", 87);
        graph.ajouterArc("B", "E", 11);
        graph.ajouterArc("C", "A", 10);
        graph.ajouterArc("D", "C", 10);
        graph.ajouterArc("D", "B", 23);
        graph.ajouterArc("E", "D", 43);

        System.out.println(graph.toString());

        Valeurs v =  new Valeurs();
        BellmanFord bf = new BellmanFord();
        v = bf.resoudre(graph,"A");
        System.out.println(v.toString());

        Valeurs v2 =  new Valeurs();
        Dijkstra dj = new Dijkstra();
        v = dj.resoudre(graph,"A");
        System.out.println(v.toString());

        GrapheListe g = new GrapheListe("Graphe/Graphe1.txt");
        System.out.println(g.toString());
    }
}