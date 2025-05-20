package main.game;

public class WorldMap {
    private Zone[][] map;


    public WorldMap (){
        this.map = new Zone[3][3];

    }
    public void addZone (Zone zone, int x, int y){
        map[x][y] = zone; 
    }
    public Zone getZone (String zoneName){
        for(int x = 0; x <= map.length; x++){
             
            for(int y = 0; y <= map.length; y++){
                Zone zone = map[x][y];  
                if (zone != null && zone.getName().equals(zoneName)) { //faire le getName
                    return zone; 
                } 
            }
        } return null; //si rien trouvé 
    }
}
