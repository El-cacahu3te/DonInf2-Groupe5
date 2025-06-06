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
        return "Résout une énigme liée à un objet dans la zone.";
    }

    @Override
    public void execute(String[] args) {
        Player player = game.getPlayer();
        Zone currentZone = game.getMap().getZoneAt(player.getX(), player.getY());

        for (Item item : currentZone.getListItems()) {
            Ipuzzle puzzle = item.getPuzzle();
            if (puzzle != null && !puzzle.isSolved()) {
                puzzle.solve(args);

                if (puzzle.isSolved()) {
                    System.out.println("Bravo ! Vous avez résolu l'énigme pour l'objet : " + item.getItemName());
                } else {
                    System.out.println("Mauvaise réponse. Indice : " + puzzle.getHint());
                }
                return;
            }
        }

        System.out.println("Aucune énigme à résoudre ici.");
    }
}

