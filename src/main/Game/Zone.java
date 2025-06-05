package main.game;

import java.util.ArrayList;
import java.util.List;

import utils.IPrintable;

public class Zone implements IPrintable {
    private String name;
    private String desc;
    private boolean islocked;
    private List<Item> items = new ArrayList<>();

    public Zone(String name, String desc, boolean islocked) {
        this.desc = desc;
        this.islocked = islocked;
        this.name = name;
    }

    public String getZoneName() {
        return this.name;
    }

    public String getZoneDesc() {
        return this.desc;
    }

    public boolean getZoneState() {
        return this.islocked;
    }

    @Override
    public String getPrintableString() {
        if (islocked) {
            return "Locked";
        } else {
            return this.getZoneName();
        }
    }

    @Override
    public boolean isGrayedOut() {
        return islocked;

    }

    public void addItem(Item item) {
        if (item != null && !items.contains(item)) {
            items.add(item);
        } else {
            System.out.println("Item is null or already exists in the zone.");

        }
    }

    public Item getItem(String name) {
        for (Item i : items) {
            if (i.getItemName().equals(name)) {
                return i;
            }
        }
        return null;
    }

  
  // Retourne une chaîne listant tous les objets de la zone, ou un message si la zone est vide
public String getItems() {
    // Si la liste d'objets est vide
    if (items.isEmpty()) {
        // On retourne un message indiquant qu'il n'y a pas d'objets dans la pièce
        return "Il n'y a pas d'objets dans cette pièce.";
    } else {
        // Sinon, on crée un StringBuilder pour construire la liste des objets
        StringBuilder sb = new StringBuilder();
        // On parcourt chaque objet de la liste 'items'
        for (Item i : items) {
            // On ajoute le nom de l'objet précédé d'un tiret et d'un retour à la ligne
            sb.append(" - ").append(i.getItemName()).append("\n");
        }
        // On retourne la chaîne complète contenant tous les objets de la zone
        return sb.toString();
    }
}

    public void removeItem(Item item) {
        if (item != null && items.contains(item)) {
            items.remove(item);

        } else {
            System.out.println("Item is null or does not exist in the zone.");
        }
    }
}
