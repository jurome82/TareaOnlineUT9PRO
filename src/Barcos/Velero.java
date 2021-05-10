
package Barcos;


public class Velero {
         

private String Marca;
private String Modelo;
private int Eslora; //(longitud del barco).
private int Vela; //(Altura del barco)    
private String Combustible;

    public Velero() {
    }

    public Velero(String Marca, String Modelo, int Eslora, int Vela, String Combustible) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Eslora = Eslora;
        this.Vela = Vela;
        this.Combustible = Combustible;
    }//Fin del Constructor
    
       public Velero(VeleroTV veleroTV) {
        String Marca = (veleroTV.getMarca());
        String Modelo = veleroTV.getModelo();
        float Eslora = veleroTV.getEslora();
        float Vela = veleroTV.getVela();
        String Combustible = veleroTV.getCombustible();
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Eslora = (int) Eslora;
        this.Vela = (int) Vela;
        this.Combustible = Combustible; 
       }
    
    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getEslora() {
        return Eslora;
    }

    public int getVela() {
        return Vela;
    }
    
    public String getCombustible() {
        return Combustible;
    }    


    
    
    
    
    



}//Fin de la Clase Velero
