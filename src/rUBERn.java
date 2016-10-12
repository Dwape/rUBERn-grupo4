/**
 * Created by Gianni on 10/10/2016.
 */
public class rUBERn {
    public static void main(String[] args) {
        MainSystem rUBERnSystem = new MainSystem();

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

        mainMenu();
    }

    static public void mainMenu(){
        System.out.println("1.Driver Options");
        System.out.println("2.Client Options");
        System.out.println("3.Exit");
        int option = Scanner.getInt("Which option would you like to excecute: ");

        switch (option) {
            case 1:
                driverMenu();
                break;
            case 2:
                clientMenu();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                mainMenu();
                break;
        }
    }

    static public void driverMenu(){
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
                mainMenu();
                break;
        }
    }

    static public void clientMenu(){
        System.out.println("1.Call Driver");
        System.out.println("2.");
        System.out.println("3.Exit");
        int option = Scanner.getInt("Which option would you like to excecute: ");

        switch (option) {
            case 1:
                long x = Scanner.getLong("Enter your X coordinates: ");
                long y = Scanner.getLong("Enter your Y coordinates: ");
                Coordinates initCoordinates = new Coordinates(x,y);
                break;
            case 2:

                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                mainMenu();
                break;
        }
    }
}
