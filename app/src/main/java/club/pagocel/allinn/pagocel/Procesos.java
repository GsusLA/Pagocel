package club.pagocel.allinn.pagocel;

/**
 * Created by Jesus on 02/08/2016.
 */
public class Procesos {
    Incrypt crypt;
    Conection conect;

    /** Constructor de la clase Procesos, aqui se inicializaran las clases y metodos
     * necesarios para el fucncionamiento de la aplicacion,  esta clase sera la que
     * actuara como capa 2 de la app, ya que aqui se realizaran los procesos que se
     * soliciten desde la app y que requieran el uso de otras clase como Conection
     * o Incrypt, de esta manera se dividen la actividades de la app en capas
     */
    public Procesos(){
        crypt = new Incrypt();
        conect = new Conection();
    }
    public boolean inicioSesion(String usr, String pssw){
        return true;
    }
}
