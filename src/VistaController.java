/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Barcos.Velero;
import Barcos.VeleroTV;
import GestorDeDatos.Gestor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author jurome
 */
public class VistaController implements Initializable {
    
    private Label label;
    @FXML private TableView<VeleroTV> TablaVelero;
    @FXML private TableColumn<VeleroTV, String> trMarca;
    @FXML private TableColumn<VeleroTV, String> trModelo;
    @FXML private TableColumn<VeleroTV, Integer> trEslora;
    @FXML private TableColumn<VeleroTV, Integer> trVela;
    @FXML private TableColumn<VeleroTV, String> trCombustible;
            
    @FXML private TextField textMarca;
    @FXML private TextField textModelo;
    @FXML private TextField textEslora;
    @FXML private TextField texteVela;

    
    
    @FXML private Button btAniadir;
    @FXML private Button btModificar;
    @FXML private Button btEliminar;
    @FXML private Button btNuevo;
    
    @FXML private Button btCargarCodigo;
    @FXML private Button btCargarFichero;
    @FXML private Button btGuardar;
    
///////////////////////////////////////////////////////////////////////////////
    ObservableList<VeleroTV> veleros = FXCollections.observableArrayList();
    
    private VeleroTV veleroTV;
    
//////////////////////////////////////////////////////////////    
    private int posicionVeleroEnTabla;
 /////////////////////////////////////////////////   
    @FXML private ChoiceBox<String> CBCombustible;  //esto es nuevo
    private ObservableList<String> listCombustibles = FXCollections.observableArrayList("Gasolina","Diesel","Electrico"); //esto es nuevo
 
    
/////////////////////////////////////////////////////////////////////////////// 
    @FXML
    private void Nuevo(ActionEvent event) {
     textMarca.setText("");
     textModelo.setText("");
     textEslora.setText("");
     texteVela.setText(""); 
     CBCombustible.setItems(listCombustibles);
     
    btModificar.setDisable(true);
    btEliminar.setDisable(true);
    btAniadir.setDisable(false); 
    }//Fin de Nuevo.

    
///////////////////////////////////////////////////////////////////////////////    
    @FXML
    private void Aniadir(ActionEvent event) {
        VeleroTV velero = new VeleroTV();
        velero.Marca.set(textMarca.getText());
        velero.Modelo.set(textModelo.getText());
        velero.Eslora.set(Integer.parseInt(textEslora.getText()));
        velero.Vela.set(Integer.parseInt(texteVela.getText()));
        velero.Combustible.set(CBCombustible.getValue());
        veleros.add(velero);
    }//Fin de Añadir.
  
///////////////////////////////////////////////////////////////////////////////
    @FXML
    private void Modificar(ActionEvent event) {
        VeleroTV velero = new VeleroTV();
        velero.Marca.set(textMarca.getText());
        velero.Modelo.set(textModelo.getText());
        velero.Eslora.set(Integer.parseInt(textEslora.getText()));
        velero.Vela.set(Integer.parseInt(texteVela.getText()));
        velero.Combustible.set(CBCombustible.getValue());
        veleros.set(posicionVeleroEnTabla, velero);        
    }//Fin de Modificar.

///////////////////////////////////////////////////////////////////////////////    
    @FXML
    private void Eliminar(ActionEvent event) {
        veleros.remove(posicionVeleroEnTabla);
    }//Fin de Eliminar.
    
/////////////////////////////////////////////////////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////// 


/**
 * Listener de la tabla veleros
 */
    private final ListChangeListener<VeleroTV> selectorTablaVeleros =
            new ListChangeListener<VeleroTV>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends VeleroTV> c) {
                    ponerVeleroSeleccionado();
                }
            };    
///////////////////////////////////////////////////////////////////////////////  
    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     * @return 
     */
    public VeleroTV getTablaVeleroSeleccionado() {
        if (TablaVelero != null) {
            List<VeleroTV> tabla = TablaVelero.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final VeleroTV competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }    
///////////////////////////////////////////////////////////////////////////////

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerVeleroSeleccionado() {
        final VeleroTV velero = getTablaVeleroSeleccionado();
        posicionVeleroEnTabla = veleros.indexOf(velero);

        if (velero != null) {

            // Pongo los textFields con los datos correspondientes
            textMarca.setText(velero.getMarca().toString());
            textModelo.setText(velero.getModelo().toString());
            textEslora.setText(velero.getEslora().toString());
            texteVela.setText(velero.getVela().toString()); 
            CBCombustible.setValue(velero.getCombustible().toString());
            // Pongo los botones en su estado correspondiente
            
            btModificar.setDisable(false);
            btEliminar.setDisable(false);
            btAniadir.setDisable(true);
        }
    }    
///////////////////////////////////////////////////////////////////////////////

    /**
     * Método para inicializar la tabla
     */
    private void inicializarTablaVeleros() {
        
        trMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
        trModelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
        trEslora.setCellValueFactory(new PropertyValueFactory<>("Eslora"));
        trVela.setCellValueFactory(new PropertyValueFactory<>("Vela"));        
        trCombustible.setCellValueFactory(new PropertyValueFactory<>("Combustible"));
        
        this.veleros = FXCollections.observableArrayList();
        TablaVelero.setItems(veleros);
    }
/**
 * initialize
 * Cargamos ArrayList del ChoiseBox
 * Iniciamos la TablaVeleros
 * @param url
 * @param rb 
 */
/////////////////////////////////////////////////////////////////////////////// 
///////////////////////////////////////////////////////////////////////////////        
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        
        CBCombustible.setItems(listCombustibles); //esto es nuevo
        CBCombustible.setValue(listCombustibles.get(1)); //esto es nuevo

        
        // Inicializamos la tabla
        this.inicializarTablaVeleros();

        // Ponemos estos dos botones para que no se puedan seleccionar
        btModificar.setDisable(true);
        btEliminar.setDisable(true);

        // Seleccionar las tuplas de la tabla de las personas
        final ObservableList<VeleroTV> tablaVelerosSel = TablaVelero.getSelectionModel().getSelectedItems();
        tablaVelerosSel.addListener(selectorTablaVeleros);

    }//Fin del inizialize.  
///////////////////////////////////////////////////////////////////////////////    
///////////////////////////////////////////////////////////////////////////////     

    @FXML
    private void CargarCodigo(ActionEvent event) {
        VeleroTV velero = new VeleroTV();
        velero.Marca.setValue("Honda");
        velero.Modelo.setValue("DW1F");
        velero.Eslora.setValue(Integer.parseInt("12"));
        velero.Vela.setValue(Integer.parseInt("2"));
        velero.Combustible.setValue(listCombustibles.get(0));
        veleros.add(velero);
        
    }//Fin de Cargar desde codigo.
    
///////////////////////////////////////////////////////////////////////////////      

    @FXML private void CargarFichero(ActionEvent event) {
        Gestor.CargarArchivo(veleros, veleroTV);  
    }//Fin de Cargar desde Fichero.
   
///////////////////////////////////////////////////////////////////////////////  

    @FXML private void Guardar(ActionEvent event) {
        Gestor.GuardarArchivo(veleros, veleroTV);

    }//Fin de Guardar en Fichero.
    
    

    
    
    
    
}//Fin de la VistaControlador
