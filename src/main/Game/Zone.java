package main.game;

import utils.IPrintable;

public class Zone implements IPrintable {
    private String name;
    private String desc;
    private boolean islocked;


     public Zone (String name, String desc, boolean islocked){
            this.desc = desc;
            this.islocked = islocked;
            this.name = name;
    }  

    public String getZoneName(){
        return this.name; 
    }

    @Override
    public String getPrintableString(){
        if(islocked){
            return "Locked"; 
        } else {
            return this.getZoneName(); 
        }
    }

    @Override
    public boolean isGrayedOut() {
        return  islocked; 
        
    }
}
