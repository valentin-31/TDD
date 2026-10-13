package practicatdd.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import practicatdd.exceptions.InvalidSettlementException;

public class SettlementTest {

    @Test
    void asentamientoCapitalValido() throws InvalidSettlementException {
        // crear una "capital"
        Settlement asentamiento = Settlement.getNewInstance("Ciudad de prueba", 4, true);

        // ASSERT
        assertNotNull(asentamiento);

        assertEquals("Ciudad de prueba", asentamiento.getName());
        assertEquals(4, asentamiento.getLevel());
        assertTrue(asentamiento.isCapital());
    }

    @Test
    void asentamientoMenorValido() throws InvalidSettlementException {
        // crear un "asentamiento menor"
        Settlement asentamiento = Settlement.getNewInstance("Ciudad de prueba", 2, false);

        // ASSERT
        assertNotNull(asentamiento);

        assertEquals("Ciudad de prueba", asentamiento.getName());
        assertEquals(2, asentamiento.getLevel());
        assertFalse(asentamiento.isCapital());
    }


    @Test
    void rechazarNombreNulo() {
        assertThrows(InvalidSettlementException.class,
                () -> Settlement.getNewInstance(null, 4, true));
    }

    @Test
    void rechazarNombreVacio() {
        assertThrows(InvalidSettlementException.class,
                () -> Settlement.getNewInstance("         ", 4, true));
    }

    @Test
    void rechazarNombreDeMas30Caracteres() {
        assertThrows(InvalidSettlementException.class,
                () -> Settlement.getNewInstance("adewqedfasdjasdjkadbnaedgwejkqw", 4, true));
    }

    @Test
    void rechazarNivelInvalido() {
        assertThrows(InvalidSettlementException.class,
                ()-> Settlement.getNewInstance("Ciudad Prueba", -1, true));
    }

    @Test
    void asentamientoArrasado() throws InvalidSettlementException{
        Settlement asentamiento = Settlement.getNewInstance("Ciudad arrasada", 0, true);

        // ASSERT
        assertNotNull(asentamiento);

        assertEquals("Ciudad arrasada", asentamiento.getName());
        assertEquals(0, asentamiento.getLevel());
        assertTrue(asentamiento.isCapital());
    }

    @Test
    void asentamientoMenorDeNivelInvalido() {
        assertThrows(InvalidSettlementException.class,
                () -> Settlement.getNewInstance("Ciudad Prueba", 4, false));
    }

    @Test
    void asentamientoCapitalDeNivelInvalido() {
        assertThrows(InvalidSettlementException.class,
                () -> Settlement.getNewInstance("Ciudad Prueba", 6, true));
    }
}
