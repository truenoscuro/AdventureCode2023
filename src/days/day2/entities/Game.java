package days.day2.entities;

import java.util.List;

public class Game {
    private int num;



    private List<Round> rounds;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    @Override
    public String toString() {
        return "Game "+ num + ": " + rounds.stream().map(Round::toString).reduce((acc,s) -> acc + " ; " +s).orElse("");
    }
}
