package modelo;

import java.util.ArrayList;
import java.util.Comparator;

public class GestionColegio {

    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();

    // VALIDAR PERSONA REPETIDA
    public boolean existePersona(String nombre, String telefono) {
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombre) && e.getTelefono().equals(telefono)) {
                return true;
            }
        }
        for (Profesor p : profesores) {
            if (p.getNombre().equalsIgnoreCase(nombre) && p.getTelefono().equals(telefono)) {
                return true;
            }
        }
        return false;
    }

    // AGREGAR ESTUDIANTE
    public void agregarEstudiante(Estudiante e) {
        if (existePersona(e.getNombre(), e.getTelefono())) {
            throw new IllegalArgumentException("La persona ya existe");
        }
        estudiantes.add(e);
    }

    // AGREGAR PROFESOR
    public void agregarProfesor(Profesor p) {
        if (existePersona(p.getNombre(), p.getTelefono())) {
            throw new IllegalArgumentException("La persona ya existe");
        }
        profesores.add(p);
    }

 
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    
    public ArrayList<Profesor> getProfesoresOrdenados() {
        profesores.sort((p1, p2) -> Double.compare(p2.calcularSalario(), p1.calcularSalario()));
        return profesores;
    }


    public double totalPrestaciones() {
        double total = 0;
        for (Profesor p : profesores) {
            total += p.calcularPrestaciones();
        }
        return total;
    }

    
    public String reporteEstudiantes() {
        StringBuilder sb = new StringBuilder();

        for (Estudiante e : estudiantes) {
            sb.append(e.toString()).append("\n");
        }

        return sb.toString();
    }

    
    public String reporteProfesores() {

        profesores.sort((p1, p2) -> Double.compare(p2.calcularSalario(), p1.calcularSalario()));
        StringBuilder sb = new StringBuilder();

        for (Profesor p : profesores) {
            sb.append(p.toString())
              .append(" | Prestaciones: ")
              .append(p.calcularPrestaciones())
              .append("\n");
        }

        sb.append("\nTotal prestaciones: ").append(totalPrestaciones());

        return sb.toString();
    }
}