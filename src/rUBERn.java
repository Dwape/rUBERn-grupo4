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
        System.out.println("1.Create Driver");
        System.out.println("2.Terminar Viaje");
        System.out.println("3.Back");
        System.out.println("4.Exit");
        int option = Scanner.getInt("Which option would you like to excecute: ");

        switch (option) {
            case 1:

                Car car = createDriver();
                Driver driver = new Driver()
                break;
            case 2:

                break;
            case 3:
                mainMenu(rUBERnSystem,invoice);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                driverMenu(rUBERnSystem, invoice);
                break;
        }
    }

    static public void clientMenu(Client user, MainSystem rUBERnSystem, Invoice invoice){
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
                if (price > user.getBalance()){
                    System.out.println("Not enough founds");
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
                double founds = Scanner.getDouble("How much money would you like to add? ");
                user.addFunds(founds);
                clientMenu(user,rUBERnSystem,invoice);
                break;
            case 3:
                System.out.println(user.getBalance());
                clientMenu(user,rUBERnSystem,invoice);
                break;
            case 4:
                mainMenu(rUBERnSystem,invoice);
                break;
            case 5:
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

    static public Driver createDriver(){
        String name = Scanner.getString("Please enter your name: ");

        boolean loop = true;
        Category category;
        while (loop) {
            System.out.println("1.Premium");
            System.out.println("2.Standard");
            System.out.println("3.Basic");
            int numerCategory = Scanner.getInt("Choose a category for your car: ");
            switch (numerCategory) {
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
        Driver driver = new Driver(car,name,)
    }

    static public Schedule createSchedule(){
        Schedule schedule = new Schedule();

    }
}
