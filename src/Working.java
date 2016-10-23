import Exceptions.CanNotGoOfflineWhileWorkingExc;
import Exceptions.CanNotWorkWhileOfflineExc;
import Exceptions.DriverAlreadyWorkingExc;

public class Working extends StateDriver {
    public Working(AbstractDriver driver){
        super(driver);
    }

    public void goOnline(){
        driver.setState(new Online(driver));
    }

    public void goOffline(){
        throw new CanNotGoOfflineWhileWorkingExc();
    }

    public void goToWork(){
        throw new DriverAlreadyWorkingExc();
    }
}
