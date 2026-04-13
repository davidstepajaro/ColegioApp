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
}