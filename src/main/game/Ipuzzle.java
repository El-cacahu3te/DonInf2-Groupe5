package main.game;

public interface Ipuzzle {
    String getName();
    Boolean isSolved();
    void solve(String[] args);
    void reset();
    
    // Additional methods can be added as needed
    // For example, to check if the puzzle is solvable or to get hints
    String getHint();
}