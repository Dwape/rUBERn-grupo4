import Exceptions.NoAvailableDriverExc;

/**
 * Created by Gianni on 10/16/2016.
 */
public class ClientMenu {

    public ClientMenu(Client client, MainSystem rUBERnSystem, Invoice invoice){
        System.out.println("1.Call Driver");
        System.out.println("2.Add Funds");
        System.out.println("3.Check Funds");
        System.out.println("4.Back");
        System.out.println("5.Exit");
        int option = Scanner.getInt("Which option would you like to execute: ");

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
                if (price > client.getBalance()){
                    System.out.println("Not enough funds");
                    new ClientMenu(client, rUBERnSystem, invoice);
                }
                if (client.getStatus()){
                    System.out.println("You are already travelling");
                    new ClientMenu(client, rUBERnSystem, invoice);
                }
                try{
                    Driver chosenDriver = rUBERnSystem.chooseDriver(start, finish,numberOfPeople);
                    client.changeStatus();
                    rUBERnSystem.transaction(client,chosenDriver,start,finish,invoice);
                    System.out.println("Trip started successfully");
                    new ClientMenu(client,rUBERnSystem,invoice);
                }catch (NoAvailableDriverExc exc){
                    System.out.println("No available driver, please try again later");
                    new ClientMenu(client, rUBERnSystem, invoice);
                }

                break;
            case 2:
                double founds = Scanner.getDouble("How much money would you like to add? ");
                client.addFunds(founds);
                System.out.println("Funds added successfully");
                new ClientMenu(client,rUBERnSystem,invoice);
                break;
            case 3:
                System.out.println("Your balance is: $"+client.getBalance());
                new ClientMenu(client,rUBERnSystem,invoice);
                break;
            case 4:
                new MainMenu(rUBERnSystem,invoice,client);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid option");
                new MainMenu(rUBERnSystem, invoice, client);
                break;
        }
    }
}
