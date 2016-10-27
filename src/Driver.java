import Exceptions.CanNotWorkWhileOfflineExc;
import org.joda.time.DateTime;

public class Driver extends AbstractDriver {

    public Driver(Car car,String name) {
        super(car, name);
    }

    public void arrived(){
        aCar.getCoordinates().setCoordinates(finishCoordinates.getValueX(),finishCoordinates.getValueY());
        finishCoordinates = null;
        goOnline();
    }

    public boolean requestDriver(Coordinates finishCoordinates){
        char result = Scanner.getChar(name + ", do you accept the request? (Y/N)");
        switch (result){
            case 'Y':
                goToWork();
                this.finishCoordinates=finishCoordinates;
                return true;
            case 'N':
                return false;
            default:
                System.out.println("Not a valid option (Case sensitive)");
                return requestDriver(finishCoordinates);
        }

    }

    public boolean getAvailability(){
        return availability;
    }

    public void setAvailability(boolean bool){
        availability= bool;
    }

    public Coordinates getCoordinates() {
        return aCar.getCoordinates();
    }

    public void addFunds(double amount){
        balance+=amount;
    }

    public Car getCar(){
        return aCar;
    }

    public String getName() {
        return name;
    }

    public void goOnline(){
        stateDriver.goOnline();
    }

    public void goOffline(){
        stateDriver.goOffline();
    }

    public void goToWork(){
        stateDriver.goToWork();
    }

    public void setState(StateDriver stateDriver){
        this.stateDriver = stateDriver;
    }

    public void stopWorking(){
        stateDriver.stopWorking();
    }
}
