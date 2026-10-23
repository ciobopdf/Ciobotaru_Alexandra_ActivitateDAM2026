package ro.ase.dam_com.example.taskseminar4;

import java.io.Serializable;

public class Apartament implements Serializable {
    private String adresa;
    private String numarCamere;
    private float ratingStare;
    private boolean esteDisponibil;
    private String tipAnunt;      // din RadioButton (Proprietar / Agentie)
    private boolean esteMobilat;  // din CheckBox

    public Apartament(String adresa, String numarCamere, float ratingStare,
                      boolean esteDisponibil, String tipAnunt, boolean esteMobilat) {
        this.adresa = adresa;
        this.numarCamere = numarCamere;
        this.ratingStare = ratingStare;
        this.esteDisponibil = esteDisponibil;
        this.tipAnunt = tipAnunt;
        this.esteMobilat = esteMobilat;
    }

    @Override
    public String toString() {
        return "Adresă: " + adresa + "\n" +
                "Număr camere: " + numarCamere + "\n" +
                "Tip anunț: " + tipAnunt + "\n" +
                "Complet mobilat: " + (esteMobilat ? "Da" : "Nu") + "\n" +
                "Rating: " + ratingStare + " / 5★\n" +
                "Disponibil: " + (esteDisponibil ? "Da" : "Nu");
    }
}