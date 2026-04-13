package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter; 

public class Profesor extends Persona {

    private String cedula;
    private String area;
    private double salarioHora;
    private int horasMes;
//contructor de la clase profesor 
//inicia los atributos heredados y propios del profesor 
//valida la mayoria de edad     
    public Profesor(String nombre, String direccion, String telefono, String fechaNacimiento,
                    String cedula, String area, double salarioHora, int horasMes) {

        super(nombre, direccion, telefono, fechaNacimiento);

        if (!esMayorDeEdad()) {
            throw new IllegalArgumentException("El profesor debe ser mayor de edad");
        }

        setCedula(cedula);
        setArea(area);
        setSalarioHora(salarioHora);
        setHorasMes(horasMes);
    }

    //  CONVERSOR DE FECHA CORRECTO
    //acepta dos dormatos 
    private LocalDate convertirFecha(String fecha) {
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            return LocalDate.parse(fecha, f1);
        } catch (Exception e) {
            return LocalDate.parse(fecha, f2);
        }
    }

    //  VALIDACION DE EDAD CORRECTA
    private boolean esMayorDeEdad() {
        LocalDate fecha = convertirFecha(this.fechaNacimiento);
        return Period.between(fecha, LocalDate.now()).getYears() >= 18;
    }
    //valida la cc del profesor solo permite valores numericos
    public void setCedula(String cedula) {
        if (!cedula.matches("\\d+")) {
            throw new IllegalArgumentException("Cedula invalida");
        }
        this.cedula = cedula;
    }

    public void setArea(String area) {
        if (area == null || area.trim().isEmpty()) {
            throw new IllegalArgumentException("Area vacia");
        }

        area = area.trim();

        if (!area.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException("Area invalida, solo letras");
        }

        this.area = area;
    }
//valida y asigna el salario por hora 
    public void setSalarioHora(double salarioHora) {
        if (salarioHora <= 0) {
            throw new IllegalArgumentException("Salario invalido");
        }
        this.salarioHora = salarioHora;
    }

    public void setHorasMes(int horasMes) {
        if (horasMes <= 0) {
            throw new IllegalArgumentException("Horas invalidas");
        }
        this.horasMes = horasMes;
    }

    public double calcularSalario() {
        double base = salarioHora * horasMes;
        return base + (base * 0.30);
    }

    public double calcularPrestaciones() {
        return calcularSalario() * 0.19;
    }

    // SOBRECARGA
    public double calcularSalario(double bono) {
        return calcularSalario() + bono;
    }

    public String getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Profesor: " + nombre + " - Area: " + area + " - Salario: " + calcularSalario();
    }
}