import java.awt.*;
import java.util.Stack;

public class MercedesBenz extends MotorVehicle implements Ramp, Load {
    public static final int loadingCapacity = 10; //The capacity the car has to load other cars for transport
    public static final int proximity = 5; //The distance to other motorvehicle objects from the MercedesBenz
    private static final int MAXWEIGHT = 8000;
    private boolean rampUp; //True if the ramp is up.
    private Stack<MotorVehicle> cars; //A stack with motorvehicle objects.



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
        super(2, Color.green, 500, "MercedesBenz", 15000, 0,0);
        //cars = new ArrayList<>(10);
        cars = new Stack<>();
        rampUp = true;
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
    @Override
    public void loadCar(MotorVehicle car) {
        if (car.getWeight() <= MAXWEIGHT) {
            if (loadingDistance(car)) {
                if (cars.size() < loadingCapacity) {
                    if (!rampUp) {
                        car.setxCord(getxCord());
                        car.setyCord(getyCord());
                        cars.push(car);
                    }
                }
            }
        }
    }

    /**
     * Method for unloading cars in the order of first-in-last-out
     * given that the ramp is down and that the speed is equal to zero.
     * The cars that are loaded out is put down in the direction and
     * have the coordinates that the Mercedes has.
     *
     */
    @Override
    public void unloadCar() {
        //ska det vara - 1? kom ihåg till test.
        int j = cars.size() -1;
        if (!this.getRampUp()){
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
            cars.pop();
        }
    }

    /**
     * Method to see distance between the loading car and car to be loaded.
     * @param car The car you want to load on the Mercedes.
     * @return Returns a boolean, true if the car is close enough to load, false otherwise.
     */
    @Override
    public boolean loadingDistance(MotorVehicle car) {
        if (Math.sqrt(Math.pow(getxCord() - car.getxCord(), 2) + Math.pow(getyCord() - car.getyCord(), 2)) <= proximity) {
            return true;
        }
        return false;
    }

    @Override
    public void move() {
        super.move();
        for (int i = 0 ; i < cars.size(); i++){
            cars.get(i).setxCord(this.getxCord());
            cars.get(i).setyCord(this.getyCord());
        }
    }

    @Override
    public void gas(double amount) {
        if (getRampUp()) {
            super.gas(amount);
        }
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