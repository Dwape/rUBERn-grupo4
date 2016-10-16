/**
 * Created by Gianni on 10/16/2016.
 */
public class DriverMenu {

    public DriverMenu(MainSystem rUBERnSystem, Invoice invoice, Driver driver, Client client){
        System.out.println("1.Finish Trip");
        System.out.println("2.Back");
        System.out.println("3.Exit");
        int option = Scanner.getInt("Which option would you like to execute: ");

        switch (option) {
            case 1:
                if (driver.isTravelling()){
                    driver.arrived();
                    client.changeStatus();
                    System.out.println("Your trip has finished successfully");
                }else{
                    System.out.println("You are not currently on a trip");
                    new DriverMenu(rUBERnSystem, invoice,driver, client);
                }

            case 2:
                new MainMenu(rUBERnSystem,invoice, client);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                new DriverMenu(rUBERnSystem, invoice,driver, client);
                break;
        }
    }
}
