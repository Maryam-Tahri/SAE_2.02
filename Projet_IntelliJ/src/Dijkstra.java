import java.util.*;

public class Dijkstra implements Resoudre {
    /**
     * Constructeur par défaut
     */
    public Dijkstra() {}

    /**
     * Méthode qui permet d'appliquer l'algorithme de Dijkstra
     * @param g
     * @param depart
     * @return
     */
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

    /**
     * Méthode qui permet d'appliquer l'algorithme de Dijkstra en rajoutant une pénalité de temps sur les changement de ligne
     * @param g
     * @param depart
     * @return
     */
    public Valeurs resoudre2(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();
        List<String> noeuds = g.ListeNoeuds();
        List<String> Q = new ArrayList<>(noeuds);
        String ligne="";

        for (String v : noeuds) {
            valeurs.setValeur(v, Double.MAX_VALUE);
            valeurs.setParent(v, null);
        }

        valeurs.setValeur(depart, 0.0);
        String u = trouverMin(Q, valeurs);
        Q.remove(u);
        //initialisation de la ligne
        for (Arc arc : g.suivants(u)) {
            String v = arc.getDest();
            ligne = arc.getLigne();
            if (Q.contains(v)) {
                double d = valeurs.getValeur(u) + arc.getCout();
                if (d < valeurs.getValeur(v)) {
                    valeurs.setValeur(v, d);
                    valeurs.setParent(v, u);
                }
            }
        }
        while (!Q.isEmpty()) {
            u = trouverMin(Q, valeurs);
            Q.remove(u);
            for (Arc arc : g.suivants(u)) {
                String v = arc.getDest();
                if (Q.contains(v)) {
                    double d = valeurs.getValeur(u) + arc.getCout();
                    if (!arc.getLigne().equals(ligne)) {
                        d+=10;
                    }
                    if (d < valeurs.getValeur(v)) {
                        valeurs.setValeur(v, d);
                        valeurs.setParent(v, u);
                        ligne = arc.getLigne();
                    }
                }
            }
        }
        return valeurs;
    }

    /**
     * Méthode qui cherche le plus petite valeur à absober dans Dijkstra
     * @param Q
     * @param valeurs
     * @return
     */
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