import java.util.ArrayList;
import java.util.Scanner;

public class Apprenant extends Personne  {
    private Classe classe;
    private ArrayList<Double> notes;
    private static ArrayList<Apprenant> apprenants = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public Apprenant(int id, String nom, String prenom, String email, Classe classe, ArrayList<Double> notes) {
        super(id, nom, prenom, email);
        this.classe = classe;
        this.notes = notes;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public ArrayList<Double> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Double> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Apprenant{" +
                "classe=" + classe +
                ", notes=" + notes +
                '}'+super.toString();
    }

    public static void gestionApprenants() {
        System.out.println("\n--- Gestion des Apprenants ---");
        System.out.println("1. Ajouter un apprenant");
        System.out.println("2. Modifier un apprenant");
        System.out.println("3. Supprimer un apprenant");
        System.out.println("4. Afficher les apprenants");
        System.out.println("5. Recharche par ID");
        System.out.print("Choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1: ajouterApprenant(); break;
            case 2: modifierApprenant(); break;
            case 3: supprimerApprenant(); break;
            case 4: afficherApprenants(); break;
            case 5:
                System.out.println("Enter ID de Formateur tu peut rechercher : ");
                int id  = scanner.nextInt();
                Apprenant apprenant =  rechercherFormateurparID(id);
                if (apprenant == null) {
                    System.out.println("Id introuvable !");
                    return;
                }
                break;
            default: System.out.println("Choix invalide !"); break;
        }
    }
    private static void ajouterApprenant() {
        int id = apprenants.size() + 1;
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Entrez la classe: ");
        String classenom = scanner.nextLine();

        Classe classe = rechercherClasseParNom(classenom);
        if (classe == null) {
            System.out.println("Classe introuvable !");
            return;
        }

        ArrayList<Double> notes = new ArrayList<>();
        System.out.println("Entrez les notes (séparer par des espaces) : ");
        String[] notesInput = scanner.nextLine().split(" ");
        try {
            for (String note : notesInput) {
                notes.add(Double.parseDouble(note));
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Veuillez entrer des notes valides.");
            return;
        }

        apprenants.add(new Apprenant(id, nom, prenom, email, classe, notes));
        System.out.println("Apprenant ajouté !");
    }
    private static void modifierApprenant() {
        System.out.print("ID de l'apprenant à modifier: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Apprenant apprenant : apprenants) {
            if (apprenant.getId() == id) {
                System.out.print("Nouveau Nom: ");
                apprenant.setNom(scanner.nextLine());
                System.out.print("Nouveau Prénom: ");
                apprenant.setPrenom(scanner.nextLine());
                System.out.print("Nouvel Email: ");
                apprenant.setEmail(scanner.nextLine());
                System.out.print("Nouvelle Classe: ");
                String classenom = scanner.nextLine();

                Classe classe = rechercherClasseParNom(classenom);
                if (classe == null) {
                    System.out.println("Classe introuvable !");
                    return;
                }
                apprenant.setClasse(classe);
                System.out.println("Apprenant modifié !");
                return;
            }
        }
        System.out.println("Apprenant introuvable !");
    }
    private static void supprimerApprenant() {
        System.out.print("ID de l'apprenant à supprimer: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        apprenants.removeIf(apprenant -> apprenant.getId() == id);
        System.out.println("Apprenant supprimé !");
    }
    private static void afficherApprenants() {
        if (apprenants.isEmpty()) {
            System.out.println("Aucun apprenant trouvé.");
        } else {
            for (Apprenant apprenant : apprenants) {
                System.out.println(apprenant);
            }
        }
    }
    private static Apprenant rechercherFormateurparID(int id) {
        for (Apprenant apprenant : apprenants){
            if (apprenant.getId()==id) {
                System.out.println(apprenant.toString());
            }
        }
        return null;
    }
    private static Classe rechercherClasseParNom(String nom) {
        for (Classe classe : Classe.classes) {
            if (classe.getNom().equalsIgnoreCase(nom)) {
                return classe;
            }
        }
        return null;
    }

}
