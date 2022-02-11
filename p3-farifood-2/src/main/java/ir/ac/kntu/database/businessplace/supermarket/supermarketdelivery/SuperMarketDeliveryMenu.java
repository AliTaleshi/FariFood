package ir.ac.kntu.database.businessplace.supermarket.supermarketdelivery;

import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.Delivery;
import ir.ac.kntu.database.businessplace.DeliveryMenu;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDelivery;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.TypeOfSalary;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.Vehicle;
import ir.ac.kntu.utility.ScannerWrapper;
import ir.ac.kntu.utility.Week;

import java.util.ArrayList;

public class SuperMarketDeliveryMenu extends DeliveryMenu {

    @Override
    public void mainMenu() {
        System.out.println("### SuperMarket Delivery Menu ###\n\n");
        System.out.println("Enter the name of the SuperMarketDelivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery superMarketDelivery = super.getDatabase().findDeliveryByName(deliveryName);

        if (superMarketDelivery != null) {
            System.out.println("1.Show SuperMarketDelivery's information");
            System.out.println("2.Build a new SuperMarketDelivery");
            System.out.println("3.Change SuperMarketDelivery's information");

            String n = ScannerWrapper.getInstance().nextLine();
            mainMenuPerformer(n + deliveryName);
        }

    }

    @Override
    public void mainMenuPerformer(String n) {
        SuperMarketDelivery superMarketDelivery = (SuperMarketDelivery) super.getDatabase().findDeliveryByName(n.substring(1));

        switch (Integer.parseInt(n.substring(0, 1))) {

            case 1:
                System.out.println(superMarketDelivery);
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
        System.out.println("### Register a new SuperMarketDelivery ###\n\n");

        System.out.println("Enter the name of the SuperMarketDelivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();

        System.out.println("Enter the type of SuperMarketDelivery's vehicle:");
        String typeOfVehicle = ScannerWrapper.getInstance().nextLine();
        Vehicle vehicle = Vehicle.valueOf(typeOfVehicle);

        System.out.println("Enter the type of SuperMarketDelivery's salary:");
        String strTypeOfSalary = ScannerWrapper.getInstance().nextLine();
        TypeOfSalary typeOfSalary = TypeOfSalary.valueOf(strTypeOfSalary);

        System.out.println("Enter the SuperMarketDelivery's salary:");
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

        System.out.println("Is SuperMarketDelivery available? (true or false)");
        String strIsAvailable = ScannerWrapper.getInstance().nextLine();
        boolean isAvailable =  Boolean.parseBoolean(strIsAvailable);

        ArrayList<BusinessPlace> superMarkets = new ArrayList<>();
        System.out.println("Enter the name of the first SuperMarket that this SuperMarketDelivery works in:");
        String firstSuperMarketName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace superMarket1 = super.getDatabase().findBusinessPlaceByName(firstSuperMarketName);
        superMarkets.add(superMarket1);

        System.out.println("Enter the name of the second SuperMarket that this SuperMarketDelivery works in:");
        String secondSuperMarketName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace superMarket2 = super.getDatabase().findBusinessPlaceByName(secondSuperMarketName);
        superMarkets.add(superMarket2);

        RestaurantDelivery restaurantDelivery = new RestaurantDelivery(deliveryName, vehicle, typeOfSalary, salary, weeklyAttendanceSchedule, isAvailable, superMarkets);
        super.getDatabase().addDelivery(restaurantDelivery);
        System.out.println("Registration Completed!");
    }

    @Override
    public void changeDeliveryInformation() {
        System.out.println("### Change SuperMarketsDelivery Information ###\n\n");
        System.out.println("Enter the name of the Delivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery superMarketDelivery = super.getDatabase().findDeliveryByName(deliveryName);
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

        if (superMarketDelivery != null) {
            switch (n) {
                case 1:
                    System.out.println("Enter new name:");
                    String name = ScannerWrapper.getInstance().nextLine();
                    superMarketDelivery.setName(name);
                    System.out.println("Done!");
                    break;
                case 2:
                    System.out.println("Enter new vehicle:");
                    String strTypeOfVehicle = ScannerWrapper.getInstance().nextLine();
                    superMarketDelivery.setVehicle(Vehicle.valueOf(strTypeOfVehicle));
                    System.out.println("Done!");
                    break;
                case 3:
                    System.out.println("Enter new typeOfSalary:");
                    String strTypeOfSalary = ScannerWrapper.getInstance().nextLine();
                    superMarketDelivery.setTypeOfSalary(TypeOfSalary.valueOf(strTypeOfSalary));
                    System.out.println("Done!");
                    break;
                case 4:
                    System.out.println("Enter the new salary:");
                    double salary = ScannerWrapper.getInstance().nextDouble();
                    superMarketDelivery.setSalary(salary);
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
                    superMarketDelivery.setWeeklyAttendanceSchedule(weeklyAttendanceSchedule);
                    System.out.println("Done!");
                case 6:
                    System.out.println("Enter the new timeFoodOrdered:");
                    String timeFoodOrdered = ScannerWrapper.getInstance().nextLine();
                    superMarketDelivery.setTimeItemOrdered(timeFoodOrdered);
                    System.out.println("Done");
                case 7:
                    System.out.println("Enter the new timeFoodDelivered:");
                    String timeFoodDelivered = ScannerWrapper.getInstance().nextLine();
                    superMarketDelivery.setTimeItemDelivered(timeFoodDelivered);
                    System.out.println("Done!");
                case 8:
                    System.out.println("Is SuperMarketDelivery available:");
                    String isAvailable = ScannerWrapper.getInstance().nextLine();
                    superMarketDelivery.setAvailable(Boolean.parseBoolean(isAvailable));
                    System.out.println("Done!");
                case 9:
                    System.out.println("Enter the name of the new SuperMarkets:\nIf finished enter 0");
                    ArrayList<BusinessPlace> superMarkets = new ArrayList<>();
                    while (true) {
                        String superMarketName = ScannerWrapper.getInstance().nextLine();
                        if (superMarketName.equals("0")) {
                            break;
                        }
                        superMarkets.add(super.getDatabase().findBusinessPlaceByName(superMarketName));
                        System.out.println("Done!");
                    }
                default:
                    break;
            }
        }
    }
}
