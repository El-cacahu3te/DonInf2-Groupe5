package main.game;

public interface Ipuzzle {
    String getName();
    Boolean isSolved();
    void solve(String[] args);
    void reset();
    String getHint();
}