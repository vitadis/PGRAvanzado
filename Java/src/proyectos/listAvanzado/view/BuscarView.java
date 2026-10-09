package proyectos.listAvanzado.view;

import proyectos.listAvanzado.data.TrabajadorData;
import proyectos.listAvanzado.util.Validador;

import java.util.concurrent.atomic.AtomicBoolean;

public class BuscarView {
    private TrabajadorData trabajadores;

    public BuscarView(TrabajadorData trabajadores) {
        this.trabajadores = trabajadores;
    }


    public void buscarTrabajadores(){
        String menu = """
                ========================================
                       BUSCAR TRABAJADORES
                ========================================
                
                1. Buscar por ID
                2. Buscar por nombre
                3. Buscar por departamento
                4. Buscar mayores de una edad
                5. Buscar salario superior a una cantidad
                6. Buscar por rango de edad
                7. Volver""";

        while(true) {
            int opcion = Validador.leerInt(menu);
            switch (opcion){
                case 1 -> {
                    int id = Validador.leerInt("Id: ");

                    trabajadores.mostrarDatos(p -> {
                        if(p.getId()==id){
                            System.out.println(p);
                        }
                    },true);
                }


                case 7 -> {
                    System.out.println("Volviendo al menu...");
                    return;
                }
                default -> System.out.println("Agrega una opcion valida");
            }
        }



    }


}
