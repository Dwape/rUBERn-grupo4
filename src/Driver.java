import org.joda.time.DateTime;

public class Driver {
    Car aCar;
    double balance=0;
    String name;
    boolean isTravelling;
    Schedule schedule;
    Coordinates finishCoordinates;

    public Driver(Car car,String name, Schedule schedule) {
        this.aCar = car;
        this.name = name;
        this.schedule=schedule;
    }

    public void arrived(){
        aCar.getCoordinates().setCoordinates(finishCoordinates.getValueX(),finishCoordinates.getValueY());
        finishCoordinates = null;
        isTravelling=false;
    }

    public boolean requestDriver(Coordinates finishCoordinates){
        char result = Scanner.getChar(name + ", do you accept the request? (Y/N)");
        switch (result){
            case 'Y':
                isTravelling = true;
                this.finishCoordinates=finishCoordinates;
                return true;
            case 'N':
                return false;
            default:
                System.out.println("Not a valid option");
                requestDriver(finishCoordinates);
                return false;
        }

    }

    public Coordinates getCoordinates() {
        return aCar.getCoordinates();
    }

    public void addFunds(double amount){
        balance+=amount;
    }

    public boolean checkAvailability(){ //si esta disponible y durante su horario de trabajo
        if(!isTravelling) {
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

    public String getName() {
        return name;
    }
}
