package main.game;

import java.util.Scanner;

public class Game {
    private Player player;
    private WorldMap map;
    private CommandRegistry command;

    public void init() {
        // Création de la carte
        this.map = new WorldMap(3, 4);
        Zone cuisine = new Zone("La cuisine", "Ici c'est la cuisine, on y fait de bon petits plats", false);
        Zone chambre = new Zone("La chambre",
                "Un endroit cosy et tranquille, parfait pour se reposer après une longue journée d'aventure.", false);
        Zone poulailler = new Zone("Le poulailler",
                "Les poules caquettent joyeusement ici. On y trouve des œufs frais chaque matin.", false);
        Zone verger = new Zone("Le verger",
                "Un lieu paisible rempli d'arbres fruitiers. L'air y est doux, parfumé de pommes et de cerises.",
                false);
        Zone foret = new Zone("La forêt",
                "Un espace dense et mystérieux. Les arbres y chuchotent des secrets anciens au gré du vent.", false);
        Zone lisiere = new Zone("La lisière de la forêt",
                "Là où la lumière du jour touche encore les troncs, entre clairière et sous-bois.", false);
        Zone riviere = new Zone("La rivière",
                "L'eau claire serpente doucement, apportant fraîcheur et sérénité. On y entend le doux murmure du courant.",
                false);
        Zone leMassif = new Zone("Le massif de fleurs",
                "Un bouquet vivant de couleurs éclatantes et de parfums enivrants. Papillons et abeilles y dansent.",
                false);
        Zone jardin = new Zone("Le jardin",
                "Le jardin est un joli endroit, plein d'herbes et de plantes sauvages, fait pour que les petits et les grands puissent passer du bon temps.",
                false);
        Zone petanque = new Zone("La petanque",
                "Un petit espace graviollonné parfait pour partager un pastis en jouant une partie de boules.", false);
        Zone piscine = new Zone("La piscine",
                "Un plongeon ? Faire bronzette au bord de la piscine ? Cette piscine aux eaux turquoise n'as synonyme qu'un seul mot : détente.",
                false);
        Zone trouNoir = new Zone("Le trou noir",
                "La légende dit que personne n'est jamais resortie de cette zone. A vos risques et perils.", false);
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
        map.addZone(petanque, 0, 3);
        map.addZone(piscine, 1, 3);
        map.addZone(trouNoir, 2, 3);
        // ajouter les Items
        // Poulailler
        Item oeuf = new Item("Oeuf", "Un œuf de poule", true, true);
        Item poule = new Item("Poule", "une petite poulette blanche", false, true);

        // Cuisine
        Item couteau = new Item("Couteau", "Un couteau de cuisine", false, true);
        Item livre = new Item("Livre", "Un vieux livre de recettes", true, true);

        // Pétanque
        Item boule = new Item("Boule", "Boule de pétanque usée", false, true);
        Item cochonnet = new Item("Cochonnet", "Cochonnet pour la pétanque", true, true);

        // Massif de fleurs
        Item fleur = new Item("Fleur", "Une jolie fleur colorée", true, true);
        Item coccinelle = new Item("Coccinelle", "Une coccinelle posé sur une fleur", false, true);

        // Jardin
        Item pelle = new Item("Pelle", "Petite pelle pour jardiner", false, true);
        Item arrosoir = new Item("Arrosoir", "Arrosoir trouvée sous une haie", true, true);

        // Verger
        Item pomme = new Item("Pomme", "Une pomme trouvée dans l'arbre creux", false, true);
        Item rateau = new Item("Rateau", "Rateau contre la cabane", true, true);

        // Piscine
        Item bouee = new Item("Bouée", "Bouée trouée mais flottante", true, true);
        Item lunette  = new Item("Lunette de piscine", "Lunette trouvé au fond de la piscine", false, true);

        // Rivière
        Item poisson = new Item("Poisson", "Petit poisson argenté", false, true);
        Item bouteille = new Item("Bouteille", "Bouteille contenant un vieux bateau en allumettes", true, true);

        // Lisière de forêt
        Item ecorce = new Item("Écorce", "Écorce avec un symbole", false, true);
        Item caillou = new Item("Caillou", "Caillou couverte de mousse", true, true);

        // Forêt
        Item champignon = new Item("Champignon", "Champignon étrange", false, true);
        Item totem = new Item("Totem", "Fragment de totem en bois", true, true);
        // panneaux 
        Item paneauP = new Item("Panneau de prévention", "N'allez pas plus au Sud ou il vous arrivera malheur!", true, false);
        Item paneauF = new Item("Paneau de prévention", "N'allez pas plus à l'Est ou il vous arrivera malheur!", true, false);
        
        // ajouter item dans zone 
        chambre.addItem(fleur);
        chambre.addItem(livre);
        cuisine.addItem(oeuf);
        cuisine.addItem(pomme);
        poulailler.addItem(bouee);
        poulailler.addItem(pelle);
        petanque.addItem(totem);
        petanque.addItem(coccinelle);
        leMassif.addItem(arrosoir);
        leMassif.addItem(ecorce);
        jardin.addItem(rateau);
        jardin.addItem(caillou);
        verger.addItem(poule);
        verger.addItem(couteau);
        piscine.addItem(lunette);
        piscine.addItem(paneauP);
        riviere.addItem(poisson);
        riviere.addItem(cochonnet);
        lisiere.addItem(champignon);
        lisiere.addItem(bouteille);
        foret.addItem(paneauF);
        foret.addItem(boule);
        // Création du joueur et position initiale
        this.player = new Player("Joueur");
        this.player.setPlayerPosition(0, 0); // position sur "chambre"

        // Initialisation du système de commandes
        this.command = new CommandRegistry();
        command.register(new HelpCommand(command));
        command.register(new MapCommand(this));
        command.register(new LookCommand(this));
        command.register(new MoveCommand(this));
        command.register(new InventoryCommand(this));
        command.register(new TakeCommand(this));
       // command.register(new UseCommand(this));
    }

    public void run() {
        init();
        System.out.println("Bienvenue dans le jeu !");
        System.out.println("Tapez 'help' pour voir les commandes disponibles.");
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

    // Getters pour les commandes
    public WorldMap getMap() {
        return this.map;
    }

    public Player getPlayer() {
        return this.player;
    }

}
