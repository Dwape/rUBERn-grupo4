import org.junit.Test;

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
        Driver driver1 = new Driver(car1, coord1, "Pedro");
        Driver driver2 = new Driver(car2, coord1, "Juan"); //Falta terminar de implementar los métodos de driver
    }
}
