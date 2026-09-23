import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void testPrueba() {
        int resul = 2 + 2;
        assertEquals(4, resul);
    }

    @Test
    void testPrueba2() {
        assertEquals(4.9999999999999999999999999999999, 5);
    }

    @Test
    void testPrueba3() {
        assertEquals(4.9999, 5);
    }

    @Test
    void testPrueba4() {
        assertEquals(4.99999999, 5);
    }

    @Test
    void testPrueba5() {
        assertEquals(4.999999999999, 5);
    }

    @Test
    void testPrueba6() {
        assertEquals(4.9999999999999999, 5);
    }
}