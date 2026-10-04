package proyectos.listAvanzado.model;

public class Trabajador {

    public enum Departamento{
        Desarrollo, Diseño, Administracion
    }


    private int id;
    private String nombre;
    private double salario;
    private Departamento depto;

    public Trabajador(int id, String nombre, double salario, Departamento depto) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.depto = depto;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", depto=" + depto +
                '}';
    }
}
