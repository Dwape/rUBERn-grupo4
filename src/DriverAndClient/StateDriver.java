package DriverAndClient;

public abstract class StateDriver {
    String stateName;
    AbstractDriver driver;
    public StateDriver (AbstractDriver driver){
        this.driver = driver;
    }
    public abstract void goOnline();
    public abstract void goOffline();
    public abstract void goToWork();
    public abstract void stopWorking();
    public String getStatus(){
        return stateName;
    }
}
