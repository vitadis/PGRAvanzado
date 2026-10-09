package proyectos.listAvanzado.data;

import proyectos.listAvanzado.model.Trabajador;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TrabajadorData {

    private List<Trabajador> trabajadores;

    public TrabajadorData() {
        this.trabajadores = cargarDatos();
    }

    public List<Trabajador> getTrabajador() {
        return trabajadores;
    }

    public void setTrabajador(List<Trabajador> trabajador) {
        this.trabajadores = trabajador;
    }

    private List<Trabajador> cargarDatos() {
        return new ArrayList<>(List.of(new Trabajador(1, "Joel", 20, 1800, Trabajador.Departamento.Desarrollo),
                new Trabajador(2, "Ana", 25, 2200, Trabajador.Departamento.Diseno),
                new Trabajador(3, "Carlos", 25, 1500, Trabajador.Departamento.Desarrollo)
        ));
    }

    private static String cabecera() {
        return String.format(
                "| %-5s | %-15s | %-5s | %-10s | %-15s |%n",
                "ID", "NOMBRE", "EDAD", "SALARIO", "DEPTO"
        );
    }

    public void mostrarDatos(Consumer<Trabajador> consumidor, boolean cabezera) {
        if (cabezera)
            System.out.println(cabecera());
        this.trabajadores.forEach(consumidor);
    }

/*
    public static void main(String[] args){
        TrabajadorData tl = new TrabajadorData();
        tl.getTrabajador().add(new Trabajador(4,"joel",19,18000, Trabajador.Departamento.Administracion));
        tl.mostrarDatos();

    }

*/


}
