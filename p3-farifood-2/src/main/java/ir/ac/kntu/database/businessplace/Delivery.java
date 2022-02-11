package ir.ac.kntu.database.businessplace;

import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.TypeOfSalary;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.Vehicle;
import ir.ac.kntu.utility.Week;

import java.util.ArrayList;
import java.util.Objects;

public class Delivery {

    private String name;

    private Vehicle vehicle;

    private TypeOfSalary typeOfSalary;

    private double salary;

    private boolean isAvailable;

    private ArrayList<BusinessPlace> businessPlaces;

    private ArrayList<Week> weeklyAttendanceSchedule;

    private String timeItemOrdered;

    private String timeItemDelivered;

    public Delivery() {}

    public Delivery(String name, Vehicle vehicle, TypeOfSalary typeOfSalary, double salary, boolean isAvailable, ArrayList<BusinessPlace> businessPlaces, ArrayList<Week> weeklyAttendanceSchedule) {
        this.name = name;
        this.vehicle = vehicle;
        this.typeOfSalary = typeOfSalary;
        this.salary = salary;
        this.isAvailable = isAvailable;
        this.businessPlaces = businessPlaces;
        this.weeklyAttendanceSchedule = weeklyAttendanceSchedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public TypeOfSalary getTypeOfSalary() {
        return typeOfSalary;
    }

    public void setTypeOfSalary(TypeOfSalary typeOfSalary) {
        this.typeOfSalary = typeOfSalary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public ArrayList<BusinessPlace> getBusinessPlaces() {
        return businessPlaces;
    }

    public ArrayList<Week> getWeeklyAttendanceSchedule() {
        return weeklyAttendanceSchedule;
    }

    public void setWeeklyAttendanceSchedule(ArrayList<Week> weeklyAttendanceSchedule) {
        this.weeklyAttendanceSchedule = weeklyAttendanceSchedule;
    }

    public String getTimeItemOrdered() {
        return timeItemOrdered;
    }

    public void setTimeItemOrdered(String timeItemOrdered) {
        this.timeItemOrdered = timeItemOrdered;
    }

    public String getTimeItemDelivered() {
        return timeItemDelivered;
    }

    public void setTimeItemDelivered(String timeItemDelivered) {
        this.timeItemDelivered = timeItemDelivered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Delivery)) {
            return false;
        }

        Delivery delivery = (Delivery) o;

        return Double.compare(delivery.getSalary(), getSalary()) == 0 && isAvailable() == delivery.isAvailable() && Objects.equals(getName(), delivery.getName()) && getVehicle() == delivery.getVehicle() && getTypeOfSalary() == delivery.getTypeOfSalary() && Objects.equals(getBusinessPlaces(), delivery.getBusinessPlaces()) && Objects.equals(getWeeklyAttendanceSchedule(), delivery.getWeeklyAttendanceSchedule()) && Objects.equals(getTimeItemOrdered(), delivery.getTimeItemOrdered()) && Objects.equals(getTimeItemDelivered(), delivery.getTimeItemDelivered());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getVehicle(), getTypeOfSalary(), getSalary(), isAvailable(), getBusinessPlaces(), getWeeklyAttendanceSchedule(), getTimeItemOrdered(), getTimeItemDelivered());
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "name='" + name + '\'' +
                ", vehicle=" + vehicle +
                ", typeOfSalary=" + typeOfSalary +
                ", salary=" + salary +
                ", isAvailable=" + isAvailable +
                ", businessPlaces=" + businessPlaces +
                ", weeklyAttendanceSchedule=" + weeklyAttendanceSchedule +
                ", timeItemOrdered=" + timeItemOrdered +
                ", timeItemDelivered=" + timeItemDelivered +
                '}';
    }
}
