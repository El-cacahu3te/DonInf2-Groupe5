package main.game;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

 public void addItem(Item item) {
        if (item != null && !items.contains(item) && item.canTake()) {
            items.add(item);
        } else if(!item.canTake()) {
            System.out.println("L'item ne peut pas être pris.");
        } else if(items.contains(item)) {
            System.out.println("L'item est déjà dans l'inventaire.");
        } else {
            System.out.println("Cet item n'existe pas.");

        }
    }
    public List<Item> getItems() {
        return items;
    }
     
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
