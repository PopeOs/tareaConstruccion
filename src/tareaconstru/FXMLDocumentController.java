/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaconstru;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

/**
 *
 * @author Felipe
 */
public class FXMLDocumentController implements Initializable {
    
    String listaItem;

    ObservableList<String> farmacias = FXCollections.observableArrayList("Ahumada", "Cruz Verde", "Doctor Simi");
    ObservableList<String> regiones = FXCollections.observableArrayList("RM Region Metropolitana");
    ObservableList<String> comunas = FXCollections.observableArrayList("Recoleta", "Ñuñoa", "Maipú");
    ObservableList<String> formatos = FXCollections.observableArrayList("Pastilla", "Tableta", "Jarabe");
    
    @FXML
    private TextField textNombre;     
    @FXML
    private TextField textPrecioMayor;
    @FXML
    private TextField textPrecioMenor;        
    @FXML
    private TextField textPeso;
    @FXML
    private TextField textLista;
    @FXML
    private TextField infoRemedio;
    @FXML
    private TextField infoFarmacia;
    
    @FXML 
    private ScrollPane algo;
    
    @FXML
    private Button imprimir; 
    @FXML
    private Button buscar;
    @FXML
    private Button agregar;
    
    @FXML
    private ChoiceBox chFarmacia;
    @FXML
    private ChoiceBox chFormato;
    @FXML
    private ChoiceBox chRegion;
    @FXML
    private ChoiceBox chComuna;
    
    ArrayList<Farmacia> listaFarm = new ArrayList<>();

    @FXML
    private void buscarRemedio(ActionEvent event) {
        infoFarmacia.clear();
        infoRemedio.clear();
        busqueda();
    }
    
    public void busqueda(){
        for(int i=0; i<listaFarm.size(); i++){
            if(chFarmacia.getValue().toString().equalsIgnoreCase(listaFarm.get(i).getNombre())){
                if(chComuna.getValue().toString().equals(listaFarm.get(i).getComuna())){
                    infoFarmacia.setText(listaFarm.get(i).getDireccion()+" Fono: " +listaFarm.get(i).getTelefono());
                    for(int j=0; j<listaFarm.get(i).getInventario().size(); j++){
                        if(listaFarm.get(i).getInventario().get(j).getNombre().equalsIgnoreCase(textNombre.getText())){
                            if(listaFarm.get(i).getInventario().get(j).formato.equals(chFormato.getValue().toString())){
                                if(String.valueOf(listaFarm.get(i).getInventario().get(j).getPeso()).equalsIgnoreCase(textPeso.getText())){
                                    infoRemedio.setText(" Formato: "+ listaFarm.get(i).getInventario().get(j).getFormato()+" Precio: $"+listaFarm.get(i).getInventario().get(j).getCosto());

                                }
                            }
                        }
                    }
                }
            }
        }
        if(infoRemedio.getText().isEmpty()){
            infoRemedio.setText("No hay stock");
        }
    }
    
    public void agregarItem(){
        String item = infoRemedio.getText();
        listaItem = listaItem+item;
        textLista.setText(listaItem);
    }
    
    public void imprimirLista(){
        System.out.println("Imprimo la lista uwu");
    }
    
    @Override   
    public void initialize(URL url, ResourceBundle rb) {
        chFarmacia.setItems(farmacias);
        chComuna.setItems(comunas);
        chRegion.setItems(regiones);
        chFormato.setItems(formatos);
        
        //RECOLETA
        Farmacia f1 = new Farmacia("Ahumada","Avenida General Rondizzoni #321","12344124", "Recoleta");
        Farmacia f2 = new Farmacia("Doctor Simi","Calle San Antonio #921","123123", "Recoleta");
        Farmacia f3 = new Farmacia("Cruz Verde","Paseo Puente #863","2342344", "Recoleta");
        
        //ÑUÑOA
        Farmacia f4 = new Farmacia("Ahumada","Calle Bandera #2919","5323422", "Ñuñoa");
        Farmacia f5 = new Farmacia("Doctor Simi","Calle Compañía #241","2342455", "Ñuñoa");
        Farmacia f6 = new Farmacia("Cruz Verde","Avenida Manuel Antonio Matta #321","2352354", "Ñuñoa");
        
        //MAIPÚ
        Farmacia f7 = new Farmacia("Ahumada","Calle Mac-Iver #334","62452342", "Maipú");
        Farmacia f8 = new Farmacia("Doctor Simi","Calle de Morandé #451","25326424", "Maipú");
        Farmacia f9 = new Farmacia("Cruz Verde","Avenida Matucana #1231","63463", "Maipú");
        
        
        Item i1 = new Item("Paracetamol", "Pastilla", 250, 990);
        Item i2 = new Item("Paracetamol", "Tableta", 400, 1250);
        Item i3 = new Item("Paracetamol", "Jarabe", 500, 5000);
        
        Item i4 = new Item("Ibuprofeno", "Pastilla", 500, 950);
        Item i5 = new Item("Ibuprofeno", "Tableta", 220, 990);
        Item i6 = new Item("Ibuprofeno", "Jarabe", 500, 2990);
        
        Item i7 = new Item("Viadil", "Pastilla", 250, 10990);
        Item i8 = new Item("Viadil", "Tableta", 300, 12990);
        Item i9 = new Item("Viadil", "Jarabe", 300, 8000);
        
        Item i10 = new Item("Tapsin", "Pastilla", 400, 250);
        Item i11 = new Item("Tapsin", "Tableta", 200, 500);
        Item i12 = new Item("Tapsin", "Jarabe", 500, 990);
        
        
        ArrayList<Item> inventario1 = new ArrayList<>();
        ArrayList<Item> inventario2 = new ArrayList<>();
        ArrayList<Item> inventario3 = new ArrayList<>();
        ArrayList<Item> inventario4 = new ArrayList<>();
        
        
        inventario1.add(i1);
        inventario1.add(i2);
        inventario1.add(i3);
        inventario1.add(i4);
        inventario1.add(i5);
        inventario1.add(i6);
        
        
        inventario2.add(i6);
        inventario2.add(i5);
        inventario2.add(i4);
        inventario2.add(i4);
        inventario2.add(i2);
        inventario2.add(i1);
        
        inventario3.add(i9);
        inventario3.add(i10);
        inventario3.add(i11);
        inventario3.add(i12);
        inventario3.add(i8);
        inventario3.add(i4);
        
        
        inventario4.add(i1);
        inventario4.add(i4);
        inventario4.add(i7);
        inventario4.add(i10);
        
        f1.setInventario(inventario1);
        f2.setInventario(inventario2);
        f3.setInventario(inventario3);
        f4.setInventario(inventario4);
        f5.setInventario(inventario1);
        f6.setInventario(inventario2);
        f7.setInventario(inventario3);
        f8.setInventario(inventario4);
        f9.setInventario(inventario4);
        
        listaFarm.add(f1);
        listaFarm.add(f2);
        listaFarm.add(f3);
        listaFarm.add(f4);
        listaFarm.add(f5);
        listaFarm.add(f6);
        listaFarm.add(f7);
        listaFarm.add(f8);
        listaFarm.add(f9);
    }    
    
}
