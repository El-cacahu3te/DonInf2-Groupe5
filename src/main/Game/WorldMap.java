package main.game;

import utils.Array2Dprinter;
import utils.IPrintable;

public class WorldMap {
    private Zone[][] map;
    private int width;
    private int height;

    public WorldMap(int x, int y) {
        this.width = x;
        this.height = y;
        this.map = new Zone[x][y];

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

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }

    public String printMap() {
        return Array2Dprinter.print2DArray(map, -1, -1);
    }
}
