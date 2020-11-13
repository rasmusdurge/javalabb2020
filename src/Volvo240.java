import java.awt.*;

public class Volvo240 extends Car {

    /**
     * Variable that is used in SpeedFactor,
     * this is only used for Volvo240
     */
    public final static double trimFactor = 1.25;

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
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Method that increases the cars currentSpeed.
     * Takes the minimum value of getCurrentSpeed() + speedFactor()
     * amount)
     * and enginePower.
     *
     * @param amount is incluced in the currentSpeed update formula.
     */
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Reduces the value of currentSpeed much like incrementSpeed
     *
     * @param amount is included in the currentSpeed update formula
     */
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
