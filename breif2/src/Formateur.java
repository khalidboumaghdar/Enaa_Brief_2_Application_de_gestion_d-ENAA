import java.util.ArrayList;
import java.util.Scanner;

public class Formateur extends Personne  {
    private static int id;
    private String specialite;
    private double salaire;
    private static ArrayList<Formateur> formateurs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Formateur(int id, String nom, String prenom, String email, String specialite, double salaire) {
        super(id, nom, prenom, email);
        this.specialite = specialite;
        this.salaire = salaire;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Formateur{" +
                "specialite='" + specialite + '\'' +
                ", salaire=" + salaire +
                '}'+super.toString();
    }

    public static void gestionFormateurs() {

        System.out.println("\n--- Gestion des Formateurs ---");
        System.out.println("1. Ajouter un formateur");
        System.out.println("2. Modifier un formateur");
        System.out.println("3. Supprimer un formateur");
        System.out.println("4. Afficher les formateurs");
        System.out.println("5. Recharche par ID");
        System.out.print("Choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                ajouterFormateur();
                break;
            case 2:
                modifierFormateur();
                break;
            case 3:
                supprimerFormateur();
                break;
            case 4:
                afficherFormateurs();
                break;
            case 5:
                System.out.println("Enter ID de Formateur tu peut rechercher : ");
                int id  = scanner.nextInt();
                Formateur formateur =  rechercherFormateurparID(id);
                if (formateur == null) {
                    System.out.println("Id introuvable !");
                    return;
                }
                break;
            default:
                System.out.println("Choix invalide !!!!");
        }
    }
    private static void ajouterFormateur() {
        id  = formateurs.size()+1;
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
        formateurs.add(new Formateur(id,nom, prenom, email, specialite, salaire));
        System.out.println("Formateur ajouté !");
    }
    private static void modifierFormateur() {
        System.out.print("ID du formateur à modifier: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Formateur formateur : formateurs) {
            if (formateur.getId() == id) {
                System.out.print("Nouveau Nom: ");
                formateur.setNom(scanner.nextLine());
                System.out.print("Nouveau Prénom: ");
                formateur.setPrenom(scanner.nextLine());
                System.out.print("Nouvel Email: ");
                formateur.setEmail(scanner.nextLine());
                System.out.print("Nouvelle Spécialité: ");
                formateur.setSpecialite(scanner.nextLine());
                System.out.print("Nouveau Salaire: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Veuillez entrer un salaire valide !");
                    scanner.next();
                }
                formateur.setSalaire(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Formateur modifié !");
                return;
            }
        }
        System.out.println("Formateur introuvable !");
    }
    private static void supprimerFormateur() {
        System.out.print("ID du formateur à supprimer: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        formateurs.removeIf(formateur -> formateur.getId() == id);
        System.out.println("Formateur supprimé !");
    }
    private static void afficherFormateurs() {
        if (formateurs.isEmpty()) {
            System.out.println("Aucun formateur trouvé.");
        } else {
            for (Formateur formateur : formateurs) {
                System.out.println(formateur);
            }
        }
    }
    private static Formateur rechercherFormateurparID(int id) {
        for (Formateur formateur : formateurs){
            if (formateur.getId()==id) {
                System.out.println(formateur.toString());
            }
        }
        return null;
    }
}
