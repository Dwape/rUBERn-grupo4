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
        schedule1.setHoursPerDay("08:00", "16:00", "friday");
        Schedule schedule2 = new Schedule();
        schedule1.setHoursPerDay("10:00", "20:00", "friday");
        Driver driver1 = new Driver(car1, "Eduardo", schedule1);
        Driver driver2 = new Driver(car2, "Pepe", schedule2);

        rUBERnSystem.addDriver(driver1);
        rUBERnSystem.addDriver(driver2);

        mainMenu(rUBERnSystem, invoice);
    }

    static public void mainMenu(MainSystem rUBERnSystem, Invoice invoice){
        System.out.println("1.Driver Options");
        System.out.println("2.Client Options");
        System.out.println("3.Exit");
        int option = Scanner.getInt("Which option would you like to excecute: ");

        switch (option) {
            case 1:
                driverMenu(rUBERnSystem, invoice);
                break;
            case 2:
                Client user = logIn();
                clientMenu(user, rUBERnSystem, invoice);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                mainMenu(rUBERnSystem, invoice);
                break;
        }
    }

    static public void driverMenu(MainSystem rUBERnSystem, Invoice invoice){
        System.out.println("1.");
        System.out.println("2.Terminar Viaje");
        System.out.println("3.Exit");
        int option = Scanner.getInt("Which option would you like to excecute: ");

        switch (option) {
            case 1:

                break;
            case 2:

                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                mainMenu(rUBERnSystem, invoice);
                break;
        }
    }

    static public void clientMenu(Client user, MainSystem rUBERnSystem, Invoice invoice){
        System.out.println("1.Call Driver");
        System.out.println("2.Add Funds");
        System.out.println("3.Exit");
        int option = Scanner.getInt("Which option would you like to excecute: ");

        switch (option) {
            case 1:
                long StartX = Scanner.getLong("Enter current X coordinates: ");
                long StartY = Scanner.getLong("Enter current Y coordinates: ");
                Coordinates start = new Coordinates(StartX, StartY);

                long FinishX = Scanner.getLong("Enter destiny's X coordinate: ");
                long FinishY = Scanner.getLong("Enter destiny's Y coordinate: ");
                Coordinates finish = new Coordinates(FinishX, FinishY);

                int numberOfPeople = Scanner.getInt("How many people will travel?");

                double price = rUBERnSystem.calculateCost(start, finish);
                if (price > user.getBalance()){
                    clientMenu(user, rUBERnSystem, invoice);
                }
                if (user.getStatus()){
                    System.out.println("You are already travelling");
                    clientMenu(user, rUBERnSystem, invoice);
                }

                Driver chosenDriver = rUBERnSystem.chooseDriver(start, finish, numberOfPeople);
                user.changeStatus();

                break;
            case 2:

                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                mainMenu(rUBERnSystem, invoice);
                break;
        }
    }

    static public Client logIn(){
        String name = Scanner.getString("Enter your name");
        long creditCardNumber = Scanner.getLong("Enter your credit card number");
        Client user = new Client(0, creditCardNumber);
        return user;
    }
}
