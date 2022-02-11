package ir.ac.kntu.database.businessplace.supermarket;

import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrder;
import ir.ac.kntu.utility.Time;

import java.util.ArrayList;
import java.util.Objects;

public class SuperMarketTimePeriod extends Time {

    private ArrayList<RestaurantOrder> restaurantOrders; // Maximum two restaurantOrders

    private Time staringTime;

    private Time endingTime;

    private double price;

    public SuperMarketTimePeriod() {}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<RestaurantOrder> getOrders() {
        return restaurantOrders;
    }

    public void setOrders(ArrayList<RestaurantOrder> restaurantOrders) {
        this.restaurantOrders = restaurantOrders;
    }

    public void addOrder(RestaurantOrder restaurantOrder) {
        this.restaurantOrders.add(restaurantOrder);
    }

    public void removeOrder(RestaurantOrder restaurantOrder) {
        this.restaurantOrders.remove(restaurantOrder);
    }

    public Time getStaringTime() {
        return staringTime;
    }

    public void setStaringTime(Time staringTime) {
        this.staringTime = staringTime;
    }

    public Time getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Time endingTime) {
        this.endingTime = endingTime;
    }

    public Time toStartingTime(String timePeriod) {
        String[] strings = timePeriod.split(" ");
        return staringTime.changeIntoTime(strings[1]);
    }

    public Time toEndingHour(String timePeriod) {
        String[] strings = timePeriod.split(" ");
        return endingTime.changeIntoTime(strings[3]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof SuperMarketTimePeriod)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        SuperMarketTimePeriod that = (SuperMarketTimePeriod) o;

        return Double.compare(that.getPrice(), getPrice()) == 0 && Objects.equals(restaurantOrders, that.restaurantOrders) && Objects.equals(getStaringTime(), that.getStaringTime()) && Objects.equals(getEndingTime(), that.getEndingTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), restaurantOrders, getStaringTime(), getEndingTime(), getPrice());
    }

    @Override
    public String toString() {
        return "SuperMarketTimePeriod{" +
                "restaurantOrders=" + restaurantOrders +
                ", staringTime=" + staringTime +
                ", endingTime=" + endingTime +
                ", price=" + price +
                '}';
    }
}
