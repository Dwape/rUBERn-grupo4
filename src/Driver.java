public class Driver {
    Car aCar;
    Coordinates coordinates; //el auto debería tener las coordenadas
    double balance=0;
    String name;
    boolean online; //true durante su horario de trabajo
    boolean isTraveling;

    public Driver(Car car, Coordinates coordinates, String name) {
        this.aCar = car;
        this.coordinates = coordinates;
        this.name = name;
    }

    public void arrived(Coordinates finishCoordinates){
        coordinates.setCoordinates(finishCoordinates.getValueX(),finishCoordinates.getValueY());
    }

    public boolean requestDriver(){ //tiene que preguntarle al chofer si acepta o rechaza el viaje.
        return true;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void addFunds(double amount){
        balance+=amount;
    }

    public boolean checkAvailability(){ //si esta disponible y durante su horario de trabajo
        return online && !isTraveling;
    }

    public Car getCar(){
        return aCar;
    }
}
