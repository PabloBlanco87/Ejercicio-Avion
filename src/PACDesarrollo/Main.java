package PACDesarrollo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*Declaramos variables y la clase Scanner para que el usuario pueda introducir 
        el número de plazas, y con ello el número de pasajeros que tiene el avión*/
        Scanner scan = new Scanner(System.in);
        int i;
        int numeroDePasajeros;

        //Pedimos por pantalla al usuario de la aplicación que nos indique el número de plazas
        System.out.println("Por favor, indique el número de plazas del avión");
        numeroDePasajeros = scan.nextInt();

        //Creamos un objeto Pasajeros, para poder acceder a sus métodos
        Pasajeros todosLosPasajeros = new Pasajeros();

        /* Creamos los pasajeros y los metemos dentro de la lista de pasajeros; utilizamos un bucle for 
        para que nos/cree los objetos Pasajero automáticamente el programa mediante un índice*/
        for (i = 0; i < numeroDePasajeros; i++) {
            Pasajero pasajero = new Pasajero(("Pasajero " + i), i);
            todosLosPasajeros.addPasajero(pasajero);
        }

        //Iniciamos iterador para que recorra el ArrayList
        todosLosPasajeros.iniciarIterador();

        //Iniciamos el método para que nos imprima por consola la lista de pasajeros
        System.out.println("Esta es la lista de pasajeros");
        todosLosPasajeros.getListaDePasajeros();
        System.out.println();

        //Iniciamos el método para que nos desordene la lista de pasajeros y nos lo imprima por pantalla
        System.out.println("Ahora desordenamos la lista de pasajeros");
        todosLosPasajeros.desordenar();
        System.out.println();

        /*Creamos el objeto Pasajero para poder utilizar los métodos que hemos creado 
        en dicha clase sobre el Pasajero de índice 0 (el que ha perdido la tarjeta de embarque)*/
        Pasajero primerPasajero = todosLosPasajeros.listaPasajeros.get(0);
        
        /*Iniciamos una variable de tipo entero que nos indicará cuál es el asiento inicial
        en el que se sienta el Pasajero de índice 0 (el que ha perdido la tarjeta de embarque)*/
        int asientoInicialPrimerPasajero = primerPasajero.getNumeroAsiento();

        //Creamos el objeto Avion para poder utilizar los métodos que hemos creado en dicha clase
        Avion avionDePasajeros = new Avion(numeroDePasajeros);
        
        //Inicializamos el método embarque() que toma por parámetro el objeto Pasajeros que hemos creado previamente
        avionDePasajeros.embarque(todosLosPasajeros);
        
        //Creamos un bucle para que nos vaya mostrando en orden de llegada la plaza asignada a cada Pasajero, con su nombre y su número de asiento
        System.out.println("Asientos asignados");
        int contador = 1;
        
        //La sentencia de abajo con : , es como un foreach, itera sobre la colección devolviendo en cada vuelta el siguiente pasajero
        for (Pasajero pasajero : todosLosPasajeros.listaPasajeros) {
            System.out.println("Plaza de avión ocupada en orden de llegada número " + contador + " " + pasajero.toString());
            contador++;
        }

        //Obetenemos los elementos del ArrayList del índice 0 (Pasajero 0, el que pierde la tarjeta de embarque)
        primerPasajero = todosLosPasajeros.listaPasajeros.get(0);
        
        //Obetenemos la posición final del primer pasajero
        int posicionFinalPrimerPasajero = primerPasajero.getNumeroAsiento();
        

        /*Creamos la condición que si el asiento inicial, coincide con el asiento final, entonces es que por suerte, se ha sentado en el asiento correcto, 
        si no, nos indica donde se ha sentado, y cuál era el asiento donde debería haberse sentado de haber conservado su tarjeta de embarque*/
        if (asientoInicialPrimerPasajero == posicionFinalPrimerPasajero) {
            System.out.println();
            System.out.println("El pasajero que ha perdido la tarjeta de embarque se ha sentado en su asiento correcto");
        } else {
            System.out.println();
            System.out.println("El primer pasajero tenía que sentarse en el asiento: " + asientoInicialPrimerPasajero + " y se ha sentado en el asiento: " + posicionFinalPrimerPasajero);
            System.out.println("Asiento incorrecto");
        }
    }
}
