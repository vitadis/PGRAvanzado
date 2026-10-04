package teoria.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ClaseList {
    static List<Persona> personas;

    static {
        personas = new ArrayList<>();
        personas.add(new Persona("Carlos", 28));
        personas.add(new Persona("Ana", 12));
        personas.add(new Persona("Luis", 22));
        personas.add(new Persona("Sofía", 29));
        personas.add(new Persona("Diego", 41));
        personas.add(new Persona("María", 19));
        personas.add(new Persona("Juan", 31));
        personas.add(new Persona("Elena", 11));
        personas.add(new Persona("Andrés", 38));
        personas.add(new Persona("Laura", 27));
    }

    //Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // lambdasEnCollections();
        // interfacesFuncionales();
        operaciones();
        //ordenacion();
        //referenciasAMetodos();

    }

    public static void lambdasEnCollections() {

        // ======================= EJERCICIO 1 ============================
        // recorrer numeros con lambda/method reference
        List<Integer> numeros = new ArrayList<>(
                List.of(5, 10, 15, 20, 25)
        );
        numeros.forEach(System.out::println); // es igual a numeros.forEach(o -> System.out.println(o))

        // Recorrer el mensaje de persona, con metodo reference.
        List<Persona> personas = new ArrayList<>(
                List.of(new Persona("Joel", 12), new Persona("Joelingo", 122))
        );

        // MR tiene que estar a corde de lo que pida, si es un predicado, deve retornar true, en este caso es un consumer, por ende retorna void
        personas.forEach(Persona::mensaje);
    }


    /**
     * Es una interfaz, que permite agregar una funcion.
     * - Solo tiene un metodo abstract, normalmente se usa uno para ejercutar(), start(), run(), lo que se vea,
     * el nombre da igual.
     * - Puede tener otros metodos statics.
     * <p>
     * - Para crear una interfaz funcional se usa la anotacion de:
     *
     * @FunctionalInterface
     *
     *
     */
    public static void interfacesFuncionales() {
        //predicado();
        // consumer();
        // function();
        unaryOperator();
    }

    public static void predicado() {

        /*
        List<Integer> numeros = new ArrayList<>(
                List.of(3, 8, 12, 15, 20, 23, 30)
        );

        numeros.forEach(System.out::println);
        // Es una interfaz funcional, que retorna un bool
        Predicate<Integer> esMayor = num -> num > 18;

        // numeros.forEach(o->System.out.println(esMayor.test(o)));

        //System.out.println("=============================================");
        numeros.removeIf(esMayor);
        numeros.forEach(System.out::println);
        */

        // Predicate -> return bool
        Predicate<Persona> esMayor = p -> p.getEdad() > 18;

        // elimino a los mayores de edad
        personas.removeIf(esMayor);
        personas.forEach(Persona::mensaje);
    }

    public static void consumer() {
        // consumer = void
        Consumer<Persona> funcion = p -> {
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Edad: " + p.getEdad());
        };
        personas.forEach(funcion);
    }

    // primer parametro entrada, segundo salida
    public static void function() {
        Function<Persona, String> funcion = p -> p.getNombre() + " tiene " + p.getEdad() + " años.";

        List<String> mensaje = personas.stream().map(funcion).toList();

        mensaje.forEach(System.out::println);
    }

    public static void unaryOperator() {
        UnaryOperator<Integer> operacion = n -> {
            if (n <= 1) return 1;
            int resultado = n;
            int c = 1;
            while (c != n) {
                resultado *= n;
                c++;
            }
            return resultado;
        };
        int num = operacion.apply(10);

        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        numeros.replaceAll(operacion);

        numeros.forEach(System.out::println);

        List<String> nombre = new ArrayList<>(List.of("joelinho", "joel", "alfonzo"));

        // paso un operador, no puedo explayarme
        nombre.replaceAll(n ->
                "joel".equals(n) ? "JOEL" : n);

        nombre.replaceAll(n -> {
            if (n.equals("JOEL"))
                return "CAMBIO 2";
            return n;
        });

        nombre.forEach(System.out::println);


    }

    public static void operaciones() {
        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5, 50, 10, 80, 20, 40));

        numeros.sort((n1,n2)-> Integer.compare(n2,n1));

        numeros.forEach(System.out::println);

        //personas.sort((p1,p2)-> Integer.compare(p2.getEdad(),p1.getEdad()));

        //personas.sort(Comparator.comparing(Persona::getEdad).reversed());

        // esto sirve, si ambos tienen la misma edad, se toma en cuenta primero edad y despues nombre.
        personas.sort(Comparator.comparing(Persona::getEdad)
                .thenComparing(Persona::getNombre)); // podemos crear varios thenComparing.


        personas.forEach(System.out::println);

    }


}
