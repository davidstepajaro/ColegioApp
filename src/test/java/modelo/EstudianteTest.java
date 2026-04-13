package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstudianteTest {

    @Test
    public void testCrearEstudianteCorrecto() {
        Estudiante e = new Estudiante(
            "Juan",
            "Calle 10",
            "3001234567",
            "10-05-2005",
            "123",
            10
        );

        assertEquals("Juan", e.getNombre());
        assertEquals("123", e.getCodigo());
        assertEquals(10, e.getGrado());
    }

    @Test
    public void testCodigoInvalido() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante("Juan", "Calle", "3001234567", "10-05-2005", "ABC", 10);
        });

        assertEquals("Codigo invalido", ex.getMessage());
    }

    @Test
    public void testGradoInvalido() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante("Juan", "Calle", "3001234567", "10-05-2005", "123", 20);
        });

        assertEquals("Grado invalido (1-11)", ex.getMessage());
    }
    @Test
public void testTelefonoInvalido() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
        new Estudiante(
            "Juan",
            "Calle",
            "123", //  inválido
            "10-05-2005",
            "123",
            5
        );
    });

    assertTrue(ex.getMessage().toLowerCase().contains("telefono"));
}

@Test
public void testNombreInvalido() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
        new Estudiante(
            "Juan123", // inválido
            "Calle",
            "3001234567",
            "10-05-2005",
            "123",
            5
        );
    });

    assertTrue(ex.getMessage().toLowerCase().contains("nombre"));
}

@Test
public void testGradoLimiteValido() {
    Estudiante e = new Estudiante(
        "Ana",
        "Calle",
        "3001234567",
        "10-05-2005",
        "124",
        1 // mínimo válido
    );

    assertEquals(1, e.getGrado());
    }
}