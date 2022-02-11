package ir.ac.kntu.database.businessplace.restaurant;

import ir.ac.kntu.database.businessplace.Item;
import ir.ac.kntu.utility.Time;

public class Food extends Item {

    private Time cookTime;

    public Food(String name, double price, double point, Time cookTime) {
        super(name, price, point);
        this.cookTime = cookTime;
    }

    public Time getCookTime() {
        return cookTime;
    }

    public void setCookTime(Time cookTime) {
        this.cookTime = cookTime;
    }
}