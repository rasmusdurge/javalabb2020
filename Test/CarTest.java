import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Tests for the Saab95-and Volvo240 constructor
 * and the essential methods in the Car class, Saab95 class and Volvo240 class.
 */

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
        Volvo.gas(0.5);
        Volvo.move();
        assertNotEquals(0, Volvo.getxCord());
    }

    public void testTurn() {
        Saab.turnLeft();
        assertEquals(Car.direction.NORTH, Saab.getDir());
        Saab.turnRight();
        assertEquals(Car.direction.EAST, Saab.getDir());
    }

    public void testGasAndBreak() {
        assertEquals(0, Volvo.getCurrentSpeed());
        Volvo.gas(0.7);
        assertNotEquals(0, Volvo.getCurrentSpeed());
        Volvo.brake(0.7);
        assertEquals(0, Volvo.getCurrentSpeed());
    }

    public void testStartAndStop() {
        Saab.startEngine();
        assertNotEquals(0, Saab.getCurrentSpeed());
        Saab.stopEngine();
        assertEquals(0, Saab.getCurrentSpeed());
    }
}
