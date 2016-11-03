package Menus;

import DriverAndClient.Client;
import DriverAndClient.Coordinates;
import DriverAndClient.NoClient;
import Exceptions.NoAvailableDriverExc;
import Exceptions.NoClientLoggedExc;
import Utility.Scanner;

/**
 * Created by Gianni on 10/16/2016.
 */
public class ClientMenu extends Formulary {

    private String title = "Client Menu";
    MainData data;

    public ClientMenu(MainData data){
        this.data=data;
        try{
            System.out.println("User: "+data.getClient().getName());
        }catch (NoClientLoggedExc exc){
            data.setClient(logIn());
        }
        show();
        int option = Scanner.getInt("Which option would you like to execute: ");
        clearScreen();

        switch (option) {
            case 1:
                callDriver(data);
                break;
            case 2:
                double founds = Scanner.getDouble("How much money would you like to add? ");
                data.getClient().addFunds(founds);
                System.out.println("Funds added successfully");
                new ClientMenu(data);
                break;
            case 3:
                System.out.println("Your balance is: $"+data.getClient().getBalance());
                new ClientMenu(data);
                break;
            case 4:
                if (data.getClient().getStatus()){
                    System.out.println("You can't log off while travelling, please wait until the trip has finished.");
                    new ClientMenu(data);
                }
                data.setClient(new NoClient());
                System.out.println("LogOut successful");
                new MainMenu(data);
                break;
            case 5:
                new MainMenu(data);
                break;
            case 6:
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
        Client client = new Client(0,creditCardNumber,name);
        return client;
    }

    private void callDriver(MainData data){
        if(data.getClient().getStatus()){
            System.out.println("Already travelling");
            new ClientMenu(data);
        }
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

    public String getTitle(){
        return title;
    }

    public void displayContent(){
        System.out.println("1.Call Driver");
        System.out.println("2.Add Funds");
        System.out.println("3.Check Funds");
        System.out.println("4.LogOut");
        System.out.println("5.Back");
        System.out.println("6.Exit");
    }
}
