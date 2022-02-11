package ir.ac.kntu.database.businessplace;

import ir.ac.kntu.database.businessplace.restaurant.FoodMenu;
import ir.ac.kntu.performance.users.Customer;
import ir.ac.kntu.performance.users.Manager;
import ir.ac.kntu.utility.Time;

import java.time.LocalTime;
import java.util.HashMap;

public class BusinessPlace {

    private String name; // Name of restaurant

    private String address; // Address of restaurant

    private FoodMenu foodMenu; // Food foodMenu of the restaurant

    private String workingHours; // "From a to b"

    private double point = 5; // Restaurant's point

    private HashMap<Customer, String> customersComments; // Users and their comments

    private Status status;

    private Manager manager;

    public BusinessPlace(String name, String address, FoodMenu foodMenu, String workingHours, double point, HashMap<Customer, String> customersComments, Status status) {
        this.name = name;
        this.address = address;
        this.foodMenu = foodMenu;
        this.workingHours = workingHours;
        this.point = point;
        this.customersComments = customersComments;
        this.status = status;
    }

    public BusinessPlace(String name, String address, FoodMenu foodMenu, String workingHours, double point, Status status, Manager manager) {
        this.name = name;
        this.address = address;
        this.foodMenu = foodMenu;
        this.workingHours = workingHours;
        this.point = point;
        this.status = status;
        this.manager = manager;
    }

    public BusinessPlace(String name, String address, FoodMenu foodMenu, String workingHours, double point) {
        this.name = name;
        this.address = address;
        this.foodMenu = foodMenu;
        this.workingHours = workingHours;
        this.point = point;
        setStatus();
    }

    public BusinessPlace() {}

    public BusinessPlace(String name, String address, FoodMenu foodMenu, String workingHours, double point, Status status) {
        this.name = name;
        this.address = address;
        this.foodMenu = foodMenu;
        this.workingHours = workingHours;
        this.point = point;
        this.status = status;
    }

    public Manager getManager() {
        return manager;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public FoodMenu getMenu() {
        return foodMenu;
    }

    /*public void setMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }*/

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public HashMap<Customer, String> getCustomersComments() {
        return customersComments;
    }

    /*public void setCustomersComments(HashMap<Customer, String> customersComments) {
        this.customersComments = customersComments;
    }*/

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void add(Customer customer, String comment) {
        this.customersComments.put(customer, comment);
    }

    public void removeComments(Customer customer, String comment) {
        this.customersComments.remove(customer, comment);
    }

    public void customerCommentsHistory() {
        System.out.println(customersComments.toString().replace("=", ": "));
    }

    public void setStatus() {
        Time currentTime = new Time();
        Time startingTime = new Time();
        Time endingTime = new Time();
        startingTime.changeWorkingHourIntoStartingHour(workingHours);
        endingTime.changeWorkingHourIntoEndingHour(workingHours);
        currentTime.changeIntoTimeWithoutReturningTypeTime(LocalTime.now().toString().substring(0, LocalTime.now().toString().indexOf(".")));
        if (currentTime.compare(startingTime) == 1 && currentTime.compare(endingTime) == -1) {
            this.setStatus(Status.ACTIVE);
        } else {
            this.setStatus(Status.INACTIVE);
        }
    }
}
