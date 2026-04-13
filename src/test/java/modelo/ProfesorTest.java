/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfesorTest {

    @Test
    public void testCrearProfesorCorrecto() {
        Profesor p = new Profesor(
            "Carlos",
            "Calle 20",
            "3001234567",
            "10-05-1990",
            "123456",
            "Matematicas",
            20000,
            10
        );

        assertEquals("Carlos", p.getNombre());
        assertEquals("Matematicas", p.getArea());
    }

    @Test
    public void testMenorEdad() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Profesor(
                "Carlos",
                "Calle",
                "3001234567",
                "10-05-2010",
                "123456",
                "Matematicas",
                20000,
                10
            );
        });

        assertEquals("El profesor debe ser mayor de edad", ex.getMessage());
    }

    @Test
    public void testCedulaInvalida() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Profesor(
                "Carlos",
                "Calle",
                "3001234567",
                "10-05-1990",
                "ABC",
                "Matematicas",
                20000,
                10
            );
        });

        assertEquals("Cedula invalida", ex.getMessage());
    }
}
