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
                "L'eau claire serpente doucement, apportant fraîcheur et sérénité. On y entend le doux murmure du courant.",
                true);
        Zone leMassif = new Zone("Le massif de fleurs",
                "Un bouquet vivant de couleurs éclatantes et de parfums enivrants. Papillons et abeilles y dansent.",
                true);
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

        // Création d'objets avec énigmes associées

        // Poulailler
        Item oeuf = new Item("Oeuf", "Un oeuf de poule", true, true);
        SimplePuzzle oeufPuzzle = new SimplePuzzle(
                "Je suis la base d'une omelette, mais je ne suis pas un plat.",
                "omelette",
                "Je suis un met a base d'oeufs."
        );
        oeufPuzzle.setZoneToUnlock(poulailler);
        oeuf.setPuzzle(oeufPuzzle);

        Item poule = new Item("Poule", "une petite poulette blanche", false, true);
        poule.setPuzzle(null);
        poule.setZoneToUnlock(null);

        // Cuisine
        Item couteau = new Item("Couteau", "Un couteau de cuisine", false, true);
        SimplePuzzle couteauPuzzle = new SimplePuzzle(
                "Je suis souvent utilisé pour couper une tomate dans la cuisine.",
                "tomate",
                "Je suis un fruit ou un légume, qui sait."
        );
        couteau.setPuzzle(couteauPuzzle);
        couteau.setZoneToUnlock(null);

        Item livre = new Item("Livre", "Un vieux livre de recettes", true, true);
        SimplePuzzle livrePuzzle = new SimplePuzzle(
                "Je suis une boisson chaude. Qui suis-je ?",
                "the",
                "Je suis une boisson chaude que l'on infuse. Qui suis-je ?"
        );
        livrePuzzle.setZoneToUnlock(cuisine); // <-- CORRECTED LINE
        livre.setPuzzle(livrePuzzle);

        // Pétanque
        Item boule = new Item("Boule", "Boule de pétanque usée", false, true);
        boule.setPuzzle(null);
        boule.setZoneToUnlock(null);

        Item cochonnet = new Item("Cochonnet", "Cochonnet pour la pétanque", true, true);
        SimplePuzzle cochonnetPuzzle = new SimplePuzzle(
                "Je suis la petite cible au centre du jeu de boules, on me trouve souvent vers le sud.",
                "sud",
                "Je suis la région d'ou vient la pétanque."
        );
        cochonnetPuzzle.setZoneToUnlock(petanque);
        cochonnet.setPuzzle(cochonnetPuzzle);

        // Massif de fleurs
        Item fleur = new Item("Fleur", "Une jolie fleur colorée", true, true);
        SimplePuzzle fleurPuzzle = new SimplePuzzle(
                "Je suis une fleur très célèbre, souvent rouge et épineuse.",
                "rose",
                "Je représente l'amour."
        );
        fleurPuzzle.setZoneToUnlock(leMassif);
        fleur.setPuzzle(fleurPuzzle);

        Item coccinelle = new Item("Coccinelle", "Une coccinelle posé sur une fleur", false, true);
        coccinelle.setPuzzle(null);
        coccinelle.setZoneToUnlock(null);

        // Jardin
        Item pelle = new Item("Pelle", "Petite pelle pour jardiner", false, true);
        pelle.setPuzzle(null);
        pelle.setZoneToUnlock(null);

        Item arrosoir = new Item("Arrosoir", "Arrosoir trouvée sous une haie", true, true);
        SimplePuzzle arrosoirPuzzle = new SimplePuzzle(
                "Je verse de l'eau pour faire pousser les plantes.",
                "eau",
                "Je suis indispensable au jardinier, mais surtout à l'arrosoir."
        );
        arrosoirPuzzle.setZoneToUnlock(jardin);
        arrosoir.setPuzzle(arrosoirPuzzle);

        // Verger
        Item pomme = new Item("Pomme", "Une pomme trouvée dans l'arbre creux", false, true);
        pomme.setPuzzle(null);
        pomme.setZoneToUnlock(null);

        Item rateau = new Item("Rateau", "Rateau contre la cabane", true, true);
        SimplePuzzle rateauPuzzle = new SimplePuzzle(
                "Je rassemble la terre ou les feuilles mortes.",
                "terre",
                "On m'utilise souvent au jardin, mais je ne suis pas une pelle."
        );
        rateauPuzzle.setZoneToUnlock(verger);
        rateau.setPuzzle(rateauPuzzle);

        // Piscine
        Item bouee = new Item("Bouée", "Bouée trouée mais flottante", true, true);
        SimplePuzzle boueePuzzle = new SimplePuzzle(
                "Je flotte souvent sur la mer pour garder la tête hors de l'eau.",
                "mer",
                "Je peut être morte et rouge."
        );
        boueePuzzle.setZoneToUnlock(piscine);
        bouee.setPuzzle(boueePuzzle);

        Item lunette = new Item("Lunette de piscine", "Lunette trouvé au fond de la piscine", false, true);
        lunette.setPuzzle(null);
        lunette.setZoneToUnlock(null);

        // Rivière
        Item poisson = new Item("Poisson", "Petit poisson argenté", false, true);
        poisson.setPuzzle(null);
        poisson.setZoneToUnlock(null);

        Item bouteille = new Item("Bouteille", "Bouteille contenant une clé", true, true);
        SimplePuzzle bouteillePuzzle = new SimplePuzzle(
                "Je ferme une bouteille, je suis souvent en liège ou plastique.",
                "bouchon",
                "On me retire avant de boire à la bouteille."
        );
        bouteillePuzzle.setZoneToUnlock(riviere);
        bouteille.setPuzzle(bouteillePuzzle);

        // Lisière de forêt
        Item ecorce = new Item("Écorce", "Écorce avec un symbole", false, true);
        ecorce.setPuzzle(null);
        ecorce.setZoneToUnlock(null);

        Item caillou = new Item("Caillou", "Caillou couverte de mousse", true, true);
        caillou.setPuzzle(null);
        caillou.setZoneToUnlock(null);

        // Forêt
        Item champignon = new Item("Champignon", "Champignon étrange", false, true);
        champignon.setPuzzle(null);
        champignon.setZoneToUnlock(null);

        Item totem = new Item("Totem", "Fragment de totem en bois", true, true);
        totem.setPuzzle(null);
        totem.setZoneToUnlock(null);

        // panneaux
        Item paneauP = new Item("Panneau de prévention", "N'allez pas plus au Sud ou il vous arrivera malheur!", false,
                false);
        paneauP.setPuzzle(null);
        paneauP.setZoneToUnlock(null);

        Item paneauF = new Item("Paneau de prévention", "N'allez pas plus à l'Est ou il vous arrivera malheur!", true,
                false);
        paneauF.setPuzzle(null);
        paneauF.setZoneToUnlock(null);

        // Ajout d’objets aux zones
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
        command.register(new UseCommand(this)); // inutile à retirer si tu veux
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