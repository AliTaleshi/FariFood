package ir.ac.kntu.database.businessplace.restaurant.restaurantorder;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.*;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDelivery;
import ir.ac.kntu.database.businessplace.restaurant.Food;
import ir.ac.kntu.database.businessplace.restaurant.Restaurant;
import ir.ac.kntu.performance.users.Customer;
import ir.ac.kntu.utility.ScannerWrapper;

import java.time.LocalTime;
import java.util.ArrayList;

public class RestaurantOrderMenu extends OrderMenu {

    public RestaurantOrderMenu(Database database) {
        super(database);
    }

    @Override
    public void mainMenu() {
        String strCurrentTime = LocalTime.now().toString().substring(0, LocalTime.now().toString().indexOf("."));

        System.out.println("### RestaurantOrder FoodMenu ###\n\n");
        System.out.println("Enter the name of the customer if you want to reserve an restaurant order for:");
        String customerName = ScannerWrapper.getInstance().nextLine();
        Customer customer = super.getDatabase().findCustomerByName(customerName);

        if (customer != null) {
            mainMenuPerformer(strCurrentTime + customerName);
        }
    }

    @Override
    public void mainMenuPerformer(String n) {
        Customer customer = super.getDatabase().findCustomerByName(n.substring(8));

        System.out.println("Active Restaurants:");
        showActiveBusinessPlaces();

        System.out.println("Enter the name of the restaurant you want:");
        String restaurantName = ScannerWrapper.getInstance().nextLine();
        Restaurant restaurant = (Restaurant) super.getDatabase().findBusinessPlaceByName(restaurantName);

        showItemsOfAMenu(restaurant.getMenu());
        System.out.println("Enter the name of the food you chose:");
        String foodName = ScannerWrapper.getInstance().nextLine();
        Food food = (Food) restaurant.getMenu().findItemByName(foodName);

        System.out.println("Active Deliveries:");
        showActiveDeliveries();
        System.out.println("Enter the name of the restaurantDelivery you chose:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        RestaurantDelivery restaurantDelivery = (RestaurantDelivery) super.getDatabase().findDeliveryByName(deliveryName);

        restaurantDelivery.setAvailable(false); // Filling RestaurantDelivery fields
        restaurantDelivery.setTimeItemOrdered(n.substring(0, 7));

        System.out.println("Enter the id of the restaurantOrder to build it:"); // Generating an restaurantOrder
        String id = ScannerWrapper.getInstance().nextLine();
        ArrayList<Delivery> deliveries = new ArrayList<>();
        deliveries.add(restaurantDelivery);
        ArrayList<BusinessPlace> restaurants = new ArrayList<>();
        restaurants.add(restaurant);
        ArrayList<Item> foods = new ArrayList<>();
        foods.add(food);

        RestaurantOrder restaurantOrder = new RestaurantOrder(id, restaurants, deliveries, foods, RestaurantOrderSituation.PROCESSING);

        customer.addOrder(restaurantOrder);
        customer.addOrder(restaurantOrder);

        System.out.println("Done!");
    }

    @Override
    public void showItemsOfAMenu(ItemMenu itemMenu) {
        System.out.println("Foods Names:");
        for (int i = 0; i < itemMenu.getItems().size(); i++) {
            System.out.println(itemMenu.getItems().get(i).getName());
        }
    }
}
