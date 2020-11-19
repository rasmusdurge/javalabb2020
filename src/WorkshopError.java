public class WorkshopError {

    public static void main(String[] args) {
        VolvoWorkshop volvoWorkshop = new VolvoWorkshop();
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        volvoWorkshop.leaveCarAtWorkshop(volvo);
        System.out.println("Don't come here with that trash!");

    }
}
