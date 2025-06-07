package main.game;

public class Item implements Iitem {
    private String name;
    private String description;
    private boolean isKey;
    private boolean canTake;

    private Ipuzzle puzzle;

    public Ipuzzle getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Ipuzzle puzzle) {
        this.puzzle = puzzle;
    }

    public Item(String name, String description, boolean isKey, boolean canTake) {
        this.name = name;
        this.description = description;
        this.isKey = isKey;
        this.canTake = canTake;
    }

    @Override
    public String getItemName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isAKey() {
        return isKey;
    }

    @Override
    public boolean canTake() {
        return canTake;
    }

    @Override
    public String toString() {
        return name + " : " + description;
    }

    private Zone zoneToUnlock;

    public Zone getZoneToUnlock() {
        return zoneToUnlock;
    }

    public void setZoneToUnlock(Zone zoneToUnlock) {
        this.zoneToUnlock = zoneToUnlock;
    }

}