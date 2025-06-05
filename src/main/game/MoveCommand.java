package main.game;

import java.awt.Font;

public class MoveCommand implements Command {
    private final Game game;

    public MoveCommand(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "move";
    }

    @Override
    public String getDescription() {
        return "Permet de se déplacer : move north/south/east/west \n  !Ne pas oublier de mettre le mot 'move' avant la direction!";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Veuillez indiquer une direction (north, south, east, west).");
            return;
        }

        String direction = args[0].toLowerCase();
        Player player = game.getPlayer();
        int x = player.getX();
        int y = player.getY();

        int newX = x;
        int newY = y;

        switch (direction) {
            case "north":
                newY -= 1;
                break;
            case "south":
                newY += 1;
                break;
            case "east":
                newX += 1;
                break;
            case "west":
                newX -= 1;
                break;
            default:
                System.out.println("Direction invalide : " + direction);
                return;
        }

        WorldMap map = game.getMap();
        Zone targetZone = map.getZoneAt(newX, newY);

        if (targetZone == null) {
            System.out.println("Impossible d'y aller.");
        } else if (targetZone.getZoneState()) {
            System.out.println("Zone bloquée.");
        } else {
            player.setPlayerPosition(newX, newY);
            System.out.println("Vous êtes maintenant dans : " + targetZone.getZoneName());
            System.out.println(targetZone.getZoneDesc());
        }
    }
}
