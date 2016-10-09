public class Driver {
    Car aCar;
    Coordinates coordinates;
    double balance=0;
    String name;

    public Driver(Car car, Coordinates coordinates, String name) {
        this.aCar = car;
        this.coordinates = coordinates;
        this.name = name;
    }

    public void arrived(Coordinates finishCoordinates){
        coordinates.setCoordinates(finishCoordinates.getValueX(),finishCoordinates.getValueY());
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void addFunds(double amount){
        balance+=amount;
    }
}
