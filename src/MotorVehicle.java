import java.awt.*;

public abstract class MotorVehicle implements Movable { //använder implementationsarv för att vi vill kunna använda instansvariablerna i volvo och saab
    private double weight;
    private final int nrDoors; // Number of doors on the car
    private final String modelName; // The car model name
    private final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private double currentSpeed; // The current speed of the car
    private double xCord; //position on the x-axis
    private double yCord; //position on the y-axis
    private direction dir; //the direction of the car



    /**
     * Constructor that initates car objects.
     *
     * @param nrDoors     The cars amount of doors.
     * @param color       The color of the car.
     * @param enginePower The cars engine power.
     * @param modelName   The cars model name.
     * @param xCord       The starting position of the car : x = 0
     * @param yCord       The starting position of the car : y = 0
     *                    <p>
     *                    We assume that the constructor can handle bad user input data like negative engine power.
     */

    MotorVehicle(int nrDoors, Color color, double enginePower, String modelName, double weight, int xCord, int yCord) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.xCord = xCord;
        this.yCord = yCord;
        stopEngine(); //the current speed will start at zero
        dir = direction.EAST; //the car starts moving in the east direction
        this.weight = weight;
    }

    /**
     * This method decides how big effect that the gas has when it is used to increase the cars speed
     */
    protected abstract double speedFactor();

    /**
     * Increases the speed of the car
     *
     * @param amount the amount that the speed is increasing
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    /**
     * Decreases the speed of the car
     *
     * @param amount the amount that the speed is decreasing
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * This method increases the cars current speed.
     *
     * @param amount amount is a factor in incrementSpeed.
     */
    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    /**
     * This method decreases the current speed of the car.
     *
     * @param amount is a factor in decrementSpeed.
     */
    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    /**
     * Starts the engine of the car
     */
    protected void startEngine() {
        if (currentSpeed > 0) {
            currentSpeed = getCurrentSpeed();
        } else {
            currentSpeed = 0.1;
        }
    }

    /**
     * Stops the engine
     */
    protected void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Enum for the direction of the car.
     */
    public enum direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    /**
     * Function for movement of the car. If we call this method the
     * car will update its position along its current direction with its currentSpeed.
     * This is done by a switch statement.
     */
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

    /**
     * Function that controls the direction that the car turns in.
     * When the method is used the cars direction updates as:
     * NORTH -> WEST -> SOUTH -> EAST -> NORTH ....
     */
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

    /**
     * Same function as turnLeft but mirrored.
     */
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

    public void setCol(Color clr) {
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

    protected void setxCord(double x){
        xCord = xCord + x;
    }

    protected void setyCord(double y){ yCord = yCord + y;
    }

    public double getWeight() {
        return weight;
    }
    //TODO av arvid
    //värt att göra en boolean i interface som avgör om den är uppe eller nere.
    // gör detta i inteface
    //använd en point här. Sätt bilens kord till mercans point. Bilen ska också ha point
    //gå igenom lista och uppdatera koordinater. då får man overrida move i mercedes.
    //point class?
    //lägg till weight i parameter? klar
    //private double weight; klar
    //
    //gör en loaderclass som vi kan delegera funktioner till.
    // denna loaderklass ska ha instantsvariabler och ska innehålla funktioner till ramper.
    // om vi gör ett object (scania eller mercedes) ska den kunna delegera till denna loaderklass!
    //gör en loaderclass
    //göra en egen klass som sköter loading unloading och håller lista + konstanter

    //TODO det vi behöver göra
    //Göra ett interface med tiltfunktioner som scania och mercedes ska implementera.
    //Värt att ändra arvshierarki?
}
