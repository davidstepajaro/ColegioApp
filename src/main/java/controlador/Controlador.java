package controlador;

import modelo.*;

public class Controlador {
//Inicializacion de la gestion principal
    private GestionColegio gestion = new GestionColegio();
//agrega estudiantes
    public void agregarEstudiante(Estudiante e) {
        gestion.agregarEstudiante(e);
    }
//registra profesores
    public void agregarProfesor(Profesor p) {
        gestion.agregarProfesor(p);
    }

    public String reporteEstudiantes() {
        StringBuilder sb = new StringBuilder();
        for (Estudiante e : gestion.getEstudiantes()) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }

    public String reporteProfesores() {
        StringBuilder sb = new StringBuilder();

        for (Profesor p : gestion.getProfesoresOrdenados()) {
            sb.append("Nombre: ").append(p.getNombre())
              .append(" | Area: ").append(p.getArea())
              .append(" | Salario: ").append(p.calcularSalario())
              .append(" | Prestaciones: ").append(p.calcularPrestaciones())
              .append("\n");
        }

        sb.append("\nTotal prestaciones: ").append(gestion.totalPrestaciones());

        return sb.toString();
    }
}