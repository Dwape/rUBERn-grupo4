import Exceptions.NoAvailableDriverExc;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/**
 * Created by Dwape on 10/10/16.
 */
public class ChooseDriverTest {

    @Test
    public void evaluateChooseDriver(){
        Basic basic = new Basic();

        Coordinates coord1 = new Coordinates(5, 3);
        Coordinates coord2 = new Coordinates(6, 8);

        Car car1 = new Car(3, basic, coord1);
        Car car2 = new Car(4, basic, coord1);
        Car car3 = new Car(4, basic, coord2);

        Driver driver1 = new Driver(car1, "Pedro");
        Driver driver2 = new Driver(car2, "Juan");
        Driver driver3 = new Driver(car3, "Manuel");

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

        Schedule schedule1 = new Schedule();
        schedule1.setHoursPerDay("04:00", "08:00", "thursday");
        schedule1.setHoursPerDay("04:00", "08:00", "friday");

        Schedule schedule2 = new Schedule();
        schedule2.setHoursPerDay("04:00", "08:00", "thursday");
        schedule2.setHoursPerDay("04:00", "08:00", "friday");

        Driver driver1 = new Driver(car1, "Pedro");
        Driver driver2 = new Driver(car2, "Juan");
        Driver driver3 = new Driver(car3, "Manuel");

        MainSystem system = new MainSystem();
        system.addDriver(driver1);
        system.addDriver(driver2);
        system.addDriver(driver3);

        Coordinates start = new Coordinates(0, 0);
        Coordinates finish = new Coordinates(10, 10);
        Driver bestCandidate = system.chooseDriver(start, finish, 5);
    }
}
