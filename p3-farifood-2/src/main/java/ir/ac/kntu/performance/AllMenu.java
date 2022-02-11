package ir.ac.kntu.performance;

import ir.ac.kntu.database.businessplace.fruitshop.FruitShopMenu;
import ir.ac.kntu.database.businessplace.fruitshop.fruitshopdelivery.FruitShopDeliveryMenu;
import ir.ac.kntu.database.businessplace.fruitshop.fruitshoporder.FruitShopOrderMenu;
import ir.ac.kntu.database.businessplace.restaurant.RestaurantMenu;
import ir.ac.kntu.database.businessplace.restaurant.restaurantdelivery.RestaurantDeliveryMenu;
import ir.ac.kntu.database.businessplace.restaurant.restaurantorder.RestaurantOrderMenu;
import ir.ac.kntu.database.businessplace.supermarket.SuperMarketMenu;
import ir.ac.kntu.database.businessplace.supermarket.supermarketdelivery.SuperMarketDeliveryMenu;
import ir.ac.kntu.database.businessplace.supermarket.supermarketorder.SuperMarketOrderMenu;

import java.util.Objects;

public class AllMenu {

    private FacilityMenu facilityMenu;

    private SettingsMenu settingsMenu;

    private SuperMarketMenu superMarketMenu;

    private SuperMarketOrderMenu superMarketOrderMenu;

    private SuperMarketDeliveryMenu superMarketDeliveryMenu;

    private FruitShopMenu fruitShopMenu;

    private FruitShopOrderMenu fruitShopOrderMenu;

    private FruitShopDeliveryMenu fruitShopDeliveryMenu;

    private RestaurantMenu restaurantMenu;

    private RestaurantOrderMenu restaurantOrderMenu;

    private RestaurantDeliveryMenu restaurantDeliveryMenu;

    public AllMenu() {}

    public FacilityMenu getFacilityMenu() {
        return facilityMenu;
    }

    public void setFacilityMenu(FacilityMenu facilityMenu) {
        this.facilityMenu = facilityMenu;
    }

    public SettingsMenu getSettingsMenu() {
        return settingsMenu;
    }

    public void setSettingsMenu(SettingsMenu settingsMenu) {
        this.settingsMenu = settingsMenu;
    }

    public SuperMarketMenu getSuperMarketMenu() {
        return superMarketMenu;
    }

    public void setSuperMarketMenu(SuperMarketMenu superMarketMenu) {
        this.superMarketMenu = superMarketMenu;
    }

    public SuperMarketOrderMenu getSuperMarketOrderMenu() {
        return superMarketOrderMenu;
    }

    public void setSuperMarketOrderMenu(SuperMarketOrderMenu superMarketOrderMenu) {
        this.superMarketOrderMenu = superMarketOrderMenu;
    }

    public SuperMarketDeliveryMenu getSuperMarketDeliveryMenu() {
        return superMarketDeliveryMenu;
    }

    public void setSuperMarketDeliveryMenu(SuperMarketDeliveryMenu superMarketDeliveryMenu) {
        this.superMarketDeliveryMenu = superMarketDeliveryMenu;
    }

    public FruitShopMenu getFruitShopMenu() {
        return fruitShopMenu;
    }

    public void setFruitShopMenu(FruitShopMenu fruitShopMenu) {
        this.fruitShopMenu = fruitShopMenu;
    }

    public FruitShopOrderMenu getFruitShopOrderMenu() {
        return fruitShopOrderMenu;
    }

    public void setFruitShopOrderMenu(FruitShopOrderMenu fruitShopOrderMenu) {
        this.fruitShopOrderMenu = fruitShopOrderMenu;
    }

    public FruitShopDeliveryMenu getFruitShopDeliveryMenu() {
        return fruitShopDeliveryMenu;
    }

    public void setFruitShopDeliveryMenu(FruitShopDeliveryMenu fruitShopDeliveryMenu) {
        this.fruitShopDeliveryMenu = fruitShopDeliveryMenu;
    }

    public RestaurantMenu getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    public RestaurantOrderMenu getRestaurantOrderMenu() {
        return restaurantOrderMenu;
    }

    public void setRestaurantOrderMenu(RestaurantOrderMenu restaurantOrderMenu) {
        this.restaurantOrderMenu = restaurantOrderMenu;
    }

    public RestaurantDeliveryMenu getRestaurantDeliveryMenu() {
        return restaurantDeliveryMenu;
    }

    public void setRestaurantDeliveryMenu(RestaurantDeliveryMenu restaurantDeliveryMenu) {
        this.restaurantDeliveryMenu = restaurantDeliveryMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof AllMenu)) {
            return false;
        }

        AllMenu allMenu = (AllMenu) o;

        return Objects.equals(getFacilityMenu(), allMenu.getFacilityMenu()) && Objects.equals(getSettingsMenu(), allMenu.getSettingsMenu()) && Objects.equals(getSuperMarketMenu(), allMenu.getSuperMarketMenu()) && Objects.equals(getSuperMarketOrderMenu(), allMenu.getSuperMarketOrderMenu()) && Objects.equals(getSuperMarketDeliveryMenu(), allMenu.getSuperMarketDeliveryMenu()) && Objects.equals(getFruitShopMenu(), allMenu.getFruitShopMenu()) && Objects.equals(getFruitShopOrderMenu(), allMenu.getFruitShopOrderMenu()) && Objects.equals(getFruitShopDeliveryMenu(), allMenu.getFruitShopDeliveryMenu()) && Objects.equals(getRestaurantMenu(), allMenu.getRestaurantMenu()) && Objects.equals(getRestaurantOrderMenu(), allMenu.getRestaurantOrderMenu()) && Objects.equals(getRestaurantDeliveryMenu(), allMenu.getRestaurantDeliveryMenu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFacilityMenu(), getSettingsMenu(), getSuperMarketMenu(), getSuperMarketOrderMenu(), getSuperMarketDeliveryMenu(), getFruitShopMenu(), getFruitShopOrderMenu(), getFruitShopDeliveryMenu(), getRestaurantMenu(), getRestaurantOrderMenu(), getRestaurantDeliveryMenu());
    }

    @Override
    public String toString() {
        return "AllMenu{" +
                "facilityMenu=" + facilityMenu +
                ", settingsMenu=" + settingsMenu +
                ", superMarketMenu=" + superMarketMenu +
                ", superMarketOrderMenu=" + superMarketOrderMenu +
                ", superMarketDeliveryMenu=" + superMarketDeliveryMenu +
                ", fruitShopMenu=" + fruitShopMenu +
                ", fruitShopOrderMenu=" + fruitShopOrderMenu +
                ", fruitShopDeliveryMenu=" + fruitShopDeliveryMenu +
                ", restaurantMenu=" + restaurantMenu +
                ", restaurantOrderMenu=" + restaurantOrderMenu +
                ", restaurantDeliveryMenu=" + restaurantDeliveryMenu +
                '}';
    }
}
