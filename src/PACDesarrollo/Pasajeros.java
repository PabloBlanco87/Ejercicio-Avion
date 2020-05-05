package PACDesarrollo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Pasajeros {

    /*Declaramos las variables de número de pasajeros, declaramos el ArrayList y lo instanciamos, 
    y por último, declaramos el Iterador, pero no lo instanciamos, tenemos que instanciarlo 
    cuando tengamos el ArrayList lleno, porque si no, se muestra vacío*/
    public final ArrayList<Pasajero> listaPasajeros = new ArrayList<>();
    public Iterator<Pasajero> mi_iterador;

    //Constructor, que toma como parámetro el número de pasajeros
    public Pasajeros() {
    }

    //Función que nos permite saber si tenemos más pasajeros en la lista
    public boolean tieneMasPasajeros() {
        return mi_iterador.hasNext();
    }

    //Función que nos devolverá el siguiente pasajero de la lista
    public Pasajero siguientePasajero() {
        if (mi_iterador.hasNext()) {
            return mi_iterador.next();
        } else {
            return null;
        }
    }

    //Función que nos permite añadir pasajeros a la lista
    public void addPasajero(Pasajero pasajero) {
        listaPasajeros.add(pasajero);
    }

    //Función que nos desordenará la lista de pasajeros (también la imprime desordenada) 
    public void desordenar() {
        Collections.shuffle(this.listaPasajeros);
        Iterator<Pasajero> it = this.listaPasajeros.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    //Función que inicia el iterador (SOLO USARLA CUANDO TENGAMOS LA LISTA LLENA)
    public void iniciarIterador() {
        mi_iterador = listaPasajeros.iterator();
    }

    //Función que nos imprime la lista de pasajeros por consola
    public void getListaDePasajeros() {
        while (mi_iterador.hasNext()) {
            Pasajero variable = mi_iterador.next();
            System.out.println(variable);
        }
    }
}
