package days.day4.entities;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private int number;

    private List<Integer> winnings;

    private List<Integer> numbers;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Integer> getWinnings() {
        return winnings;
    }

    public void setWinnings(List<Integer> winnings) {
        this.winnings = winnings;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getWinningNumbers() {

        return this.winnings.stream().filter(n -> numbers.contains(n)).toList();
    }

    @Override
    public String toString() {
        return "Card " + number + ": "
                + winnings.stream().map(n -> n + "").reduce((acc, n) -> acc + " " + n).orElse("")
                + " | "
                + numbers.stream().map(n -> n + "").reduce((acc, n) -> acc + " " + n).orElse("")
                + " ; "
                + getWinningNumbers().stream().map(n -> n + "").reduce((acc, n) -> acc + " " + n).orElse("");
    }


}
