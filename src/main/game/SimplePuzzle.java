package main.game;


public class SimplePuzzle implements Ipuzzle {
    private final String name;
    private final String solution;
    private boolean solved = false;
    private final String hint;

    public SimplePuzzle(String name, String solution, String hint) {
        this.name = name;
        this.solution = solution;
        this.hint = hint;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean isSolved() {
        return solved;
    }

    // Ajoute en haut de la classe
private Zone zoneToUnlock;

// Ajoute ce setter dans la classe
public void setZoneToUnlock(Zone zone) {
    this.zoneToUnlock = zone;
}

  @Override
public void solve(String[] args) {
    if (args.length == 0) {
        System.out.println("Veuillez entrer une réponse.");
        return;
    }

    String userAnswer = String.join(" ", args).trim().toLowerCase();
    if (userAnswer.equals(solution.toLowerCase())) {
        solved = true;
        // Ajoute ceci :
        if (zoneToUnlock != null) {
            zoneToUnlock.setZoneState(false); // déverrouille la zone
            System.out.println("La zone " + zoneToUnlock.getZoneName() + " est maintenant déverrouillée !");
        }
    }
}

    @Override
    public void reset() {
        solved = false;
    }

    @Override
    public String getHint() {
        return hint;
    }
}
