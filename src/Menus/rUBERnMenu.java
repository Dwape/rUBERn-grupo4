package Menus;

import Categories.Basic;
import Categories.Category;
import Categories.Premium;
import Categories.Standard;
import DriverAndClient.Car;
import DriverAndClient.Client;
import DriverAndClient.Coordinates;
import DriverAndClient.Driver;
import Utility.Scanner;

import java.util.ArrayList;

public class rUBERnMenu extends Formulary {

    MainData data;
    private String title = "rUBERn Menu";

    public rUBERnMenu (MainData data){
        this.data=data;
        show();
        int result = Scanner.getInt("Which option would you like to execute: ");
        clearScreen();

        switch (result){
            case 1:
                data.getrUBERnSystem().addDriver(createDriver());
                new rUBERnMenu(data);
                break;
            case 2:
                data.getInvoice().print();
                new rUBERnMenu(data);
                break;
            case 3:
                showUsers();
                new rUBERnMenu(data);
                break;
            case 4:
                new MainMenu(data);
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    private Driver createDriver(){
        String name = Scanner.getString("Please enter your name: ");

        boolean loop = true;
        Category category;
        category = new Premium();
        while (loop) {
            System.out.println("1.Premium");
            System.out.println("2.Standard");
            System.out.println("3.Basic");
            int numberCategory = Scanner.getInt("Choose a category for your car: ");
            switch (numberCategory) {
                case 1:
                    category = new Premium();
                    loop = false;
                    break;
                case 2:
                    category = new Standard();
                    loop = false;
                    break;
                case 3:
                    category = new Basic();
                    loop = false;
                    break;
                default:
                    System.out.println("Not a valid option");
                    break;
            }
        }
        int spaceCar = Scanner.getInt("Car capacity for passenger: ");
        System.out.println("Please enter your coordinates");
        long coordinateX = Scanner.getLong("Enter your X coordinate: ");
        long coordinateY = Scanner.getLong("Enter your y coordinate: ");
        long creditCard = Scanner.getLong("Enter your credit card number: ");
        Coordinates coordinates = new Coordinates(coordinateX,coordinateY);
        System.out.println();
        Car car = new Car(spaceCar,category,coordinates);
        System.out.println("Driver registered successfully");
        return new Driver(car,name, creditCard);
    }

    private void showUsers(){
        ArrayList<Driver> driverList = data.getrUBERnSystem().getDriverList();
        System.out.println("Clients: ");
        String status;
        if(data.getClient().getStatus())
            status = "Travelling";
        else
            status="Not travelling";
        System.out.println(data.getClient().getName() + "------" + status);

        System.out.println("\nDrivers: ");
        for(int i=0;i<driverList.size();i++){
            System.out.println(driverList.get(i).getName() + "------" + driverList.get(i).getStatus());
        }
    }

    public String getTitle(){
        return title;
    }

    public void displayContent(){
        System.out.println("1.Register Driver");
        System.out.println("2.Print Invoice");
        System.out.println("3.Show current users");
        System.out.println("4.Back");
        System.out.println("5.Exit");
    }
}
