import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class Driver {
    Car aCar;
    double balance=0;
    String name;
    boolean isTraveling;
    Schedule schedule;

    public Driver(Car car,String name, Schedule schedule) {
        this.aCar = car;
        this.name = name;
        this.schedule=schedule;
    }

    public void arrived(Coordinates finishCoordinates){
        aCar.getCoordinates().setCoordinates(finishCoordinates.getValueX(),finishCoordinates.getValueY());
        isTraveling=false;
    }

    public boolean requestDriver(){
        /*char result = Scanner.getChar(name + ", do you accept the request? (Y/N)"); //No funciona test con scanner
        switch (result){
            case 'Y': return true; isTravelling = true;
            case 'N': return false;
            default:
                System.out.println("Not a valid option");
                requestDriver();
                return false;
        }*/
        return true;
    }

    public Coordinates getCoordinates() {
        return aCar.getCoordinates();
    }

    public void addFunds(double amount){
        balance+=amount;
    }

    public boolean checkAvailability(){ //si esta disponible y durante su horario de trabajo
        if(!isTraveling) {
            DateTime today = DateTime.now();
            int now = today.getMillisOfDay();
            int dayOfTheWeek = DateTime.now().getDayOfWeek();

            int[][] hoursWork = schedule.getWorkWeek();

            return (hoursWork[dayOfTheWeek- 1][0] < now && hoursWork[dayOfTheWeek - 1][1]> now);
        }else{
            return false;
        }
    }

    public Car getCar(){
        return aCar;
    }
}
