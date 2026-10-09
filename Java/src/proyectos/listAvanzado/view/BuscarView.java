package proyectos.listAvanzado.view;

import proyectos.listAvanzado.data.TrabajadorData;
import proyectos.listAvanzado.model.Trabajador;
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
                    AtomicBoolean existe = new AtomicBoolean(false);
                    trabajadores.mostrarDatos(p -> {
                        if(p.getId()==id){
                            System.out.println(p);
                            existe.set(true);
                        }
                    },true);

                    if (!existe.get()){
                        System.out.println("No existe nadie con ese id");
                    }
                }
                case 2 -> {
                    String nombre = Validador.leerString("Nombre: ",false);
                    AtomicBoolean existe = new AtomicBoolean(false);
                    trabajadores.mostrarDatos(p -> {
                        if(p.getNombre().equals(nombre)){
                            System.out.println(p);
                            existe.set(true);
                        }
                    },true);

                    if (!existe.get()){
                        System.out.println("No existe nadie con ese nombre");
                    }
                }
                case 3 -> {
                    Trabajador.Departamento dpto = Validador.leerDpto("Departamento: ");
                    AtomicBoolean existe = new AtomicBoolean(false);
                    trabajadores.mostrarDatos(p -> {
                        if(p.getDepto().equals(dpto)){
                            System.out.println(p);
                            existe.set(true);
                        }
                    },true);

                    if (!existe.get()){
                        System.out.println("No existe ningun trabajador en ese departamento");
                    }
                }
                case 4 -> {
                    int edad = Validador.leerInt("Edad: ");
                    AtomicBoolean existe = new AtomicBoolean(false);
                    trabajadores.mostrarDatos(p -> {
                        if(p.getEdad()>edad){
                            System.out.println(p);
                            existe.set(true);
                        }
                    },true);

                    if (!existe.get()){
                        System.out.println("No existe ningun trabajador mayor de "+ edad);
                    }
                }
                case 5 -> {
                    int salario = Validador.leerInt("Salario: ");
                    AtomicBoolean existe = new AtomicBoolean(false);
                    trabajadores.mostrarDatos(p -> {
                        if(p.getSalario()>salario){
                            System.out.println(p);
                            existe.set(true);
                        }
                    },true);

                    if (!existe.get()){
                        System.out.println("No existe ningun trabajador con mayor salario a "+salario);
                    }
                }
                case 6 -> {
                    int edad1 = Validador.leerInt("Edad 1: ");
                    int edad2 = Validador.leerInt("Edad 2: ");

                    if (edad1 <18 ||edad2<18){
                        System.out.println("No contratamos menores de 18");

                    }
                    if ( edad1 > edad2){
                        int temp = edad2;
                        edad2 = edad1;
                        edad1 = temp;
                    }
                    int e1 = edad1;
                    int e2 = edad2;
                    AtomicBoolean existe = new AtomicBoolean(false);

                    trabajadores.mostrarDatos(p -> {
                        if(p.getEdad() >= e1  && p.getEdad()<= e2){
                            System.out.println(p);
                            existe.set(true);
                        }
                    },true);

                    if (!existe.get()){
                        System.out.println("No existe ningun trabajador con ese rango de edad");
                    }
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
