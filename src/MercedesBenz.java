import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class MercedesBenz extends Car implements CargoFunctions {
    public static final int loadingCapacity = 10;
    public static final int proximity = 5;
    private boolean rampUp;
    private List<Car> cars;

    /**
     * Constructor for CarTransport objects
     */
    public MercedesBenz() {
        super(2, Color.green, 100, "MercedesBenz", 0, 0);
        cars = new ArrayList<>(10);
        rampUp = true;
    }

    //@Override
    public void putTiltUp() {
        rampUp = true;
    }

    //@Override
    public void putTiltDown() {
        rampUp = false;
    }

    public void loadCar(Car car) {
        if (loadingDistance(car)) {
            if (cars.size() < loadingCapacity) {
                if (!haveCargo) {
                    if (!rampUp && getCurrentSpeed() == 0) {
                        cars.add(car);
                    }
                }
            }
        }
    }

    public void unloadCar() {

    }

    public boolean loadingDistance(Car car) {
        if (Math.sqrt(Math.pow(getxCord() - car.getxCord(), 2) + Math.pow(getyCord() - car.getyCord(), 2)) <= proximity) {
            return true;
        }
        return false;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.1;
    }

    public boolean getRampUp() {
        return rampUp;
    }
}