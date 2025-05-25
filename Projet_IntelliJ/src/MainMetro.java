import java.io.IOException;
import java.util.List;

public class MainMetro {

    public static void main(String[] args) {
        try{
            Graphe g2 = LireReseau.Lire("Graphe/plan.txt");
            for (int i = 0;i <5;i++){
                String depart = g2.ListeNoeuds().get((int)(Math.floor(Math.random()*285)));
                String arrive = g2.ListeNoeuds().get((int)(Math.floor(Math.random()*285)));
                Valeurs v =  new Valeurs();
                Valeurs v2 =  new Valeurs();
                BellmanFord bf = new BellmanFord();
                Dijkstra dj = new Dijkstra();
                v = bf.resoudre(g2,depart);
                v2 = dj.resoudre(g2,depart);
                List<String> c1 = v.calculerChemin(arrive);
                List<String> c2 = v2.calculerChemin(arrive);
                System.out.println(c1);
                System.out.println(c2);
            }
        }catch(IOException e){
            System.out.println("LireReseau Erreur : "+e.getMessage());
        }
    }
}
