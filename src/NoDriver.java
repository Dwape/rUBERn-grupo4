import Exceptions.NoAvailableDriverExc;

public class NoDriver extends AbstractDriver{

    @Override
    public void arrived(){
        throw new NoAvailableDriverExc();
    }

    @Override
    public boolean requestDriver(Coordinates finishCoordinates){
        throw new NoAvailableDriverExc();
    }

    @Override
    public Coordinates getCoordinates(){
        throw new NoAvailableDriverExc();
    }

    @Override
    public void addFunds(double amount){
        throw new NoAvailableDriverExc();
    }

    @Override
    public boolean checkAvailability(){
        throw new NoAvailableDriverExc();
    }

    @Override
    public Car getCar(){
        throw new NoAvailableDriverExc();
    }

    @Override
    public String getName(){
        throw new NoAvailableDriverExc();
    }

    @Override
    public boolean isTravelling(){
        throw new NoAvailableDriverExc();
    }
}
