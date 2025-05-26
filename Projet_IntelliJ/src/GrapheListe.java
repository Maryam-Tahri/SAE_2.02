import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    /**
     * Contructeur par défaut d'un GrapheListe
     */
    public GrapheListe() {
        noeuds = new ArrayList<>(10);
        adjacence = new ArrayList<>(10);
    }

    /**
     * Méthode qui permet d'ajouté un arc pondéré entre deux noeuds
     * Si les noeuds de départ ou de destination n'existe pas, ils sont créer et ajouté au graphe
     * @param depart
     * @param destination
     * @param count
     */
    public void ajouterArc(String depart, String destination, double count) {
        int ind1 = getIndice(depart);

        if (!noeuds.contains(depart)) {
            ajouterNoeud(depart);
            ind1 = getIndice(depart);
            adjacence.add(new Arcs());
        }
        if (!noeuds.contains(destination)) {
            ajouterNoeud(destination);
            adjacence.add(new Arcs());
        }
        Arc arc = new Arc(destination, count);
        adjacence.get(ind1).ajouterArc(arc);
    }

    /**
     * Méthode qui permet d'ajouter un arc au graphe a partir d'un arc déjà existant
     * @param depart
     * @param a
     */
    public void ajouterArc(String depart, Arc a) {
        adjacence.get(getIndice(depart)).ajouterArc(a);
    }

    /**
     * Méthode qui permet de récupré l'indice du noeud dans la liste de noeud en attribut
     * @param n
     * @return
     */
    public int getIndice(String n) {
        for (int i = 0; i < this.noeuds.size(); i++) {
            if (this.noeuds.get(i).equals(n)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * méthode qui renvoie l'attribut qui contient la liste de noeuds
     * @return
     */
    public List<String> ListeNoeuds() {
        return this.noeuds;
    }

    /**
     * Méthode qui renvoie les arcs qui parte du noeuds en paramètre
     * @param s
     * @return
     */
    public List<Arc> suivants(String s) {
        int ind = getIndice(s);
        return adjacence.get(ind).getArcs();
    }

    /**
     * Méthode pour rajouté un noeud au graphe
     * @param n
     */
    public void ajouterNoeud(String n) {
        if (!noeuds.contains(n)) {
            noeuds.add(n);
            adjacence.add(new Arcs()); // Initialize an Arcs object for the new node
        }
    }

    /**
     * Méthode qui renvoie l'affichage de l'objet
     * @return
     */
    public String toString(){
        String res = "";
        for (int i = 0; i < this.noeuds.size(); i++) {
            res += this.noeuds.get(i) + " -> ";
            if (!(adjacence.isEmpty())){
                List<Arc> as = adjacence.get(i).getArcs();
                for (int j = 0; j < as.size(); j++) {
                    res += as.get(j).toString() + " ";
                }
                res += "\n";
            }
        }
        return res;
    }

    /**
     * Constructeur qui prend en paramètre un fichier et construit le graphe dans le fichier
     * @param nomFichier
     */
    public GrapheListe(String nomFichier){
        noeuds = new ArrayList<>(10);
        adjacence = new ArrayList<>(10);
        try{
            BufferedReader br = new BufferedReader(new FileReader(nomFichier));
            ArrayList<String> txt = new ArrayList<String>();
            String line =br.readLine();
            while (line != null){
                txt.add(line);
                line = br.readLine();
            }
            br.close();
            for (String s : txt) {
                String[] split = s.split("\t");
                this.ajouterArc(split[0],split[1],Double.valueOf(split[2]));
            }
        }catch( IOException e){
            System.out.println("problème du fichier");
        }
    }


}
