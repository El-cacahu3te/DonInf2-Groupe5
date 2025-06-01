package main.game;

public class MapCommand implements Command {
    private final Game game;

    public MapCommand(Game game) {
        this.game = game;
    }

    @Override
    public String getName() {
        return "map";
    }

    @Override
    public String getDescription() {
        return "Affiche la carte du monde.";
    }

    @Override
    public void execute(String[] args) {
        System.out.println(game.getMap().printMap());
    }
}
