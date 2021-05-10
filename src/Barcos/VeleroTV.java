/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barcos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author jurome
 */
public class VeleroTV {
    

public SimpleStringProperty Marca = new SimpleStringProperty();
public SimpleStringProperty Modelo = new SimpleStringProperty();
public SimpleIntegerProperty Eslora = new SimpleIntegerProperty();
public SimpleIntegerProperty Vela = new SimpleIntegerProperty();
public SimpleStringProperty Combustible = new SimpleStringProperty();

    public VeleroTV() {
    }//Fin del constructor vacio.

    public VeleroTV(SimpleStringProperty Marca, SimpleStringProperty Modelo, SimpleIntegerProperty Eslora, SimpleIntegerProperty Vela, SimpleStringProperty Combustible) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Eslora = Eslora;
        this.Vela = Vela;
        this.Combustible = Combustible;
    }//Fin del constructor VeleroTV.

    public VeleroTV(Velero velero) {
        SimpleStringProperty Marca = new SimpleStringProperty(velero.getMarca());
        SimpleStringProperty Modelo = new SimpleStringProperty(velero.getModelo());
        SimpleIntegerProperty Eslora = new SimpleIntegerProperty(velero.getEslora());
        SimpleIntegerProperty Vela = new SimpleIntegerProperty(velero.getVela());
        SimpleStringProperty Combustible = new SimpleStringProperty(velero.getCombustible());
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Eslora = Eslora;
        this.Vela = Vela;
        this.Combustible = Combustible;
    }//Fin del constructor de Velero en VeleroTV



    public String getMarca() {
        return Marca.get();
    }

    public String getModelo() {
        return Modelo.get();
    }

    public Integer getEslora() {
        return Eslora.get();
    }

    public Integer getVela() {
        return Vela.get();
    }

    public String getCombustible() {
        return Combustible.get();
    }//Fin get Gasolina.

   

    
    
}//Fin de Velero TV.
