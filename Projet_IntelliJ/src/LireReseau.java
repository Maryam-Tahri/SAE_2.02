import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LireReseau {
    public static Graphe Lire(String nFichier) throws IOException {
        GrapheListe g = new GrapheListe();
        BufferedReader br = new BufferedReader(new FileReader(nFichier));
        String line = br.readLine();
        boolean stations = true;
        while (line != null) {
            System.out.println(line+" "+stations);
            if (!(line.equals(""))) {
                if (line.startsWith("%") ) {
                    if (stations && line.equals("%% Connexions:")) {
                        stations = false;
                    }
                }else {
                    String[] s = line.split(":");
                    if(stations){
                        g.ajouterNoeud(s[1]);
                    }else{
                        String depart = g.ListeNoeuds().get(Integer.parseInt(s[0])-1);
                        String dest = g.ListeNoeuds().get(Integer.parseInt(s[1])-1);
                        double cout = Double.parseDouble(s[2]);
                        String ligne = s[3];
                        Arc a1 = new Arc(dest,cout,ligne);
                        Arc a2 = new Arc(depart,cout,ligne);
                        g.ajouterArc(depart,a1);
                        g.ajouterArc(dest,a2);
                    }
                }
            }
            line = br.readLine();
        }
        br.close();
        return g;
    }
}
