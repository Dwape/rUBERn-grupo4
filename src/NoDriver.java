import Exceptions.NoAvailableDriverExc;

public class NoDriver extends AbstractDriver{

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

    public void changeAvailability(){
        throw new NoAvailableDriverExc();
    }

    public void stopWorking(){
        throw new NoAvailableDriverExc();
    }

    public Coordinates getFinishCoordinates(){
        throw new NoAvailableDriverExc();
    }

    public void resetFinishCoordinates(){
        throw new NoAvailableDriverExc();
    }

    public double getBalance(){
        throw new NoAvailableDriverExc();
    }
}
