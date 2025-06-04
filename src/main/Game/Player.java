package main.game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Zone startingZone;
    private Inventory inventory = new Inventory(); // Inventaire du joueur
    private int x, y; // Position du joueur sur la carte

    public Player(String PlayerName) {
        this.name = PlayerName;
        this.x = 0; // Position initiale du joueur
        this.y = 0; // Position initiale du joueur // !définir la zone de départ si elle n'est pas
                    // verrouillée
    }

    public void setPlayerPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getPlayerPosition() {
        return new int[] { x, y };
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    
    public Inventory getInventory() {  
        return inventory;
    }


}
