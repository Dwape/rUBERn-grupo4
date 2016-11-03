package Utility;

public class Category {

    private double extraPercentageCost;

    private String categoryName;

    public Category(String name, double percentage){
        extraPercentageCost = percentage;
        categoryName = name;
    }

    public double getExtraPercentageCost(){
        return extraPercentageCost;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public void setName(String newName){
        categoryName = newName;
    }

    public void setPercentageCost(double newPercentage){
        extraPercentageCost = newPercentage;
    }
}
