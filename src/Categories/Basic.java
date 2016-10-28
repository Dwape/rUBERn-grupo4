package Categories;

import Categories.Category;

public class Basic implements Category {
    private double extraPercentageCost = 10;

    @Override
    public double getExtraPercentageCost() {
        return 0;
    }
}
