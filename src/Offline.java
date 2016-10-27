import Exceptions.CanNotWorkWhileOfflineExc;
import Exceptions.DriverAlreadyOfflineExc;
import Exceptions.DriverNotWorkingExc;

public class Offline extends StateDriver {
    public Offline(AbstractDriver driver){
        super(driver);
    }
    public void goOnline(){
        driver.setState(new Online(driver));
        driver.setAvailability(true);
    }

    public void goOffline(){
        throw new DriverAlreadyOfflineExc();
    }

    public void goToWork(){
        throw new CanNotWorkWhileOfflineExc();
    }

    public void stopWorking(){
        throw new DriverNotWorkingExc();
    }
}
