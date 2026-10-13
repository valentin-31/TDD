package practicatdd.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import practicatdd.exceptions.InvalidHeroException;

public class HeroTest {

    @Test
    void crearHeroeValido() throws InvalidHeroException{
        // ARRANGE
        List<String> habilidades = new ArrayList<>();

        UUID uuid = UUID.randomUUID();

        // ACT
        Hero heroePrueba = Hero.getNewInstance(uuid, "Nombre", 31, habilidades);


        // ASSERT
        assertNotNull(heroePrueba);

        assertEquals(uuid, heroePrueba.getUUID());
        assertEquals("Nombre", heroePrueba.getName());
        assertEquals(31, heroePrueba.getLevel());
        assertEquals(habilidades, heroePrueba.getSkillList());
    }

    @Test
    void rechazarIdNulo() {
        assertThrows(InvalidHeroException.class,
                () -> Hero.getNewInstance(null, "asdasdsad", 31, new ArrayList<>()));
    }

    @Test
    void rechazarNombreNulo() {
        assertThrows(InvalidHeroException.class,
                () -> Hero.getNewInstance(UUID.randomUUID(), null, 31, new ArrayList<>()));
    }

    @Test
    void rechazarNombreVacio() {
        assertThrows(InvalidHeroException.class,
                () -> Hero.getNewInstance(UUID.randomUUID(), "    ", 31, new ArrayList<>()));
    }

    @Test
    void rechazarNivelCero() {
        assertThrows(InvalidHeroException.class,
                () -> Hero.getNewInstance(UUID.randomUUID(), "nombreaaasdasd", 0, new ArrayList<>()));
    }

    @Test
    void rechazarNivelNegativo() {
        assertThrows(InvalidHeroException.class,
                () -> Hero.getNewInstance(UUID.randomUUID(), "nombreaaasdasd", -1, new ArrayList<>()));
    }

    @Test
    void rechazarNivelSobreLimiteSuperior() {
        assertThrows(InvalidHeroException.class,
                () -> Hero.getNewInstance(UUID.randomUUID(), "nombreaaasdasd", 41, new ArrayList<>()));
    }

    @Test
    void rechazarHabilidadesNulas() {
        assertThrows(InvalidHeroException.class,
                () -> Hero.getNewInstance(UUID.randomUUID(), "nombreaaasdasd", 15, null));
    }

    @Test
    void rechazarHabilidadesRepetidas() {
        UUID id = UUID.randomUUID();

        List<String> habilidadesRepetidas = new ArrayList<>();
        habilidadesRepetidas.add("Habilidad repetida");
        habilidadesRepetidas.add("Habilidad unica");
        habilidadesRepetidas.add("Habilidad repetida");

        assertThrows(InvalidHeroException.class,
                () -> Hero.getNewInstance(id, "nombreaaasdasd", 35, habilidadesRepetidas));
    }
}
