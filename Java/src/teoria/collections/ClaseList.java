package teoria.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ClaseList {

    public static void main(String[] args) {

        lambdasEnCollections();
        interfacesFuncionales();
        operaciones();
        ordenacion();
        referenciasAMetodos();

    }


    /**
     * =========================================================
     * 1. LAMBDAS EN COLLECTIONS
     * =========================================================
     *
     * Una lambda permite pasar COMPORTAMIENTO como parámetro.
     *
     * En lugar de crear un método para indicar qué hacer,
     * podemos pasar directamente la operación.
     *
     * Forma general:
     *
     *      parametros -> expresion
     *
     * o:
     *
     *      parametros -> {
     *          instrucciones;
     *      }
     */


    public static void lambdasEnCollections() {

        List<Integer> numeros =
                new ArrayList<>(List.of(
                        10, 20, 30, 40, 50
                ));


        /*
         * forEach recibe una acción.
         *
         * La lambda:
         *
         *      numero -> System.out.println(numero)
         *
         * significa:
         *
         * "Para cada número, ejecuta esto".
         */

        numeros.forEach(
                numero -> System.out.println(numero)
        );


        /*
         * Podemos hacer que la lambda tenga varias instrucciones.
         */

        numeros.forEach(numero -> {

            int resultado = numero * 2;

            System.out.println(resultado);

        });
    }


    /**
     * =========================================================
     * 2. INTERFACES FUNCIONALES
     * =========================================================
     *
     * Muchas operaciones de Collections utilizan interfaces
     * funcionales.
     *
     * Las cuatro que debes dominar:
     *
     * Predicate<T>
     * Consumer<T>
     * Function<T,R>
     * UnaryOperator<T>
     */


    public static void interfacesFuncionales() {

        List<Integer> numeros =
                new ArrayList<>(List.of(
                        10, 20, 30, 40
                ));


        /*
         * -----------------------------------------------------
         * PREDICATE
         * -----------------------------------------------------
         *
         * Recibe T
         * Devuelve boolean
         *
         * T -> boolean
         */

        Predicate<Integer> esMayorQue20 =
                numero -> numero > 20;


        System.out.println(
                esMayorQue20.test(30)
        );


        /*
         * removeIf() utiliza precisamente un Predicate.
         */

        numeros.removeIf(esMayorQue20);


        /*
         * También podemos escribirlo directamente:
         */

        numeros.removeIf(numero -> numero > 20);


        /*
         * -----------------------------------------------------
         * CONSUMER
         * -----------------------------------------------------
         *
         * Recibe T
         * No devuelve nada.
         *
         * T -> void
         */

        Consumer<Integer> mostrar =
                numero -> System.out.println(numero);

        numeros.forEach(mostrar);


        /*
         * -----------------------------------------------------
         * FUNCTION
         * -----------------------------------------------------
         *
         * Recibe T
         * Devuelve R
         *
         * T -> R
         */

        Function<Integer, String> convertir =
                numero -> "Número: " + numero;

        String resultado = convertir.apply(50);


        /*
         * -----------------------------------------------------
         * UNARYOPERATOR
         * -----------------------------------------------------
         *
         * Recibe T
         * Devuelve T
         *
         * T -> T
         */

        UnaryOperator<Integer> duplicar =
                numero -> numero * 2;

        int numero = duplicar.apply(10);
    }


    /**
     * =========================================================
     * 3. OPERACIONES FUNCIONALES SOBRE LIST
     * =========================================================
     */

    public static void operaciones() {

        List<Integer> numeros =
                new ArrayList<>(List.of(
                        1, 2, 3, 4, 5
                ));


        /*
         * replaceAll()
         *
         * Modifica cada elemento utilizando una función.
         *
         * Es equivalente conceptualmente a:
         *
         *      elemento = funcion(elemento)
         */

        numeros.replaceAll(
                numero -> numero * 10
        );


        /*
         * Ahora:
         *
         * [10, 20, 30, 40, 50]
         */


        /*
         * removeIf()
         *
         * Elimina elementos según un Predicate.
         */

        numeros.removeIf(
                numero -> numero > 30
        );


        /*
         * Resultado:
         *
         * [10, 20, 30]
         */


        /*
         * forEach()
         *
         * Ejecuta un Consumer.
         */

        numeros.forEach(
                numero -> System.out.println(numero)
        );
    }


    /**
     * =========================================================
     * 4. ORDENACIÓN FUNCIONAL
     * =========================================================
     *
     * Aquí entramos en Comparator.
     */

    public static void ordenacion() {

        List<Persona> personas =
                new ArrayList<>(List.of(

                        new Persona("Joel", 20),
                        new Persona("Ana", 25),
                        new Persona("Carlos", 18),
                        new Persona("Pedro", 30)

                ));


        /*
         * Ordenar por edad.
         */

        personas.sort(
                (p1, p2) ->
                        Integer.compare(
                                p1.getEdad(),
                                p2.getEdad()
                        )
        );


        /*
         * Comparator.comparing()
         *
         * Permite expresar la misma idea de manera
         * más declarativa.
         */

        personas.sort(
                Comparator.comparing(
                        Persona::getEdad
                )
        );


        /*
         * Orden descendente.
         */

        personas.sort(
                Comparator.comparing(
                        Persona::getEdad
                ).reversed()
        );


        /*
         * Ordenar por nombre.
         */

        personas.sort(
                Comparator.comparing(
                        Persona::getNombre
                )
        );


        /*
         * Comparator encadenado.
         *
         * Primero apellido.
         * Si empatan, edad.
         */

        personas.sort(
                Comparator
                        .comparing(Persona::getNombre)
                        .thenComparing(Persona::getEdad)
        );
    }


    /**
     * =========================================================
     * 5. METHOD REFERENCES
     * =========================================================
     *
     * Una method reference permite sustituir ciertas lambdas
     * cuando simplemente estamos llamando a un método existente.
     *
     * Lambda:
     *
     *      p -> p.getNombre()
     *
     * Method reference:
     *
     *      Persona::getNombre
     */


    public static void referenciasAMetodos() {

        List<Persona> personas =
                new ArrayList<>(List.of(

                        new Persona("Joel", 20),
                        new Persona("Ana", 25),
                        new Persona("Carlos", 18)

                ));


        /*
         * Lambda
         */

        personas.forEach(
                p -> System.out.println(p.getNombre())
        );


        /*
         * Method reference
         */

        personas.forEach(
                p -> System.out.println(p.getNombre())
        );


        /*
         * Otro ejemplo.
         *
         * Comparator.comparing() necesita una función:
         *
         * Persona -> algo
         *
         * Persona::getEdad representa precisamente eso.
         */

        personas.sort(
                Comparator.comparing(Persona::getEdad)
        );
    }


    /**
     * =========================================================
     * IDEA FUNDAMENTAL
     * =========================================================
     *
     * Collections modernas no consisten únicamente en:
     *
     *      add()
     *      get()
     *      remove()
     *
     * Sino en pasar COMPORTAMIENTO.
     *
     * Ejemplo:
     *
     *      removeIf(Predicate)
     *
     *      forEach(Consumer)
     *
     *      replaceAll(UnaryOperator)
     *
     *      sort(Comparator)
     *
     * Esto es la base para entender Streams.
     */
}