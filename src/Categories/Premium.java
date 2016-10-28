package Categories;

import Categories.Category;

public class Premium implements Category {
    private double extraPercentageCost = 0;

    @Override
    public double getExtraPercentageCost() {
        return extraPercentageCost;
    }
}
