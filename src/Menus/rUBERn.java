package Menus;

import DriverAndClient.*;
import Utility.Invoice;
import Utility.MainSystem;
import Utility.Category;

/**
 * Created by Gianni on 10/10/2016.
 */
public class rUBERn {
    public static void main(String[] args) {
        MainSystem rUBERnSystem = new MainSystem();
        Invoice invoice = new Invoice();

        Category standard = new Category("standard", 5);
        Category premium = new Category("premium", 0);
        Coordinates coordinates1 = new Coordinates(1, 1);
        Coordinates coordinates2 = new Coordinates(2, 2);
        Car car1 = new Car(4, standard, coordinates1);
        Car car2 = new Car(3, premium, coordinates2);
        Driver driver1 = new Driver(car1, "Eduardo",123123);
        Driver driver2 = new Driver(car2, "Pepe",123213);

        rUBERnSystem.addDriver(driver1);
        rUBERnSystem.addDriver(driver2);

        MainData data = new MainData(new NoClient(),rUBERnSystem,invoice,new NoDriver());
        data.addCategory(standard);
        data.addCategory(premium);

        MainMenu mainMenu = new MainMenu(data);
    }
}
