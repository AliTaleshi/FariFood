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

public interface LogIn {

    Person logIn(Database database);

    void enters(Person person, AllMenu allMenu);
}
