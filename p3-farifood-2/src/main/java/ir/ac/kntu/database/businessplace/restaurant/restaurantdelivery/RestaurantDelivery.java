package ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery;

import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.Delivery;
import ir.ac.kntu.utility.Week;

import java.util.ArrayList;

public class RestaurantDelivery extends Delivery {

    public RestaurantDelivery(String name, Vehicle vehicle, TypeOfSalary typeOfSalary, double salary, ArrayList<Week> weeklyAttendanceSchedule, boolean isAvailable, ArrayList<BusinessPlace> restaurants) {
        super(name, vehicle, typeOfSalary, salary, isAvailable, restaurants, weeklyAttendanceSchedule);
    }
}
