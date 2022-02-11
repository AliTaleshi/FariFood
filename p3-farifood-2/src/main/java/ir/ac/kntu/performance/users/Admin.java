package ir.ac.kntu.performance.users;

import ir.ac.kntu.performance.AllMenu;
import ir.ac.kntu.performance.Main;
import ir.ac.kntu.utility.ScannerWrapper;

public class Admin extends Person {

    public Admin(String userName, String passWord, String realName, String email) {
        super.setUserName(userName);
        super.setPassWord(passWord);
        super.setRealName(realName);
        super.setEmail(email);
    }

    public Admin(String userName, String passWord, String realName, String email, long phoneNumber, String address) {
        super(userName, passWord, realName, email, phoneNumber, address);
    }

    @Override
    public void enters(Person person, AllMenu allMenu) {
        if (person != null) {

            Main.mainMenu();
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
                case 5:
                    allMenu.getSettingsMenu().mainMenu();
                default:
                    break;
            }
        } else {
            System.out.println("Invalid username or password!\nPlease try again :)");
        }
    }
}
