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
    @Test
    public void testCalculoSalario() {
    Profesor p = new Profesor(
        "Ana",
        "Calle 1",
        "3001234568",
        "10-05-1990",
        "789456",
        "Fisica",
        10000,
        10
    );

    double esperado = 10000 * 10 * 1.30;

    assertEquals(esperado, p.calcularSalario(), 0.01);

    }
    @Test
    public void testPrestaciones() {
    Profesor p = new Profesor(
        "Luis",
        "Calle 2",
        "3001234569",
        "10-05-1985",
        "852369",
        "Quimica",
        10000,
        10
    );

    double esperado = p.calcularSalario() * 0.19;

    assertEquals(esperado, p.calcularPrestaciones(), 0.01);
    }
    @Test
    public void testSalarioConBono() {
    Profesor p = new Profesor(
        "Mario",
        "Calle 3",
        "3001234570",
        "10-05-1980",
        "963258",
        "Biologia",
        10000,
        10
    );

    double salarioNormal = p.calcularSalario();
    double salarioConBono = p.calcularSalario(50000);

    assertEquals(salarioNormal + 50000, salarioConBono, 0.01);
    }
    @Test
    public void testSalarioInvalido() {
     Exception ex = assertThrows(IllegalArgumentException.class, () -> {
        new Profesor(
            "Pedro",
            "Calle 4",
            "3001234571",
            "10-05-1990",
            "741852",
            "Historia",
            -10000, // ❌ inválido
            10
        );
    });

    assertEquals("Salario invalido", ex.getMessage());
    }
    
}
