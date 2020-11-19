public class VolvoWorkshop extends Workshop<Volvo240> {

    public VolvoWorkshop() {
        super(15);
    }

    void leaveCarArWorkshop(Volvo240 volvo){
         super.leaveCarAtWorkshop(volvo);
    }

    Volvo240 pickUpCar() {
        return (Volvo240) super.pickUpCar();
    }

}
