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
            System.out.println(currentZone.getZoneDesc() +"\n Objets dans la pièce: \n"+ currentZone.getItems());
        } else {
            System.out.println("Aucune zone ici.");
        }
    }
}
