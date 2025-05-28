package main.game;

public class Game {
    Player player;
    WorldMap map;
    CommandRegistry command;

        public void init() {
            this.map = new WorldMap(3,3);
            Zone cuisine = new Zone("La cuisine", "Ici c'est la cuisine, on y fait de bon petits plats", true);
            Zone chambre = new Zone("La chambre", "Un endroit cosy et tranquille, parfait pour se reposer après une longue journée d'aventure.", false);
            Zone poulailler = new Zone("Le poulailler", "Les poules caquettent joyeusement ici. On y trouve des œufs frais chaque matin.", true);
            Zone verger = new Zone("Le verger", "Un lieu paisible rempli d'arbres fruitiers. L'air y est doux, parfumé de pommes et de cerises.", true);
            Zone foret = new Zone("La forêt", "Un espace dense et mystérieux. Les arbres y chuchotent des secrets anciens au gré du vent.", true);
            Zone lisiere = new Zone("La lisière de la forêt", "Là où la lumière du jour touche encore les troncs, entre clairière et sous-bois.", true);
            Zone riviere = new Zone("La rivière", "L'eau claire serpente doucement, apportant fraîcheur et sérénité. On y entend le doux murmure du courant.", true);
            Zone leMassif = new Zone("Le massif de fleurs", "Un bouquet vivant de couleurs éclatantes et de parfums enivrants. Papillons et abeilles y dansent.", true);
            Zone jardin = new Zone("Le jardin", "Le jardin est un joli endroit, plein d'herbes et de plantes sauvages, fait pour que les petits et les grands puissent passer du bon temps.", true);
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
            System.out.println(map.printMap());
           
        }

    }


