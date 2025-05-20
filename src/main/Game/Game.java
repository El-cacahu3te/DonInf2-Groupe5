package main.game;

public class Game {
    Player player;
    WorldMap map;
    CommandRegistry command;





   // System.out.println("Initializing game...");

        public void init() {
            this.map = new WorldMap();
            Zone cuisine = new Zone("La cuisine", "cest surper", true);
            Zone chambre = new Zone("La chambre","ldajljal",true);
            Zone poulailler = new Zone("Le poulailler","ldajljal",true);
            Zone verger = new Zone("Le verger","ldajljal",true);
            Zone foret = new Zone("La forêt","ldajljal",true);
            Zone lisiere = new Zone("La lisière de la forêt","ldajljal",true);
            Zone riviere = new Zone("La rivière","ldajljal",true);
            Zone leMassif = new Zone("Le massif de fleurs","ldajljal",true);
            Zone jardin = new Zone("Le jardin","Le jardin est un joli entroit, plein d'herbes et de plantes sauvages, fait pour que les petits et les grands puissent passer du bon temps. ",true);
            map.addZone(jardin, 2, 2);
        }
        
        public void setZone() {

        }
        public void run() {
            System.out.println("Running game...");
            System.out.println();
            // your runtime code here...


            // end of game
        }


    }


