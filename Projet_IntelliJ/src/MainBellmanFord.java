public class MainBellmanFord {

    public static void main(String[] args) {
        GrapheListe graph = new GrapheListe();

        graph.ajouterArc("A", "B", 12);
        graph.ajouterArc("A", "D", 87);
        graph.ajouterArc("B", "E", 11);
        graph.ajouterArc("C", "A", 10);
        graph.ajouterArc("D", "C", 10);
        graph.ajouterArc("D", "B", 23);
        graph.ajouterArc("E", "D", 43);

        Valeurs v =  new Valeurs();
        BellmanFord bf = new BellmanFord();
        v = bf.resoudre(graph,"A");
        //System.out.println(v.toString());
    }
}
