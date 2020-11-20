import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class MercedesBenz extends Car {
    //public static final int loadingWeight = XX
    public static final int loadingCapacity = 10; //The capacity the car has to load other cars for transport
    public static final int proximity = 5; //The distance to other car objects from the MercedesBenz
    private boolean rampUp; //True if the ramp is up
    private List<Car> cars; //A list with car objects


    public static void main(String[] args) {
        MercedesBenz merca = new MercedesBenz();
        Volvo240 volvo = new Volvo240();
        Scania scania = new Scania();

        merca.stopEngine();
        merca.putRampDown();
        merca.loadCar(volvo);
        merca.putRampUp();
        merca.startEngine();
    }

    /**
     * Constructor for CarTransport objects
     */
    public MercedesBenz() {
        super(2, Color.green, 100, "MercedesBenz", 0, 0);
        cars = new ArrayList<>(10);
        rampUp = true;
        //hårdkoda weight här så att den inte kan lasta sig själv ex weight + 5000
    }

    /**
     * Method to put ramp up by setting rampUp to true.
     */
    //@Override
    public void putRampUp() {
        if (getCurrentSpeed() == 0)
            rampUp = true;
    }

    /**
     * Method to put  ramp down by setting rampUp to false.
     */
    //@Override
    public void putRampDown() {
        if (getCurrentSpeed() == 0)
            rampUp = false;
    }

    /**
     * Method to load cars onto the Mercedes. The Mercedes loads cars if it has room, if the car is close enough,
     * if the car doesn't have a cargo and if the Mercedes has ramp down and stands still.
     *
     * @param car The car that you want to load on Mercedes.
     */
    public void loadCar(Car car) {
        if (checkIfPersonalVehicle(car)) {
            if (loadingDistance(car)) {
                if (cars.size() < loadingCapacity) {
                    if (!rampUp) {
                        cars.add(car);
                    }
                }
            }
        }
    }

    public boolean checkIfPersonalVehicle (Car car) {
        if (car instanceof PersonalVehicle) {
            return true;
        }
        return false;
    }

    /**
     * Method for unloading cars in the order of first-in-last-out
     * given that the ramp is down and that the speed is equal to zero.
     * The cars that are loaded out is put down in the direction and
     * have the coordinates that the Mercedes has.
     *
     * @param i the amount of cars that are supposed to be loaded out of the Mercedes.
     */
    public void unloadCar(int i) {
        if (rampUp == false){
            for (int j = cars.size() -1 ; j < i ; i-- ){
                switch (getDir()){
                    case EAST:
                        cars.get(j).setxCord(-1);
                        break;
                    case WEST:
                        cars.get(j).setxCord(1);
                        break;
                    case NORTH:
                        cars.get(j).setyCord(-1);
                        break;
                    case SOUTH:
                        cars.get(j).setyCord(1);
                }
                cars.remove(j);
            }
        }
    }

    /**
    * Method to see distance between the loading car and car to be loaded.
    * @param car The car you want to load on the Mercedes.
    * @return Returns a boolean, true if the car is close enough to load, false otherwise.
     */

    public boolean loadingDistance(Car car) {
        if (Math.sqrt(Math.pow(getxCord() - car.getxCord(), 2) + Math.pow(getyCord() - car.getyCord(), 2)) <= proximity) {
        } return true;
    }


    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.1;
    }

    public boolean getRampUp() {
        return rampUp;
    }

    public int getCarsSize() {
        return cars.size();
    }
}