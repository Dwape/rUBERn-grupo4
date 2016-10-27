import Exceptions.NoAvailableDriverExc;

public class NoDriver extends AbstractDriver{

    public void arrived(){
        throw new NoAvailableDriverExc();
    }

    public boolean requestDriver(Coordinates finishCoordinates){
        throw new NoAvailableDriverExc();
    }

    public Coordinates getCoordinates(){
        throw new NoAvailableDriverExc();
    }

    public void addFunds(double amount){
        throw new NoAvailableDriverExc();
    }


    public Car getCar(){
        throw new NoAvailableDriverExc();
    }

    public String getName(){
        throw new NoAvailableDriverExc();
    }


    public void goOnline(){
        throw new NoAvailableDriverExc();
    }

    public void goOffline(){
        throw new NoAvailableDriverExc();
    }

    public void goToWork(){
        throw new NoAvailableDriverExc();
    }

    public void setState(StateDriver s){
        throw new NoAvailableDriverExc();
    }

    public boolean getAvailability(){throw new NoAvailableDriverExc();}

    public void setAvailability(boolean bool){
        throw new NoAvailableDriverExc();
    }
}
