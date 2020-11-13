import java.awt.*;

public class Saab95 extends Car {

    /**
     * If we use turboOn the effect of SpeedFactor gets larger.
     */
    private boolean turboOn;

    /**
     * Constructor for Saab95 objects. Initiates Saab95 objects
     */
    public Saab95() {
        super(2, Color.red, 125, "Saab95", 10, 10);
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * The engine power gets larger if the variable turboOn is used.
     *
     * @return enginePower
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * Method that increases the cars currentSpeed.
     *
     * @param amount is incluced in the currentSpeed update formula.
     */
    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Reduces the value of currentSpeed much like incrementSpeed
     *
     * @param amount is included in the currentSpeed update formula
     */
    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}