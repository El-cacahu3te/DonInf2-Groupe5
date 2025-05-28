package main.game;

import java.util.HashMap;

public class CommandRegistry {
    private HashMap<String,Command> commandRegistry =  new HashMap<>(); 

    public void addCommand(String name, Command command) {
        commandRegistry.put(name, command);
    }

}
