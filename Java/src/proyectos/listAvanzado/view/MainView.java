package proyectos.listAvanzado.view;

import proyectos.listAvanzado.data.TrabajadorData;
import proyectos.listAvanzado.util.Validador;

public class MainView {

    public static void mainMenu() {
        TrabajadorData td = new TrabajadorData();
        MostrarView mv = new MostrarView(td);

        String menu = """
                ========================================
                       GESTIÓN DE TRABAJADORES
                ========================================
                
                1. Mostrar trabajadores
                2. Buscar trabajadores
                3. Eliminar trabajadores
                4. Modificar trabajadores
                5. Ordenar trabajadores
                6. Estadísticas
                7. Aplicar modificaciones masivas
                8. Procesar trabajadores
                9. Restaurar trabajadores
                0. Salir
                
                Seleccione una opción:""";


        while (true) {
            int opcion = Validador.leerInt(menu);
            switch (opcion) {
                case 0 -> {
                    System.out.println("Adios, cerrando el programa...");
                    System.exit(0);
                }
                case 1 -> {
                    mv.mostrarTrabajadores();
                }
                default -> System.out.println("Agrega una opcion valida");
            }
        }


    }

    public static void main(String[] args) {
        MainView.mainMenu();
    }


}
