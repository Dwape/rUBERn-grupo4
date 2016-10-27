import Exceptions.CanNotGoOfflineWhileWorkingExc;
import Exceptions.CanNotWorkWhileOfflineExc;
import Exceptions.DriverAlreadyWorkingExc;

public class Working extends StateDriver {
    public Working(AbstractDriver driver){
        super(driver);
    }

    public void goOnline(){
        throw new CanNotGoOfflineWhileWorkingExc();
    }

    public void goOffline(){
        throw new CanNotGoOfflineWhileWorkingExc();
    }

    public void goToWork(){
        throw new DriverAlreadyWorkingExc();
    }

    public void stopWorking(){
        driver.setState(new Online(driver));
        driver.setAvailability(true);
    }
}
