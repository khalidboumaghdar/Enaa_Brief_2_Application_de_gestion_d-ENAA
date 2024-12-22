import java.util.ArrayList;
import java.util.Scanner;

public class Classe {
private static int id;
    private String nom;
    public static  ArrayList<Classe> classes = new ArrayList<>();
    private static  Scanner scanner = new Scanner(System.in);

    public Classe(int id, String nom) {
        this.id = classes.size()+1;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String toString() {
        return "Classe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }    
 public static void gestionClasses() {
        System.out.println("\n--- Gestion des Classes ---");
        System.out.println("1. Ajouter une classe");
        System.out.println("2. Modifier une classe");
        System.out.println("3. Supprimer une classe");
        System.out.println("4. Afficher les classes");
        System.out.print("Choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1 : ajouterClasse();
            break;
            //case 2 : modifierClasse();
            break;
            //case 3 : supprimerClasse();
            break;
            //case 4 : afficherClasses();
            break;
            default :
                System.out.println("Choix invalide !");
        }
    }
  private static void ajouterClasse() {

        scanner.nextLine();
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        classes.add(new Classe(id, nom));
        System.out.println("Classe ajoutée !");
        id++;
    }


}
