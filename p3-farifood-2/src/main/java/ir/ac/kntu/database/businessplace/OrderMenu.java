package ir.ac.kntu.database.businessplace;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrder;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrderSituation;
import ir.ac.kntu.performance.users.Customer;
import ir.ac.kntu.utility.ScannerWrapper;

import java.time.LocalTime;
import java.util.ArrayList;

public class OrderMenu {

    private Database database;

    public OrderMenu(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public void mainMenu() {
        String strCurrentTime = LocalTime.now().toString().substring(0, LocalTime.now().toString().indexOf("."));

        System.out.println("### Order Menu ###\n\n");
        System.out.println("Enter the name of the customer if you want to reserve an businessPlace order for:");
        String customerName = ScannerWrapper.getInstance().nextLine();
        Customer customer = database.findCustomerByName(customerName);

        if (customer != null) {
            mainMenuPerformer(strCurrentTime + customerName);
        }
    }

    public void mainMenuPerformer(String n) {
        Customer customer = database.findCustomerByName(n.substring(8));

        System.out.println("Active BusinessPlaces:");
        showActiveBusinessPlaces();

        System.out.println("Enter the name of the business place you want:");
        String businessPlaceName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace businessPlace = database.findBusinessPlaceByName(businessPlaceName);

        showItemsOfAMenu(businessPlace.getMenu());
        System.out.println("Enter the name of the item you chose:");
        String foodName = ScannerWrapper.getInstance().nextLine();
        Item item = businessPlace.getMenu().findItemByName(foodName);

        System.out.println("Active Deliveries:");
        showActiveDeliveries();
        System.out.println("Enter the name of the Delivery you chose:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery delivery = database.findDeliveryByName(deliveryName);

        delivery.setAvailable(false); // Filling Delivery fields
        delivery.setTimeItemOrdered(n.substring(0, 7));

        System.out.println("Enter the id of the Order to build it:"); // Generating an Order
        String id = ScannerWrapper.getInstance().nextLine();
        ArrayList<Delivery> deliveries = new ArrayList<>();
        deliveries.add(delivery);
        ArrayList<BusinessPlace> restaurants = new ArrayList<>();
        restaurants.add(businessPlace);
        ArrayList<Item> foods = new ArrayList<>();
        foods.add(item);

        Order order = new Order(id, restaurants, deliveries, foods, RestaurantOrderSituation.PROCESSING);

        customer.addOrder((RestaurantOrder) order);
        customer.addOrder((RestaurantOrder) order);

        System.out.println("Done!");
    }

    public void showActiveDeliveries() {
        for (int i = 0; i < database.getDeliveries().size(); i++) {
            if (database.getDeliveries().get(i).isAvailable()) {
                System.out.println(database.getDeliveries().get(i).getName());
            }
        }
    }

    public void showActiveBusinessPlaces() {
        for (int i = 0; i < database.getRestaurants().size(); i++) {
            if (database.getRestaurants().get(i).getStatus().equals(Status.ACTIVE)) {
                System.out.println(database.getRestaurants().get(i).getName());
            }
        }
    }

    public void showItemsOfAMenu(ItemMenu itemMenu) {
        System.out.println("Items Names:");
        for (int i = 0; i < itemMenu.getItems().size(); i++) {
            System.out.println(itemMenu.getItems().get(i).getName());
        }
    }
}
