package ir.ac.kntu.database.businessplace.supermarket;

import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.Status;
import ir.ac.kntu.database.businessplace.restaurant.FoodMenu;
import ir.ac.kntu.utility.Time;

import java.util.ArrayList;

public class SuperMarket extends BusinessPlace {

    private ArrayList<SuperMarketTimePeriod> superMarketTimePeriodsForOrders;

    public SuperMarket(String name, String address, FoodMenu foodMenu, String workingHours, double point, Status status, ArrayList<SuperMarketTimePeriod> superMarketTimePeriodsForOrders) {
        super(name, address, foodMenu, workingHours, point, status);
        this.superMarketTimePeriodsForOrders = new ArrayList<>();
        setTimePeriodsForOrdersFromWorkingHours();
    }

    public void setTimePeriodsForOrdersFromWorkingHours() {
        Time startingTime = new Time();
        Time endingTime = new Time();
        Time difference = new Time();
        startingTime.changeWorkingHourIntoStartingHour(super.getWorkingHours());
        endingTime.changeWorkingHourIntoEndingHour(super.getWorkingHours());
        difference = difference.differenceBetweenTwoTimes(startingTime, endingTime);
        difference.milliSecondsToTime(difference.toMilliSeconds(difference) % 24);

        for (int i = startingTime.getHour() + 1; i <= startingTime.getHour() + difference.getHour(); i++) {
            SuperMarketTimePeriod superMarketTimePeriod = new SuperMarketTimePeriod(); // defining time ranges in this loop
            superMarketTimePeriod.setStaringTime(superMarketTimePeriod.setTimeByHour(i - 1));
            superMarketTimePeriod.setEndingTime(superMarketTimePeriod.setTimeByHour(i));
            this.superMarketTimePeriodsForOrders.add(superMarketTimePeriod);
        }
    }

    public void addTimePeriodsForOrders(SuperMarketTimePeriod superMarketTimePeriod) {
        this.superMarketTimePeriodsForOrders.add(superMarketTimePeriod);
    }
}
