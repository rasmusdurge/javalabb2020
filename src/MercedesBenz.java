import java.awt.*;

public class MercedesBenz extends Car implements TiltFunctions {
    private boolean rampUp;

    /**
     * Constructor for CarTransport objects
     */
    public MercedesBenz() {
        super(2, Color.green, 100, "Scania", 0, 0);
        this.rampUp = true;
        stopEngine();
    }

    public void rampGoesDown() {
        if (rampUp) {
            rampUp = false;
        }
    }

    @Override
    protected double speedFactor() {
        return 0;
    }
}