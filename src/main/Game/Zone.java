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
    public ArrayList<Item> getItem() {
        ArrayList<Item> itemList = new ArrayList<>();
        for (Item item : items) {
            if (item != null) {
                itemList.add(item);
            }
        }
        return itemList;
    }

    public void removeItem(Item item) {
        if (item != null && items.contains(item)) {
            items.remove(item);
        } else {
            System.out.println("Item is null or does not exist in the zone.");
        }
    }
}
