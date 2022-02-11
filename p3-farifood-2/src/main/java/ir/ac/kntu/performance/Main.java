package ir.ac.kntu.performance;

import java.util.ArrayList;

import ir.ac.kntu.database.*;
import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.Status;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDelivery;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDeliveryMenu;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.TypeOfSalary;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.Vehicle;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrderMenu;
import ir.ac.kntu.database.businessplace.restaurant.*;
import ir.ac.kntu.performance.users.Admin;
import ir.ac.kntu.performance.users.Customer;
import ir.ac.kntu.performance.users.Manager;
import ir.ac.kntu.performance.users.Person;
import ir.ac.kntu.utility.ScannerWrapper;
import ir.ac.kntu.utility.Time;
import ir.ac.kntu.utility.Week;

/**
 * @author Ali Taleshi
 */

public class Main {

    public static void main(String[] args) {

        Database database = new Database();

        FoodMenu foodMenu1 = new FoodMenu();
        FoodMenu foodMenu2 = new FoodMenu();
        FoodMenu foodMenu3 = new FoodMenu();
        FoodMenu foodMenu4 = new FoodMenu();
        FoodMenu foodMenu5 = new FoodMenu();
        FoodMenu foodMenu6 = new FoodMenu();
        Time time1 = new Time(1, 2, 4);
        Food food1 = new Food("Kebab", 12.58, 6, time1);
        Time time2 = new Time(2, 4, 5);
        Food food2 = new Food("Steak", 13.43, 8, time2);
        Time time3 = new Time(4, 2, 0);
        Food food3 = new Food("Pizza", 11.40, 9, time3);
        Time time4 = new Time(1, 3, 23);
        Food food4 = new Food("Rice", 11.00, 5, time4);
        Time time5 = new Time(2, 34, 30);
        Food food5 = new Food("Spaghetti", 9.34, 10, time5);
        Time time6 = new Time(2, 54, 23);
        Food food6 = new Food("Bacon", 8.93, 12, time6);
        Time time7 = new Time(1, 4, 34);
        Food food7 = new Food("Sushi", 8.45, 13, time7);
        foodMenu1.addItem(food1);
        foodMenu1.addItem(food2);
        foodMenu1.addItem(food3);
        foodMenu1.addItem(food4);
        foodMenu2.addItem(food2);
        foodMenu2.addItem(food4);
        foodMenu2.addItem(food6);
        foodMenu2.addItem(food7);
        foodMenu3.addItem(food1);
        foodMenu3.addItem(food3);
        foodMenu3.addItem(food5);
        foodMenu3.addItem(food7);
        foodMenu4.addItem(food7);
        foodMenu4.addItem(food4);
        foodMenu4.addItem(food3);
        foodMenu4.addItem(food1);
        foodMenu5.addItem(food6);
        foodMenu5.addItem(food5);
        foodMenu5.addItem(food3);
        foodMenu5.addItem(food2);
        foodMenu6.addItem(food6);
        foodMenu6.addItem(food5);
        foodMenu6.addItem(food7);
        foodMenu6.addItem(food2);

        Admin admin1 = new Admin("Ali", "ali0000", "Ali Taleshi", "alitys0833@gmail.com");
        database.addAdmin(admin1);
        database.addPerson(admin1);

        Customer customer1 = new Customer("Nima", "nima0000", "Nima Rezaee", "nima@gmail.com", 3432434, "Iran , Tehran");
        database.addCustomer(customer1);
        database.addPerson(customer1);

        Manager manager1 = new Manager("Sina", "sina0000", "Sina Kazemi", "sina@gmail.com", 656564, "Iran, Mashhad", database);
        database.addManager(manager1);
        database.addPerson(manager1);

        Manager manager2 = new Manager("Hasan", "hasan0000", "Hasan Kazemi", "sina@gmail.com", 656564, "Iran, Mashhad", database);
        database.addManager(manager2);
        database.addPerson(manager2);

        Manager manager3 = new Manager("Hossein", "hosein0000", "Hosein Kazemi", "sina@gmail.com", 656564, "Iran, Mashhad", database);
        database.addManager(manager3);
        database.addPerson(manager3);

        Manager manager4 = new Manager("Masoud", "masoud0000", "Masoud Kazemi", "sina@gmail.com", 656564, "Iran, Mashhad", database);
        database.addManager(manager4);
        database.addPerson(manager4);

        Manager manager5 = new Manager("Leila", "leila0000", "Leila Kazemi", "sina@gmail.com", 656564, "Iran, Mashhad", database);
        database.addManager(manager5);
        database.addPerson(manager5);

        Manager manager6 = new Manager("Neda", "neda0000", "Neda Kazemi", "sina@gmail.com", 656564, "Iran, Mashhad", database);
        database.addManager(manager6);
        database.addPerson(manager6);

        Restaurant restaurant1 = new Restaurant("Royal", "Iran, Tehran", foodMenu1, "from 12:00:00 to 22:00:00", 5, TypeOfPrice.ECONOMICAL, Status.ACTIVE, manager1);
        database.addBusinessPlace(restaurant1);
        Restaurant restaurant2 = new Restaurant("Maldives", "Spain, Madrid", foodMenu2, "from 10:00:00 to 23:00:00", 5, TypeOfPrice.LUXURY, Status.INACTIVE, manager2);
        database.addBusinessPlace(restaurant2);
        Restaurant restaurant3 = new Restaurant("MacDonald", "USA, New york", foodMenu3, "from 9:00:00 to 20:00:00", 5, TypeOfPrice.MEDIUM, Status.ACTIVE, manager3);
        database.addBusinessPlace(restaurant3);
        Restaurant restaurant4 = new Restaurant("Eternity", "France, Paris", foodMenu4, "from 12:00:00 to 21:00:00", 5, TypeOfPrice.ECONOMICAL, Status.INACTIVE, manager4);
        database.addBusinessPlace(restaurant4);
        Restaurant restaurant5 = new Restaurant("Norma", "Germany, Berlin", foodMenu5, "from 8:00:00 to 19:00:00", 5, TypeOfPrice.MEDIUM, Status.ACTIVE, manager5);
        database.addBusinessPlace(restaurant5);
        Restaurant restaurant6 = new Restaurant("Signs", "USA, Chicago", foodMenu6, "from 13:00:00 to 23:00:00", 5, TypeOfPrice.LUXURY, Status.INACTIVE, manager6);
        database.addBusinessPlace(restaurant6);

        Person person = new Person();

        ArrayList<Week> daysAvailable = new ArrayList<>();
        daysAvailable.add(Week.SATURDAY);
        daysAvailable.add(Week.MONDAY);
        daysAvailable.add(Week.THURSDAY);
        ArrayList<BusinessPlace> restaurants = new ArrayList<>();
        RestaurantDelivery restaurantDelivery = new RestaurantDelivery("Ahmad", Vehicle.MOTORBIKE, TypeOfSalary.PERHOUR, 1000, daysAvailable, true, restaurants);
        database.addDelivery(restaurantDelivery);

        RestaurantOrderMenu restaurantOrderMenu = new RestaurantOrderMenu(database);
        FacilityMenu facilityMenu = new FacilityMenu(database);
        RestaurantMenu restaurantMenu = new RestaurantMenu(database, facilityMenu);
        RestaurantDeliveryMenu restaurantDeliveryMenu = new RestaurantDeliveryMenu(facilityMenu, database);
        SettingsMenu settingsMenu = new SettingsMenu(database);

        System.out.println("Enter your role:"); // Find out the role of the user
        System.out.println("1.Admin");
        System.out.println("2.Customer");
        System.out.println("3.Manager");
        int n = ScannerWrapper.getInstance().nextInt();

        AllMenu allMenu = new AllMenu();
        allMenu.setFacilityMenu(facilityMenu);
        allMenu.setRestaurantMenu(restaurantMenu);
        allMenu.setRestaurantOrderMenu(restaurantOrderMenu);
        allMenu.setRestaurantDeliveryMenu(restaurantDeliveryMenu);
        allMenu.setSettingsMenu(settingsMenu);

        switch (n) {
            case 1:
                Admin admin = (Admin) person.logIn(database);
                admin.enters(admin, allMenu);
                break;
            case 2:
                Customer customer = (Customer) person.logIn(database);
                customer.enters(customer, allMenu);
                break;
            case 3:
                Manager manager = (Manager) person.logIn(database);
                manager.enters(manager, allMenu);
                break;
            default:
                break;
        }
    }

    public static void mainMenu() {
        System.out.println("### Welcome to the FariFood managing system. ###\n\n");
        System.out.println("You can choose a menu from the list below:\n");
        System.out.println("1.RestaurantOrder menu");
        System.out.println("2.Facility menu");
        System.out.println("3.RestaurantDelivery menu");
        System.out.println("4.Restaurant menu");
        System.out.println("5.Settings menu");
        System.out.println("6.SuperMarketOrder menu");
        System.out.println("7.SuperMarketDelivery menu");
        System.out.println("8.FruitShopOrder menu");
        System.out.println("9.FruitShopDelivery menu");
        System.out.println("0.Exit");
    }
}
