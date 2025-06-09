package main.game;

public class UseCommand implements Command {
    private final String name = "use";
    private final String description = "Utilise un objet de ton inventaire.";
    private Game game; 

    public UseCommand (Game game){
        this.game = game; 
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
public void execute(String[] args) {
    if (args.length < 1) {
        System.out.println("Usage: use <item>");
        return;
    }

    String itemName = String.join(" ", args);
    Item item = game.getPlayer().getInventory().getItem(itemName);

    if (item == null) {
        System.out.println("Vous n'avez pas cet objet dans votre inventaire.");
        return;
    }

    Ipuzzle puzzle = item.getPuzzle();
if (puzzle != null && !puzzle.isSolved()) {
    System.out.println("Cet objet est verrouillé par une énigme !");
    System.out.println("Énigme : " + puzzle.getName());
    System.out.println("Pour répondre, utilisez la commande : solve <nom de l'objet> <réponse>");
    return;
}

    System.out.println("Vous utilisez " + itemName + ".");
}

    
}
