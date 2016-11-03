package DriverAndClient;

import DriverAndClient.Offline;
import DriverAndClient.StateDriver;

public abstract class AbstractDriver {
    Car aCar;
    String name;
    Coordinates finishCoordinates;
    StateDriver stateDriver;
    boolean availability;
    CreditCard creditCard;
    boolean testing;

    public AbstractDriver(Car car, String name, long creditCardNumber) {
        this.aCar = car;
        this.name = name;
        stateDriver = new Offline(this);
        availability = false;
        creditCard = new CreditCard(0,creditCardNumber);
    }

    public AbstractDriver(){}

    public abstract boolean requestDriver(Coordinates finishCoordinates);

    public abstract Coordinates getCoordinates();

    public abstract void addFunds(double amount);

    public abstract boolean getAvailability();

    public abstract void changeAvailability();

    public abstract Car getCar();

    public abstract String getName();

    public abstract void goOnline();

    public abstract void goOffline();

    public abstract void goToWork();

    public abstract void stopWorking();

    public abstract void setState(StateDriver stateDriver);

    public abstract Coordinates getFinishCoordinates();

    public abstract void resetFinishCoordinates ();

    public abstract double getBalance();

    public abstract CreditCard getCreditCard();

    public abstract String getStatus();
}
