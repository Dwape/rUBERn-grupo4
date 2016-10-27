import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DriverTest {

    @Test
    public void evaluateCheckAvailability(){

        Basic basic = new Basic();

        Coordinates coord1 = new Coordinates(5, 3);
        Car car1 = new Car(3, basic, coord1);

        Driver driver1 = new Driver(car1, "Pedro", 14234234);

        MainSystem system = new MainSystem();
        system.addDriver(driver1);

        driver1.goOnline();

        boolean available = driver1.getAvailability();

        assertEquals(true, available);
    }
}
