package ir.ac.kntu.database.businessplace.fruitshop;

import ir.ac.kntu.database.businessplace.Item;

import java.util.Objects;

public class Fruit extends Item {

    private int quantity;

    public Fruit(String name, double price, double point, int quantity) {
        super(name, price, point);
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Fruit)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        Fruit fruit = (Fruit) o;

        return quantity == fruit.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "quantity=" + quantity +
                '}';
    }
}
