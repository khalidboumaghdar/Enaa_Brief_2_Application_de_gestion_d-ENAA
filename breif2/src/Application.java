import java.util.ArrayList;
import java.util.Scanner;

public class Application {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gestion des Apprenants");
            System.out.println("2. Gestion des Formateurs");
            System.out.println("3. Gestion des Classes");
            System.out.println("4. Quitter");
            System.out.print("Choix: ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1 : Apprenant.gestionApprenants();
                    break;
                case 2 : Formateur.gestionFormateurs();
                    break;
                case 3: Classe.gestionClasses();
                    break;
                case 4:
                    System.out.println("Merci d'avoir utilisé l'application. Au revoir !");
                    break;
                default :
                    System.out.println("Choix invalide, veuillez réessayer !");
            }
        }while (choix!=4);
    }
}
