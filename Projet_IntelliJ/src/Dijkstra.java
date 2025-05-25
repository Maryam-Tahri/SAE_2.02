import java.util.*;

public class Dijkstra implements Resoudre {

    public Dijkstra() {}

    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();
        List<String> noeuds = g.ListeNoeuds();
        List<String> Q = new ArrayList<>(noeuds);

        for (String v : noeuds) {
            valeurs.setValeur(v, Double.MAX_VALUE);
            valeurs.setParent(v, null);
        }

        valeurs.setValeur(depart, 0.0);

        while (!Q.isEmpty()) {
            String u = trouverMin(Q, valeurs);
            Q.remove(u);
            for (Arc arc : g.suivants(u)) {
                String v = arc.getDest();
                if (Q.contains(v)) {
                    double d = valeurs.getValeur(u) + arc.getCout();
                    if (d < valeurs.getValeur(v)) {
                        valeurs.setValeur(v, d);
                        valeurs.setParent(v, u);
                    }
                }
            }
        }
        return valeurs;
    }

    private String trouverMin(List<String> Q, Valeurs valeurs) {
        String minNoeud = null;
        double minValeur = Double.MAX_VALUE;
        for (String noeud : Q) {
            double val = valeurs.getValeur(noeud);
            if (val < minValeur) {
                minValeur = val;
                minNoeud = noeud;
            }
        }
        return minNoeud;
    }
}