package ir.ac.kntu.performance;

import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.Delivery;
import ir.ac.kntu.database.businessplace.Item;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDeliveryMenu;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrder;
import ir.ac.kntu.database.businessplace.restaurant.FoodMenu;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDelivery;
import ir.ac.kntu.performance.users.Customer;
import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrderSituation;
import ir.ac.kntu.database.businessplace.restaurant.Food;
import ir.ac.kntu.database.businessplace.restaurant.Restaurant;
import ir.ac.kntu.database.businessplace.restaurant.TypeOfPrice;
import ir.ac.kntu.utility.ScannerWrapper;
import ir.ac.kntu.utility.Time;

import java.util.ArrayList;
import java.util.Objects;

public class FacilityMenu {

    private Database database;

    public FacilityMenu(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }


    public void setDatabase(Database database) {
        this.database = database;
    }


    public void mainMenu() {
        System.out.println("### Facility Main FoodMenu ###\n\n");
        System.out.println("1.Restaurant's Settings");
        System.out.println("2.Customer's Settings");
        System.out.println("3.RestaurantOrder's Settings");
        System.out.println("4.RestaurantDelivery's Settings");
        System.out.println("5.See comments of a restaurant");
        System.out.println("6.See comments of a food in all restaurants");
        System.out.println("7.See three best restaurants");
        System.out.println("8.See three best foods in each restaurant");
        System.out.println("9.Sort restaurants by number of comments and see them");
        System.out.println("10.Sort foods by best restaurants");
        System.out.println("11.Find a restaurant by name");
        System.out.println("12.Find a restaurant by type of price");
        System.out.println("13.See a customer comments");
        System.out.println("14.See a customer restaurantOrders history");

        String n = ScannerWrapper.getInstance().nextLine();

        mainMenuPerformer(n);
    }

    public void mainMenuPerformer(String n) {
        switch (Integer.parseInt(n)) {
            case 1:
                restaurantSettings();
                break;
            case 2:
                customersSettings();
                break;
            case 3:
                orderSettings();
                break;
            case 4:
                deliverySettings();
                break;
            case 5:
                database.showBusinessPlaceCommentHistory();
                break;
            case 6:
                database.showItemCommentsHistoryForAllBusinessPlaces();
                break;
            case 7:
                database.showBestThreeBusinessPlaces();
                break;
            case 8:
                database.showBestThreeItemsInEachBusinessPlace();
                break;
            case 9:
                database.sortBusinessPlacesByComments();
                break;
            case 10:
                database.showBestFiveBusinessPlacesHaveAnItem();
                break;
            case 11:
                System.out.println("Enter the name of the restaurant:");
                String restaurantName = ScannerWrapper.getInstance().nextLine();
                Restaurant restaurant1 = (Restaurant) database.findBusinessPlaceByName(restaurantName);
                System.out.println("Found!\n" + restaurant1.toString());
                break;
            case 12:
                Restaurant restaurant2 = database.findRestaurantByTypeOfPrice();
                System.out.println("Found!\n" + restaurant2.toString());
                break;
            case 13:
                database.showCustomerComments();
                break;
            case 14:
                database.showCustomerOrdersHistory();
                break;
            default:
                break;
        }
    }

    public void restaurantSettings() {
        System.out.println("### Restaurant Settings FoodMenu ###\n\n");
        System.out.println("All restaurants names:");
        database.showAllBusinessPlaces();
        System.out.println("Enter the name of the restaurant:");
        ScannerWrapper.getInstance().nextLine(); //To delete the 'enter key' in the buffer
        String name = ScannerWrapper.getInstance().nextLine();
        Restaurant restaurant = (Restaurant) database.findBusinessPlaceByName(name);

        if (restaurant != null) {
            System.out.println("### Restaurant's Settings FoodMenu ###\n\n");
            System.out.println("1.Register a new restaurant");
            System.out.println("2.Change restaurant's information");
            System.out.println("3.See restaurant's information");

            int n = ScannerWrapper.getInstance().nextInt();

            switch (n) {
                case 1:
                    registerRestaurant();
                    System.out.println("Done!");
                    break;

                case 2:
                    changeRestaurantInformation();
                    System.out.println("Done!");
                    break;

                case 3:
                    System.out.println(restaurant);
                    break;

                default:
                    break;
            }
        }
    }

    public int restaurantPointsAndCommentsMenu() {
        System.out.println("### Points & Comments FoodMenu ###\n\n");
        System.out.println("1.Give Points");
        System.out.println("2.Write Comments");

        return ScannerWrapper.getInstance().nextInt();
    }

