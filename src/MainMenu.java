import java.util.ArrayList;

/**
 * Created by Gianni on 10/16/2016.
 */
public class MainMenu {
    private ClientMenu clientMenu;
    private DriverMenu driverMenu;

    public MainMenu(Data data){
        System.out.println("1.Driver Options");
        System.out.println("2.Client Options");
        System.out.println("3.rUBERn Options");
        System.out.println("4.Exit");
        int option = Scanner.getInt("Which option would you like to execute: ");

        switch (option) {
            case 1:
                driverList(data);
                break;
            case 2:
                clientMenu = new ClientMenu(data);
                break;
            case 3:
                new rUBERnMenu(data);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                new MainMenu(data);
                break;
        }
    }

    private void driverList(Data data){
        ArrayList<Driver> driverArrayList = data.getrUBERnSystem().getDriverList();
        Driver chosenDriver = driverArrayList.get(0);
        System.out.println("1.Register");
        for(int i=0;i<driverArrayList.size();i++){
            System.out.println(i+1+"."+driverArrayList.get(i).getName());
        }
        int result = Scanner.getInt("Select a driver: ");
        try {
            chosenDriver = driverArrayList.get(result - 1);
        } catch (IndexOutOfBoundsException t) {
            System.out.println("Not a valid option");
            driverList(data);
        }
        new DriverMenu(data);
    }

}