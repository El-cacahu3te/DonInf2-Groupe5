package main.game;

import java.util.Scanner;

public class Game {
    private Player player;
    private WorldMap map;
    private CommandRegistry command;
   
    public void init() {
        // Création de la carte
        this.map = new WorldMap(3, 3);
        
        // Création des zones
        Zone cuisine = new Zone("La cuisine", "Ici c'est la cuisine, on y fait de bons petits plats", true);
        Zone chambre = new Zone("La chambre", "Un endroit cosy et tranquille, parfait pour se reposer après une longue journée d'aventure.", false);
        Zone poulailler = new Zone("Le poulailler", "Les poules caquettent joyeusement ici. On y trouve des œufs frais chaque matin.", true);
        Zone verger = new Zone("Le verger", "Un lieu paisible rempli d'arbres fruitiers. L'air y est doux, parfumé de pommes et de cerises.", true);
        Zone foret = new Zone("La forêt", "Un espace dense et mystérieux. Les arbres y chuchotent des secrets anciens au gré du vent.", true);
        Zone lisiere = new Zone("La lisière de la forêt", "Là où la lumière du jour touche encore les troncs, entre clairière et sous-bois.", true);
        Zone riviere = new Zone("La rivière", "L'eau claire serpente doucement, apportant fraîcheur et sérénité.", true);
        Zone leMassif = new Zone("Le massif de fleurs", "Un bouquet vivant de couleurs éclatantes et de parfums enivrants.", true);
        Zone jardin = new Zone("Le jardin", "Le jardin est un joli endroit, plein d'herbes et de plantes sauvages.", true);

        // Ajout des zones à la carte
        map.addZone(chambre, 0, 0);
        map.addZone(leMassif, 1, 0);
        map.addZone(riviere, 2, 0);
        map.addZone(cuisine, 0, 1);
        map.addZone(jardin, 1, 1);
        map.addZone(lisiere, 2, 1);
        map.addZone(poulailler, 0, 2);
        map.addZone(verger, 1, 2);
        map.addZone(foret, 2, 2);

         commandRegistry = new CommandRegistry();
            commandRegistry.put("move", new MoveCommand(null));
            Player p1 = new Player("Alice");

        // Création du joueur et position initiale
        this.player = new Player("Joueur");
        this.player.setPlayerPosition(0, 0); // position sur "chambre"

        // Initialisation du système de commandes
        this.command = new CommandRegistry();
        command.register(new HelpCommand(command));
        command.register(new MapCommand(this));
        command.register(new LookCommand(this));
        command.register(new MoveCommand(this));
    }

    public void run() {
        init();
        System.out.println("Bienvenue dans le jeu !");
        System.out.println("Tapez 'help' pour voir les commandes disponibles.");
        System.out.println(map.printMap());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("Fermeture du jeu...");
                break;
            }
            command.executeCommand(input);
        }
        scanner.close();
    }

    // Getters pour les commandes
    public WorldMap getMap() {
        return this.map;
    }

    public Player getPlayer() {
        return this.player;
    }
    
}
