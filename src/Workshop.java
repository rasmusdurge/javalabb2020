import java.util.ArrayList;

public class Workshop<C extends MotorVehicle>{
    private int workshopSize; //The amount of cars that the workshop can take in
    ArrayList<C> carsInWorkshop; //A list of the cars that is left at the workshop

    /**
     * Constructor for Workshop objects
     */
    public Workshop(int workshopSize) {
    carsInWorkshop = new ArrayList<>(this.workshopSize = workshopSize);
    }

    /**
     * Method for leaving a car at a mixed workshop.
     * @param car the car that is left at the workshop
     */


    public void leaveCarAtWorkshop(C car) {
        carsInWorkshop.add(car);
    }

    /**
     * Method for picking up a car at a mixed workshop.
     * @return which car that has been picked out (the first car that was left in the workshop)
     */
    C pickUpCar() {
        return carsInWorkshop.remove(0);
    }
}
