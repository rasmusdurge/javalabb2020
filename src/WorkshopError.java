public class WorkshopError {

    /**
     * Main-method that initiates a volvo- and saab-object and also a volvoworkshop-object.
     * Using the method leaveCarAtWorkshop to try and leave a volvo/saab at the workshop.
     * @param args argument.
     */
    public static void main(String[] args) {

        Workshop<Volvo240> VolvoWorkshop = new Workshop(25);
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        VolvoWorkshop.leaveCarAtWorkshop(volvo);

    }
}
