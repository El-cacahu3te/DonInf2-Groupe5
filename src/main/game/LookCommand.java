package main.game;

public class LookCommand implements Command {
    private final Game game;

    public LookCommand(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "look";
    }

    @Override
    public String getDescription() {
        return "Affiche la description de la zone actuelle.";
    }

    @Override
    public void execute(String[] args) {
        int x = game.getPlayer().getX();
        int y = game.getPlayer().getY();
        Zone currentZone = game.getMap().getZoneAt(x, y);
        if (currentZone != null) {
            System.out.println(currentZone.getZoneDesc() + "\nObjets dans la pièce:");
            if (currentZone.getListItems().isEmpty()) {
                System.out.println("Il n'y a plus d'objets dans cette pièce.");
            } else {
                for (Item item : currentZone.getListItems()) {
                    System.out.println("- " + item.getItemName() + " : " + item.getDescription());
                }
            }
        } else {
            System.out.println("Aucune zone ici.");
        }
    }
}
