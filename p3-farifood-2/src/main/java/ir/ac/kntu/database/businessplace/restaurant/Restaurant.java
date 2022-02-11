package ir.ac.kntu.database.businessplace.restaurant;

import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.Status;
import ir.ac.kntu.performance.users.Manager;

import java.util.Objects;

public class Restaurant extends BusinessPlace {

    private TypeOfPrice typeOfPrice; // Restaurants type of price

    public Restaurant(String name, String address, FoodMenu foodMenu, String workingHours, double point, TypeOfPrice typeOfPrice, Status status, Manager manager) {
        super(name, address, foodMenu, workingHours, point, status, manager);
        this.typeOfPrice = typeOfPrice;
    }

    public Restaurant(String name, String address, FoodMenu foodMenu, String workingHours, double point, TypeOfPrice typeOfPrice) {
        super(name, address, foodMenu, workingHours, point);
        this.typeOfPrice = typeOfPrice;
    }

    public TypeOfPrice getTypeOfPrice() {
        return typeOfPrice;
    }

    public void setTypeOfPrice(TypeOfPrice typeOfPrice) {
        this.typeOfPrice = typeOfPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Restaurant)) {
            return false;
        }

        Restaurant that = (Restaurant) o;

        return getTypeOfPrice() == that.getTypeOfPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeOfPrice());
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "typeOfPrice=" + typeOfPrice +
                '}';
    }
}
