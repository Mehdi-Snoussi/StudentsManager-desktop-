import java.awt.*;

public class MyThread extends Thread {
    MyList ml;
    Graphics g;

    public MyThread(MyList ml) {
        this.ml = ml;
        g = ml.cv.getGraphics();
    }
    //appeler les methoses de remplissage et graphisme pour chaque 1s
    public void run() {
        while (true) {
            ml.cv.update(g);
            ml.mdb.RemplirTab(ml.model);
            histogramme(ml.mdb.getNbrPersonne());
            axesXY(ml.mdb.getNbrPersonne(), "Genre", "Total");
            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //methode de creation d'histogramme
    public void histogramme(int nbPersonne) {
        if (nbPersonne > 0){
            //calculer rapport dans chaque genre
            int nbrHomme = ml.mdb.select_G("Homme");
            int nbrFemme = ml.mdb.select_G("Femme");
            float rapport_f = (float) nbrFemme / nbPersonne;
            float rapport_h = (float) nbrHomme / nbPersonne;

            // histogramme pour femme
            g.setColor(Color.PINK);
            int y = (int) (260 * rapport_f);
            // si y = 260 c.a.d toute la base et composé des femmes ou hommes
            if(y==260){
                g.fillRect(150, 40, 50, 220);
                g.drawString("Femme",151,272);}
            else{
                g.fillRect(150, 260 - y, 50, y);
                g.drawString("Femme",151,272);
            }

            // histogramme pour homme
            y = (int) (260 * rapport_h);
            g.setColor(Color.BLUE);
            if(y==260){
                g.fillRect(250, 40, 50, 220);
                g.drawString("Homme",253,272);}

            else {
                g.fillRect(250, 260 - y, 50, y);
                g.drawString("Homme",253,272);
            }
        }
    }

    //methode de creation des axes
    public void axesXY(int nbPeronnes, String labelX, String labelY) {
        g.setColor(Color.green);
        //axe X
        g.drawLine(20, 260, 550, 260);
        //arrow
        g.drawLine(530, 250, 550, 260);
        g.drawLine(530, 270, 550, 260);
        //label
        g.drawString(labelX, 520, 240);

        // axe Y
        g.drawLine(20, 15, 20, 260);
        //arrow
        g.drawLine(20, 10, 30, 25);
        g.drawLine(20, 10, 10, 25);
        //label
        g.drawString(labelY, 25, 15);

        //total des personnes
        g.setColor(Color.YELLOW);
        g.drawLine(10, 40, 30, 40);
        g.setColor(Color.RED);
        g.drawString(String.valueOf(nbPeronnes), 35, 45);

        //titre
        g.setColor(Color.red);
        g.drawString("Histogramme", 250, 20);
    }
}