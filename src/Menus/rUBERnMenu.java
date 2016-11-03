package Menus;

import Utility.Category;
import DriverAndClient.Car;
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
                configureCategory();
                new rUBERnMenu(data);
                break;
            case 5:
                new MainMenu(data);
                break;
            case 6:
                System.exit(0);
                break;
        }
    }

    private Driver createDriver(){
        String name = Scanner.getString("Please enter your name: ");

        Category category = existingCategories();
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

    private void configureCategory(){
        ArrayList<Category> categories = data.getCategories();
            System.out.println("1.Create new category");
            System.out.println("2.Modify existing category");
            System.out.println("3.Delete existing category");
            System.out.println("4.Back");
            int numberCategory = Scanner.getInt("Choose a category for your car: ");
            switch (numberCategory) {
                case 1:
                    String name = Scanner.getString("Enter category name: ");
                    double percentageCost = Scanner.getDouble("Enter extra percentage cost: ");
                    Category newCategory = new Category(name, percentageCost);
                    data.addCategory(newCategory);
                    break;
                case 2:
                    Category modifiedCategory = existingCategories();
                    data.getCategories().remove(modifiedCategory);
                    String newName = Scanner.getString("Enter new category name: ");
                    double newPercentageCost = Scanner.getDouble("Enter new extra percentage cost: ");
                    modifiedCategory.setName(newName);
                    modifiedCategory.setPercentageCost(newPercentageCost);
                    data.addCategory(modifiedCategory);
                    break;
                case 3:
                    Category removeCategory = existingCategories();
                    data.getCategories().remove(removeCategory);
                    break;
                case 4:
                    new MainMenu(data);
                    break;
                default:
                    System.out.println("Not a valid option");
                    break;
        }
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
        System.out.println("4.Configure Categories");
        System.out.println("5.Back");
        System.out.println("6.Exit");
    }

    public Category existingCategories(){
        ArrayList<Category> categories = data.getCategories();
        for (int i = 0; i < categories.size(); i++){
            System.out.println(i + "." + categories.get(i).getCategoryName());
        }
        int option = Scanner.getInt("Choose a category: ");
        if (option-1 > categories.size()) {
            System.out.println("Invalid Option");
            existingCategories();
        }
            return categories.get(option-1);
    }
}
