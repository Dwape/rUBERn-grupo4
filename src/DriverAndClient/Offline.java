package DriverAndClient;

import DriverAndClient.Online;
import DriverAndClient.StateDriver;
import Exceptions.CanNotWorkWhileOfflineExc;
import Exceptions.DriverAlreadyOfflineExc;
import Exceptions.DriverNotWorkingExc;

public class Offline extends StateDriver {
    public Offline(AbstractDriver driver){
        super(driver);
        stateName = "Offline";
    }
    public void goOnline(){
        driver.setState(new Online(driver));
        driver.changeAvailability();
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
