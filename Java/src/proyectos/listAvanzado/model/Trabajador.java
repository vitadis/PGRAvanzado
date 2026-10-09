package proyectos.listAvanzado.model;

public class Trabajador {

    public enum Departamento{
        Desarrollo, Diseno, Administracion
    }


    private int id;
    private String nombre;
    private int edad;
    private int salario;
    private Departamento depto;

    public Trabajador(int id, String nombre, int edad,int salario, Departamento depto) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.depto = depto;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-5s | %-15s | %-5s | %-10s | %-15s |%n",
                id, nombre, edad, salario, depto
        );
    }
}
