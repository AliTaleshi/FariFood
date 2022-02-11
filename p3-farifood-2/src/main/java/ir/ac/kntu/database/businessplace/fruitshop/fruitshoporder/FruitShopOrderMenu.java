package ir.ac.kntu.database.businessplace.fruitshop.fruitshoporder;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.*;
import ir.ac.kntu.database.businessplace.fruitshop.Fruit;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDelivery;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrder;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrderSituation;
import ir.ac.kntu.performance.users.Customer;
import ir.ac.kntu.utility.ScannerWrapper;

import java.time.LocalTime;
import java.util.ArrayList;

public class FruitShopOrderMenu extends OrderMenu {

    public FruitShopOrderMenu(Database database) {
        super(database);
    }

    @Override
    public void mainMenu() {
        String strCurrentTime = LocalTime.now().toString().substring(0, LocalTime.now().toString().indexOf("."));

        System.out.println("### FruitShopOrder FruitMenu ###\n\n");
        System.out.println("Enter the name of the customer if you want to reserve an FruitShop order for:");
        String customerName = ScannerWrapper.getInstance().nextLine();
        Customer customer = super.getDatabase().findCustomerByName(customerName);

        if (customer != null) {
            mainMenuPerformer(strCurrentTime + customerName);
        }
    }

    @Override
    public void mainMenuPerformer(String n) {
        Customer customer = super.getDatabase().findCustomerByName(n.substring(8));

        System.out.println("Active FruitShops:");
        showActiveBusinessPlaces();

        System.out.println("Enter the name of the FruitShop you want:");
        String fruitShopName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace fruitShop = super.getDatabase().findBusinessPlaceByName(fruitShopName);

        showItemsOfAMenu(fruitShop.getMenu());
        System.out.println("Enter the name of the fruit you chose:");
        String fruitName = ScannerWrapper.getInstance().nextLine();
        Fruit fruit = (Fruit) fruitShop.getMenu().findItemByName(fruitName);

        System.out.println("Active FruitShopDeliveries:");
        showActiveDeliveries();
        System.out.println("Enter the name of the FruitShopDelivery you chose:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery fruitShopDelivery = (RestaurantDelivery) super.getDatabase().findDeliveryByName(deliveryName);

        fruitShopDelivery.setAvailable(false); // Filling RestaurantDelivery fields
        fruitShopDelivery.setTimeItemOrdered(n.substring(0, 7));

        System.out.println("Enter the id of the FruitShopOrder to build it:"); // Generating an restaurantOrder
        String id = ScannerWrapper.getInstance().nextLine();
        ArrayList<Delivery> deliveries = new ArrayList<>();
        deliveries.add(fruitShopDelivery);
        ArrayList<BusinessPlace> fruitShops = new ArrayList<>();
        fruitShops.add(fruitShop);
        ArrayList<Item> fruits = new ArrayList<>();
        fruits.add(fruit);

        Order fruitShopOrder = new Order(id, fruitShops, deliveries, fruits, RestaurantOrderSituation.PROCESSING);

        customer.addOrder((RestaurantOrder) fruitShopOrder);
        customer.addOrder((RestaurantOrder) fruitShopOrder);

        System.out.println("Done!");
    }

    @Override
    public void showItemsOfAMenu(ItemMenu itemMenu) {
        System.out.println("Fruits Names:");
        for (int i = 0; i < itemMenu.getItems().size(); i++) {
            System.out.println(itemMenu.getItems().get(i).getName());
        }
    }
}