    public void restaurantPointsAndComments() {
        for (int i = 0; i < database.getOrders().size(); i++) {
            if (database.getOrders().get(i).getOrderSituation().equals(RestaurantOrderSituation.DELIVERED)) {
                if (restaurantPointsAndCommentsMenu() == 1) {
                    System.out.println("Enter the Point of the restaurant:");
                    double point = ScannerWrapper.getInstance().nextDouble();
                    database.getRestaurants().get(i).setPoint(point);
                } else if (restaurantPointsAndCommentsMenu() == 2){
                    System.out.println("Write your Comment about the restaurant:");
                    String comment = ScannerWrapper.getInstance().nextLine();
                    database.getRestaurants().get(i).add(database.getCustomers().get(i), comment);
                }
            }
        }
    }

    public void changeRestaurantInformation() {
        System.out.println("### Change Restaurant Information ###\n\n");
        System.out.println("Enter the name of the restaurant:");
        String restaurantName = ScannerWrapper.getInstance().nextLine();
        Restaurant restaurant = (Restaurant) database.findBusinessPlaceByName(restaurantName);
        System.out.println("1.Change name");
        System.out.println("2.Change address");
        System.out.println("3.Change menu");
        System.out.println("4.Change workingHours");
        System.out.println("5.Change point");
        System.out.println("6.Change typeOfPrice");
        int n = ScannerWrapper.getInstance().nextInt();
        if (restaurant != null) {
            switch (n) {
                case 1:
                    System.out.println("Enter new name:");
                    String name = ScannerWrapper.getInstance().nextLine();
                    restaurant.setName(name);
                    System.out.println("Done!");
                    break;
                case 2:
                    System.out.println("Enter new address:");
                    String address = ScannerWrapper.getInstance().nextLine();
                    restaurant.setAddress(address);
                    System.out.println("Done!");
                    break;
                case 3:
                    changeRestaurantMenu(restaurant);
                    break;
                case 4:
                    System.out.println("Enter the new workingHours:");
                    String workingHours = ScannerWrapper.getInstance().nextLine();
                    restaurant.setWorkingHours(workingHours);
                    System.out.println("Done!");
                    break;
                case 5:
                    System.out.println("Enter the new point:");
                    double point = ScannerWrapper.getInstance().nextDouble();
                    restaurant.setPoint(point);
                    System.out.println("Done!");
                    break;
                case 6:
                    System.out.println("Enter the new typeOfPrice:");
                    String typeOfPrice = ScannerWrapper.getInstance().nextLine();
                    restaurant.setTypeOfPrice(TypeOfPrice.valueOf(typeOfPrice));
                    System.out.println("Done");
                    break;
                default:
                    break;
            }
        }
    }

    public void registerRestaurant() {
        System.out.println("### Register a new restaurant ###\n\n");

        System.out.println("Enter the name of restaurant:");
        String name = ScannerWrapper.getInstance().nextLine();

        System.out.println("Enter the address of restaurant:");
        String address = ScannerWrapper.getInstance().nextLine();

        System.out.println("Build a new foodMenu:\n");
        FoodMenu foodMenu = buildNewMenu();

        System.out.println("Enter the working hours:");
        String workingHours = ScannerWrapper.getInstance().nextLine(); // From hh:mm:ss to hh:mm:ss

        System.out.println("Enter the point of the restaurant:");
        double point = ScannerWrapper.getInstance().nextDouble();

        System.out.println("Enter the type of price:");
        String strTypeOfPrice = ScannerWrapper.getInstance().nextLine();
        strTypeOfPrice = strTypeOfPrice.toUpperCase();
        TypeOfPrice typeOfPrice = getTypeOfPriceFromString(strTypeOfPrice); // should test this line later

        Restaurant restaurant = new Restaurant(name, address, foodMenu, workingHours, point, typeOfPrice);

        database.getRestaurants().add(restaurant); // Add restaurant to database

        System.out.println("Registration Completed!");
    }

    public TypeOfPrice getTypeOfPriceFromString(String strTypeOfPrice) {
        return TypeOfPrice.valueOf(strTypeOfPrice);
    }

    public FoodMenu buildNewMenu() {
        FoodMenu foodMenu = new FoodMenu();
        System.out.println("### Build a new foodMenu ###\n\n");
        System.out.println("Build a new food:");
        Food food1 = buildNewFood();
        foodMenu.addItem(food1);
        System.out.println("Build a new food:");
        Food food2 = buildNewFood();
        foodMenu.addItem(food2);

        return foodMenu;
    }

    public void changeRestaurantMenu(Restaurant restaurant) {
        System.out.println("Enter new menu:");
        System.out.println("1.Add food");
        System.out.println("2.Remove food");

        int n = ScannerWrapper.getInstance().nextInt();

        if (n == 1) {
            System.out.println("### Add Food ###\n\n");
            restaurant.getMenu().addItem(buildNewFood());
            System.out.println("Done!");
        } else if (n == 2) {
            System.out.println("### Remove Food ###\n\n");
            System.out.println("Enter the name of the food:");
            String foodName = ScannerWrapper.getInstance().nextLine();
            Food food = (Food) restaurant.getMenu().findItemByName(foodName);

            if (food != null) {
                restaurant.getMenu().removeItem(food);
                System.out.println("Done!");
            }
        }
    }

