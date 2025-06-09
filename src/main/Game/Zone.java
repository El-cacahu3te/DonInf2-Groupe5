package main.game;

import java.util.ArrayList;
import java.util.List;
import java.text.Normalizer;
import java.util.regex.Pattern;
import utils.IPrintable;

public class Zone implements IPrintable {
    private String name;
    private String desc;
    private boolean islocked;
    private List<Item> items = new ArrayList<>();

    // Constructeur
    public Zone(String name, String desc, boolean islocked) {
        this.name = name;
        this.desc = desc;
        this.islocked = islocked;
    }

    // Accesseurs de base
    public String getZoneName() {
        return this.name;
    }

    public String getZoneDesc() {
        return this.desc;
    }

    public boolean getZoneState() {
        return this.islocked;
    }

    public void setZoneState(boolean locked) {
        this.islocked = locked;
    }

    // Méthode pour afficher la zone dans la carte
    @Override
    public String getPrintableString() {
        return islocked ? "Locked" : this.getZoneName();
    }

    @Override
    public boolean isGrayedOut() {
        return islocked;
    }

    // Gestion des objets
    public List<Item> getListItems() {
        return this.items;
    }

    public void addItem(Item item) {
        if (item != null && !items.contains(item)) {
            items.add(item);
        } else {
            System.out.println("Item is null or already exists in the zone.");
        }
    }

    public void removeItem(Item item) {
        if (item != null && items.contains(item)) {
            items.remove(item);
        } else {
            System.out.println("Item is null or does not exist in the zone.");
        }
    }

   public Item getItem(String name) {
    String normalizedInput = normalize(name);
    for (Item i : items) {
        if (normalize(i.getItemName()).equalsIgnoreCase(normalizedInput) && i.canTake()) {
            return i;
        }
    }
    return null;
}

    // Ajoute cette méthode utilitaire dans la classe Zone
    private String normalize(String s) {
        if (s == null)
            return "";
        String normalized = Normalizer.normalize(s, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }

    // Pour afficher proprement tous les objets de la zone
    public String getItems() {
        if (items.isEmpty()) {
            return "Il n'y a pas d'objets dans cette pièce.";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Item i : items) {
                sb.append(" - ").append(i.getItemName()).append("\n");
            }
            return sb.toString();
        }
    }
}
