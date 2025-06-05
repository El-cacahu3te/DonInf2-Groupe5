package main.game;

import java.util.Scanner;

public class Game {
    private Player player;
    private WorldMap map;
    private CommandRegistry command;

    public void init() {
        // Création de la carte
        this.map = new WorldMap(3, 4);
        Zone cuisine = new Zone("La cuisine", "Ici c'est la cuisine, on y fait de bon petits plats", true);
        Zone chambre = new Zone("La chambre",
                "Un endroit cosy et tranquille, parfait pour se reposer après une longue journée d'aventure.", false);
        Zone poulailler = new Zone("Le poulailler",
                "Les poules caquettent joyeusement ici. On y trouve des œufs frais chaque matin.", true);
        Zone verger = new Zone("Le verger",
                "Un lieu paisible rempli d'arbres fruitiers. L'air y est doux, parfumé de pommes et de cerises.", true);
        Zone foret = new Zone("La forêt",
                "Un espace dense et mystérieux. Les arbres y chuchotent des secrets anciens au gré du vent.", true);
        Zone lisiere = new Zone("La lisière de la forêt",
                "Là où la lumière du jour touche encore les troncs, entre clairière et sous-bois.", true);
        Zone riviere = new Zone("La rivière",
                "L'eau claire serpente doucement, apportant fraîcheur et sérénité. On y entend le doux murmure du courant.", true);
        Zone leMassif = new Zone("Le massif de fleurs",
                "Un bouquet vivant de couleurs éclatantes et de parfums enivrants. Papillons et abeilles y dansent.", true);
        Zone jardin = new Zone("Le jardin",
                "Le jardin est un joli endroit, plein d'herbes et de plantes sauvages.", true);
        Zone petanque = new Zone("La petanque",
                "Un petit espace gravillonné parfait pour une partie de boules.", true);
        Zone piscine = new Zone("La piscine",
                "Piscine aux eaux turquoise, synonyme de détente.", true);
        Zone trouNoir = new Zone("Le trou noir",
                "La légende dit que personne n'est jamais ressorti de cette zone.", true);

        // Ajout des zones
        map.addZone(chambre, 0, 0);
        map.addZone(leMassif, 1, 0);
        map.addZone(riviere, 2, 0);
        map.addZone(cuisine, 0, 1);
        map.addZone(jardin, 1, 1);
        map.addZone(lisiere, 2, 1);
        map.addZone(poulailler, 0, 2);
        map.addZone(verger, 1, 2);
        map.addZone(foret, 2, 2);
        map.addZone(petanque, 0, 3);
        map.addZone(piscine, 1, 3);
        map.addZone(trouNoir, 2, 3);

        // Création d'objets
        Item livre = new Item("Livre", "Un vieux livre de recettes", true, true);
        livre.setPuzzle(new SimplePuzzle(
            "Je suis une boisson chaude, noire ou verte. Qui suis-je ?",
            "the",
            "C'est une boisson qu'on boit souvent le matin."
        ));

        // Autres items (extraits pour clarté)
        Item fleur = new Item("Fleur", "Une jolie fleur colorée", true, true);
        Item couteau = new Item("Couteau", "Un couteau de cuisine", false, true);
        Item oeuf = new Item("Oeuf", "Un œuf de poule", true, true);

        // Ajout d’objets aux zones
        chambre.addItem(fleur);
        chambre.addItem(livre);
        cuisine.addItem(oeuf);
        verger.addItem(couteau);

        // Création du joueur
        this.player = new Player("Joueur");
        this.player.setPlayerPosition(0, 0); // position dans la chambre

        // Initialisation des commandes
        this.command = new CommandRegistry();
        command.register(new HelpCommand(command));
        command.register(new MapCommand(this));
        command.register(new LookCommand(this));
        command.register(new MoveCommand(this));
        command.register(new InventoryCommand(this));
        command.register(new TakeCommand(this));
        command.register(new UseCommand(this));
        command.register(new SolveCommand(this)); // <-- Ajouté pour les énigmes
    }

    public void run() {
        init();
        System.out.println("Bienvenue dans le jeu !");
        System.out.println("Tapez 'help' pour voir les commandes disponibles.");
        System.out.println("La case bleu clair indique votre position actuelle.");
        System.out.println(map.printMap(player.getX(), player.getY()));

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

    public WorldMap getMap() {
        return this.map;
    }

    public Player getPlayer() {
        return this.player;
    }
}
