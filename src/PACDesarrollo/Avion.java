package PACDesarrollo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Avion {

    private int numPlazas;
    Random random = new Random();

    //Constructor que toma como parámetro un tipo entero (el número de plazas del avión)
    public Avion(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    //Creamos la función embarque, que toma como parámetro un objeto de tipo Pasajero
    public void embarque(Pasajeros pasajeros) {
        //Declaramos una variable de tipo entero que nos servirá para seguir dando vueltas al bucle que crearemos en la línea 26
        int index = 0;

        //Declaramos e instanciamos un ArrayList de tipo Integer al que llamamos asientosAsignados
        ArrayList<Integer> asientosAsignados = new ArrayList<>();

        //Creamos el bucle for con dos condiciones, mientras se cumplan (es un boolean), el bucle se seguirá ejecutando
        for (Iterator<Pasajero> iterator = pasajeros.listaPasajeros.iterator(); iterator.hasNext();) {

            //Nos devolverá el siguiente pasajero (si se cumplen las condiciones del for)
            Pasajero pasajero = iterator.next();

            //El primero siempre pierde la tarjeta y le cambiamos a "es verdad" que ha perdido la tarjeta de embarque
            if (index == 0) {
                pasajero.setPerdidoTarjeta(true);
            }

            /*Declaramos variable de tipo entero asiento y la igualamos a lo que nos crea la función 
            obtieneAsientoDisponible() que hemos creado abajo  y nos devuelve un tipo entero*/
            int asiento = obtieneAsientoDisponible(pasajero, asientosAsignados);

            //Con la siguiente sentencia, nos devolverá el número de asiento de cada pasajero
            pasajero.setNumeroAsiento(asiento);

            //Hacemos sumatorio de la variable index para obligar a nuestro programa a que solo pierda la tarjeta de embarque el primer pasajero (index=0)
            index++;
        }
    }

    //Creamos la función obtieneAsientoDisponible() que recibe como parámetros un objeto Pasajero y un ArrayList de tipo entero para utilizarlo en la funcióm embarque
    private int obtieneAsientoDisponible(Pasajero pasajero, ArrayList<Integer> asientosAsignados) {

        //Creamos las variables
        int resultado = 0;
        boolean asientoNoDisponible;

        //Hacemos un do-while para obligar a que entre por lo menos una vez mientras que el asiento no disponible sea true
        do {
            //Declaramos la variable booleana como falsa de incio
            asientoNoDisponible = false;

            /*Creamos condición, si el objeto Pasajero ha perdido la tarjeta (isPerdidoTarjeta es un getter), 
            generará un número de asiento al azar (donde se sentará el primer pasajero), si no la ha perdido, 
            la variable resultado tomará como valor el número de asiento asignado inicial*/
            if (pasajero.isPerdidoTarjeta()) {
                resultado = random.nextInt(numPlazas);
            } else {
                resultado = pasajero.getNumeroAsiento();
            }

            //Creamos un bucle for, que debe recorrer la lista con el iterador que inicializamos, y cumplir la condición booleana hasNext()
            for (Iterator<Integer> iterator = asientosAsignados.iterator(); iterator.hasNext();) {

                ////Nos devolverá el numeor de asiento del siguiente pasajero (si se cumplen las condiciones del for)
                Integer numeroAsiento = iterator.next();

                //Si la variable resultado tiene el mismo valor que el valor del iterador, asigna a la variable asientoNoDisponible el valor true, y nos saca del bucle for
                if (resultado == numeroAsiento) {
                    asientoNoDisponible = true;
                    break;
                }
            }

            //Creamos la condicion de: si el asiento no está disponible entonces, lo tratamos como si hubiese perdido la tarjeta y volverá al bucle for
            if (asientoNoDisponible) {
                pasajero.setPerdidoTarjeta(true);
            } else {
                asientoNoDisponible = false;
            }
        } while (asientoNoDisponible);

        //Asignamos resultado al iterador
        asientosAsignados.add(resultado);

        //Devolvemos valor de tipo entero para utilizarlo en la función embarque
        return resultado;
    }
    

    /////////////////////////////////////////////////////////////////////////////////////
    ////Esta es otra función que funciona, pero me parecía más elegante la otra sin    //
    ////hacer la función recursiva, por lo que he visto en foros, no está considerada  //
    ////una buena práctica                                                             //
    /////////////////////////////////////////////////////////////////////////////////////
    
  /*  private int obtieneAsientoDisponible(Pasajero pasajero, ArrayList<Integer> asientosAsignados) {
        int resultado;

        if (pasajero.isPerdidoTarjeta()) {
            resultado = random.nextInt(numPlazas);
        } else {
            resultado = pasajero.getNumeroAsiento();
        }

        boolean yaHaSidoAsignado = false;

        for (Iterator<Integer> iterator = asientosAsignados.iterator(); iterator.hasNext();) {
            Integer numeroAsiento = iterator.next();

            if (resultado == numeroAsiento) {
                yaHaSidoAsignado = true;
                break;
            }
        }

        if (yaHaSidoAsignado) {
            pasajero.setPerdidoTarjeta(true);
            return obtieneAsientoDisponible(pasajero, asientosAsignados);
        }

        asientosAsignados.add(resultado);
        return resultado;
    }*/
}
