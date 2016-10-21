import Exceptions.NoAvailableDriverExc;

/**
 * Created by Gianni on 10/16/2016.
 */
public class ClientMenu {

    public ClientMenu(MainData data){
        System.out.println("1.LogIn");
        System.out.println("2.LogOut");
        System.out.println("3.Call Driver");
        System.out.println("4.Add Funds");
        System.out.println("5.Check Funds");
        System.out.println("6.Back");
        System.out.println("7.Exit");
        int option = Scanner.getInt("Which option would you like to execute: ");

        switch (option) {
            case 1:
                data.setClient(logIn());
                System.out.println("LogIn successful");
                new ClientMenu(data);
                break;
            case 2:
                data.setClient(new NoClient());
                System.out.println("LogOut successful");
                new ClientMenu(data);
                break;
            case 3:
                callDriver(data);
                break;
            case 4:
                double founds = Scanner.getDouble("How much money would you like to add? ");
                data.getClient().addFunds(founds);
                System.out.println("Funds added successfully");
                new ClientMenu(data);
                break;
            case 5:
                System.out.println("Your balance is: $"+data.getClient().getBalance());
                new ClientMenu(data);
                break;
            case 6:
                new MainMenu(data);
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                new MainMenu(data);
                break;
        }
    }

    public Client logIn(){
        String name = Scanner.getString("Enter your name: ");
        long creditCardNumber = Scanner.getLong("Enter your credit card number: ");
        Client client = new Client(0,creditCardNumber);
        return client;
    }

    private void callDriver(MainData data){
        long StartX = Scanner.getLong("Enter current X coordinates: ");
        long StartY = Scanner.getLong("Enter current Y coordinates: ");
        Coordinates start = new Coordinates(StartX, StartY);

        long FinishX = Scanner.getLong("Enter destiny's X coordinate: ");
        long FinishY = Scanner.getLong("Enter destiny's Y coordinate: ");
        Coordinates finish = new Coordinates(FinishX, FinishY);

        int numberOfPeople = Scanner.getInt("How many people will travel? ");

        double price = data.getrUBERnSystem().calculateCost(start, finish);
        if (price > data.getClient().getBalance()){
            System.out.println("Not enough funds");
            new ClientMenu(data);
        }
        if (data.getClient().getStatus()){
            System.out.println("You are already travelling");
            new ClientMenu(data);
        }
        try{
            data.getrUBERnSystem().chooseDriver(start, finish,numberOfPeople);
            data.getClient().changeStatus();
            data.setStartCoordinates(start);
            data.setFinishCoordinates(finish);
            System.out.println("Trip started successfully");
            new ClientMenu(data);
        }catch (NoAvailableDriverExc exc){
            System.out.println("No available driver, please try again later");
            new ClientMenu(data);
        }
    }
}
