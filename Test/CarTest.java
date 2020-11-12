import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    Saab95 Saab = new Saab95();
    Volvo240 Volvo = new Volvo240();

    @Test
    public void testConstructor() {
        assertEquals(Color.red, Saab.getColor());
        assertEquals(4, Volvo.getNrDoors());
        assertEquals(10, Saab.getxCord());
        assertEquals(0, Volvo.getyCord());
    }

    public void testMove() {
    }
}
