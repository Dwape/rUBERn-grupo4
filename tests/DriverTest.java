import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dwape on 10/13/16.
 */
public class DriverTest {

    @Test
    public void evaluateCheckAvailability(){

        Basic basic = new Basic();

        Coordinates coord1 = new Coordinates(5, 3);
        Car car1 = new Car(3, basic, coord1);

        Schedule schedule1 = new Schedule();
        schedule1.setHoursPerDay("04:00", "08:00", "thursday");
        schedule1.setHoursPerDay("04:00", "08:00", "friday");

        Driver driver1 = new Driver(car1, "Pedro");

        MainSystem system = new MainSystem();
        system.addDriver(driver1);

        boolean available = driver1.checkAvailability();

        assertEquals(false, available);
    }
}
