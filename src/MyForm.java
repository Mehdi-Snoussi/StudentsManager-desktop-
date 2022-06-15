import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MyForm extends JFrame {

    //Les Libelles
    JLabel examen=new JLabel("Examen");
    JLabel NomL=new JLabel("Nom");
    JLabel GenreL=new JLabel("Genre");

    //zone de texte
    public JTextField NomT = new JTextField();

    //Les radiobuttons
    ButtonGroup group=new ButtonGroup();
    JRadioButton op1= new JRadioButton("Homme");
    JRadioButton op2= new JRadioButton("Femme");

    //Les buttons
    JButton Ajouter=new JButton("Ajouter");
    JButton Lister=new JButton("List");

    MyEvents evt;

    // interface graphique
    public MyForm(){
        //titre de la fenetre
        super("Examen");

        //positionnement et taille de la fenetre
        setBounds(1000,350,450,200);

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        //mise en forme de jlabel examen
        examen.setHorizontalAlignment(SwingConstants.CENTER);
        examen.setFont(new Font("Time New Roman", Font.BOLD, 25));

        //Changer l'icone qui se trouve en haut a gauche de la JFrame
        setIconImage(new ImageIcon("Icon\\image1.png").getImage());

        //Radiobuttons panel
        JPanel RBpanel = new JPanel();
        RBpanel.setLayout(new GridLayout(1,2));
        RBpanel.add(op1);
        RBpanel.add(op2);
        group.add(op1);
        group.add(op2);
        op1.setSelected(true);

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(2,2));
        form.add(NomL);
        form.add(NomT);
        form.add(GenreL);
        form.add(RBpanel);
        form.setBorder(new TitledBorder("Form"));

        //buttons panel
        JPanel Pbutton= new JPanel();
        Pbutton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Pbutton.add(Lister);
        Pbutton.add(Ajouter);

        Container c = getContentPane();
        c.setLayout( new BorderLayout());
        c.add("North",examen);
        c.add("Center",form);
        c.add("South",Pbutton);

        //Actions sur button ajouter avec classe externe
        evt = new MyEvents(this);
        Ajouter.addActionListener(evt);

        //Actions sur button lister avec expression lambda
        Lister.addActionListener(e->new MyList());

        setVisible(true);

    }

    public static void main (String[] args) {
        new MyForm();
    }
}
