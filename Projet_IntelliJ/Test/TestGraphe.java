import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestGraphe {

    @Test
    public void testGrapheContientNoeud() {

        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);

        List<String> noeuds = graphe.ListeNoeuds();
        assertTrue(noeuds.contains("A"));
        assertTrue(noeuds.contains("B"));
        assertTrue(noeuds.contains("D"));

    }
    
    @Test
    public void testGrapheSuivantOk() {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);

        List<Arc> arcsA = graphe.suivants("A");
        assertEquals(2, arcsA.size());
        assertEquals("B", arcsA.get(0).getDest());
        assertEquals(12, arcsA.get(0).getCout());
        assertEquals("D", arcsA.get(1).getDest());
        assertEquals(87, arcsA.get(1).getCout());
    }

    @Test
    public void testGrapheArcInconnu(){
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);

        assertEquals(-1 , graphe.getIndice("C"));
    }
}


