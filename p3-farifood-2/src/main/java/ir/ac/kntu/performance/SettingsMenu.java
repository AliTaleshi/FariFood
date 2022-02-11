package ir.ac.kntu.performance;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrder;
import ir.ac.kntu.utility.ScannerWrapper;

public class SettingsMenu {

    private Database database;

    public SettingsMenu(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }


    public void setDatabase(Database database) {
        this.database = database;
    }

    public void mainMenu() {
        System.out.println("### Settings FoodMenu ###\n\n");

        System.out.println("Enter the id of the restaurantOrder:");
        String id = ScannerWrapper.getInstance().nextLine();
        RestaurantOrder restaurantOrder = (RestaurantOrder) database.findOrderById(id);

        if (restaurantOrder != null) {
            System.out.println("1.Show restaurants sorted by points in ascending restaurantOrder");
            System.out.println("2.Show restaurants sorted by points in descending restaurantOrder");
            System.out.println("3.Show restaurants sorted by comments in ascending restaurantOrder");
            System.out.println("4.Show restaurants sorted by comments in descending restaurantOrder");

            String n = ScannerWrapper.getInstance().nextLine();

            mainMenuPerformer(n + id);
        } else {
            System.out.println("RestaurantOrder with this id not found!\nPlease try again :)");
        }
    }

    public void mainMenuPerformer(String n) {
        RestaurantOrder restaurantOrder = (RestaurantOrder) database.findOrderById(n.substring(1));

        switch (Integer.parseInt(n.substring(0, 1))) {
            case 1:
                restaurantOrder.arrangeRestaurantsByPointAscending(restaurantOrder.getBusinessPlaces());
                System.out.println("Done!");
                break;
            case 2:
                restaurantOrder.arrangeRestaurantsByPointDescending(restaurantOrder.getBusinessPlaces());
                System.out.println("Done!");
                break;
            case 3:
                restaurantOrder.arrangeRestaurantsByCommentsAscending(restaurantOrder.getBusinessPlaces());
                System.out.println("Done!");
                break;
            case 4:
                restaurantOrder.arrangeRestaurantsByCommentsDescending(restaurantOrder.getBusinessPlaces());
                System.out.println("Done!");
                break;
            default:
                break;
        }
    }
}