package main.game;

import java.util.ArrayList;
import java.util.List;

public class InventoryCommand implements Command {
    private final Game game;
    

    public InventoryCommand(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "looinventory";
    }

    @Override
    public String getDescription() {
        return "Affiche le contenu de l'inventaire du joueur.";
    }

    @Override
    public void execute(String[] args) {
        Player player = game.getPlayer();
        if (player.getInventory().isEmpty()) {
            System.out.println("Votre inventaire est vide.");
        } else {
            System.out.println("Contenu de l'inventaire :");
            for (Item item : player.getInventory().getItems()) {
                System.out.println("- " + item);
            }
        }
    }


}
