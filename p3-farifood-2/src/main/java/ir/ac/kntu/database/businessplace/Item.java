package ir.ac.kntu.database.businessplace;

import ir.ac.kntu.performance.users.Customer;

import java.util.HashMap;
import java.util.Objects;

public class Item {

    private String name;

    private double price; //Dollars

    private double point;

    private HashMap<Customer, String> customersComments; // Customers and their comments

    public Item(String name, double price, double point) {
        this.customersComments = new HashMap<>();
        this.name = name;
        this.price = price;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    /*public void setPrice(double price) {
        this.price = price;
    }*/

    public double getPoint() {
        return point;
    }

    /*public void setPoint(double point) {
        this.point = point;
    }*/

    public HashMap<Customer, String> getCustomersComments() {
        return customersComments;
    }

    /*public void setCustomersComments(HashMap<Customer, String> customersComments) {
        this.customersComments = customersComments;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Item)) {
            return false;
        }

        Item item = (Item) o;

        return Double.compare(item.getPrice(), getPrice()) == 0 && Double.compare(item.getPoint(), getPoint()) == 0 && Objects.equals(getName(), item.getName()) && Objects.equals(getCustomersComments(), item.getCustomersComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getPoint(), getCustomersComments());
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", point=" + point +
                ", customersComments=" + customersComments +
                '}';
    }
}
