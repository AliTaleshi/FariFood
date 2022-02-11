package ir.ac.kntu.database.businessplace.restaurant;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.BusinessPlaceMenu;
import ir.ac.kntu.performance.FacilityMenu;
import ir.ac.kntu.utility.ScannerWrapper;

import java.util.Objects;

public class RestaurantMenu extends BusinessPlaceMenu {

    public RestaurantMenu(Database database, FacilityMenu facilityMenu) {
        super(database, facilityMenu);
    }

    @Override
    public void mainMenu() {
        System.out.println("### Restaurant FoodMenu ###\n\n");
        System.out.println("Enter the name of the restaurant:");
        String restaurantName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace restaurant = super.getDatabase().findBusinessPlaceByName(restaurantName);

        if (restaurant != null) {
            System.out.println("1.Show restaurant's information");
            System.out.println("2.Build a new restaurant");
            System.out.println("3.Change restaurant's information");

            String n = ScannerWrapper.getInstance().nextLine();
            mainMenuPerformer(n + restaurantName);
        }
    }

    @Override
    public void mainMenuPerformer(String n) {
        BusinessPlace restaurant = (Restaurant) super.getDatabase().findBusinessPlaceByName(n.substring(1));
        switch (Integer.parseInt(n.substring(0, 1))) {
            case 1:
                System.out.println(restaurant);
                break;
            case 2:
                super.getFacilityMenu().registerRestaurant();
                break;
            case 3:
                super.getFacilityMenu().changeRestaurantInformation();
                break;
            default:
                break;
        }
    }
}
