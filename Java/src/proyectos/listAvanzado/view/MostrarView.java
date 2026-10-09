package proyectos.listAvanzado.view;

import proyectos.listAvanzado.data.TrabajadorData;
import proyectos.listAvanzado.util.Validador;

public class MostrarView {
    private TrabajadorData trabajadores;

    public MostrarView(TrabajadorData trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void mostrarTrabajadores() {

        String menu = """
                ========================================
                       MOSTRAR TRABAJADORES
                ========================================
                
                1. Mostrar todos
                2. Mostrar nombres
                3. Mostrar mayores de edad
                4. Mostrar por departamento
                5. Mostrar salarios
                6. Volver""";

        while (true) {
            int opcion = Validador.leerInt(menu);
            switch (opcion) {
                case 1 -> trabajadores.mostrarDatos(System.out::println, true);
                case 2 -> {
                    System.out.println("Nombres: ");
                    trabajadores.mostrarDatos(p -> System.out.println(p.getNombre()), false);
                }
                case 3 -> {
                    System.out.println("Mayores de edad: ");
                    trabajadores.mostrarDatos(p -> {
                        if (p.getEdad() > 18)
                            System.out.println(p.getEdad());
                    }, false);
                }
                case 4 -> trabajadores.mostrarDatos(p -> System.out.println("Departamento: " + p.getDepto().toString() + " Id: " + p.getId()), false);
                case 5 -> trabajadores.mostrarDatos(p -> {
                    System.out.println("Id: " + p.getId() + " Salario: " + p.getSalario());
                }, false);
                case 6 -> {
                    System.out.println("Volviendo al menu...");
                    return;
                }
                default -> System.out.println("Agrega una opcion valida");
            }
        }
    }

}
