import org.joda.time.DateTime;

public abstract class AbstractDriver {
    Car aCar;
    double balance=0;
    String name;
    boolean isTravelling;
    Schedule schedule;
    Coordinates finishCoordinates;

    public AbstractDriver(Car car,String name, Schedule schedule) {
        this.aCar = car;
        this.name = name;
        this.schedule=schedule;
    }

    public AbstractDriver(){}

    public abstract void arrived();

    public abstract boolean requestDriver(Coordinates finishCoordinates);

    public abstract Coordinates getCoordinates();

    public abstract void addFunds(double amount);

    public abstract boolean checkAvailability();

    public abstract Car getCar();

    public abstract String getName();

    public abstract boolean isTravelling();
}
