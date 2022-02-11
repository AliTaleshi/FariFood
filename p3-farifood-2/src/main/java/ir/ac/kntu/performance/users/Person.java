package ir.ac.kntu.performance.users;

import ir.ac.kntu.database.Database;
import ir.ac.kntu.database.businessplace.fruitshop.fruitshopdelivery.FruitShopDeliveryMenu;
import ir.ac.kntu.database.businessplace.fruitshop.fruitshoporder.FruitShopOrderMenu;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDeliveryMenu;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrderMenu;
import ir.ac.kntu.database.businessplace.restaurant.RestaurantMenu;
import ir.ac.kntu.database.businessplace.supermarket.supermarketdelivery.SuperMarketDeliveryMenu;
import ir.ac.kntu.database.businessplace.supermarket.supermarketorder.SuperMarketOrderMenu;
import ir.ac.kntu.performance.AllMenu;
import ir.ac.kntu.performance.FacilityMenu;
import ir.ac.kntu.performance.SettingsMenu;
import ir.ac.kntu.utility.ScannerWrapper;

import java.util.Objects;

public class Person implements LogIn {

    private String userName;

    private String passWord;

    private String realName;

    private String email;

    private long phoneNumber;

    private String address;

    public Person(String userName, String passWord, String realName, String email, long phoneNumber, String address) {
        this.userName = userName;
        this.passWord = passWord;
        this.realName = realName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Person() {}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Person logIn(Database database) {
        System.out.println("Enter your username:");
        String username = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter your password:");
        String password = ScannerWrapper.getInstance().nextLine();

        for (int i = 0; i < database.getPersons().size(); i++) {
            if (database.getPersons().get(i).getUserName().equals(username) && database.getPersons().get(i).getPassWord().equals(password)) {
                return database.getPersons().get(i);
            }
        }

        return null;
    }

    @Override
    public void enters(Person person, AllMenu allMenu) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;

        return getPhoneNumber() == person.getPhoneNumber() && Objects.equals(getUserName(), person.getUserName()) && Objects.equals(getPassWord(), person.getPassWord()) && Objects.equals(getRealName(), person.getRealName()) && Objects.equals(getEmail(), person.getEmail()) && Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassWord(), getRealName(), getEmail(), getPhoneNumber(), getAddress());
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                '}';
    }
}
