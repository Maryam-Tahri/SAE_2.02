import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Valeurs v = new Valeurs();
        Valeurs v2 = new Valeurs();
        BellmanFord bf = new BellmanFord();
        Dijkstra dj = new Dijkstra();

        GrapheListe g = new GrapheListe("Graphe/Graphe1.txt");
        //System.out.println(g.toString());
        long datedeb1 = System.nanoTime();
        v = dj.resoudre(g,"1");
        long datefin1 = System.nanoTime();
        long dateexec1 = datefin1-datedeb1;
        long datedeb2 = System.nanoTime();
        v2 = bf.resoudre(g,"1");
        long datefin2 = System.nanoTime();
        long dateexec2 = datefin2-datedeb2;
        System.out.println("Graphe 1 Dijkstra :\n"+v.toString() + "\ntemps d'éxecution de Dijkstra ; " + dateexec1 +"ms\nGraphe 1 BellmanFord :\n" + v2.toString() +"\nTemps d'éxecution de bellmanFord\n"+dateexec2+"ms");


        g = new GrapheListe("Graphe/Graphe15.txt");
        datedeb1 = System.nanoTime();
        v = dj.resoudre(g,"1");
        datefin1 = System.nanoTime();
        dateexec1 = datefin1-datedeb1;
        datedeb2 = System.nanoTime();
        v2 = bf.resoudre(g,"1");
        datefin2 = System.nanoTime();
        dateexec2 = datefin2-datedeb2;
        System.out.println("Graphe 15 Dijkstra :\n"+v.toString() + "\ntemps d'éxecution de Dijkstra :" + dateexec1 +"ms\nGraphe 15 BellmanFord :\n" + v2.toString() +"\nTemps d'éxecution de bellmanFord\n"+dateexec2+"ms");

        g = new GrapheListe("Graphe/Graphe31.txt");
        datedeb1 = System.nanoTime();
        v = dj.resoudre(g,"1");
        datefin1 = System.nanoTime();
        dateexec1 = datefin1-datedeb1;
        datedeb2 = System.nanoTime();
        v2 = bf.resoudre(g,"1");
        datefin2 = System.nanoTime();
        dateexec2 = datefin2-datedeb2;
        System.out.println("Graphe 31 Dijkstra :\n"+v.toString() + "\ntemps d'éxecution de Dijkstra ; " + dateexec1 +"ms\nGraphe 31 BellmanFord :\n" + v2.toString() +"\nTemps d'éxecution de bellmanFord : "+dateexec2+"ms");

        g = new GrapheListe("Graphe/Graphe45.txt");
        datedeb1 = System.nanoTime();
        v = dj.resoudre(g,"1");
        datefin1 = System.nanoTime();
        dateexec1 = datefin1-datedeb1;
        datedeb2 = System.nanoTime();
        v2 = bf.resoudre(g,"1");
        datefin2 = System.nanoTime();
        dateexec2 = datefin2-datedeb2;
        System.out.println("Graphe 45 Dijkstra :\n"+v.toString() + "\ntemps d'éxecution de Dijkstra : " + dateexec1 +"ms\nGraphe 45 BellmanFord :\n" + v2.toString() +"\nTemps d'éxecution de bellmanFord : "+dateexec2+"ms");

        g = new GrapheListe("Graphe/Graphe66.txt");
        datedeb1 = System.nanoTime();
        v = dj.resoudre(g,"1");
        datefin1 = System.nanoTime();
        dateexec1 = datefin1-datedeb1;
        datedeb2 = System.nanoTime();
        v2 = bf.resoudre(g,"1");
        datefin2 = System.nanoTime();
        dateexec2 = datefin2-datedeb2;
        System.out.println("Graphe 66 Dijkstra :\n"+v.toString() + "\ntemps d'éxecution de Dijkstra : " + dateexec1 +"ms\nGraphe 66 BellmanFord :\n" + v2.toString() +"\nTemps d'éxecution de bellmanFord : "+dateexec2+"ms");


    }
}