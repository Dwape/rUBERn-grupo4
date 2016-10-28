package Categories;

import Categories.Category;

public class Standard implements Category {
    private double extraPercentageCost = 5;

    @Override
    public double getExtraPercentageCost() {
        return extraPercentageCost;
    }
}
