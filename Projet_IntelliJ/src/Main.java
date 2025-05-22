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
        //System.out.println(v.toString());

        Valeurs v2 =  new Valeurs();
        Dijkstra dj = new Dijkstra();
        v = dj.resoudre(graph,"A");
        //System.out.println(v.toString());

        GrapheListe g = new GrapheListe("Graphe/Graphe1.txt");
        //System.out.println(g.toString());
        v = dj.resoudre(g,"1");
        v2 = bf.resoudre(g,"1");
        System.out.println("Graphe 1 Dijkstra :"+v.toString() + "\n\nGraphe 1 BellmanFord :" + v2.toString());


        g = new GrapheListe("Graphe/Graphe15.txt");
        v = dj.resoudre(g,"1");
        v2 = bf.resoudre(g,"1");
        System.out.println("Graphe 15 Dijkstra :"+v.toString() + "\n\nGraphe 15 BellmanFord :" + v2.toString());


        g = new GrapheListe("Graphe/Graphe31.txt");
        v = dj.resoudre(g,"1");
        v2 = bf.resoudre(g,"1");
        System.out.println("Graphe 31 Dijkstra :"+v.toString() + "\n\nGraphe 31 BellmanFord :" + v2.toString());

        g = new GrapheListe("Graphe/Graphe45.txt");
        v = dj.resoudre(g,"1");
        v2 = bf.resoudre(g,"1");
        System.out.println("Graphe 45 Dijkstra :"+v.toString() + "\n\nGraphe 45 BellmanFord :" + v2.toString());


        g = new GrapheListe("Graphe/Graphe66.txt");
        v = dj.resoudre(g,"1");
        v2 = bf.resoudre(g,"1");
        System.out.println("Graphe 66 Dijkstra :"+v.toString() + "\n\nGraphe 66 BellmanFord :" + v2.toString());


    }
}