package main.game;

import utils.Array2Dprinter;
import utils.IPrintable;

public class WorldMap {
    private Zone[][] map;
    private int width;
    private int height;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Zone[width][height];

    }

    public void addZone(Zone zone, int x, int y) {
        if (map[x][y] == null) {
            map[x][y] = zone;
        } else {
            System.out.println("Cette Zone existe déjà");
        }
    }

    public Zone getZone(String zoneName) {
        for (int x = 0; x <= map.length; x++) {

            for (int y = 0; y <= map.length; y++) {
                Zone zone = map[x][y];
                if (zone != null && zone.getZoneName().equals(zoneName)) { // faire le getName
                    return zone;
                }
            }
        }
        return null; // si rien trouvé
    }

    public int[] getZoneCoordinates(String zoneName) {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                Zone zone = map[x][y];
                if (zone != null && zone.getZoneName().equals(zoneName)) {
                    return new int[]{x, y}; //retourne les coordonnées de la zone
                }
            }
        }
        return null; // si rien trouvé
    }

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }

    //public WorldMap getZoneMap() {
       // return this.map;
    //}

    public String printMap() {
        return Array2Dprinter.print2DArray(map, -1, -1);
    }

    public Zone getZoneAt(int x, int y) {
        if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
            return map[x][y];
        }
        return null;
    }
    
    
}
