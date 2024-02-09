package sio.tp1;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sio.tp1.Model.Bouteille;
import sio.tp1.Model.Cepage;
import sio.tp1.Model.Couleur;
import sio.tp1.Model.Vin;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TP1Controller implements Initializable
{
    ArrayList<Bouteille> mesBouteilles = new ArrayList<>();
    @FXML
    private TableColumn tcNumeroBouteille;
    @FXML
    private TableColumn<Bouteille,String> tcNomVin;
    @FXML
    private TableColumn tcQuantite;
    @FXML
    private Label lblValeurCave;
    @FXML
    private TextField txtMillesime;


    @FXML
    private TextField txtPrix;
    @FXML
    private TextField txtCepage;
    @FXML
    private TextField txtCouleur;
    @FXML
    private TextField txtPourcentageVinsRouges;
    @FXML
    private TextField txtPourcentageVinsBlancs;
    @FXML
    private TextField txtPourcentageVinsRoses;
    @FXML
    private TableView<Bouteille> tvBouteilles;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        initDatas();

        tcNumeroBouteille.setCellValueFactory(new PropertyValueFactory<Bouteille,Integer>("idBouteille"));
        tcNomVin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLeVin().getNomVin()));
        tcQuantite.setCellValueFactory(new PropertyValueFactory<Bouteille,Integer>("quantiteBouteille"));

        tvBouteilles.setItems(FXCollections.observableArrayList(mesBouteilles));

        double totalValue = 0.0;
        for (Bouteille bouteille : mesBouteilles) {
            totalValue += bouteille.getLeVin().getPrixDuVin() * bouteille.getQuantiteBouteille();
        }
        lblValeurCave.setText(String.valueOf(totalValue));

        double rougePourcentage = (double) mesBouteilles.stream().filter(bouteille -> bouteille.getLeVin().getLaCouleur().getNomCouleur().equals("Rouge")).count()
                / mesBouteilles.size() * 100;
        txtPourcentageVinsRouges.setText(String.valueOf(rougePourcentage) + "%");

        double blancPourcentage = (double) mesBouteilles.stream().filter(bouteille -> bouteille.getLeVin().getLaCouleur().getNomCouleur().equals("Blanc")).count()
                / mesBouteilles.size() * 100;
        txtPourcentageVinsBlancs.setText(String.valueOf(blancPourcentage) + "%");

        double rosePourcentage = (double) mesBouteilles.stream().filter(bouteille -> bouteille.getLeVin().getLaCouleur().getNomCouleur().equals("Rosé")).count()
                / mesBouteilles.size() * 100;
        txtPourcentageVinsRoses.setText(String.valueOf(rosePourcentage) + "%");

        // Print the total value of the cave
        System.out.println("Total Value of the Cave: " + totalValue);

    }
    public void initDatas()
    {
        // Les couleurs du vin
        Couleur blanc = new Couleur("Blanc");
        Couleur rose = new Couleur("Rosé");
        Couleur rouge = new Couleur("Rouge");

        // Les cépages du vin
        Cepage beaujolais = new Cepage("Beaujolais");
        Cepage chardonnay = new Cepage("Chardonnay");
        Cepage gamay = new Cepage("Gamay");
        Cepage pinotNoir = new Cepage("Pinot noir");
        Cepage sauvignon = new Cepage("Sauvignon");

        // Les vins
        Vin vin1 = new Vin("Juliénas", 2005, beaujolais, rouge,13.78);
        Vin vin2 = new Vin("Saint Amour", 2012, beaujolais, blanc,18);
        Vin vin3 = new Vin("Brouilly", 2018, beaujolais, rouge,14.5);
        Vin vin4 = new Vin("Morgon", 2015, beaujolais, rose,21.34);
        Vin vin5 = new Vin("Bourgogne Côte de Beaune", 2002, chardonnay, blanc,39.5);
        Vin vin6 = new Vin("Aligoté", 2016, chardonnay, blanc,7.12);
        Vin vin7 = new Vin("Bourgogne Côte de Nuits", 2000, chardonnay, rose,11.67);
        Vin vin8 = new Vin("Chablis", 2011, chardonnay, blanc,15.17);
        Vin vin9 = new Vin("Champagne", 2014, chardonnay, blanc,24.71);
        Vin vin10 = new Vin("La Roche", 2005, gamay, rouge,12.45);
        Vin vin11 = new Vin("Le Carquelin", 2005, gamay, rouge,15.98);
        Vin vin12 = new Vin("Morgon Vieilles Vignes", 2005, gamay, rouge,19.54);
        Vin vin13 = new Vin("Coeurs de terroirs", 2005, gamay, rose,9.80);
        Vin vin14 = new Vin("Alox Corton", 2005, pinotNoir, rouge,17.65);
        Vin vin15 = new Vin("Edelzwicker ", 2017, pinotNoir, blanc,23.81);
        Vin vin16 = new Vin("Romanée Conti", 2009, pinotNoir, rouge,14.83);
        Vin vin17 = new Vin("Château d'Yguem", 2010, sauvignon, rose,11.56);
        Vin vin18 = new Vin("Château Guiraud", 2003, sauvignon, rouge,16.90);
        Vin vin19 = new Vin("Château Coutet", 2017, sauvignon, rouge,22.74);
        Vin vin20 = new Vin("Château Suduiraut", 2007, sauvignon, rouge, 8.63);

        // Les bouteilles
        Bouteille b1 = new Bouteille(1, 125, vin1);
        Bouteille b2 = new Bouteille(2, 56, vin2);
        Bouteille b3 = new Bouteille(3,23, vin3);
        Bouteille b4 = new Bouteille(4, 14, vin4);
        Bouteille b5 = new Bouteille(5, 87, vin5);
        Bouteille b6 = new Bouteille(6, 34, vin6);
        Bouteille b7 = new Bouteille(7, 78, vin7);
        Bouteille b8 = new Bouteille(8, 19, vin8);
        Bouteille b9 = new Bouteille(9, 41, vin9);
        Bouteille b10 = new Bouteille(10, 12, vin10);
        Bouteille b11 = new Bouteille(11, 25, vin11);
        Bouteille b12 = new Bouteille(12, 46, vin12);
        Bouteille b13 = new Bouteille(13, 62, vin13);
        Bouteille b14 = new Bouteille(14, 5, vin14);
        Bouteille b15 = new Bouteille(15, 44, vin15);
        Bouteille b16 = new Bouteille(16, 62, vin16);
        Bouteille b17 = new Bouteille(17, 21, vin17);
        Bouteille b18 = new Bouteille(18, 71, vin18);
        Bouteille b19 = new Bouteille(19, 37, vin19);
        Bouteille b20 = new Bouteille(20, 92, vin20);

        mesBouteilles.add(b1);mesBouteilles.add(b2);mesBouteilles.add(b3);
        mesBouteilles.add(b4);mesBouteilles.add(b5);mesBouteilles.add(b6);
        mesBouteilles.add(b7);mesBouteilles.add(b8);mesBouteilles.add(b9);
        mesBouteilles.add(b10);mesBouteilles.add(b11);mesBouteilles.add(b12);
        mesBouteilles.add(b13);mesBouteilles.add(b14);mesBouteilles.add(b15);
        mesBouteilles.add(b16);mesBouteilles.add(b17);mesBouteilles.add(b18);
        mesBouteilles.add(b19);mesBouteilles.add(b20);
    }

    @FXML
    public void tvBouteillesMouseClicked(Event event)
    {
        Bouteille bouteilleSelect = (Bouteille) tvBouteilles.getSelectionModel().getSelectedItem();
        txtMillesime.setText(String.valueOf(bouteilleSelect.getLeVin().getMillesimeVin()));
        txtPrix.setText(String.valueOf(bouteilleSelect.getLeVin().getPrixDuVin()));
        txtCepage.setText(String.valueOf(bouteilleSelect.getLeVin().getLeCepage().getNomCepage()));
        txtCouleur.setText(String.valueOf(bouteilleSelect.getLeVin().getLaCouleur().getNomCouleur()));

    }
}