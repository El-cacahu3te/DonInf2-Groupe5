package main.game;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private Map<String, Command> commands = new HashMap<>();

    public void register(Command command) {
        commands.put(command.getName(), command);
    }

    public void executeCommand(String input) {
        String[] parts = input.trim().split(" ");
        String name = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, args.length);

        Command command = commands.get(name);
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Commande inconnue: " + name);
        }
    }

    public void listCommands() {
        for (Command cmd : commands.values()) {
            System.out.println("- " + cmd.getName() + " : " + cmd.getDescription());
        }
    }
}
