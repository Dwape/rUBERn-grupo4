package DriverAndClient;

import Utility.Category;

/**
 * Created by Gianni on 10/9/2016.
 */
public class Car {
    private int space;
    private Category aCategory;
    private Coordinates coordinates;

    public Car(int space, Category aCategory, Coordinates coordinates) {
        this.space = space;
        this.aCategory = aCategory;
        this.coordinates=coordinates;
    }
    public int getSpace(){
        return space;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Category getaCategory() {
        return aCategory;
    }
}
