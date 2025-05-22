import java.util.List;

public class BellmanFord {

    /**
     * Algorithme pointFixe(Graphe g, Noeud depart):

     *             Pour chaque Arc (N, cout) dans g.suivants(X) faire
     *                 Si L.getValeur(X) + cout < L.getValeur(N) alors
     *                     L.setValeur(N, L.getValeur(X) + cout)
     *                     L.setParent(N, X)
     *                     modifié = true
     *                 Fin Si
     *             Fin Pour
     *         Fin Pour
     *     Fin Tant que
     *     Retourner L
     * Fin
     * @param g
     * @param depart
     * @return
     */
    public Valeurs resoudre(Graphe g, String depart){
        Valeurs l = new Valeurs();
        for (int i = 0 ; i < g.ListeNoeuds().size(); i++){
            l.setValeur(g.ListeNoeuds().get(i), Double.MAX_VALUE);
            l.setParent(g.ListeNoeuds().get(i), null);
        }
        l.setValeur(depart, 0);
        boolean modif = true;
        while (modif){
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
}
