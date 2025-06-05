package main.game;

public class TakeCommand implements Command {
    private Player player;
    private Zone currentZone;
    private Game game; 

    public TakeCommand ( Game game){
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
        Item item = currentZone.getItem(itemName);

        if (item != null && item.canTake()) {
            player.getInventory().addItem(item);
            currentZone.removeItem(item);
            System.out.println("Vous avez pris l'objet: " + itemName);
        } else {
            System.out.println("L'objet '" + itemName + "' n'existe pas dans cette zone.");
        }
    }

}
