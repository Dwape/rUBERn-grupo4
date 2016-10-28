import Categories.Basic;
import DriverAndClient.Car;
import DriverAndClient.Coordinates;
import DriverAndClient.Driver;
import Exceptions.NoAvailableDriverExc;
import Utility.MainSystem;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ChooseDriverTest {

    @Test
    public void evaluateChooseDriver(){
        Basic basic = new Basic();

        Coordinates coord1 = new Coordinates(5, 3);
        Coordinates coord2 = new Coordinates(6, 8);

        Car car1 = new Car(3, basic, coord1);
        Car car2 = new Car(4, basic, coord1);
        Car car3 = new Car(4, basic, coord2);

        Driver driver1 = new Driver(car1, "Pedro", 12231223);
        Driver driver2 = new Driver(car2, "Juan", 46372643);
        Driver driver3 = new Driver(car3, "Manuel", 57324234);

        driver1.isTesting();
        driver2.isTesting();
        driver3.isTesting();

        driver2.goOnline();

        MainSystem system = new MainSystem();
        system.addDriver(driver1);
        system.addDriver(driver2);
        system.addDriver(driver3);

        Coordinates start = new Coordinates(0, 0);
        Coordinates finish = new Coordinates(10, 10);
        Driver bestCandidate = system.chooseDriver(start, finish, 4);

        assertEquals(driver2, bestCandidate);
    }

    @Test (expected= NoAvailableDriverExc.class)
    public void evaluateNoAvailableDriverExc(){

        Basic basic = new Basic();

        Coordinates coord1 = new Coordinates(5, 3);
        Coordinates coord2 = new Coordinates(6, 8);

        Car car1 = new Car(3, basic, coord1);
        Car car2 = new Car(4, basic, coord1);
        Car car3 = new Car(4, basic, coord2);

        Driver driver1 = new Driver(car1, "Pedro", 34231123);
        Driver driver2 = new Driver(car2, "Juan", 57382734);
        Driver driver3 = new Driver(car3, "Manuel", 56432123);

        driver1.isTesting();
        driver2.isTesting();
        driver3.isTesting();

        MainSystem system = new MainSystem();
        system.addDriver(driver1);
        system.addDriver(driver2);
        system.addDriver(driver3);

        Coordinates start = new Coordinates(0, 0);
        Coordinates finish = new Coordinates(10, 10);
        Driver bestCandidate = system.chooseDriver(start, finish, 5);
    }
}
