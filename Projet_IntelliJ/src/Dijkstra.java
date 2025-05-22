import java.util.*;

public class Dijkstra {

    public static Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();
        List<String> noeuds = g.ListeNoeuds();
        List<String> Q = new ArrayList<>(noeuds);

        for (String v : g.ListeNoeuds()) {
            valeurs.setValeur(v, Double.MAX_VALUE);
            valeurs.setParent(v, null);
            Q.add(v);
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

    private static String trouverMin(List<String> Q, Valeurs valeurs) {
        String minSommet = null;
        double minValeur = Double.MAX_VALUE;
        for (String s : Q) {
            double val = valeurs.getValeur(s);
            if (val < minValeur) {
                minValeur = val;
                minSommet = s;
            }
        }
        return minSommet;
    }
}


