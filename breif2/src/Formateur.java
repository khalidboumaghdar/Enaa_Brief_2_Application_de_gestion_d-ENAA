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
    public static void gestionFormateurs() {
        System.out.println("\n--- Gestion des Formateurs ---");
        System.out.println("1. Ajouter un formateur");
        System.out.println("2. Modifier un formateur");
        System.out.println("3. Supprimer un formateur");
        System.out.println("4. Afficher les formateurs");
        System.out.print("Choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                ajouterFormateur();
                break;
            case 2:
                //modifierFormateur();
                break;
            case 3:
                //supprimerFormateur();
                break;
            case 4:
                //afficherFormateurs();
                break;
            default:
                System.out.println("Choix invalide !");
        }
    }
    private static void ajouterFormateur() {
        scanner.nextLine();
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Spécialité: ");
        String specialite = scanner.nextLine();
        System.out.print("Salaire: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Veuillez entrer un salaire valide !");
            scanner.next();
        }
        double salaire = scanner.nextDouble();
        formateurs.add(new Formateur(nom, prenom, email, specialite, salaire));
        System.out.println("Formateur ajouté !");
    }
}
