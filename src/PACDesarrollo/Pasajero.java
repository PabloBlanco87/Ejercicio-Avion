package PACDesarrollo;

public class Pasajero {

    /* Creamos los 3 atributos o propiedades propuestas, nombre, número de asiento 
    asignado y un boolean para comprobar si el pasajero ha perdido la tarjeta o no:
     */
    private String nombre;
    private int numeroAsiento;
    private boolean perdidoTarjeta = false;

    // Creamos el constructor, que recibe como parámetros el nombre del pasajero, su asiento y si ha perdido la tarjeta
    public Pasajero(String nombre, int numeroAsiento) {

        this.nombre = nombre;
        this.numeroAsiento = numeroAsiento;
    }

    // Creamos todos los Getters de los atributos de la clase Pasajero: 
    public String getNombre() {
        return nombre;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public boolean isPerdidoTarjeta() {
        return perdidoTarjeta;
    }

    // Creamos todos los Setters de los atributos de la clase Pasajero  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public void setPerdidoTarjeta(boolean perdidoTarjeta) {
        this.perdidoTarjeta = perdidoTarjeta;
    }

    // Creamos la función toString() de la clase Pasajero:
    @Override
    public String toString() {
        return "Pasajero{" + "Nombre: " + nombre + ", Numero de asiento: " + numeroAsiento + '}';
    }
}
