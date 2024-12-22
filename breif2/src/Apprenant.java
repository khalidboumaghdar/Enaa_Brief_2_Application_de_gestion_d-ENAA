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

    public int getId() {
        return id;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public void setNotes(ArrayList<Double> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Apprenant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", classe=" + classe.getNom() +
                ", notes=" + notes +
                '}';
    }
}