    public Food buildNewFood() {
        System.out.println("### Build a new food ###\n\n");

        System.out.println("Enter the name of the food:");
        String name = ScannerWrapper.getInstance().nextLine();

        System.out.println("Enter the price of the food:");
        double price = ScannerWrapper.getInstance().nextDouble();

        System.out.println("Enter the point of the food:");
        double point = ScannerWrapper.getInstance().nextDouble();

        System.out.println("Enter the cookTime:"); // hh:mm:ss
        String time = ScannerWrapper.getInstance().nextLine();
        Time cookTime = new Time();
        cookTime = cookTime.changeIntoTime(time);

        return new Food(name, price, point, cookTime);
    }

    public void customersSettings() {
        System.out.println("Enter the name of the customer:");
        String name = ScannerWrapper.getInstance().nextLine();
        Customer customer = database.findCustomerByName(name);

        System.out.println("### Customer's Settings FoodMenu ###\n\n");
        System.out.println("1.Register a new customer");
        System.out.println("2.Change customer's information");
        System.out.println("3.See customer's information");

        int n = ScannerWrapper.getInstance().nextInt();

        switch (n) {
            case 1:
                registerCustomer();
                System.out.println("Done!");
                break;

            case 2:
                changeCustomerInformation();
                System.out.println("Done!");
                break;

            case 3:
                System.out.println(customer);
                break;

            default:
                break;
        }
    }

    public void registerCustomer() {
        System.out.println("Enter customer's name:");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter customer's phone number:");
        long phoneNumber =  ScannerWrapper.getInstance().nextInt();
        System.out.println("Enter customer's address:");
        String address = ScannerWrapper.getInstance().nextLine();

        Customer customer = new Customer(name, phoneNumber, address);

        database.addCustomer(customer);

        System.out.println("Registration Completed!");
    }

    public void changeCustomerInformation() {
        System.out.println("Enter the name of the customer:");
        String name = ScannerWrapper.getInstance().nextLine();
        Customer customer = database.findCustomerByName(name);
        System.out.println("1.Change phoneNumber");
        System.out.println("2.Change address");
        System.out.println("3.Change name");
        int n = ScannerWrapper.getInstance().nextInt();

        switch (n) {
            case 1:
                System.out.println("Enter new phoneNumber:");
                long phoneNumber = ScannerWrapper.getInstance().nextInt();
                customer.setPhoneNumber(phoneNumber);
                break;
            case 2:
                System.out.println("Enter new address:");
                String address = ScannerWrapper.getInstance().nextLine();
                customer.setAddress(address);
                break;
            case 3:
                System.out.println("Enter new phoneNumber:");
                phoneNumber = ScannerWrapper.getInstance().nextInt();
                System.out.println("Enter new address:");
                address = ScannerWrapper.getInstance().nextLine();
                customer.setPhoneNumber(phoneNumber);
                customer.setAddress(address);
                break;
            default:
                break;
        }
    }

    public void orderSettings() {
        System.out.println("### RestaurantOrder Settings FoodMenu ###\n\n");
        System.out.println("Enter the id of the restaurantOrder:");
        ScannerWrapper.getInstance().nextLine();
        String orderId = ScannerWrapper.getInstance().nextLine();
        RestaurantOrder restaurantOrder = (RestaurantOrder) database.findOrderById(orderId);

        if (restaurantOrder != null) {
            System.out.println("1.Build a new restaurantOrder");
            System.out.println("2.Change restaurantOrder's information");
            System.out.println("3.See restaurantOrder's information");
            int n = ScannerWrapper.getInstance().nextInt();

            switch (n) {
                case 1:
                    buildNewOrder();
                    break;
                case 2:
                    changeOrderInformation();
                    break;
                case 3:
                    System.out.println(restaurantOrder);
                default:
                    break;
            }
        }

    }

