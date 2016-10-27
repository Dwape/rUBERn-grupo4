public class Driver extends AbstractDriver {

    public Driver(Car car,String name, long creditCardNumber) {
        super(car, name, creditCardNumber);
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

    public Coordinates getFinishCoordinates(){
        return finishCoordinates;
    }

    public void resetFinishCoordinates(){
        finishCoordinates = null;
    }

    public boolean getAvailability(){
        return availability;
    }

    public void changeAvailability(){
        availability= !availability;
    }

    public Coordinates getCoordinates() {
        return aCar.getCoordinates();
    }

    public void addFunds(double amount){
        creditCard.addFunds(amount);
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

    public double getBalance(){
        return creditCard.getBalance();
    }
}
