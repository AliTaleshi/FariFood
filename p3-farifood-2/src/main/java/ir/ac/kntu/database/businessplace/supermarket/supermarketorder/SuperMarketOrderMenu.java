package ir.ac.kntu.database.businessplace.supermarket.supermarketorder;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.*;
import ir.ac.kntu.database.businessplace.fruitshop.Fruit;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDelivery;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrder;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrderSituation;
import ir.ac.kntu.database.businessplace.supermarket.Supply;
import ir.ac.kntu.performance.users.Customer;
import ir.ac.kntu.utility.ScannerWrapper;

import java.time.LocalTime;
import java.util.ArrayList;

public class SuperMarketOrderMenu extends OrderMenu {

    public SuperMarketOrderMenu(Database database) {
        super(database);
    }

    @Override
    public void mainMenu() {
        String strCurrentTime = LocalTime.now().toString().substring(0, LocalTime.now().toString().indexOf("."));

        System.out.println("### SuperMarketOrder SupplyMenu ###\n\n");
        System.out.println("Enter the name of the customer if you want to reserve an SuperMarket order for:");
        String customerName = ScannerWrapper.getInstance().nextLine();
        Customer customer = super.getDatabase().findCustomerByName(customerName);

        if (customer != null) {
            mainMenuPerformer(strCurrentTime + customerName);
        }
    }

    @Override
    public void mainMenuPerformer(String n) {
        Customer customer = super.getDatabase().findCustomerByName(n.substring(8));

        System.out.println("Active SuperMarkets:");
        showActiveBusinessPlaces();

        System.out.println("Enter the name of the SuperMarket you want:");
        String superMarketName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace superMarket = super.getDatabase().findBusinessPlaceByName(superMarketName);

        showItemsOfAMenu(superMarket.getMenu());
        System.out.println("Enter the name of the supply you chose:");
        String fruitName = ScannerWrapper.getInstance().nextLine();
        Supply supply = (Supply) superMarket.getMenu().findItemByName(fruitName);

        System.out.println("Active SuperMarketDeliveries:");
        showActiveDeliveries();
        System.out.println("Enter the name of the SuperMarketDelivery you chose:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery superMarketDelivery = super.getDatabase().findDeliveryByName(deliveryName);

        superMarketDelivery.setAvailable(false); // Filling RestaurantDelivery fields
        superMarketDelivery.setTimeItemOrdered(n.substring(0, 7));

        System.out.println("Enter the id of the SuperMarketOrder to build it:"); // Generating an restaurantOrder
        String id = ScannerWrapper.getInstance().nextLine();
        ArrayList<Delivery> deliveries = new ArrayList<>();
        deliveries.add(superMarketDelivery);
        ArrayList<BusinessPlace> superMarkets = new ArrayList<>();
        superMarkets.add(superMarket);
        ArrayList<Item> supplies = new ArrayList<>();
        supplies.add(supply);

        Order superMarketOrder = new Order(id, superMarkets, deliveries, supplies, RestaurantOrderSituation.PROCESSING);

        customer.addOrder((RestaurantOrder) superMarketOrder);
        customer.addOrder((RestaurantOrder) superMarketOrder);

        System.out.println("Done!");
    }

    @Override
    public void showItemsOfAMenu(ItemMenu itemMenu) {
        System.out.println("Supplies Names:");
        for (int i = 0; i < itemMenu.getItems().size(); i++) {
            System.out.println(itemMenu.getItems().get(i).getName());
        }
    }
}
