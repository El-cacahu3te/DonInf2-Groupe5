package main.game;

public class SolveCommand implements Command {
    private Game game;

    public SolveCommand(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "solve";
    }

    @Override
    public String getDescription() {
        return "Résout une énigme liée à un objet dans la zone ou dans l'inventaire.\nUtilisation : solve <nom de l'objet> <réponse>";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Utilisation : solve <nom de l'objet> <réponse>");
            return;
        }

        String objectName = args[0].toLowerCase();
        String answer = String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length)).toLowerCase();

        Player player = game.getPlayer();
        Zone currentZone = game.getMap().getZoneAt(player.getX(), player.getY());

        Item itemToSolve = null;

        // Cherche l'objet dans la zone
        for (Item item : currentZone.getListItems()) {
            if (item.getItemName().equalsIgnoreCase(objectName)) {
                itemToSolve = item;
                break;
            }
        }

        // Sinon cherche l'objet dans l'inventaire
        if (itemToSolve == null) {
            for (Item item : player.getInventory().getItems()) {
                if (item.getItemName().equalsIgnoreCase(objectName)) {
                    itemToSolve = item;
                    break;
                }
            }
        }

        if (itemToSolve == null) {
            System.out.println("Objet '" + objectName + "' introuvable dans la zone ou l'inventaire.");
            return;
        }

        Ipuzzle puzzle = itemToSolve.getPuzzle();
        if (puzzle == null) {
            System.out.println("L'objet '" + itemToSolve.getItemName() + "' n'a pas d'énigme.");
            return;
        }

        if (puzzle.isSolved()) {
            System.out.println("L'énigme de l'objet '" + itemToSolve.getItemName() + "' a déjà été résolue.");
            return;
        }

        // Résolution
        puzzle.solve(new String[]{answer});

        if (puzzle.isSolved()) {
            System.out.println("Bravo ! Vous avez résolu l'énigme pour l'objet : " + itemToSolve.getItemName());

            Zone zoneToUnlock = itemToSolve.getZoneToUnlock();
            if (zoneToUnlock != null && zoneToUnlock.getZoneState()) {
                zoneToUnlock.setZoneState(false);
                System.out.println("La zone '" + zoneToUnlock.getZoneName() + "' est maintenant déverrouillée !");
            }
        } else {
            System.out.println("Mauvaise réponse. Indice : " + puzzle.getHint());
        }
    }
}
