package sio.tp1.Model;

import javafx.beans.property.SimpleStringProperty;

public class Vin
{
    private String nomVin;
    private int millesimeVin;
    private Cepage leCepage;
    private Couleur laCouleur;
    private double prixVin;

    public Vin(String nomVin, int millesimeVin, Cepage leCepage, Couleur laCouleur, double prixVin) {
        this.nomVin = nomVin;
        this.millesimeVin = millesimeVin;
        this.leCepage = leCepage;
        this.laCouleur = laCouleur;
        this.prixVin = prixVin;
    }

    public String getNomVin() {
        return nomVin;
    }

    public int getMillesimeVin() {
        return millesimeVin;
    }

    public Cepage getLeCepage() {
        return leCepage;
    }

    public Couleur getLaCouleur() {
        return laCouleur;
    }

    public double getPrixDuVin() {
        return prixVin;
    }
}
