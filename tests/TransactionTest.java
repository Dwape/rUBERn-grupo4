import Categories.Basic;
import DriverAndClient.Car;
import DriverAndClient.Client;
import DriverAndClient.Coordinates;
import DriverAndClient.Driver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dwape on 10/27/16.
 */
public class TransactionTest {

    @Test
    public void evaluateDriverFunds(){

        Basic basic = new Basic();

        Coordinates coord1 = new Coordinates(5, 3);
        Car car1 = new Car(3, basic, coord1);

        Driver driver1 = new Driver(car1, "Pedro", 14234234);

        driver1.addFunds(150.5);

        double funds = driver1.getBalance();
        assertEquals(150.5, funds, 0);
    }

    @Test
    public void evaluateClientFunds(){

        Client client1 = new Client (100, 14234234, "Gianni");
        client1.addFunds(50);
        client1.spend(25);

        double funds = client1.getBalance();
        assertEquals(125, funds, 0);
    }
}
