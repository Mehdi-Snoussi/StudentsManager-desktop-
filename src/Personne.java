public class Personne {

    private String nom;
    private String genre;
    private int id;

    //Constructeur par defaut
    public Personne(){}

    //constructeur paramétrer
    public Personne(int id, String nom , String genre){
        this.nom=nom;
        this.genre=genre;
    }
    //constructeur paramétrer
    public Personne(String nom , String genre){
        this.nom=nom;
        this.genre=genre;
    }

    // Getteurs et Setteurs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) { this.nom = nom; }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) { this.genre = genre; }

    public int getId() { return id; }
}
