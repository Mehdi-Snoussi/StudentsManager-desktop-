import java.awt.event.*;
import java.util.Objects;

public class MyEvents implements ActionListener {

    MyForm mf;
    MyDataBase mdb;

    public MyEvents(MyForm mf) {
        this.mf = mf;
        mdb = new MyDataBase();
    }
    //ActionListener
    public void actionPerformed(ActionEvent e) {
        // s'il existe une action sur boutton ajouter et nom non vide
        if((e.getSource()==mf.Ajouter ) && (!Objects.equals(mf.NomT.getText(), ""))){
            //Récupérations du genre
            String Genre;
            String Nom = mf.NomT.getText();
            if(mf.op1.isSelected())
                Genre="Homme";
            else
                Genre="Femme";
            // instance du classe personne et appel du methode ajouter
            Personne p = new Personne(Nom, Genre);
            mdb.Ajouter(p);
            javax.swing.JOptionPane.showMessageDialog(mf,"Insertion effectuée");
        }
    }
}
