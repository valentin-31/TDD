package practicatdd.model;

import org.junit.jupiter.api.*;
import practicatdd.exceptions.InvalidClanRatException;

import static org.junit.jupiter.api.Assertions.*;

public class ClanRatTest {

    @Test
    void crearClanRatValido() throws InvalidClanRatException {
        // ARRANGE

        // ACT

        ClanRat ratita = ClanRat.getNewInstance("Los ratines", 160, 300);

        // ASSERT
        assertNotNull(ratita); // hice algo?

        assertEquals("Los ratines", ratita.getName());
        assertEquals(160, ratita.getQuantity());
        assertEquals(300, ratita.getCost());
    }

    @Test
    void rechazarNombreNulo(){
        assertThrows(InvalidClanRatException.class,
                () -> ClanRat.getNewInstance(null, 160, 300));
    }

    @Test
    void rechazarNombreVacio(){
        assertThrows(InvalidClanRatException.class,
                () -> ClanRat.getNewInstance("     ", 160, 300));
    }

    @Test
    void rechazarCeroSoldados(){
        assertThrows(InvalidClanRatException.class, () -> ClanRat.getNewInstance("ratines", 0, 500));
    }

    @Test
    void rechazaSoldadosFueraDelLimite(){
        assertThrows(InvalidClanRatException.class, () -> ClanRat.getNewInstance("ratines", 161, 500));
    }

    @Test
    void rechazaCostoCero(){
        assertThrows(InvalidClanRatException.class, () -> ClanRat.getNewInstance("ratines", 150, 0));
    }

    @Test
    void rechazaCostoNegativo(){
        assertThrows(InvalidClanRatException.class, () -> ClanRat.getNewInstance("ratines", 150, -1));
    }
}