    public void buildNewOrder() {
        System.out.println("Enter restaurantOrder's id:");
        String id = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter restaurants names:\nIf finished enter 0");
        ArrayList<BusinessPlace> restaurants = new ArrayList<>();
        while (true) {
            String restaurantName = ScannerWrapper.getInstance().nextLine();
            if (restaurantName.equals("0")) {
                break;
            }
            restaurants.add(database.findBusinessPlaceByName(restaurantName));
        }

        System.out.println("Enter restaurant delivery's names:\nIf finished enter 0");
        ArrayList<Delivery> deliveries = new ArrayList<>();
        while (true) {
            String deliveryName = ScannerWrapper.getInstance().nextLine();
            if (deliveryName.equals("0")) {
                break;
            }
            deliveries.add(database.findDeliveryByName(deliveryName));
        }

        System.out.println("Enter the name of the foods:\nIf finished enter 0");
        ArrayList<Item> foods = new ArrayList<>();
        while (true) {
            String foodName = ScannerWrapper.getInstance().nextLine();
            if (foodName.equals("0")) {
                break;
            }
            foods.add(database.findItemByName(foodName));
        }

        RestaurantOrder restaurantOrder = new RestaurantOrder(id, restaurants, deliveries, foods,  RestaurantOrderSituation.PROCESSING);

        database.addOrder(restaurantOrder);

        System.out.println("Registration Completed!");
    }

    public void changeOrderInformation() {
        System.out.println("Enter the id of the restaurantOrder:");
        String id = ScannerWrapper.getInstance().nextLine();
        RestaurantOrder restaurantOrder = (RestaurantOrder) database.findOrderById(id);
        System.out.println("1.Change id");
        System.out.println("2.Change restaurants");
        System.out.println("3.Change deliveries");
        System.out.println("4.Change foods");
        System.out.println("5.Change restaurantOrder situation");
        int n = ScannerWrapper.getInstance().nextInt();

        switch (n) {
            case 1:
                System.out.println("Enter new id:");
                String newId = ScannerWrapper.getInstance().nextLine();
                restaurantOrder.setId(newId);
                System.out.println("Done!");
                break;
            case 2:
                System.out.println("Enter the name of the new restaurants:\nIf finished enter 0");
                ArrayList<BusinessPlace> restaurants = new ArrayList<>();
                while (true) {
                    String restaurantName = ScannerWrapper.getInstance().nextLine();
                    if (restaurantName.equals("0")) {
                        break;
                    }
                    restaurants.add(database.findBusinessPlaceByName(restaurantName));
                }
                restaurantOrder.setBusinessPlaces(restaurants);
                System.out.println("Done!");
                break;
            case 3:
                System.out.println("Enter the name of the new deliveries:\nIf finished enter 0");
                ArrayList<Delivery> deliveries = new ArrayList<>();
                while (true) {
                    String deliveryName = ScannerWrapper.getInstance().nextLine();
                    if (deliveryName.equals("0")) {
                        break;
                    }
                    deliveries.add(database.findDeliveryByName(deliveryName));
                }
                restaurantOrder.setDeliveries(deliveries);
                System.out.println("Done!");
                break;
            case 4:
                System.out.println("Enter the name of the new foods:\nIf finished enter 0");
                ArrayList<Item> foods = new ArrayList<>();
                while (true) {
                    String foodName = ScannerWrapper.getInstance().nextLine();
                    if (foodName.equals("0")) {
                        break;
                    }
                    foods.add(database.findItemByName(foodName));
                }
                restaurantOrder.setItems(foods);
                System.out.println("Done!");
                break;
            case 5:
                System.out.println("Enter the restaurantOrder situation:");
                String orderSituation = ScannerWrapper.getInstance().nextLine();
                restaurantOrder.setOrderSituation(RestaurantOrderSituation.valueOf(orderSituation.toUpperCase()));
                System.out.println("Done!");
                break;
            default:
                break;
        }
    }

    public void deliverySettings() { // I did the logical calculations in the database class to prevent 500-line-classes error
        System.out.println("### RestaurantDelivery Settings FoodMenu ###\n\n");
        System.out.println("Enter the name of the restaurantDelivery:");
        ScannerWrapper.getInstance().nextLine();
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        RestaurantDelivery restaurantDelivery = (RestaurantDelivery) database.findDeliveryByName(deliveryName);

        if (restaurantDelivery != null) {
            System.out.println("1.Register a new restaurantDelivery");
            System.out.println("2.Change restaurantDelivery's information");
            System.out.println("3.See restaurantDelivery's information");

            RestaurantDeliveryMenu restaurantDeliveryMenu = new RestaurantDeliveryMenu();
            int n = ScannerWrapper.getInstance().nextInt();

            switch (n) {
                case 1:
                    restaurantDeliveryMenu.registerDelivery(); // This logical method
                    System.out.println("Done!");
                    break;
                case 2:
                    restaurantDeliveryMenu.changeDeliveryInformation(); // And this one
                    System.out.println("Done!");
                    break;
                case 3:
                    System.out.println(restaurantDelivery);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FacilityMenu)) {
            return false;
        }
        FacilityMenu that = (FacilityMenu) o;
        return Objects.equals(getDatabase(), that.getDatabase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDatabase());
    }

    @Override
    public String toString() {
        return "FacilityMenu{" +
                "database=" + database +
                '}';
    }
}