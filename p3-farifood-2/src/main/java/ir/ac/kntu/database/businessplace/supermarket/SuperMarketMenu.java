package ir.ac.kntu.database.businessplace.supermarket;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.BusinessPlaceMenu;
import ir.ac.kntu.performance.FacilityMenu;
import ir.ac.kntu.utility.ScannerWrapper;

public class SuperMarketMenu extends BusinessPlaceMenu {

    public SuperMarketMenu(Database database, FacilityMenu facilityMenu) {
        super(database, facilityMenu);
    }


    @Override
    public void mainMenu() {
        System.out.println("### SuperMarket Menu ###\n\n");
        System.out.println("Enter the name of the SuperMarket:");
        String superMarketName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace restaurant = super.getDatabase().findBusinessPlaceByName(superMarketName);

        if (restaurant != null) {
            System.out.println("1.Show SuperMarket's information");
            System.out.println("2.Build a new SuperMarket");
            System.out.println("3.Change SuperMarket's information");

            String n = ScannerWrapper.getInstance().nextLine();
            mainMenuPerformer(n + superMarketName);
        }
    }

    @Override
    public void mainMenuPerformer(String n) {
        BusinessPlace superMarket = super.getDatabase().findBusinessPlaceByName(n.substring(1));
        switch (Integer.parseInt(n.substring(0, 1))) {
            case 1:
                System.out.println(superMarket);
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
