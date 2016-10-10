import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class Driver {
    Car aCar;
    Coordinates coordinates; //el auto debería tener las coordenadas
    double balance=0;
    String name;
    boolean isTraveling;
    Schedule schedule;

    public Driver(Car car, Coordinates coordinates, String name, Schedule schedule) {
        this.aCar = car;
        this.coordinates = coordinates;
        this.name = name;
        this.schedule=schedule;
    }

    public void arrived(Coordinates finishCoordinates){
        coordinates.setCoordinates(finishCoordinates.getValueX(),finishCoordinates.getValueY());
        isTraveling=false;
    }

    public boolean requestDriver(){ //tiene que preguntarle al chofer si acepta o rechaza el viaje.
        /*char result = Scanner.getChar(name + ", do you accept the request? (Y/N)"); //No funciona test con scanner
        switch (result){
            case 'Y': return true;
            case 'N': return false;
            default:
                System.out.println("Not a valid option");
                requestDriver();
                return false;
        }*/
        return true;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void addFunds(double amount){
        balance+=amount;
    }

    public boolean checkAvailability(){ //si esta disponible y durante su horario de trabajo
        if(!isTraveling) {
            DateTime today = DateTime.now();
            int now = today.getMillisOfDay();
            int dayOfTheWeek = DateTime.now().getDayOfWeek();

            int[][] hoursHowrk = schedule.getWorkWeek();

            return (hoursHowrk[dayOfTheWeek- 1][0] < now && hoursHowrk[dayOfTheWeek + 1][1]> now);
        }else{
            return false;
        }
    }

    public Car getCar(){
        return aCar;
    }
}
