import DriverAndClient.Car;
import DriverAndClient.Coordinates;
import DriverAndClient.Driver;
import Exceptions.CanNotWorkWhileOfflineExc;
import Exceptions.DriverAlreadyOnlineExc;
import Utility.Category;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StateDriverTest {

    @Test (expected= DriverAlreadyOnlineExc.class)
    public void evaluateGoOnline(){

        Category basic = new Category("basic", 10);

        Coordinates coord1 = new Coordinates(5, 3);
        Car car1 = new Car(3, basic, coord1);

        Driver driver1 = new Driver(car1, "Pedro", 12342345);

        driver1.goOnline();

        driver1.goOffline();
        boolean available = driver1.getAvailability();
        assertEquals(false, available);

        driver1.goOnline();

        driver1.goOnline();
    }

    @Test (expected= CanNotWorkWhileOfflineExc.class)
    public void evaluateStateDriver(){

        Category basic = new Category("basic", 10);

        Coordinates coord1 = new Coordinates(5, 3);
        Car car1 = new Car(3, basic, coord1);

        Driver driver1 = new Driver(car1, "Pedro", 27432123);

        driver1.goOnline();

        driver1.goToWork();

        boolean available = driver1.getAvailability();
        assertEquals(false, available);

        driver1.stopWorking();

        available = driver1.getAvailability();
        assertEquals(true, available);

        driver1.goOffline();

        available = driver1.getAvailability();
        assertEquals(false, available);

        driver1.goToWork();
    }
}
