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



}
