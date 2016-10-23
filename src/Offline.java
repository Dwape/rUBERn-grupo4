import Exceptions.CanNotWorkWhileOfflineExc;
import Exceptions.DriverAlreadyOfflineExc;

public class Offline extends StateDriver {
    public Offline(AbstractDriver driver){
        super(driver);
    }
    public void goOnline(){
        driver.setState(new Online(driver));
    }

    public void goOffline(){
        throw new DriverAlreadyOfflineExc();
    }

    public void goToWork(){
        throw new CanNotWorkWhileOfflineExc();
    }
}
