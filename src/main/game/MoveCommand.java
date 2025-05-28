package main.game;

public class MoveCommand extends Command {
   Player p; 
    WorldMap map;


    public MoveCommand(Player p, WorldMap map) {
      this.p = p; 
      this.map = map;
      
    }


    @Override
    public void execute(String args) {
        int[] position = p.getPlayerPosition();
        int x = position[0];
        int y = position[1];

         switch(args.toLowerCase()) {
    case "north":
        y += 1;     
        break;

    case "south":
        if (player.getY() < map.length - 1) {
            player.setY(player.getY() + 1);
        } else {
            System.out.println("Vous ne pouvez pas aller plus au sud.");
        }
        break;

    case "east":
        if (player.getX() < map[0].length - 1) {
            player.setX(player.getX() + 1);
        } else {
            System.out.println("Vous ne pouvez pas aller plus à l'est.");
        }
        break;

    case "west":
        if (player.getX() > 0) {
            player.setX(player.getX() - 1);
        } else {
            System.out.println("Vous ne pouvez pas aller plus à l'ouest.");
        }
        break;

     case "north-east":
        if (player.getX() > 0) {
            player.setX(player.getX() - 1);
        } else {
            System.out.println("Vous ne pouvez pas aller plus à l'ouest.");
        }
        break;

     case "north-west":
        if (player.getX() > 0) {
            player.setX(player.getX() - 1);
        } else {
            System.out.println("Vous ne pouvez pas aller plus à l'ouest.");
        }
        break;

    default:
        System.out.println("Invalid direction: " + args);
        break;
    }
        if(map.getZone(x,y) != null) {
            p.setPlayerPosition(x, y);
            System.out.println("Vous vous déplacez vers " + map.getZone(x, y).getZoneName());
        } else {
            System.out.println("Vous ne pouvez pas vous déplacer dans cette direction, il n'y a pas de zone.");
        }
    }


        
    }

    

}
