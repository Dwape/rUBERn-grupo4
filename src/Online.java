import Exceptions.DriverAlreadyOnlineExc;

public class Online extends StateDriver {
    public Online(AbstractDriver driver){
        super(driver);
    }

    public void goOnline(){
        throw new DriverAlreadyOnlineExc();
    }

    public void goOffline(){
        driver.setState(new Offline(driver));
    }

    public void goToWork(){
        driver.setState(new Working(driver));
    }

}
