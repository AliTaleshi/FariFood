package ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.Delivery;
import ir.ac.kntu.database.businessplace.DeliveryMenu;
import ir.ac.kntu.database.businessplace.restaurant.Restaurant;
import ir.ac.kntu.performance.FacilityMenu;
import ir.ac.kntu.utility.ScannerWrapper;
import ir.ac.kntu.utility.Week;

import java.util.ArrayList;

public class RestaurantDeliveryMenu extends DeliveryMenu {

    private FacilityMenu facilityMenu;

    private Database database;

    public RestaurantDeliveryMenu(FacilityMenu facilityMenu, Database database) {
        this.facilityMenu = facilityMenu;
        this.database = database;
    }

    public RestaurantDeliveryMenu() {}

    @Override
    public void mainMenu() {
        System.out.println("### RestaurantDelivery FoodMenu ###\n\n");
        System.out.println("Enter the name of the restaurantDelivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery restaurantDelivery = database.findDeliveryByName(deliveryName);

        if (restaurantDelivery != null) {
            System.out.println("1.Show restaurantDelivery's information");
            System.out.println("2.Build a new restaurantDelivery");
            System.out.println("3.Change restaurantDelivery's information");

            String n = ScannerWrapper.getInstance().nextLine();
            mainMenuPerformer(n + deliveryName);
        }

    }
    @Override
    public void mainMenuPerformer(String n) {
        Delivery restaurantDelivery = database.findDeliveryByName(n.substring(1));
        switch (Integer.parseInt(n.substring(0, 1))) {
            case 1:
                System.out.println(restaurantDelivery);
                break;
            case 2:
                registerDelivery();
                break;
            case 3:
                changeDeliveryInformation();
                break;
            default:
                break;
        }
    }

    @Override
    public void registerDelivery() {
        System.out.println("### Register a new restaurantDelivery ###\n\n");

        System.out.println("Enter the name of the restaurantDelivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();

        System.out.println("Enter the type of restaurantDelivery's vehicle:");
        String typeOfVehicle = ScannerWrapper.getInstance().nextLine();
        Vehicle vehicle = Vehicle.valueOf(typeOfVehicle);

        System.out.println("Enter the type of restaurantDelivery's salary:");
        String strTypeOfSalary = ScannerWrapper.getInstance().nextLine();
        TypeOfSalary typeOfSalary = TypeOfSalary.valueOf(strTypeOfSalary);

        System.out.println("Enter the restaurantDelivery's salary:");
        double salary = ScannerWrapper.getInstance().nextDouble();

        System.out.println("Enter the weekly attendance schedule:");
        ArrayList<Week> weeklyAttendanceSchedule = new ArrayList<>();
        while (true) {
            System.out.println("Enter the name of the say for building schedule:");
            System.out.println("If finished enter 0 to exit");

            String day = ScannerWrapper.getInstance().nextLine();

            if (day.equals("0")) {
                break;
            }
            weeklyAttendanceSchedule.add(Week.valueOf(day));
        }

        System.out.println("Is restaurantDelivery available? (true or false");
        String strIsAvailable = ScannerWrapper.getInstance().nextLine();
        boolean isAvailable =  Boolean.parseBoolean(strIsAvailable);

        ArrayList<BusinessPlace> restaurants = new ArrayList<>();
        System.out.println("Enter the name of the first restaurant that this restaurantDelivery works in:");
        String firstRestaurantName = ScannerWrapper.getInstance().nextLine();
        Restaurant restaurant1 = (Restaurant) database.findBusinessPlaceByName(firstRestaurantName);
        restaurants.add(restaurant1);

        System.out.println("Enter the name of the second restaurant that this restaurantDelivery works in:");
        String secondRestaurantName = ScannerWrapper.getInstance().nextLine();
        Restaurant restaurant2 = (Restaurant) database.findBusinessPlaceByName(secondRestaurantName);
        restaurants.add(restaurant2);

        RestaurantDelivery restaurantDelivery = new RestaurantDelivery(deliveryName, vehicle, typeOfSalary, salary, weeklyAttendanceSchedule, isAvailable, restaurants);
        database.addDelivery(restaurantDelivery);
        System.out.println("Registration Completed!");
    }

    @Override
    public void changeDeliveryInformation() {
        System.out.println("### Change RestaurantDelivery Information ###\n\n");
        System.out.println("Enter the name of the RestaurantDelivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery restaurantDelivery = database.findDeliveryByName(deliveryName);
        System.out.println("1.Change name");
        System.out.println("2.Change vehicle");
        System.out.println("3.Change typeOfSalary");
        System.out.println("4.Change salary");
        System.out.println("5.Change weeklyAttendanceSchedule");
        System.out.println("6.Change timeFoodOrdered");
        System.out.println("7.Change timeFoodDelivered");
        System.out.println("8.Change isAvailable");
        System.out.println("9.Change restaurants restaurantDelivery is working in");
        int n = ScannerWrapper.getInstance().nextInt();

        if (restaurantDelivery != null) {
            switch (n) {
                case 1:
                    System.out.println("Enter new name:");
                    String name = ScannerWrapper.getInstance().nextLine();
                    restaurantDelivery.setName(name);
                    System.out.println("Done!");
                    break;
                case 2:
                    System.out.println("Enter new vehicle:");
                    String strTypeOfVehicle = ScannerWrapper.getInstance().nextLine();
                    restaurantDelivery.setVehicle(Vehicle.valueOf(strTypeOfVehicle));
                    System.out.println("Done!");
                    break;
                case 3:
                    System.out.println("Enter new typeOfSalary:");
                    String strTypeOfSalary = ScannerWrapper.getInstance().nextLine();
                    restaurantDelivery.setTypeOfSalary(TypeOfSalary.valueOf(strTypeOfSalary));
                    System.out.println("Done!");
                    break;
                case 4:
                    System.out.println("Enter the new salary:");
                    double salary = ScannerWrapper.getInstance().nextDouble();
                    restaurantDelivery.setSalary(salary);
                    System.out.println("Done!");
                case 5:
                    System.out.println("Enter the new days of attendance schedule:\nIf finished enter 0");
                    ArrayList<Week> weeklyAttendanceSchedule = new ArrayList<>();
                    while (true) {
                        String day = ScannerWrapper.getInstance().nextLine();
                        if (day.equals("0")) {
                            break;
                        }
                        weeklyAttendanceSchedule.add(Week.valueOf(day));
                    }
                    restaurantDelivery.setWeeklyAttendanceSchedule(weeklyAttendanceSchedule);
                    System.out.println("Done!");
                case 6:
                    System.out.println("Enter the new timeFoodOrdered:");
                    String timeFoodOrdered = ScannerWrapper.getInstance().nextLine();
                    restaurantDelivery.setTimeItemOrdered(timeFoodOrdered);
                    System.out.println("Done");
                case 7:
                    System.out.println("Enter the new timeFoodDelivered:");
                    String timeFoodDelivered = ScannerWrapper.getInstance().nextLine();
                    restaurantDelivery.setTimeItemDelivered(timeFoodDelivered);
                    System.out.println("Done!");
                case 8:
                    System.out.println("Is restaurantDelivery available:");
                    String isAvailable = ScannerWrapper.getInstance().nextLine();
                    restaurantDelivery.setAvailable(Boolean.parseBoolean(isAvailable));
                    System.out.println("Done!");
                case 9:
                    System.out.println("Enter the name of the new restaurants:\nIf finished enter 0");
                    ArrayList<Restaurant> restaurants = new ArrayList<>();
                    while (true) {
                        String nameRestaurant = ScannerWrapper.getInstance().nextLine();
                        if (nameRestaurant.equals("0")) {
                            break;
                        }
                        restaurants.add((Restaurant) database.findBusinessPlaceByName(nameRestaurant));
                        System.out.println("Done!");
                    }
                default:
                    break;
            }
        }
    }
}
