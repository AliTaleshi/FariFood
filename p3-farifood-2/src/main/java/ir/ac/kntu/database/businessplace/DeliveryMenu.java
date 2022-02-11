package ir.ac.kntu.database.businessplace;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDelivery;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.TypeOfSalary;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.Vehicle;
import ir.ac.kntu.performance.FacilityMenu;
import ir.ac.kntu.utility.ScannerWrapper;
import ir.ac.kntu.utility.Week;

import java.util.ArrayList;

public class DeliveryMenu {

    private FacilityMenu facilityMenu;

    private Database database;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public void mainMenu() {
        System.out.println("### Delivery Menu ###\n\n");
        System.out.println("Enter the name of the Delivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery restaurantDelivery = database.findDeliveryByName(deliveryName);

        if (restaurantDelivery != null) {
            System.out.println("1.Show Delivery's information");
            System.out.println("2.Build a new Delivery");
            System.out.println("3.Change Delivery's information");

            String n = ScannerWrapper.getInstance().nextLine();
            mainMenuPerformer(n + deliveryName);
        }

    }

    public void mainMenuPerformer(String n) {
        Delivery delivery = database.findDeliveryByName(n.substring(1));

        switch (Integer.parseInt(n.substring(0, 1))) {
            case 1:
                System.out.println(delivery);
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


    public void registerDelivery() {
        System.out.println("### Register a new Delivery ###\n\n");

        System.out.println("Enter the name of the Delivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();

        System.out.println("Enter the type of Delivery's vehicle:");
        String typeOfVehicle = ScannerWrapper.getInstance().nextLine();
        Vehicle vehicle = Vehicle.valueOf(typeOfVehicle);

        System.out.println("Enter the type of Delivery's salary:");
        String strTypeOfSalary = ScannerWrapper.getInstance().nextLine();
        TypeOfSalary typeOfSalary = TypeOfSalary.valueOf(strTypeOfSalary);

        System.out.println("Enter the Delivery's salary:");
        double salary = ScannerWrapper.getInstance().nextDouble();

        System.out.println("Enter the weekly attendance schedule:");
        ArrayList<Week> weeklyAttendanceSchedule = new ArrayList<>();
        while (true) {
            System.out.println("Enter the name of the day for building schedule:");
            System.out.println("If finished enter 0");

            String day = ScannerWrapper.getInstance().nextLine();

            if (day.equals("0")) {
                break;
            }
            weeklyAttendanceSchedule.add(Week.valueOf(day));
        }

        System.out.println("Is Delivery available? (true or false)");
        String strIsAvailable = ScannerWrapper.getInstance().nextLine();
        boolean isAvailable =  Boolean.parseBoolean(strIsAvailable);

        ArrayList<BusinessPlace> businessPlaces = new ArrayList<>();
        System.out.println("Enter the name of the first business place that this Delivery works in:");
        String firstBusinessPlaceName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace businessPlace1 = database.findBusinessPlaceByName(firstBusinessPlaceName);
        businessPlaces.add(businessPlace1);

        System.out.println("Enter the name of the second business place that this Delivery works in:");
        String secondBusinessPlaceName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace businessPlace2 = database.findBusinessPlaceByName(secondBusinessPlaceName);
        businessPlaces.add(businessPlace2);

        RestaurantDelivery restaurantDelivery = new RestaurantDelivery(deliveryName, vehicle, typeOfSalary, salary, weeklyAttendanceSchedule, isAvailable, businessPlaces);
        database.addDelivery(restaurantDelivery);
        System.out.println("Registration Completed!");
    }

    public void changeDeliveryInformation() {
        System.out.println("### Change Delivery Information ###\n\n");
        System.out.println("Enter the name of the Delivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery delivery = database.findDeliveryByName(deliveryName);
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

        if (delivery != null) {
            switch (n) {
                case 1:
                    System.out.println("Enter new name:");
                    String name = ScannerWrapper.getInstance().nextLine();
                    delivery.setName(name);
                    System.out.println("Done!");
                    break;
                case 2:
                    System.out.println("Enter new vehicle:");
                    String strTypeOfVehicle = ScannerWrapper.getInstance().nextLine();
                    delivery.setVehicle(Vehicle.valueOf(strTypeOfVehicle));
                    System.out.println("Done!");
                    break;
                case 3:
                    System.out.println("Enter new typeOfSalary:");
                    String strTypeOfSalary = ScannerWrapper.getInstance().nextLine();
                    delivery.setTypeOfSalary(TypeOfSalary.valueOf(strTypeOfSalary));
                    System.out.println("Done!");
                    break;
                case 4:
                    System.out.println("Enter the new salary:");
                    double salary = ScannerWrapper.getInstance().nextDouble();
                    delivery.setSalary(salary);
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
                    delivery.setWeeklyAttendanceSchedule(weeklyAttendanceSchedule);
                    System.out.println("Done!");
                case 6:
                    System.out.println("Enter the new timeItemOrdered:");
                    String timeItemOrdered = ScannerWrapper.getInstance().nextLine();
                    delivery.setTimeItemOrdered(timeItemOrdered);
                    System.out.println("Done");
                case 7:
                    System.out.println("Enter the new timeItemDelivered:");
                    String timeItemDelivered = ScannerWrapper.getInstance().nextLine();
                    delivery.setTimeItemDelivered(timeItemDelivered);
                    System.out.println("Done!");
                case 8:
                    System.out.println("Is Delivery available:");
                    String isAvailable = ScannerWrapper.getInstance().nextLine();
                    delivery.setAvailable(Boolean.parseBoolean(isAvailable));
                    System.out.println("Done!");
                case 9:
                    System.out.println("Enter the name of the new business places:\nIf finished enter 0");
                    ArrayList<BusinessPlace> businessPlaces = new ArrayList<>();
                    while (true) {
                        String businessPlaceName = ScannerWrapper.getInstance().nextLine();
                        if (businessPlaceName.equals("0")) {
                            break;
                        }
                        businessPlaces.add(database.findBusinessPlaceByName(businessPlaceName));
                        System.out.println("Done!");
                    }
                default:
                    break;
            }
        }
    }
}
