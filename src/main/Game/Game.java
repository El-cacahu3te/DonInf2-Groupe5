package main.game;

public class Game {
    Player player;
    WorldMap map;
    CommandRegistry command;





   System.out.println("Initializing game...");

        public void init() {
            this.map = new WorldMap(3,3);
            Zone cuisine = new Zone("La cuisine", "cest surper", true);
            Zone chambre = new Zone("La chambre","ldajljal",false);
            Zone poulailler = new Zone("Le poulailler","ldajljal",true);
            Zone verger = new Zone("Le verger","ldajljal",true);
            Zone foret = new Zone("La forêt","ldajljal",true);
            Zone lisiere = new Zone("La lisière de la forêt","ldajljal",true);
            Zone riviere = new Zone("La rivière","ldajljal",true);
            Zone leMassif = new Zone("Le massif de fleurs","ldajljal",true);
            Zone jardin = new Zone("Le jardin","Le jardin est un joli entroit, plein d'herbes et de plantes sauvages, fait pour que les petits et les grands puissent passer du bon temps. ",true);
            map.addZone(chambre, 0, 0);
            map.addZone(leMassif, 1, 0);
            map.addZone(riviere, 2, 0);
            map.addZone(cuisine, 0, 1);
            map.addZone(jardin, 1, 1);
            map.addZone(lisiere, 2, 1);
            map.addZone(poulailler, 0, 2);
            map.addZone(verger, 1, 2);
            map.addZone(foret, 2, 2);
        }

        public void run(){
            init(); 
           
        }

    }


