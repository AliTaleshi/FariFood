package ir.ac.kntu.performance.users;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.performance.AllMenu;
import ir.ac.kntu.utility.ScannerWrapper;

public class Manager extends Person{

    private Database database;

    public Manager(String userName, String passWord, String realName, String email, long phoneNumber, String address, Database database) {
        super(userName, passWord, realName, email, phoneNumber, address);
        this.database = database;
    }

    @Override
    public void enters(Person person, AllMenu allMenu) {
        if (person != null && validateIdentity(this.getUserName())) {

            mainMenu();
            int n = ScannerWrapper.getInstance().nextInt();
            switch (n) {
                case 1:
                    allMenu.getRestaurantOrderMenu().mainMenu();
                    break;
                case 2:
                    allMenu.getFacilityMenu().mainMenu();
                    break;
                case 3:
                    allMenu.getRestaurantDeliveryMenu().mainMenu();
                    break;
                case 4:
                    allMenu.getRestaurantMenu().mainMenu();
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Invalid username or password!\nPlease try again :)");
        }
    }

    public void mainMenu() {
        System.out.println("### Manager Menu ###\n\n");
        System.out.println("1.Restaurant Order Menu");
        System.out.println("2.Restaurant Facility Menu");
        System.out.println("3.Restaurant Delivery Menu");
        System.out.println("4.Restaurant Menu");
    }

    public boolean validateIdentity(String managerUserName) {
        for (int i = 0; i < database.getBusinessPlaces().size(); i++) {
            if (database.getBusinessPlaces().get(i).getManager().getUserName().equals(managerUserName)) {
                return true;
            }
        }

        System.out.println("Not found!");
        return false;
    }
}