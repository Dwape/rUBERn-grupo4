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
        Car car1 = new Car(3, basic);
        Car car2 = new Car(4, basic);
        Car car3 = new Car(4, basic);
        Coordinates coord1 = new Coordinates(5, 3);
        Coordinates coord2 = new Coordinates(6, 8);

        LocalTime hora = new LocalTime(7, 0, 0, 0);
        Schedule schedule1 = new Schedule();
        schedule1.setHoursPerDay("04:00", "08:00", "monday");
        schedule1.setHoursPerDay("04:00", "08:00", "tuesday");
        schedule1.setHoursPerDay("04:00", "08:00", "wednesday");
        schedule1.setHoursPerDay("04:00", "08:00", "thursday");
        schedule1.setHoursPerDay("04:00", "08:00", "friday");
        schedule1.setHoursPerDay("04:00", "08:00", "saturday");
        schedule1.setHoursPerDay("04:00", "08:00", "sunday");
        Schedule schedule2 = new Schedule();
        schedule2.setHoursPerDay("04:00", "06:00", "monday");
        schedule2.setHoursPerDay("04:00", "06:00", "tuesday");
        schedule2.setHoursPerDay("04:00", "06:00", "wednesday");
        schedule2.setHoursPerDay("04:00", "06:00", "thursday");
        schedule2.setHoursPerDay("04:00", "06:00", "friday");
        schedule2.setHoursPerDay("04:00", "06:00", "saturday");
        schedule2.setHoursPerDay("04:00", "06:00", "sunday");

        Driver driver1 = new Driver(car1, coord1, "Pedro", schedule1);
        Driver driver2 = new Driver(car2, coord2, "Juan", schedule1);
        Driver driver3 = new Driver(car3, coord2, "Manuel", schedule2);

        MainSystem system = new MainSystem();//Falta terminar de implementar los métodos de driver
        system.addDriver(driver1);
        system.addDriver(driver2);
        system.addDriver(driver3);

        Coordinates start = new Coordinates(0, 0);
        Coordinates finish = new Coordinates(10, 10);
        Driver bestCandidate = system.chooseDriver(start, finish, 4);

        assertEquals(driver2, bestCandidate);
    }
}
