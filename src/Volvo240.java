import java.awt.*;

public class Volvo240 extends Car implements PersonalVehicle {

    /**
     * Increases the speed with a factor 1.25
     */
    private final static double trimFactor = 1.25;


    /**
     * Constructor for Volvo240 objects
     */
    public Volvo240() {
        super(4, Color.black, 100, "Volvo240", 1, 1);
    }

    /**
     * Uses trimFactor and a constant number to increase the speed factor
     *
     * @return enginePower times 0.01 times trimfactor
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
