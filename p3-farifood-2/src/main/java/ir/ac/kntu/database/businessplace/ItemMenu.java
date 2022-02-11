package ir.ac.kntu.database.businessplace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class ItemMenu {

    private ArrayList<Item> items;

    public ItemMenu(ArrayList<Item> items) {
        this.items = new ArrayList<>();
        this.items = items;
    }

    public ItemMenu() {
        this.items = new ArrayList<>();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item findItemByName(String itemName) {
        for (int i = 0; i < this.getItems().size(); i++) {
            if (this.getItems().get(i).getName().equals(itemName)) {
                return this.getItems().get(i);
            }
        }

        System.out.println("Not found!");
        return null;
    }

    public void sortItemsByPoints() {
        for (int i = 0; i < getItems().size()-1; i++) {
            for (int j = 0; j < getItems().size()-i-1; j++) {
                if (getItems().get(j).getPoint() > getItems().get(j+1).getPoint()) {
                    Collections.swap(getItems(), j, j+1);
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ItemMenu)) {
            return false;
        }

        ItemMenu itemMenu = (ItemMenu) o;

        return Objects.equals(getItems(), itemMenu.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItems());
    }

    @Override
    public String toString() {
        return "ItemMenu{" +
                "items=" + items +
                '}';
    }
}
