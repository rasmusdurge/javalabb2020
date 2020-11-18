import java.awt.*;

public class Scania extends Car implements CargoFunctions {
    private double currentTilt;
    private static final double INITIAL = 0;
    private static final double MAX = 70;

    /**
     * Constructor for Scania objects
     */
    public Scania() {
        super(2, Color.blue, 150, "Scania", 0, 0);
        this.currentTilt = INITIAL;
        stopEngine();
    }

    /**
     * Method to change the tilt of the cargo.
     * @param changeTiltTo to what degree you want to set the tilt to
     */

    public void tiltUp(double changeTiltTo) {
        if (getCurrentSpeed() == 0) {
            if (changeTiltTo >= currentTilt && changeTiltTo <= MAX) {
                currentTilt = changeTiltTo;
            }
        }
    }

    public void tiltDown(double changeTiltTo){
        if (getCurrentSpeed() == 0) {
            if (changeTiltTo <= getCurrentTilt() && changeTiltTo >= INITIAL)
                currentTilt = changeTiltTo;
        }
    }

    @Override
    public void gas(double amount) {
        if (currentTilt == 0) {
            super.gas(amount);
        }
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public double getCurrentTilt() {
        return currentTilt;
    }

}