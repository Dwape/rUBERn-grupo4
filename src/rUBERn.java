import Exceptions.NoAvailableDriverExc;

import java.util.ArrayList;

/**
 * Created by Gianni on 10/10/2016.
 */
public class rUBERn {
    public static void main(String[] args) {

        MainSystem rUBERnSystem = new MainSystem();

        Invoice invoice = new Invoice();

        Standard standard = new Standard();
        Premium premium = new Premium();
        Coordinates coordinates1 = new Coordinates(100, 545);
        Coordinates coordinates2 = new Coordinates(230, 155);
        Car car1 = new Car(4, standard, coordinates1);
        Car car2 = new Car(3, premium, coordinates2);
        Schedule schedule1 = new Schedule();
        schedule1.setHoursPerDay("08:00", "16:00", "thursday");
        Schedule schedule2 = new Schedule();
        schedule1.setHoursPerDay("10:00", "20:00", "thursday");
        Driver driver1 = new Driver(car1, "Eduardo", schedule1);
        Driver driver2 = new Driver(car2, "Pepe", schedule2);

        rUBERnSystem.addDriver(driver1);
        rUBERnSystem.addDriver(driver2);

        Client client = logIn();
        MainMenu mainMenu = new MainMenu(rUBERnSystem, invoice, client);
    }


    static public Client logIn(){
        String name = Scanner.getString("Enter your name: ");
        long creditCardNumber = Scanner.getLong("Enter your credit card number: ");
        Client client = new Client(0,creditCardNumber);
        return client;
    }
}
