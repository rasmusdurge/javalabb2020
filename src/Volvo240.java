import java.awt.*;

public class Volvo240 extends Car {

    /**
     * Variable that is used in SpeedFactor,
     * this is only used for Volvo240
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructor for Volvo240 objects. Initiates Volvo240 objects
     */
    public Volvo240() {
        super(4, Color.black, 100, "Volvo240", 0, 0);
    }

    /**
     * Method for calculating the speedFactor for Volvo240. speedFactor
     * is used in incrementSpeed
     *
     * @return enginePower times trimfactor with a set percentage.
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Method that increases the cars currentSpeed.
     * Takes the minimum value of getCurrentSpeed() + speedFactor()
     * amount)
     * and enginePower.
     *
     * @param amount is incluced in the currentSpeed update formula.
     */
    @Override
    public void incrementSpeed(double amount) {
        double increasingValue = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        setCurrentSpeed(increasingValue);
    }

    /**
     * Reduces the value of currentSpeed much like incrementSpeed
     *
     * @param amount is included in the currentSpeed update formula
     */
    @Override
    public void decrementSpeed(double amount) {
        double decreasingValue = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        setCurrentSpeed(decreasingValue);
    }
}
