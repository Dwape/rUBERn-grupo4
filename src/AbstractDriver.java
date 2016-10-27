public abstract class AbstractDriver {
    Car aCar;
    double balance=0;
    String name;
    Coordinates finishCoordinates;
    StateDriver stateDriver;
    boolean availability;
    boolean testing;

    public AbstractDriver(Car car,String name) {
        this.aCar = car;
        this.name = name;
        stateDriver = new Offline(this);
        availability = false;
    }

    public AbstractDriver(){}

    public abstract void arrived();

    public abstract boolean requestDriver(Coordinates finishCoordinates);

    public abstract Coordinates getCoordinates();

    public abstract void addFunds(double amount);

    public abstract boolean getAvailability();

    public abstract void setAvailability(boolean bool);

    public abstract Car getCar();

    public abstract String getName();

    public abstract void goOnline();

    public abstract void goOffline();

    public abstract void goToWork();

    public abstract void stopWorking();

    public abstract void setState(StateDriver stateDriver);

}
