import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGraphe {

    @Test
    public void testGraphe() {

        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);

        List<String> noeuds = graphe.ListeNoeuds();
        assertTrue(noeuds.contains("A"));
        assertTrue(noeuds.contains("B"));
        assertTrue(noeuds.contains("D"));

        List<Arc> arcsA = graphe.suivants("A");
        assertEquals(2, arcsA.size());
        assertEquals("B", arcsA.get(0).getDest());
        assertEquals(12, arcsA.get(0).getCout());
        assertEquals("D", arcsA.get(1).getDest());
        assertEquals(87, arcsA.get(1).getCout());
    }
}


