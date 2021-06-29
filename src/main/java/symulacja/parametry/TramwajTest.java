package symulacja.parametry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test jednostkowy stanu technicznego tramwaju.
 */
class TramwajTest {

    @Test
    void losujStanTechniczny() {
        int stanTechTramwaju;
        stanTechTramwaju = (int) (Math.random() * 26);
        assertTrue(stanTechTramwaju <= 26 && stanTechTramwaju >= 0);
    }
}