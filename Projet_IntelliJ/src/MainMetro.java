import java.io.IOException;
import java.util.List;

public class MainMetro {

    public static void main(String[] args) {
        try {
            Graphe g2 = LireReseau.Lire("Graphe/plan.txt");
            for (int i = 0; i < 5; i++) {
                String depart = g2.ListeNoeuds().get((int) (Math.floor(Math.random() * 285)));
                String arrive = g2.ListeNoeuds().get((int) (Math.floor(Math.random() * 285)));
                Valeurs v = new Valeurs();
                Valeurs v2 = new Valeurs();
                Valeurs v3 = new Valeurs();
                BellmanFord bf = new BellmanFord();
                Dijkstra dj = new Dijkstra();


                long datedeb1 = System.nanoTime();
                v = bf.resoudre(g2, depart);
                long datefin1 = System.nanoTime();
                long execBellmanFord = datefin1 - datedeb1;
                long datedeb2 = System.nanoTime();
                v2 = dj.resoudre(g2, depart);
                long datefin2 = System.nanoTime();
                long execDijkstra1 = datefin2 - datedeb2;
                List<String> c1 = v.calculerChemin(arrive);
                System.out.println("\nDépart : " + depart + "\nArrivé : " + arrive);
                System.out.println(c1);
                System.out.println("Temps d'execution Dijkstra : " + execDijkstra1 + "ns\n" + "Temps d'execution de BerllmanFord : " + execBellmanFord + "ns\n===================================================================================");

            }
        } catch (IOException e) {
            System.out.println("LireReseau Erreur : " + e.getMessage());
        }

        try {
            Graphe g2 = LireReseau.Lire("Graphe/plan.txt");
            for (int i = 0; i < 5; i++) {
                String depart = g2.ListeNoeuds().get((int) (Math.floor(Math.random() * 285)));
                String arrive = g2.ListeNoeuds().get((int) (Math.floor(Math.random() * 285)));
                Valeurs v = new Valeurs();
                Valeurs v2 = new Valeurs();
                Valeurs v3 = new Valeurs();
                BellmanFord bf = new BellmanFord();
                Dijkstra dj = new Dijkstra();


                long datedeb1 = System.nanoTime();
                v = bf.resoudre2(g2, depart);
                long datefin1 = System.nanoTime();
                long execBellmanFord = datefin1 - datedeb1;
                long datedeb2 = System.nanoTime();
                v2 = dj.resoudre2(g2, depart);
                long datefin2 = System.nanoTime();
                long execDijkstra1 = datefin2 - datedeb2;
                List<String> c1 = v.calculerChemin(arrive);
                System.out.println("\nDépart : " + depart + "\nArrivé : " + arrive);
                System.out.println(c1);
                System.out.println("Temps d'execution Dijkstra : " + execDijkstra1 + "ns\n" + "Temps d'execution de BerllmanFord : " + execBellmanFord + "ns\n===================================================================================");

            }
        } catch (IOException e) {
            System.out.println("LireReseau Erreur : " + e.getMessage());
        }
    }
}
