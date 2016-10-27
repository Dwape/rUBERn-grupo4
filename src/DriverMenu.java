import Exceptions.*;

/**
 * Created by Gianni on 10/16/2016.
 */
public class DriverMenu extends Formulary{
    MainData data;
    private String title = "Driver Menu";

    public DriverMenu(MainData data){
        this.data=data;
        show();
        int option = Scanner.getInt("Which option would you like to execute: ");

        switch (option) {
            case 1:
                finishTrip();
                new DriverMenu(data);
                break;
            case 2:
                goOnline();
                new DriverMenu(data);
                break;
            case 3:
                goOffline();
                new DriverMenu(data);
                break;
            case 4:
                new MainMenu(data);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                new DriverMenu(data);
                break;
        }
    }

    private void finishTrip(){
        try {
            data.getDriver().goToWork();
            data.getDriver().goOnline();
            System.out.println("You are not currently on a trip");
        }catch (DriverAlreadyWorkingExc t){
            data.getDriver().arrived();
            data.getClient().changeStatus();
            System.out.println("Your trip has finished successfully");
            data.getrUBERnSystem().transaction(data.getClient(), data.getDriver(), data.startCoordinates, data.finishCoordinates, data.getInvoice());
        }catch (CanNotWorkWhileOfflineExc t){
            System.out.println("Your are not online");
        }
    }

    public String getTitle(){
        return title;
    }

    public void displayContent(){
        System.out.println("1.Finish Trip");
        System.out.println("2.Go Online");
        System.out.println("3.Go Offline");
        System.out.println("4.Back");
        System.out.println("5.Exit");
    }

    public void goOnline(){
        try {
            data.getDriver().goOnline();
            System.out.println("You are now online");
        }catch (DriverAlreadyWorkingExc t){
            System.out.println("Can not go online while you are working");
        }catch (DriverAlreadyOnlineExc t){
            System.out.println("Your are already online");
        }catch (CanNotGoOfflineWhileWorkingExc t){
            System.out.println("Your are now working, you can not go online");
        }

    }

    public void goOffline(){
        try {
            data.getDriver().goOffline();
            System.out.println("Your are now offline");
        }catch (DriverAlreadyOfflineExc t){
            System.out.println("You are already offline");
        }catch (CanNotWorkWhileOfflineExc t){
            System.out.println("You can not go offline while working");
        }catch (CanNotGoOfflineWhileWorkingExc t){
            System.out.println("Your are working");
        }
    }
}
