package main.game;

import java.text.Normalizer;

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
        if (args.length < 1) {
            System.out.println("Utilisation : solve <objet> <réponse>");
            return;
        }

        Player player = game.getPlayer();

        String itemName = args[0];
        String normalizedInput = normalize(itemName);

        // Vérifie que l'objet est dans l'inventaire du joueur
        Item item = null;
        for (Item invItem : player.getInventory().getItems()) {
            if (normalize(invItem.getItemName()).equalsIgnoreCase(normalizedInput)) {
                item = invItem;
                break;
            }
        }
        if (item == null) {
            System.out.println(
                "Vous devez avoir l'objet '" + itemName + "' dans votre inventaire pour résoudre son énigme.");
            return;
        }

        Ipuzzle puzzle = item.getPuzzle();
        if (puzzle == null) {
            System.out.println("Cet objet n'a pas d'énigme à résoudre.");
            return;
        }

        if (puzzle.isSolved()) {
            System.out.println("L'énigme de cet objet est déjà résolue !");
            return;
        }

        // Si aucune réponse n'est donnée, on affiche juste la question
        if (args.length == 1) {
            System.out.println("Énigme : " + puzzle.getName());
            return;
        }

        // Sinon, on tente de résoudre l'énigme
        String[] answer = new String[args.length - 1];
        System.arraycopy(args, 1, answer, 0, answer.length);

        boolean solvedBefore = puzzle.isSolved();
        puzzle.solve(answer);

        if (puzzle.isSolved() && !solvedBefore) {
            System.out.println("Bravo ! Vous avez résolu l'énigme pour l'objet : " + item.getItemName());
        } else if (!puzzle.isSolved()) {
            System.out.println("Mauvaise réponse. Indice : " + puzzle.getHint());
        }
    }

    // Méthode utilitaire pour normaliser les accents
    private String normalize(String s) {
        if (s == null)
            return "";
        String normalized = Normalizer.normalize(s, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }
}