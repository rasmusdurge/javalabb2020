import java.awt.*;

public class Saab95 extends MotorVehicle {

    /**
     * Increases the effect of SpeedFactor
     */

    private boolean turboOn;

    /**
     * Constructor for Saab95 objects
     */
    public Saab95() {
        super(2, Color.red, 125, "Saab95", 1000, 10,10);
        turboOn = false;
    }

    /**
     * Setting if turbo is on
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Setting if turbo is off
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * The engine power gets larger if the variable turboOn is used.
     *
     * @return enginePower times 0.01 times turbo
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}