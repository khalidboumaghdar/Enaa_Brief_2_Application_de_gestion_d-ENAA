import java.util.ArrayList;
import java.util.Scanner;

public class Formateur extends Personne  {
 private static int id;
    private String specialite;
    private double salaire;
    private static ArrayList<Formateur> formateurs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Formateur(String nom, String prenom, String email, String specialite, double salaire) {
        super(id,nom,prenom,email);
        this.id = formateurs.size() + 1;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialite = specialite;
        this.salaire = salaire;
    }

    public int getId() { return id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setEmail(String email) { this.email = email; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }
    public void setSalaire(double salaire) { this.salaire = salaire; }

    @Override
    public String toString() {
        return "Formateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", spécialité='" + specialite + '\'' +
                ", salaire=" + salaire +
                '}';
    	}
}
