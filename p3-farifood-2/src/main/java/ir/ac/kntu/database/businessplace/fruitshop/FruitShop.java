package ir.ac.kntu.database.businessplace.fruitshop;

import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.utility.Time;

import java.util.ArrayList;

public class FruitShop extends BusinessPlace {

    private ArrayList<FruitShopTimePeriod> fruitShopTimePeriodsForOrders;

    public ArrayList<FruitShopTimePeriod> getFruitShopTimePeriodsForOrders() {
        return fruitShopTimePeriodsForOrders;
    }

    public void setFruitShopTimePeriodsForOrders(ArrayList<FruitShopTimePeriod> fruitShopTimePeriodsForOrders) {
        this.fruitShopTimePeriodsForOrders = fruitShopTimePeriodsForOrders;
    }

    public void setTimePeriodsForOrdersFromWorkingHours() {
        Time startingTime = new Time();
        Time endingTime = new Time();
        Time difference = new Time();
        startingTime.changeWorkingHourIntoStartingHour(super.getWorkingHours());
        endingTime.changeWorkingHourIntoEndingHour(super.getWorkingHours());
        difference = difference.differenceBetweenTwoTimes(startingTime, endingTime);
        difference.milliSecondsToTime(difference.toMilliSeconds(difference) % 24);

        for (int i = startingTime.getHour() + 2; i <= startingTime.getHour() + difference.getHour(); i += 2) {
            FruitShopTimePeriod fruitShopTimePeriod = new FruitShopTimePeriod(); // defining time ranges in this loop
            fruitShopTimePeriod.setStaringTime(fruitShopTimePeriod.setTimeByHour(i - 2));
            fruitShopTimePeriod.setEndingTime(fruitShopTimePeriod.setTimeByHour(i));
            this.fruitShopTimePeriodsForOrders.add(fruitShopTimePeriod);
        }
    }
}
