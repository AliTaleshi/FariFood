package ir.ac.kntu.database.businessplace.fruitshop;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.BusinessPlaceMenu;
import ir.ac.kntu.performance.FacilityMenu;
import ir.ac.kntu.utility.ScannerWrapper;

public class FruitShopMenu extends BusinessPlaceMenu {

    public FruitShopMenu(Database database, FacilityMenu facilityMenu) {
        super(database, facilityMenu);
    }


    @Override
    public void mainMenu() {
        System.out.println("### FruitShop Menu ###\n\n");
        System.out.println("Enter the name of the FruitShop:");
        String fruitShopName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace restaurant = super.getDatabase().findBusinessPlaceByName(fruitShopName);

        if (restaurant != null) {
            System.out.println("1.Show FruitShop's information");
            System.out.println("2.Build a new FruitShop");
            System.out.println("3.Change FruitShop's information");

            String n = ScannerWrapper.getInstance().nextLine();
            mainMenuPerformer(n + fruitShopName);
        }
    }

    @Override
    public void mainMenuPerformer(String n) {
        BusinessPlace fruitShop = super.getDatabase().findBusinessPlaceByName(n.substring(1));
        switch (Integer.parseInt(n.substring(0, 1))) {
            case 1:
                System.out.println(fruitShop);
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
