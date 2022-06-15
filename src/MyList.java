import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyList extends JFrame {
    //Le tableau
    String entete[] = {"Id","Nom","Genre"};
    DefaultTableModel model = new DefaultTableModel(entete,0);
    JTable table = new JTable(model);
    JScrollPane sp = new JScrollPane();

    //creer un objet cv pour l'histogramme
    Canvas cv = new Canvas();

    MyDataBase mdb = new MyDataBase();
    MyThread mt;

    public MyList(){
        //Titre de la fenetre
        super("Examen");
        //positionnement et taille de la fenetre
        setBounds(400,200,600,600);

        setResizable(false);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setIconImage(new ImageIcon("Icon\\image1.png").getImage());
        // couleur de backgound du cv est black
        cv.setBackground(Color.black);


        sp.getViewport().add(table);
        sp.setBorder(new TitledBorder("Liste des utilisateurs"));

        Container c = getContentPane();
        c.setLayout(new GridLayout(2 ,1));
        c.add(sp);
        c.add(cv);
        setVisible(true);

        // lancer le thread
        mt= new MyThread(this);
        mt.start();

        //objet g de type graphics
        Graphics g= cv.getGraphics();

    }
}
