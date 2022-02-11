package ir.ac.kntu.database;

import ir.ac.kntu.database.businessplace.BusinessPlace;
import ir.ac.kntu.database.businessplace.Delivery;
import ir.ac.kntu.database.businessplace.Item;
import ir.ac.kntu.database.businessplace.Order;
import ir.ac.kntu.database.businessplace.fruitshop.FruitShop;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDelivery;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrder;
import ir.ac.kntu.database.businessplace.restaurant.Restaurant;
import ir.ac.kntu.database.businessplace.restaurant.TypeOfPrice;
import ir.ac.kntu.database.businessplace.supermarket.SuperMarket;
import ir.ac.kntu.performance.users.Admin;
import ir.ac.kntu.performance.users.Customer;
import ir.ac.kntu.performance.users.Manager;
import ir.ac.kntu.performance.users.Person;
import ir.ac.kntu.utility.ScannerWrapper;

import java.util.ArrayList;
import java.util.Collections;

public class Database {

    private ArrayList<Person> persons;

    private ArrayList<Admin> admins;

    private ArrayList<Customer> customers;

    private ArrayList<Manager> managers;

    private ArrayList<Delivery> deliveries;

    private ArrayList<Order> orders;

    private ArrayList<BusinessPlace> businessPlaces;

    private ArrayList<SuperMarket> superMarkets;

    private ArrayList<FruitShop> fruitShops;

    private ArrayList<Restaurant> restaurants;

    private ArrayList<Item> allItems;

    public Database() {
        this.admins = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.persons = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.deliveries = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.businessPlaces = new ArrayList<>();
        this.superMarkets = new ArrayList<>();
        this.fruitShops = new ArrayList<>();
        this.restaurants = new ArrayList<>();
        this.allItems = new ArrayList<>();
    }

    public void addAdmin(Admin admin) {
        this.getAdmins().add(admin);
    }

    public void addCustomer(Customer customer) {
        this.getCustomers().add(customer);
    }

    public void addDelivery(RestaurantDelivery restaurantDelivery) {
        this.getDeliveries().add(restaurantDelivery);
    }

    public void addOrder(RestaurantOrder restaurantOrder) {
        this.getOrders().add(restaurantOrder);
    }

