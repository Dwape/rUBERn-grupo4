/**
 * Created by Gianni on 10/10/2016.
 */
public class rUBERn {
    public static void main(String[] args) {
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
                Coordinates initCoordinates = new Coordinates();
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
