import Exceptions.NoAvailableDriverExc;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by Gianni on 10/10/2016.
 */
public class rUBERn {
    public static void main(String[] args) {

        MainSystem rUBERnSystem = new MainSystem();

        Invoice invoice = new Invoice();

        Basic basic = new Basic();
        Standard standard = new Standard();
        Premium premium = new Premium();
        Coordinates coordinates1 = new Coordinates(100, 545);
        Coordinates coordinates2 = new Coordinates(230, 155);
        Car car1 = new Car(4, standard, coordinates1);
        Car car2 = new Car(3, premium, coordinates2);
        Schedule schedule1 = new Schedule();
        schedule1.setHoursPerDay("08:00", "16:00", "thursday");
        Schedule schedule2 = new Schedule();
        schedule1.setHoursPerDay("10:00", "20:00", "thursday");
        Driver driver1 = new Driver(car1, "Eduardo", schedule1);
        Driver driver2 = new Driver(car2, "Pepe", schedule2);

        rUBERnSystem.addDriver(driver1);
        rUBERnSystem.addDriver(driver2);

        Client client = logIn();
        mainMenu(rUBERnSystem, invoice, client);
    }

    static public void mainMenu(MainSystem rUBERnSystem, Invoice invoice, Client client){
        System.out.println("1.Driver Options");
        System.out.println("2.Client Options");
        System.out.println("3.Exit");
        int option = Scanner.getInt("Which option would you like to excecute: ");

        switch (option) {
            case 1:
                driverList(rUBERnSystem, invoice, client);
                break;
            case 2:
                clientMenu(client, rUBERnSystem, invoice);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                mainMenu(rUBERnSystem, invoice, client);
                break;
        }
    }

    static public void driverMenu(MainSystem rUBERnSystem, Invoice invoice, Driver driver, Client client){
        System.out.println("1.Terminar Viaje");
        System.out.println("2.Back");
        System.out.println("3.Exit");
        int option = Scanner.getInt("Which option would you like to excecute: ");

        switch (option) {
            case 1:
                driver.arrived();
                client.changeStatus();
                System.out.println("Su viaje fue terminado correctamente");
            case 2:
                mainMenu(rUBERnSystem,invoice, client);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                driverMenu(rUBERnSystem, invoice,driver, client);
                break;
        }
    }

    static public void clientMenu(Client client, MainSystem rUBERnSystem, Invoice invoice){
        System.out.println("1.Call Driver");
        System.out.println("2.Add Funds");
        System.out.println("3.Check Funds");
        System.out.println("4.Back");
        System.out.println("5.Exit");
        int option = Scanner.getInt("Which option would you like to excecute: ");

        switch (option) {
            case 1:
                long StartX = Scanner.getLong("Enter current X coordinates: ");
                long StartY = Scanner.getLong("Enter current Y coordinates: ");
                Coordinates start = new Coordinates(StartX, StartY);

                long FinishX = Scanner.getLong("Enter destiny's X coordinate: ");
                long FinishY = Scanner.getLong("Enter destiny's Y coordinate: ");
                Coordinates finish = new Coordinates(FinishX, FinishY);

                int numberOfPeople = Scanner.getInt("How many people will travel? ");

                double price = rUBERnSystem.calculateCost(start, finish);
                if (price > client.getBalance()){
                    System.out.println("Not enough founds");
                    clientMenu(client, rUBERnSystem, invoice);
                }
                if (client.getStatus()){
                    System.out.println("You are already travelling");
                    clientMenu(client, rUBERnSystem, invoice);
                }
                try{
                    Driver chosenDriver = rUBERnSystem.chooseDriver(start, finish,numberOfPeople);
                    client.changeStatus();
                    rUBERnSystem.transaction(client,chosenDriver,start,finish,invoice);
                    System.out.println("Travel started successfully");
                    clientMenu(client,rUBERnSystem,invoice);
                }catch (NoAvailableDriverExc exc){
                    System.out.println("No available driver, please try again later");
                    clientMenu(client, rUBERnSystem, invoice);
                }

                break;
            case 2:
                double founds = Scanner.getDouble("How much money would you like to add? ");
                client.addFunds(founds);
                clientMenu(client,rUBERnSystem,invoice);
                break;
            case 3:
                System.out.println(client.getBalance());
                clientMenu(client,rUBERnSystem,invoice);
                break;
            case 4:
                mainMenu(rUBERnSystem,invoice,client);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                mainMenu(rUBERnSystem, invoice, client);
                break;
        }
    }

