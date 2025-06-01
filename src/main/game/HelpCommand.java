package main.game;

public class HelpCommand implements Command {
    private final CommandRegistry registry;

    public HelpCommand(CommandRegistry registry) {
        this.registry = registry;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Affiche la liste des commandes disponibles.";
    }

    @Override
    public void execute(String[] args) {
        registry.listCommands();
    }
}
