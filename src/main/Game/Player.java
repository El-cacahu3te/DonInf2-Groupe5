package main.game;

public class Player {
    private String name; 
    private Zone startingZone; 
    private int x, y; // Position du joueur sur la carte


    public Player(String PlayerName){
        this.name = PlayerName; 
        this.x = 0; // Position initiale du joueur
        this.y = 0; // Position initiale du joueur   // !définir la zone de départ si elle n'est pas verrouillée
      }

    public void setPlayerPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

     public int[] getPlayerPosition() {
        return new int[]{x, y};
    }
}
    


