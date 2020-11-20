import java.awt.*;

public class Scania extends Car{
    private double currentTilt; //The tilt of the cars cargo
    private static final double INITIAL = 0; //The minimum tilt of the cargo is equal to zero degrees. This is the initial tilt of the cargo.
    private static final double MAX = 70; //The maximum tilt of the cargo is equal to 70 degrees
    private boolean haveCargo;

    /**
     * Constructor for Scania objects
     */
    public Scania() {
        super(2, Color.blue, 150, "Scania", 0, 0);
        this.currentTilt = INITIAL;
        stopEngine();
        //hårdkoda weight här så att den inte kan lasta sig själv ex weight + 5000
    }

    /**
     * Method to change the tilt of the cargo that is higher than the original tilt.
     * @param changeTiltTo to what degree you want to set the tilt to
     */
    public void tiltUp(double changeTiltTo) {
        if (getCurrentSpeed() == 0) {
            if (changeTiltTo >= currentTilt && changeTiltTo <= MAX) {
                currentTilt = changeTiltTo;
            }
        }
    }

    /**
     * Same as tiltUp but to a tilt that is lower than the original tilt.
* @param changeTiltTo to what degree you want to set the tilt to.
     */
    public void tiltDown(double changeTiltTo){
        if (getCurrentSpeed() == 0) {
            if (changeTiltTo <= getCurrentTilt() && changeTiltTo >= INITIAL)
                currentTilt = changeTiltTo;
        }
    }

    /**
     * Method to increase the speed of the vehicle and can be used if the current tilt is zero.
     * @param amount amount is a factor in incrementSpeed.
     */
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