    static public void driverList(MainSystem mainSystem, Invoice invoice, Client client){
        ArrayList<Driver>driverArrayList = mainSystem.getDriverList();
        Driver choosenDriver = driverArrayList.get(0);
        System.out.println("1.Register");
        for(int i=0;i<driverArrayList.size();i++){
            System.out.println(i+2+"."+driverArrayList.get(i).getName());
        }
        int result = Scanner.getInt("Select a driver: ");
        if(result==1){
            choosenDriver = createDriver();
            System.out.println("Driver created successfully");
        }else {
            try {
                choosenDriver = driverArrayList.get(result - 2);
            } catch (IndexOutOfBoundsException t) {
                System.out.println("Not a valid option");
                driverList(mainSystem, invoice, client);
            }
        }
        driverMenu(mainSystem, invoice, choosenDriver, client);
    }

    static public Client logIn(){
        String name = Scanner.getString("Enter your name: ");
        long creditCardNumber = Scanner.getLong("Enter your credit card number: ");
        Client client = new Client(0, creditCardNumber);
        return client;
    }

    static public Driver createDriver(){
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
        System.out.println("Please enter your coordinates");
        long coordinateX = Scanner.getLong("Enter your X coordinate: ");
        long coordinateY = Scanner.getLong("Enter your y coordinate: ");
        Coordinates coordinates = new Coordinates(coordinateX,coordinateY);
        int spaceCar = Scanner.getInt("Car capacity for people: ");
        System.out.println();
        Car car = new Car(spaceCar,category,coordinates);
        return new Driver(car,name,createSchedule());
    }

    static public Schedule createSchedule(){
        Schedule schedule = new Schedule();
        System.out.println("Please enter your working hours");
        String imonday = Scanner.getString("Enter your starting hour on monday (HH:mm): ");
        String fmonday = Scanner.getString("Enter your finish hour on monday (HH:mm): ");
        schedule.setHoursPerDay(imonday,fmonday,"monday");

        String ituesday = Scanner.getString("Enter your starting hour on tuesday (HH:mm): ");
        String ftuesday = Scanner.getString("Enter your finish hour on tuesday (HH:mm): ");
        schedule.setHoursPerDay(ituesday,ftuesday,"tuesday");

        String iwednesday = Scanner.getString("Enter your starting hour on wednesday (HH:mm): ");
        String fwednesday = Scanner.getString("Enter your finish hour on wednesday (HH:mm): ");
        schedule.setHoursPerDay(iwednesday,fwednesday,"wednesday");

        String ithusrday = Scanner.getString("Enter your starting hour on thursday (HH:mm): ");
        String fthusrday = Scanner.getString("Enter your finish hour on thursday (HH:mm): ");
        schedule.setHoursPerDay(ithusrday,fthusrday,"thursday");

        String ifriday = Scanner.getString("Enter your starting hour on friday (HH:mm): ");
        String ffriday = Scanner.getString("Enter your finish hour on friday (HH:mm): ");
        schedule.setHoursPerDay(ifriday,ffriday,"friday");

        String isaturday = Scanner.getString("Enter your starting hour on saturday (HH:mm): ");
        String fsaturday = Scanner.getString("Enter your finish hour on saturday (HH:mm): ");
        schedule.setHoursPerDay(isaturday,fsaturday,"saturday");

        String isunday = Scanner.getString("Enter your starting hour on sunday (HH:mm): ");
        String fsunday = Scanner.getString("Enter your finish hour on sunday (HH:mm): ");
        schedule.setHoursPerDay(isunday,fsunday,"sunday");

        return schedule;
    }
}
