package ir.ac.kntu.database.businessplace;

import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrderSituation;

import java.util.ArrayList;


public class Order {

    private String id;

    private ArrayList<BusinessPlace> businessPlaces;

    private ArrayList<Delivery> deliveries;

    private RestaurantOrderSituation orderSituation;

    private ArrayList<Item> items;

    public Order(String id, ArrayList<BusinessPlace> businessPlaces, ArrayList<Delivery> deliveries, ArrayList<Item> items, RestaurantOrderSituation restaurantOrderSituation) {
        this.businessPlaces = new ArrayList<>();
        this.deliveries = new ArrayList<>();
        this.items = new ArrayList<>();
        this.id = id;
        this.businessPlaces = businessPlaces;
        this.deliveries = deliveries;
        this.items = items;
    }

    public Order() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<BusinessPlace> getBusinessPlaces() {
        return businessPlaces;
    }

    public void setBusinessPlaces(ArrayList<BusinessPlace> businessPlaces) {
        this.businessPlaces = businessPlaces;
    }

    public ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(ArrayList<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public RestaurantOrderSituation getOrderSituation() {
        return orderSituation;
    }

    public void setOrderSituation(RestaurantOrderSituation orderSituation) {
        this.orderSituation = orderSituation;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addDelivery(Delivery delivery) {
        deliveries.add(delivery);
    }

    public void addBusinessPlace(BusinessPlace businessPlace) {
        businessPlaces.add(businessPlace);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}