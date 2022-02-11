package ir.ac.kntu.database.businessplace.fruitshop.fruitshopdelivery;

import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.Delivery;
import ir.ac.kntu.database.businessplace.DeliveryMenu;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDelivery;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.TypeOfSalary;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.Vehicle;
import ir.ac.kntu.utility.ScannerWrapper;
import ir.ac.kntu.utility.Week;

import java.util.ArrayList;

public class FruitShopDeliveryMenu extends DeliveryMenu {

    @Override
    public void mainMenu() {
        System.out.println("### FruitShop Delivery Menu ###\n\n");
        System.out.println("Enter the name of the FruitShopDelivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery fruitShopDelivery = super.getDatabase().findDeliveryByName(deliveryName);

        if (fruitShopDelivery != null) {
            System.out.println("1.Show FruitShopDelivery's information");
            System.out.println("2.Build a new FruitShopDelivery");
            System.out.println("3.Change FruitShopDelivery's information");

            String n = ScannerWrapper.getInstance().nextLine();
            mainMenuPerformer(n + deliveryName);
        }

    }

    @Override
    public void mainMenuPerformer(String n) {
        FruitShopDelivery fruitShopDelivery = (FruitShopDelivery) super.getDatabase().findDeliveryByName(n.substring(1));

        switch (Integer.parseInt(n.substring(0, 1))) {

            case 1:
                System.out.println(fruitShopDelivery);
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
        System.out.println("### Register a new FruitShopDelivery ###\n\n");

        System.out.println("Enter the name of the FruitShopDelivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();

        System.out.println("Enter the type of FruitShopDelivery's vehicle:");
        String typeOfVehicle = ScannerWrapper.getInstance().nextLine();
        Vehicle vehicle = Vehicle.valueOf(typeOfVehicle);

        System.out.println("Enter the type of FruitShopDelivery's salary:");
        String strTypeOfSalary = ScannerWrapper.getInstance().nextLine();
        TypeOfSalary typeOfSalary = TypeOfSalary.valueOf(strTypeOfSalary);

        System.out.println("Enter the FruitShopDelivery's salary:");
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

        System.out.println("Is FruitShopDelivery available? (true or false)");
        String strIsAvailable = ScannerWrapper.getInstance().nextLine();
        boolean isAvailable =  Boolean.parseBoolean(strIsAvailable);

        ArrayList<BusinessPlace> fruitShops = new ArrayList<>();
        System.out.println("Enter the name of the first FruitShop that this FruitShopDelivery works in:");
        String firstFruitShopName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace fruitShop1 = super.getDatabase().findBusinessPlaceByName(firstFruitShopName);
        fruitShops.add(fruitShop1);

        System.out.println("Enter the name of the second FruitShop that this FruitShopDelivery works in:");
        String secondFruitShopName = ScannerWrapper.getInstance().nextLine();
        BusinessPlace fruitShop2 = super.getDatabase().findBusinessPlaceByName(secondFruitShopName);
        fruitShops.add(fruitShop2);

        RestaurantDelivery restaurantDelivery = new RestaurantDelivery(deliveryName, vehicle, typeOfSalary, salary, weeklyAttendanceSchedule, isAvailable, fruitShops);
        super.getDatabase().addDelivery(restaurantDelivery);
        System.out.println("Registration Completed!");
    }

    @Override
    public void changeDeliveryInformation() {
        System.out.println("### Change FruitShopDelivery Information ###\n\n");
        System.out.println("Enter the name of the FruitShopDelivery:");
        String deliveryName = ScannerWrapper.getInstance().nextLine();
        Delivery fruitShopDelivery = super.getDatabase().findDeliveryByName(deliveryName);
        System.out.println("1.Change name");
        System.out.println("2.Change vehicle");
        System.out.println("3.Change typeOfSalary");
        System.out.println("4.Change salary");
        System.out.println("5.Change weeklyAttendanceSchedule");
        System.out.println("6.Change timeFruitOrdered");
        System.out.println("7.Change timeFruitDelivered");
        System.out.println("8.Change isAvailable");
        System.out.println("9.Change restaurants restaurantDelivery is working in");
        int n = ScannerWrapper.getInstance().nextInt();

        if (fruitShopDelivery != null) {
            switch (n) {
                case 1:
                    System.out.println("Enter new name:");
                    String name = ScannerWrapper.getInstance().nextLine();
                    fruitShopDelivery.setName(name);
                    System.out.println("Done!");
                    break;
                case 2:
                    System.out.println("Enter new vehicle:");
                    String strTypeOfVehicle = ScannerWrapper.getInstance().nextLine();
                    fruitShopDelivery.setVehicle(Vehicle.valueOf(strTypeOfVehicle));
                    System.out.println("Done!");
                    break;
                case 3:
                    System.out.println("Enter new typeOfSalary:");
                    String strTypeOfSalary = ScannerWrapper.getInstance().nextLine();
                    fruitShopDelivery.setTypeOfSalary(TypeOfSalary.valueOf(strTypeOfSalary));
                    System.out.println("Done!");
                    break;
                case 4:
                    System.out.println("Enter the new salary:");
                    double salary = ScannerWrapper.getInstance().nextDouble();
                    fruitShopDelivery.setSalary(salary);
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
                    fruitShopDelivery.setWeeklyAttendanceSchedule(weeklyAttendanceSchedule);
                    System.out.println("Done!");
                case 6:
                    System.out.println("Enter the new timeFruitOrdered:");
                    String timeFoodOrdered = ScannerWrapper.getInstance().nextLine();
                    fruitShopDelivery.setTimeItemOrdered(timeFoodOrdered);
                    System.out.println("Done");
                case 7:
                    System.out.println("Enter the new timeFruitDelivered:");
                    String timeFoodDelivered = ScannerWrapper.getInstance().nextLine();
                    fruitShopDelivery.setTimeItemDelivered(timeFoodDelivered);
                    System.out.println("Done!");
                case 8:
                    System.out.println("Is FruitShopDelivery available:");
                    String isAvailable = ScannerWrapper.getInstance().nextLine();
                    fruitShopDelivery.setAvailable(Boolean.parseBoolean(isAvailable));
                    System.out.println("Done!");
                case 9:
                    System.out.println("Enter the name of the new FruitShops:\nIf finished enter 0");
                    ArrayList<BusinessPlace> fruitShops = new ArrayList<>();
                    while (true) {
                        String fruitShopName = ScannerWrapper.getInstance().nextLine();
                        if (fruitShopName.equals("0")) {
                            break;
                        }
                        fruitShops.add(super.getDatabase().findBusinessPlaceByName(fruitShopName));
                        System.out.println("Done!");
                    }
                default:
                    break;
            }
        }
    }
}
