import java.util.ArrayList;

/**
 * Created by Gianni on 10/16/2016.
 */
public class MainMenu extends Formulary{
    private ClientMenu clientMenu;
    private DriverMenu driverMenu;

    private String title = "Main Menu";

    public MainMenu(MainData data){
        show();
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

    private void driverList(MainData data){
        ArrayList<Driver> driverArrayList = data.getrUBERnSystem().getDriverList();
        Driver chosenDriver = driverArrayList.get(0);
        for(int i=0;i<driverArrayList.size();i++){
            System.out.println(i+1+"."+driverArrayList.get(i).getName());
        }
        int result = Scanner.getInt("Select a driver: ");
        try {
            chosenDriver = driverArrayList.get(result - 1);
            data.setDriver(chosenDriver);
        } catch (IndexOutOfBoundsException t) {
            System.out.println("Not a valid option");
            driverList(data);
        }
        new DriverMenu(data);
    }

    public String getTitle(){
        return title;
    }

    public void displayContent(){
        System.out.println("1.Driver Options");
        System.out.println("2.Client Options");
        System.out.println("3.rUBERn Options");
        System.out.println("4.Exit");
    }

}
