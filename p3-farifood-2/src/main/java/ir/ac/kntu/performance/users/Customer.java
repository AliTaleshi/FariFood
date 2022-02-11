package ir.ac.kntu.performance.users;

import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrder;
import ir.ac.kntu.performance.AllMenu;
import ir.ac.kntu.utility.ScannerWrapper;

import java.util.ArrayList;
import java.util.Objects;

public class Customer extends Person {

    private double credit = 999999999;

    private ArrayList<String> comments;

    private ArrayList<RestaurantOrder> restaurantOrders;

    public Customer(String name, long phoneNumber, String address) {
        comments = new ArrayList<>();
        restaurantOrders = new ArrayList<>();
        super.setPhoneNumber(phoneNumber);
        super.setAddress(address);
    }

    public Customer(String userName, String passWord, String realName, String email, long phoneNumber, String address) {
        super(userName, passWord, realName, email, phoneNumber, address);
        comments = new ArrayList<>();
        restaurantOrders = new ArrayList<>();
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ArrayList<RestaurantOrder> getOrders() {
        return restaurantOrders;
    }

    public void setOrders(ArrayList<RestaurantOrder> restaurantOrders) {
        this.restaurantOrders = restaurantOrders;
    }

    public void addOrder(RestaurantOrder restaurantOrder) {
        this.getOrders().add(restaurantOrder);
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    @Override
    public void enters(Person person, AllMenu allMenu) {
        if (person != null) {

            mainMenu();
            int n = ScannerWrapper.getInstance().nextInt();
            switch (n) {
                case 1:
                    allMenu.getRestaurantOrderMenu().mainMenu();
                case 2:
                    allMenu.getFruitShopOrderMenu().mainMenu();
                case 3:
                    allMenu.getSuperMarketOrderMenu().mainMenu();
                case 4:
                    System.out.println(this);
                default:
                    break;
            }
        } else {
            System.out.println("Invalid username or password!\nPlease try again :)");
        }
    }

    public void mainMenu() {
        System.out.println("### Menu for customers ###\n\n");
        System.out.println("1.Order Food");
        System.out.println("2.Order Fruit");
        System.out.println("3.Order Supply");
        System.out.println("4.Show Your History");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Customer)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        Customer customer = (Customer) o;

        return Objects.equals(getComments(), customer.getComments()) && Objects.equals(getOrders(), customer.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getComments(), getOrders());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "comments=" + comments +
                ", restaurantOrders=" + restaurantOrders +
                '}';
    }
}