package main.game;

import java.text.Normalizer;

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
        String normalizedInput = normalize(itemName);

        Item item = null;
        for (Item invItem : game.getPlayer().getInventory().getItems()) {
            if (normalize(invItem.getItemName()).equalsIgnoreCase(normalizedInput)) {
                item = invItem;
                break;
            }
        }

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

        System.out.println("Vous utilisez " + item.getItemName() + " mais rien de spécial ne se passe.");
    }

    // Ajoute cette méthode utilitaire
    private String normalize(String s) {
        if (s == null)
            return "";
        String normalized = Normalizer.normalize(s, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }
}