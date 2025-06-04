package main.game;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

 public void addItem(Item item) {
        if (item != null && !items.contains(item)) {
            items.add(item);
        } else {
            System.out.println("L'item est déjà dans l'inventaire ou est nul.");
        }
    }
    public List<Item> getItems() {
        return items;
    }
     
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
