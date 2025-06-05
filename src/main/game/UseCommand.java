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
        String itemName = args[0];
        // Logic to use the item from the inventory would go here.
        System.out.println("You used the " + itemName + ".");
    }
    
}
