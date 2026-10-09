package proyectos.listAvanzado.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {
    private static final Scanner teclado = new Scanner(System.in);

    public static String leerString(String mensaje, boolean vacio){
        System.out.println(mensaje);
        String salida;
        if (vacio){
            return teclado.nextLine();
        }
        do {
            salida = teclado.nextLine();
            if(salida.isEmpty())
                System.out.println("No empty");
        }while(salida.isEmpty());
        return salida;
    }

    public static int leerInt(String mensaje) {
        String numero;
        Pattern patron = Pattern.compile("\\d+");

        do {
            numero = leerString(mensaje, false);

            if (!patron.matcher(numero).matches()) {
                System.out.println("Solo enteros");
            }

        } while (!patron.matcher(numero).matches());

        return Integer.parseInt(numero);
    }

}
