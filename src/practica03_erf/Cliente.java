package practica03_erf;

public class Cliente{
    // Atributos
    private int numero;
    private String nombre;
    private int edad;
    private int puntos;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con todos los parámetros
    public Cliente(int numero, String nombre, int edad, int puntos) {
        this.numero = numero;
        this.nombre = nombre;
        this.edad = edad;
        this.puntos = puntos;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    // Método toString para visualizar los datos del cliente
    @Override
    public String toString() {
        return "Cliente {" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", puntos=" + puntos +
                '}';
    }
}