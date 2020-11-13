import java.awt.*;

public abstract class Car implements Movable { //använder implementationsarv för att vi vill kunna använda instansvariablerna i volvo och saab
    private int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car

    //position
    private double xCord;
    private double yCord;
    //riktning
    private direction dir;

    Car(int nrDoors, Color color, double enginePower, String modelName, int xCord, int yCord) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.xCord = xCord;
        this.yCord = yCord;
        stopEngine();
        dir = direction.EAST; //the car starts moving in the east direction
    }

    @Override
    public void move() {
        switch (dir) {
            case EAST:
                xCord = xCord + currentSpeed;
                break;
            case NORTH:
                yCord = yCord + currentSpeed;
                break;
            case WEST:
                xCord = xCord - currentSpeed;
                break;
            case SOUTH:
                yCord = yCord - currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        switch (dir) { //like an if-loop
            case EAST:
                dir = direction.NORTH;
                break;
            case NORTH:
                dir = direction.WEST;
                break;
            case WEST:
                dir = direction.SOUTH;
                break;
            case SOUTH:
                dir = direction.EAST;
        }
    }

    @Override
    public void turnRight() {
        switch (dir) { //like an if-loop
            case EAST:
                dir = direction.SOUTH;
                break;
            case SOUTH:
                dir = direction.WEST;
                break;
            case WEST:
                dir = direction.NORTH;
                break;
            case NORTH:
                dir = direction.EAST;
        }
    }

    public enum direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public double getxCord() {
        return xCord;
    }

    public double getyCord() {
        return yCord;
    }

    public direction getDir() {
        return dir;
    }

    protected void startEngine() {
        currentSpeed = 0.1;
    }

    protected void stopEngine() {
        currentSpeed = 0;
    }

    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        } else {
            incrementSpeed(0);
        }
    }

    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        } else {
            decrementSpeed(0);
        }
    }

    public abstract double speedFactor();

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

}
