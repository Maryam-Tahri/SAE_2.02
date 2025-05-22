import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDijkstra {
    @Test
    public void testResoudreParentChemin() {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("E", "D", 43);
        graphe.ajouterArc("C", "A", 19);

        Dijkstra dijkstra= new Dijkstra();
        Valeurs valeurs = dijkstra.resoudre(graphe, "A");

        assertEquals(null, valeurs.getParent("A"));
        assertEquals("A", valeurs.getParent("B"));
        assertEquals("D", valeurs.getParent("C"));
        assertEquals("E", valeurs.getParent("D"));
        assertEquals("B", valeurs.getParent("E"));
    }


    @Test
    public void testResoudreValeurChemin() {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("E", "D", 43);
        graphe.ajouterArc("C", "A", 19);

        Dijkstra dijkstra= new Dijkstra();
        Valeurs valeurs = dijkstra.resoudre(graphe, "A");

        assertEquals(0, valeurs.getValeur("A"));
        assertEquals(12, valeurs.getValeur("B"));
        assertEquals(76, valeurs.getValeur("C"));
        assertEquals(66, valeurs.getValeur("D"));
        assertEquals(23, valeurs.getValeur("E"));

    }
}
