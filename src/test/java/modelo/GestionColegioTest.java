/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestionColegioTest {

    @Test
    public void testAgregarEstudianteYProfesor() {
        GestionColegio g = new GestionColegio();

        Estudiante e = new Estudiante(
            "Juan",
            "Calle",
            "3001234567",
            "10-05-2005",
            "123",
            10
        );

        Profesor p = new Profesor(
            "Carlos",
            "Calle",
            "3001234567",
            "10-05-1990",
            "456",
            "Matematicas",
            20000,
            10
        );

        g.agregarEstudiante(e);
        g.agregarProfesor(p);

        String reporteE = g.reporteEstudiantes();
        String reporteP = g.reporteProfesores();

        assertTrue(reporteE.contains("Juan"));
        assertTrue(reporteP.contains("Carlos"));
    }
}