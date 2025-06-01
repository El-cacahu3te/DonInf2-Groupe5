package main.game;

public interface Command {
    String getName();
    String getDescription();
    void execute(String[] args);
}
