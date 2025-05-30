import java.util.List;

public class BellmanFord {

    /**
     * Construteur par défaut
     */
    public BellmanFord() {
    }

    /**
     * Méthode qui permet d'appliquer l'algorithme du point fixe de BellmanFord
     *
     * @param g
     * @param depart
     * @return
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs l = new Valeurs();
        for (int i = 0; i < g.ListeNoeuds().size(); i++) {
            l.setValeur(g.ListeNoeuds().get(i), Double.MAX_VALUE);
            l.setParent(g.ListeNoeuds().get(i), null);
        }
        l.setValeur(depart, 0);
        boolean modif = true;
        while (modif) {
            modif = false;
            for (String noeud : g.ListeNoeuds()) {
                List<Arc> arcs = g.suivants(noeud);
                for (Arc arc : arcs) {
                    double nouvelleValeur = l.getValeur(noeud) + arc.getCout();
                    if (nouvelleValeur < l.getValeur(arc.getDest())) {
                        l.setValeur(arc.getDest(), nouvelleValeur);
                        l.setParent(arc.getDest(), noeud);
                        modif = true;
                    }
                }
            }
        }
        return l;
    }

    /**
     * Méthode qui permet d'appliquer l'algorithme du point fixe de BellmanFord en rajoutéant les pénalité de temps sur les changement de ligne
     *
     * @param g
     * @param depart
     * @return
     */
    public Valeurs resoudre2(Graphe g, String depart) {
        Valeurs l = new Valeurs();
        for (int i = 0; i < g.ListeNoeuds().size(); i++) {
            l.setValeur(g.ListeNoeuds().get(i), Double.MAX_VALUE);
            l.setParent(g.ListeNoeuds().get(i), null);
        }
        l.setValeur(depart, 0);
        //initialisation de la ligne
        boolean modif = true;
        String ligne = "";
        for (String noeud : g.ListeNoeuds()) {
            List<Arc> arcs = g.suivants(noeud);
            for (Arc arc : arcs) {
                double nouvelleValeur = l.getValeur(noeud) + arc.getCout();
                if (nouvelleValeur < l.getValeur(arc.getDest())) {
                    l.setValeur(arc.getDest(), nouvelleValeur);
                    l.setParent(arc.getDest(), noeud);
                    ligne = arc.getDest();
                    modif = true;
                }
            }
        }
        while (modif) {
            modif = false;
            for (String noeud : g.ListeNoeuds()) {
                List<Arc> arcs = g.suivants(noeud);
                for (Arc arc : arcs) {
                    double nouvelleValeur = l.getValeur(noeud) + arc.getCout();
                    if (!ligne.equals(arc.getLigne())) {
                        nouvelleValeur += 10;
                    }
                    if (nouvelleValeur < l.getValeur(arc.getDest())) {
                        l.setValeur(arc.getDest(), nouvelleValeur);
                        l.setParent(arc.getDest(), noeud);
                        ligne = arc.getLigne();
                        modif = true;
                    }
                }
            }
        }
        return l;
    }
}