    public void addManager(Manager manager) {
        this.managers.add(manager);
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public ArrayList<BusinessPlace> getBusinessPlaces() {
        return businessPlaces;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Item> getAllItems() {
        return allItems;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addBusinessPlace(BusinessPlace businessPlace) {
        businessPlaces.add(businessPlace);
    }

    public void sortItemsByPoints() { // BubbleSorting
        for (int i = 0; i < allItems.size()-1; i++) {
            for (int j = 0; j < allItems.size()-i-1; j++) {
                if (allItems.get(j).getPoint() > allItems.get(j+1).getPoint()) {
                    Collections.swap(getAllItems(), j, j+1);
                }
            }
        }
    }

    public void sortBusinessPlacesByPoint() { // BubbleSorting
        for (int i = 0; i < businessPlaces.size() - 1; i++) {
            for (int j = 0; j < businessPlaces.size() - i - 1; j++) {
                if (businessPlaces.get(j).getPoint() > businessPlaces.get(j + 1).getPoint()) {
                    Collections.swap(getBusinessPlaces(), j, j + 1);
                }
            }
        }
    }

    public void sortBusinessPlacesByComments() { // BubbleSorting
        for (int i = 0; i < businessPlaces.size(); i++) {
            for (int j = 0; j < businessPlaces.size() - i - 1; j++) {
                if(businessPlaces.get(j).getCustomersComments().size() > businessPlaces.get(j + 1).getCustomersComments().size()) {
                    Collections.swap(getBusinessPlaces(), j, j + 1);
                }
            }
        }
    }

    public BusinessPlace findBusinessPlaceByName(String name) {
        for (int i = 0; i < this.getBusinessPlaces().size(); i++) {
            if (this.getBusinessPlaces().get(i).getName().equals(name)) {
                return this.getBusinessPlaces().get(i);
            }
        }

        System.out.println("Not found!");
        return null;
    }

    public Customer findCustomerByName(String name) {
        for (int i = 0; i < getCustomers().size(); i++) {
            if (getCustomers().get(i).getRealName().equals(name)) {
                return getCustomers().get(i);
            }
        }

        System.out.println("Not found!");
        return null;
    }

    public Order findOrderById(String id) {
        for (int i = 0; i < getOrders().size(); i++) {
            if (getOrders().get(i).getId().equals(id)) {
                return getOrders().get(i);
            }
        }

        System.out.println("Not found!");
        return null;
    }

    public Delivery findDeliveryByName(String name) {
        for (int i = 0; i < getDeliveries().size(); i++) {
            if (getDeliveries().get(i).getName().equals(name)) {
                return getDeliveries().get(i);
            }
        }

        System.out.println("Not found!");
        return null;
    }

    public Person findPersonByName(String name) {
        for (int i = 0; i < getPersons().size(); i++) {
            if (getPersons().get(i).getRealName().equals(name)) {
                return getPersons().get(i);
            }
        }

        System.out.println("Not found!");
        return null;
    }

    public Item findItemByName(String name) {
        for (int i = 0; i < getAllItems().size(); i++) {
            if (getAllItems().get(i).getName().equals(name)) {
                return getAllItems().get(i);
            }
        }

        System.out.println("Not found!");
        return null;
    }

    public void showBusinessPlaceCommentHistory() {
        System.out.println("### Business Place's Comment History ###\n\n");
        System.out.println("Enter the name of the business place:");
        String nameBusinessPlace = ScannerWrapper.getInstance().nextLine();
        BusinessPlace businessPlace = findBusinessPlaceByName(nameBusinessPlace);
        businessPlace.customerCommentsHistory();
    }

    public void showItemCommentsHistoryForAllBusinessPlaces() {
        System.out.println("### Item Comments History in all Business Places ###\n\n");
        System.out.println("Enter the name of the item:");
        String foodName = ScannerWrapper.getInstance().nextLine();
        for (int i = 0; i < getBusinessPlaces().size(); i++) {
            if (getBusinessPlaces().get(i).getMenu().findItemByName(foodName) != null) {
                System.out.println(getBusinessPlaces().get(i).getName() + ":");
                getBusinessPlaces().get(i).getMenu().findItemByName(foodName).getCustomersComments().toString();
            }
        }
    }

    public void showAllBusinessPlaces() {
        for (BusinessPlace businessPlace : businessPlaces) {
            System.out.println(businessPlace.getName());
        }
    }

    public void showBestThreeItemsInEachBusinessPlace() {
        for (int i = 0; i < getBusinessPlaces().size(); i++) {
            getBusinessPlaces().get(i).getMenu().sortItemsByPoints();
            System.out.println(getBusinessPlaces().get(i).getName() + ":");
            System.out.println("1st Place: " + getBusinessPlaces().get(i).getMenu().getItems().get(getBusinessPlaces().get(i).getMenu().getItems().size()-1).getName());
            System.out.println("2nd Place: " + getBusinessPlaces().get(i).getMenu().getItems().get(getBusinessPlaces().get(i).getMenu().getItems().size()-2).getName());
            System.out.println("3rd Place: " + getBusinessPlaces().get(i).getMenu().getItems().get(getBusinessPlaces().get(i).getMenu().getItems().size()-3).getName());
        }
    }

    public void showBestThreeBusinessPlaces() {
        sortBusinessPlacesByPoint();
        System.out.println("1st Place: " + getBusinessPlaces().get(getBusinessPlaces().size()-1).getName());
        System.out.println("2nd Place: " + getBusinessPlaces().get(getBusinessPlaces().size()-2).getName());
        System.out.println("3rd Place: " + getBusinessPlaces().get(getBusinessPlaces().size()-3).getName());
    }

    public void showSortedBusinessPlacesByComments() {
        sortBusinessPlacesByComments();
        for (int i = 0; i < getBusinessPlaces().size(); i++) {
            System.out.println(getBusinessPlaces().get(i).getName());
        }
    }

    public void showBestFiveBusinessPlacesHaveAnItem() {
        System.out.println("Enter the name of the Item:");
        String itemName = ScannerWrapper.getInstance().nextLine();
        int flag = 0;
        sortBusinessPlacesByPoint();

        for (int i = 0; i < getBusinessPlaces().size(); i++) {
            sortBusinessPlacesByPoint();
            if (getBusinessPlaces().get(i).getMenu().findItemByName(itemName) != null && flag != 6) {
                flag++;
                System.out.println(flag + ": " + getBusinessPlaces().get(i).getName());
            } else if(getBusinessPlaces().get(i).getMenu().findItemByName(itemName) == null) {
                System.out.println("Item Not Found!");
            }
        }
    }

    public Restaurant findRestaurantByTypeOfPrice() {
        System.out.println("Enter the type of price:");
        String typeOfPrice = ScannerWrapper.getInstance().nextLine();
        for (int i = 0; i < getRestaurants().size(); i++) {
            if (getRestaurants().get(i).getTypeOfPrice().equals(TypeOfPrice.valueOf(typeOfPrice.toUpperCase()))) {
                return getRestaurants().get(i);
            }
        }

        System.out.println("Not found!");
        return null;
    }

    public void showCustomerComments() {
        System.out.println("Enter the real name of the customer:");
        String customerName = ScannerWrapper.getInstance().nextLine();
        Customer customer = findCustomerByName(customerName);
        if (customer != null) {
            System.out.println(customer.getRealName() + ": ");
            for (int i = 0; i < customer.getComments().size(); i++) {
                System.out.println(customer.getComments().get(i));
            }
        } else {
            System.out.println("Not found!");
        }
    }

    public void showCustomerOrdersHistory() {
        System.out.println("Enter the real name of the customer");
        String customerName = ScannerWrapper.getInstance().nextLine();
        Customer customer = findCustomerByName(customerName);
        if (customer != null) {
            System.out.println(customer.getRealName() + ": ");
            for (int i = 0; i < customer.getOrders().size(); i++) {
                System.out.println(customer.getOrders().get(i).toString());
            }
        } else {
            System.out.println("Not found!");
        }
    }
}
