import javax.swing.table.DefaultTableModel;
import  java.sql.*;

public class MyDataBase {
    //Les variables BD-----------------------------------
    Connection maConnection = null; //Variable de connexion
    Statement stm = null; //Requete
    int nbrPersonne =0;

    public MyDataBase() {
        connexion();
    }

    //----------------------------------------------------------------------------------------
    //Méthode de connexion--------------------------------------------------------------------
    void connexion() {
        String pilote = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/java";
        String nom_utilisateur = "root";
        String motdepasse = "";

        //1) Charger un pilote driver ==>
        try {
            Class.forName(pilote);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver loading error: " + e);
        }

        //2) Etablir une connexion ==>
        try {
            maConnection = DriverManager.getConnection(url, nom_utilisateur, motdepasse);
        } catch (SQLException e) {
            System.err.println("Error opening SQL connection: " + e);
        }

        //3) Créer un objet Statement ==>
        try {
            stm = maConnection.createStatement();
        } catch (SQLException e) {
            System.err.println("Error creating SQL statement: " + e);
        }
    }

    //----------------------------------------------------------------------------------------
    //methode d'ajout
    public int Ajouter(Personne p) {
        try {
            //requete d'insertion
            String req = "INSERT INTO users (nom, genre) VALUES('" + p.getNom() + "', '" + p.getGenre() + "')";
            //executer la requete
            int resUpd = stm.executeUpdate(req);
            return resUpd;
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e);
        }
        return 0;
    }
    // methode de remplissage du tableau
    void RemplirTab(DefaultTableModel model) {

        String req = "SELECT * FROM users";
        try {
            ResultSet res = stm.executeQuery(req);
            model.setRowCount(0);
            nbrPersonne=0 ;
            while (res.next()) {
                int ID = res.getInt("id");
                String Nom = res.getString("Nom");
                String Genre = res.getString("Genre");
                //injecter personne dans table
                model.addRow(new Object[]{ID, Nom, Genre});
                // calculer total des personne ajouter
                nbrPersonne++;
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e);
        }
    }
    // methode pour recuperer genre
    public int select_G (String genre){
        try{
            String req="SELECT COUNT(*) FROM users WHERE genre='"+genre+"'";
            ResultSet result =stm.executeQuery(req);
            if(result.next()) {
                return result.getInt(1);
            }
        }catch (SQLException e) {
            System.err.println("Error executing query: " + e);
        }
         return 0 ;
    }
    // recuperer nbr des personnes
    public int getNbrPersonne() {
        return nbrPersonne;
    }
}

