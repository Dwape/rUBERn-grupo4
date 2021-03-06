package Menus;

import DriverAndClient.*;
import Utility.Invoice;
import Utility.MainSystem;
import Utility.Category;

import java.util.ArrayList;

/**
 * Created by Dwape on 10/19/16.
 */
public class MainData {

    AbstractClient client;
    MainSystem rUBERnSystem;
    Invoice invoice;
    AbstractDriver driver;
    Coordinates startCoordinates;
    Coordinates finishCoordinates;
    ArrayList<Category> categories = new ArrayList<>();

    public MainData(AbstractClient client, MainSystem rUBERnSystem, Invoice invoice, AbstractDriver driver) {
        this.client = client;
        this.rUBERnSystem = rUBERnSystem;
        this.invoice = invoice;
        this.driver = driver;
    }


    public Coordinates getStartCoordinates() {
        return startCoordinates;
    }
    public Coordinates getFinishCoordinates() {
        return finishCoordinates;
    }
    public AbstractClient getClient() {
        return client;
    }
    public MainSystem getrUBERnSystem() {
        return rUBERnSystem;
    }
    public Invoice getInvoice() {
        return invoice;
    }
    public AbstractDriver getDriver() {
        return driver;
    }
    public ArrayList getCategories(){
        return categories;
    }

    public void setStartCoordinates(Coordinates startCoordinates) {
        this.startCoordinates = startCoordinates;
    }
    public void setFinishCoordinates(Coordinates finishCoordinates) {
        this.finishCoordinates = finishCoordinates;
    }
    public void setClient(AbstractClient client) {
        this.client = client;
    }
    public void setrUBERnSystem(MainSystem rUBERnSystem) {
        this.rUBERnSystem = rUBERnSystem;
    }
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public void addCategory(Category newCategory){
        categories.add(newCategory);
    }
}
