package main.game;

import utils.IPrintable;

public class WorldMap {
    private Zone[][] map;
    private int x; 
    private int y; 


    public WorldMap (int x, int y){
        this.x = x; 
        this.y = y; 
        this.map = new Zone[x][y];

    }
    public void addZone (Zone zone, int x, int y){
        if(map[x][y] == null){
         map[x][y] = zone; 
    } else {
        System.out.println("Cette Zone existe déjà");
    }
    public Zone getZone (String zoneName){
        for(int x = 0; x <= map.length; x++){
             
            for(int y = 0; y <= map.length; y++){
                Zone zone = map[x][y];  
                if (zone != null && zone.getZoneName().equals(zoneName)) { //faire le getName
                    return zone; 
                } 
            }
        } return null; //si rien trouvé 
    }
    public int getX(){
        return map.length; 
    }
    public int getY(){
        return map[0].length;
    }
    public IPrintable[][] map(){
        this.map.print2DArray(map,getX(),getY()); 
        return this.map; 
    }
}
