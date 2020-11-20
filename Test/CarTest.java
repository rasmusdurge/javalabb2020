import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Saab95-and Volvo240 constructor
 * and the essential methods in the Car class, Saab95 class and Volvo240 class.
 */

public class CarTest {
    Saab95 Saab = new Saab95();
    Volvo240 Volvo = new Volvo240();
    Scania scania = new Scania();
    MercedesBenz mercedesBenz = new MercedesBenz();

    @Test
    public void testConstructor() {
        assertEquals(Color.red, Saab.getColor());
        assertEquals(4, Volvo.getNrDoors());
        assertEquals(10, Saab.getxCord());
        assertEquals(0, Volvo.getyCord());
    }

    @Test
    public void testMove() {
        Volvo.gas(0.5);
        Volvo.move();
        assertNotEquals(0, Volvo.getxCord());
    }

    @Test
    public void testTurn() {
        Saab.turnLeft();
        assertEquals(Car.direction.NORTH, Saab.getDir());
        Saab.turnRight();
        assertEquals(Car.direction.EAST, Saab.getDir());
    }

    @Test
    public void testGasAndBreak() {
        assertEquals(0, Volvo.getCurrentSpeed());
        Volvo.gas(0.7);
        assertNotEquals(0, Volvo.getCurrentSpeed());
        Volvo.brake(0.7);
        assertEquals(0, Volvo.getCurrentSpeed());
    }

    @Test
    public void testStartAndStop() {
        Saab.startEngine();
        assertNotEquals(0, Saab.getCurrentSpeed());
        Saab.stopEngine();
        assertEquals(0, Saab.getCurrentSpeed());
    }

    @Test
    public void testCargoTiltUpAndDown() {
        scania.tiltUp(30);
        assertEquals(30, scania.getCurrentTilt());
        scania.tiltDown(20);
        assertEquals(20, scania.getCurrentTilt());
        scania.tiltDown(-10);
        assertNotEquals(-10, scania.getCurrentTilt());
    }
    @Test
    public void testMercedes(){
        mercedesBenz.startEngine();
        assertNotEquals(0,mercedesBenz.getCurrentSpeed());
        mercedesBenz.move();
        assertNotEquals(0,mercedesBenz.getxCord());
    }
    @Test
    public void testMercedesTilt(){
        assertTrue(mercedesBenz.getRampUp());
        mercedesBenz.putRampDown();
        assertFalse(mercedesBenz.getRampUp());
    }
    @Test
    public void testMercedesLoad(){
        mercedesBenz.stopEngine();
        mercedesBenz.putRampDown();
        mercedesBenz.loadCar(Volvo);
        mercedesBenz.loadCar(scania);
       assertEquals(1, mercedesBenz.getCarsSize());
    }
    @Test
    public void testMercedesUnload(){
        mercedesBenz.stopEngine();
        mercedesBenz.putRampDown();
        mercedesBenz.loadCar(Volvo);
        mercedesBenz.loadCar(Saab);
        mercedesBenz.unloadCar(2);
        assertEquals(0,mercedesBenz.getCarsSize());

    }



}