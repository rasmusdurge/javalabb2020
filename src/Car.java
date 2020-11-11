import java.awt.*;

public abstract class Car implements Movable { //använder implementationsarv för att vi vill kunna använda instansvariablerna i volvo och saab
    private int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car

    Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine(); //don't know if this one can be here
        dir = direction.EAST; //the car starts moving in the east direction
    }

    public enum direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    //position
    protected double xCord;
    protected double yCord;
    //riktning
    protected direction dir;


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

    protected int getNrDoors() {
        return nrDoors;
    }

    protected double getEnginePower() {
        return enginePower;
    }

    protected double getCurrentSpeed() {
        return currentSpeed;
    }

    protected Color getColor() {
        return color;
    }

    protected void setColor(Color clr) {
        color = clr;
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
