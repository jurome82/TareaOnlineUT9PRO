/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorDeDatos;

import Barcos.Velero;
import Barcos.VeleroTV;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.collections.ObservableList;

/**
 *
 * @author jurom
 */
public class Gestor {
    

    public static ArrayList<Velero> lista_veleroList = new ArrayList();

    

    public static void GuardarArchivo(ObservableList<VeleroTV> lista_velero, VeleroTV veleroTV) {

        Iterator<VeleroTV> it = lista_velero.iterator();
        while (it.hasNext()) {

            veleroTV = it.next();
            Velero velero = new Velero(veleroTV);
            lista_veleroList.add(velero);

        }
        try {
           
            FileOutputStream salida = new FileOutputStream("veleroBinario.obj");
            ObjectOutputStream procesar = new ObjectOutputStream(salida);

            procesar.writeObject(lista_veleroList);

            procesar.close();
            salida.close();

        } catch (FileNotFoundException e) {
            System.out.println("No pudo crearse el fichero");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }//Fin del Metodo para GuardarArchivo.
    
    
    public static void CargarArchivo(ObservableList<VeleroTV> veleros, VeleroTV veleroTV) {
        Velero velero;

        Iterator<Velero> it = lista_veleroList.iterator();
        while (it.hasNext()) {
            velero = it.next();
            veleroTV = new VeleroTV(velero);
            veleros.add(veleroTV);

        }

        try {          
            FileInputStream f = new FileInputStream("CatalogoVeleros.obj");
            ObjectInputStream entrada = new ObjectInputStream(f);
            
            lista_veleroList = (ArrayList<Velero>) entrada.readObject();
            f.close();
            entrada.close();

        } catch (FileNotFoundException e) {
            
            System.out.println("Archivo Vacio");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha podido abrir el fichero");
        } catch (IOException e) {
            System.out.println("Error al leer del fichero");
            e.printStackTrace();
        }

    }//Fin del Metodo para cargar el arhivo    
    
    
    
    
    
    
}//fin clase gestora.
