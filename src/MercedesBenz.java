import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class MercedesBenz extends Car implements TiltFunctions {
    private boolean rampUp;
    private List<Car> cars;

    /**
     * Constructor for CarTransport objects
     */
    public MercedesBenz() {
        super(2, Color.green, 100, "Scania", 0, 0);
        cars = new ArrayList<>();
        rampUp = true;
        stopEngine();
    }

    public void putRampUp() {
        rampUp = true;
    }

    public void putRampDown() {
        rampUp = false;
    }

    @Override
    protected double speedFactor() {
        return 0;
    }

    public boolean getRampUp() {
        return rampUp;
    }
}