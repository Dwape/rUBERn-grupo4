import org.joda.time.DateTime;

public class Driver extends AbstractDriver {

    public Driver(Car car,String name, Schedule schedule) {
        super(car, name, schedule);
    }

    @Override
    public void arrived(){
        aCar.getCoordinates().setCoordinates(finishCoordinates.getValueX(),finishCoordinates.getValueY());
        finishCoordinates = null;
        isTravelling=false;
    }

    @Override
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
                System.out.println("Not a valid option (Case sensitive)");
                return requestDriver(finishCoordinates);
        }

    }

    @Override
    public Coordinates getCoordinates() {
        return aCar.getCoordinates();
    }

    @Override
    public void addFunds(double amount){
        balance+=amount;
    }

    @Override
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

    @Override
    public Car getCar(){
        return aCar;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isTravelling() {
        return isTravelling;
    }
}
