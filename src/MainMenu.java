import java.util.ArrayList;

/**
 * Created by Gianni on 10/16/2016.
 */
public class MainMenu {
    private ClientMenu clientMenu;
    private DriverMenu driverMenu;

    public MainMenu(MainSystem rUBERnSystem, Invoice invoice, Client client){
        System.out.println("1.Driver Options");
        System.out.println("2.Client Options");
        System.out.println("3.Exit");
        int option = Scanner.getInt("Which option would you like to execute: ");

        switch (option) {
            case 1:
                driverList(rUBERnSystem, invoice, client);
                break;
            case 2:
                clientMenu = new ClientMenu(client, rUBERnSystem, invoice);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                new MainMenu(rUBERnSystem, invoice, client);
                break;
        }
    }

    private void driverList(MainSystem mainSystem, Invoice invoice, Client client){
        ArrayList<Driver> driverArrayList = mainSystem.getDriverList();
        Driver chosenDriver = driverArrayList.get(0);
        System.out.println("1.Register");
        for(int i=0;i<driverArrayList.size();i++){
            System.out.println(i+2+"."+driverArrayList.get(i).getName());
        }
        int result = Scanner.getInt("Select a driver: ");
        if(result==1){
            chosenDriver = createDriver();
            mainSystem.addDriver(chosenDriver);
            System.out.println("Driver created successfully");
        }else {
            try {
                chosenDriver = driverArrayList.get(result - 2);
            } catch (IndexOutOfBoundsException t) {
                System.out.println("Not a valid option");
                driverList(mainSystem, invoice, client);
            }
        }
        driverMenu = new DriverMenu(mainSystem, invoice, chosenDriver, client);
    }

    private Driver createDriver(){
        String name = Scanner.getString("Please enter your name: ");

        boolean loop = true;
        Category category;
        category = new Premium();
        while (loop) {
            System.out.println("1.Premium");
            System.out.println("2.Standard");
            System.out.println("3.Basic");
            int numberCategory = Scanner.getInt("Choose a category for your car: ");
            switch (numberCategory) {
                case 1:
                    category = new Premium();
                    loop = false;
                    break;
                case 2:
                    category = new Standard();
                    loop = false;
                    break;
                case 3:
                    category = new Basic();
                    loop = false;
                    break;
                default:
                    System.out.println("Not a valid option");
                    break;
            }
        }
        int spaceCar = Scanner.getInt("Car capacity for passenger: ");
        System.out.println("Please enter your coordinates");
        long coordinateX = Scanner.getLong("Enter your X coordinate: ");
        long coordinateY = Scanner.getLong("Enter your y coordinate: ");
        Coordinates coordinates = new Coordinates(coordinateX,coordinateY);
        System.out.println();
        Car car = new Car(spaceCar,category,coordinates);
        return new Driver(car,name,createSchedule());
    }

    private Schedule createSchedule() {
        Schedule schedule = new Schedule();
        String[] daysOfTheWeek = new String[7];
        daysOfTheWeek[0] = "monday";
        daysOfTheWeek[1] = "tuesday";
        daysOfTheWeek[2] = "wednesday";
        daysOfTheWeek[3] = "thursday";
        daysOfTheWeek[4] = "friday";
        daysOfTheWeek[5] = "saturday";
        daysOfTheWeek[6] = "sunday";
        int i = 0;
        System.out.println("Please enter your working hours");
        while (i < 7) {
            try {
                String iDay = Scanner.getString("Enter your starting hour on " + daysOfTheWeek[i] + " (HH:mm): ");
                String fDay = Scanner.getString("Enter your finish hour on " + daysOfTheWeek[i] + " (HH:mm): ");
                schedule.setHoursPerDay(iDay, fDay, daysOfTheWeek[i]);
                i++;
            } catch (IllegalArgumentException exc) {
                System.out.println("Please enter the time in the following format (HH:mm)");
            }
        }
        return schedule;
    }
}
