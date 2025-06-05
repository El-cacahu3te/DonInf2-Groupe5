package main.game;

public class TakeCommand implements Command {
    private Game game;

    public TakeCommand(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "take";
    }

    @Override
    public String getDescription() {
        return "Prend un objet dans la zone actuelle.";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Veuillez spécifier l'objet à prendre.");
            return;
        }

        String itemName = args[0];
        int x = game.getPlayer().getX();
        int y = game.getPlayer().getY();

        Zone currentZone = game.getMap().getZoneAt(x, y);
        if (currentZone == null) {
            System.out.println("Vous n'êtes dans aucune zone valide.");
            return;
        }

        Item item = currentZone.getItem(itemName);
        if (item == null || !item.canTake()) {
            System.out.println("L'objet '" + itemName + "' n'existe pas dans cette zone ou ne peut pas être pris.");
            return;
        }

        // ➕ Vérifie s'il y a une énigme associée
        Ipuzzle puzzle = item.getPuzzle();
        if (puzzle != null && !puzzle.isSolved()) {
            System.out.println("Une énigme bloque cet objet !");
            System.out.println("Indice : " + puzzle.getHint());
            System.out.println("Pour répondre, tapez : solve <réponse>");
            return;
        }

        // ➕ Si l'énigme est résolue (ou pas d'énigme), on prend l'objet
        game.getPlayer().getInventory().addItem(item);
        currentZone.removeItem(item);
        System.out.println("Vous avez pris l'objet: " + itemName);
    }
}
