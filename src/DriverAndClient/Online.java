package DriverAndClient;

import DriverAndClient.StateDriver;
import DriverAndClient.Working;
import Exceptions.DriverAlreadyOnlineExc;
import Exceptions.DriverNotWorkingExc;

public class Online extends StateDriver {
    public Online(AbstractDriver driver){
        super(driver);
    }

    public void goOnline(){
        throw new DriverAlreadyOnlineExc();
    }

    public void goOffline(){
        driver.setState(new Offline(driver));
        driver.changeAvailability();
    }

    public void goToWork(){
        driver.setState(new Working(driver));
        driver.changeAvailability();
    }

    public void stopWorking(){
        throw new DriverNotWorkingExc();
    }
}
