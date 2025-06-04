package main.game;

public class Item implements Iitem {
    private String name;
    private String description;
    private boolean isKey;
    private boolean canTake; 

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
     if(this.isKey){
        return true; 
     } else {
            return false; }
     }

     @Override
    public boolean canTake() {
     if(this.canTake){
        return true; 
     } else {
            return false; }
     }

}
