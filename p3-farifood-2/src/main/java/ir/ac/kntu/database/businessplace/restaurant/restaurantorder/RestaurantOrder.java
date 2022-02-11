package ir.ac.kntu.database.businessplace.restaurant.restaurantorder;

import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.Delivery;
import ir.ac.kntu.database.businessplace.Item;
import ir.ac.kntu.database.businessplace.Order;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDelivery;
import ir.ac.kntu.utility.Time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class RestaurantOrder extends Order {

    public RestaurantOrder(String id, ArrayList<BusinessPlace> restaurants, ArrayList<Delivery> deliveries, ArrayList<Item> foods, RestaurantOrderSituation restaurantOrderSituation) {
        super(id, restaurants, deliveries, foods, restaurantOrderSituation);
    }

    public void arrangeRestaurantsByPointAscending(ArrayList<BusinessPlace> restaurants) { // BubbleSorting
        for (int i = 0; i < restaurants.size() - 1; i++) {
            for (int j = 0; j < restaurants.size() - i - 1; j++) {
                if (restaurants.get(j).getPoint() > restaurants.get(j + 1).getPoint()) {
                    Collections.swap(restaurants, j, j + 1);
                }
            }
        }
    }

    public void arrangeRestaurantsByPointDescending(ArrayList<BusinessPlace> restaurants) { // BubbleSorting
        for (int i = restaurants.size(); i >= 0; i--) {
            for (int j = restaurants.size(); j > restaurants.size() - i; j--) {
                if (restaurants.get(j).getPoint() > restaurants.get(j - 1).getPoint()) {
                    Collections.swap(restaurants, j, j - 1);
                }
            }
        }
    }

    public void arrangeRestaurantsByCommentsAscending(ArrayList<BusinessPlace> restaurants) { // BubbleSorting
        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size() - i - 1; j++) {
                if(restaurants.get(j).getCustomersComments().size() > restaurants.get(j + 1).getCustomersComments().size()) {
                    Collections.swap(restaurants, j, j + 1);
                }
            }
        }
    }

    public void arrangeRestaurantsByCommentsDescending(ArrayList<BusinessPlace> restaurants) { // BubbleSorting
        for (int i = restaurants.size(); i >= 0; i--) {
            for (int j = restaurants.size(); j > restaurants.size() - i; j--) {
                if (restaurants.get(j).getCustomersComments().size() > restaurants.get(j - 1).getCustomersComments().size()) {
                    Collections.swap(restaurants, j, j - 1);
                }
            }
        }
    }

    public void allRestaurantsCommentsHistory(ArrayList<BusinessPlace> restaurants) {
        for (BusinessPlace restaurant : restaurants) {
            restaurant.customerCommentsHistory();
        }
    }

    public void orderCondition(RestaurantDelivery restaurantDelivery) {
        Date date = new Date();
        String[] dateParts = date.toString().split(" ");
        Time currentTime = changeIntoTime(dateParts[3]);
        Time deliveryTime = changeIntoTime(restaurantDelivery.getTimeItemDelivered());

        int n = currentTime.compare(deliveryTime); // compare two currentTime and deliveryTime

        switch (n) {
            case -1:
                super.setOrderSituation(RestaurantOrderSituation.SENDING); // If currentTime was less than deliveryTime restaurantOrderSituation would be SENDING
                break;
            case 0:
                super.setOrderSituation(RestaurantOrderSituation.DELIVERED); // If currentTime was equal to deliveryTime restaurantOrderSituation would be DELIVERED
                break;
            default:
                super.setOrderSituation(RestaurantOrderSituation.PROCESSING); // Else restaurantOrderSituation would be SENDING
                break;

        }
    }

    public Delivery availableDelivery() {
        for (int i = 0; i < super.getDeliveries().size(); i++) {
            if (super.getDeliveries().get(i).isAvailable()) {
                return super.getDeliveries().get(i);
            }
        }

        return null;
    }

    public Time changeIntoTime(String time) {
        String[] timeParts = time.split(":");
        Time time1 = new Time(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]), Integer.parseInt(timeParts[2])); // hh:mm:ss
        return time1;
    }
}
