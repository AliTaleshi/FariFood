package ir.ac.kntu.database.businessplace.supermarket;

import ir.ac.kntu.database.businessplace.Item;
import ir.ac.kntu.database.businessplace.ItemMenu;

public class Supply extends Item {

    private int quantity;

    public Supply(String name, double price, double point, int quantity) {
        super(name, price, point);
        this.quantity = quantity;
    }
}
