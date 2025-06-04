package main.game;

public abstract class Item implements Iitem {
    private String name;
    private String description;
    private boolean isKey;

    public Item(String name, String description, boolean isKey) {
        this.name = name;
        this.description = description;
        this.isKey = isKey;
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
    public Boolean isAKey() {
      //  if( isKey){
            return isAKey();} //pas sur de moi 
          //  else {
           // return false;
   // }
    
}
