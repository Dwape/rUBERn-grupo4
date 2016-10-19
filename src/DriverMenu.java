/**
 * Created by Gianni on 10/16/2016.
 */
public class DriverMenu {

    public DriverMenu(Data data){
        System.out.println("1.Finish Trip");
        System.out.println("2.Back");
        System.out.println("3.Exit");
        int option = Scanner.getInt("Which option would you like to execute: ");

        switch (option) {
            case 1:
                finishTrip(data);
            case 2:
                new MainMenu(data);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                new DriverMenu(data);
                break;
        }
    }

    private void finishTrip(Data data){
        if (data.getDriver().isTravelling()){
            data.getDriver().arrived();
            data.getClient().changeStatus();
            System.out.println("Your trip has finished successfully");
            data.getrUBERnSystem().transaction(data.getClient(),data.getDriver(),data.startCoordinates,data.finishCoordinates, data.getInvoice());
        }else{
            System.out.println("You are not currently on a trip");
            new DriverMenu(data);
        }
    }
}
