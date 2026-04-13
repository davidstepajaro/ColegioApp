package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Persona {

    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected String fechaNacimiento;
//constructor de la clase persona 
    public Persona(String nombre, String direccion, String telefono, String fechaNacimiento) {

        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento); 
    }
//valida y asigna el nombre de la persona 
    //permite solo letras
    public void setNombre(String nombre) {
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException("Nombre invalido");
        }
        this.nombre = nombre;
    }
//valida y asigna la dirrecion de la persona 
    //no permite valores vacios o solo espacios 
    public void setDireccion(String direccion) {
        if (direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("Direccion invalida");
        }
        this.direccion = direccion;
    }
//valida y asigna el numero de telefono
    //debe contener exactamente 10 digitos 
    public void setTelefono(String telefono) {
        if (!telefono.matches("\\d{10}")) {
            throw new IllegalArgumentException("Telefono invalido");
        }
        this.telefono = telefono;
    }
//valida y asigna fecha de nacimiento
    //acepta solo dos formatos: dd-MM-yyyy o dd/MM/yyyy
    public void setFechaNacimiento(String fecha) {

        if (fecha == null || fecha.trim().isEmpty()) {
            throw new IllegalArgumentException("Fecha invalida. Use dd-MM-yyyy o dd/MM/yyyy");
        }

        fecha = fecha.trim();

        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate.parse(fecha, formato1);
        } catch (DateTimeParseException e1) {
            try {
                LocalDate.parse(fecha, formato2);
            } catch (DateTimeParseException e2) {
                throw new IllegalArgumentException("Fecha invalida. Use dd-MM-yyyy o dd/MM/yyyy");
            }
        }

        this.fechaNacimiento = fecha;
    }
//retorna el nombre de la persona
    public String getNombre() {
        return nombre;
    }
//retorna el numero de telefono de la persona 
    public String getTelefono() {
        return telefono;
    }
}