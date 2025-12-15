package abstractFactoryPattern;

public class PetrolCar implements Car{
    @Override
    public void drive() {
        System.out.println("Driving a Petrol Car.");
    }
}
