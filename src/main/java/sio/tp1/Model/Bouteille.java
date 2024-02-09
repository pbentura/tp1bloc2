package sio.tp1.Model;

public class Bouteille
{
    private int idBouteille;
    private int quantiteBouteille;
    private Vin leVin;

    public Bouteille(int idBouteille, int quantiteBouteille, Vin leVin) {
        this.idBouteille = idBouteille;
        this.quantiteBouteille = quantiteBouteille;
        this.leVin = leVin;
    }

    public int getIdBouteille() {
        return idBouteille;
    }

    public int getQuantiteBouteille() {
        return quantiteBouteille;
    }

    public Vin getLeVin() {
        return leVin;
    }
}
