package ir.ac.kntu.database.businessplace;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.restaurant.Restaurant;
import ir.ac.kntu.performance.FacilityMenu;
import ir.ac.kntu.utility.ScannerWrapper;

public class BusinessPlaceMenu {

    private Database database;

    private FacilityMenu facilityMenu;

    public BusinessPlaceMenu(Database database, FacilityMenu facilityMenu) {
        this.database = database;
        this.facilityMenu = facilityMenu;
    }


    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public FacilityMenu getFacilityMenu() {
        return facilityMenu;
    }


    public void mainMenu() {
        System.out.println("### BusinessPlace Menu ###\n\n");
        System.out.println("Enter the name of the BusinessPlace:");
        String businessPlaceName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace businessPlace = database.findBusinessPlaceByName(businessPlaceName);

        if (businessPlace != null) {
            System.out.println("1.Show BusinessPlace's information");
            System.out.println("2.Build a new BusinessPlace");
            System.out.println("3.Change BusinessPlace's information");

            String n = ScannerWrapper.getInstance().nextLine();
            mainMenuPerformer(n + businessPlaceName);
        }
    }

    public void mainMenuPerformer(String n) {
        BusinessPlace businessPlace = database.findBusinessPlaceByName(n.substring(1));
        switch (Integer.parseInt(n.substring(0, 1))) {
            case 1:
                System.out.println(businessPlace);
                break;
            case 2:
                facilityMenu.registerRestaurant();
                break;
            case 3:
                facilityMenu.changeRestaurantInformation();
                break;
            default:
                break;
        }
    }
}
