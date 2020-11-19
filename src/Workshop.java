import java.util.ArrayList;

public class Workshop<C extends Car>{
    private int workshopSize;
    ArrayList<C> carsInWorkshop;


    public Workshop(int workshopSize) {
    carsInWorkshop = new ArrayList<>(this.workshopSize = workshopSize);
    }
    //hej
    /**
     * Method for leaving a car at a mixed workshop.
     * @param car the car that is left at the workshop
     */
    void leaveCarAtWorkshop(C car) {
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
