package days.day4.puzzle1;

import days.day4.entities.Card;
import days.day4.entities.CardBuilder;
import utils.FileUtils;
import utils.WriteUtils;

import java.util.Arrays;
import java.util.List;

public class Puzzle1 {

    public static List<Card> getCards(String text) {

        return Arrays.stream(text.split("\n"))
                .map(card -> {
                    String[] gameCard = card.split(":");
                    String[] numbers = gameCard[1].split("\\|");
                    return CardBuilder.builder()
                            .number(WriteUtils.toInt(gameCard[0].replaceAll("\\D", "")))
                            .winners(
                                    Arrays.stream(numbers[0].split(" ")).filter(n -> !n.isEmpty()).map(WriteUtils::toInt).toList()
                            )
                            .numbers(
                                    Arrays.stream(numbers[1].split(" ")).filter(n -> !n.isEmpty()).map(WriteUtils::toInt).toList()
                            )
                            .build();
                }).toList();
    }

    public static Double calculate(String text) {
        return getCards(text).stream()
                .map(Card::getWinningNumbers)
                .filter(c -> !c.isEmpty())
                .map(c -> Math.pow(2, c.size() - 1))
                .reduce(Double::sum).orElse(-1d);

    }

    public static void demo() {
        String text = FileUtils.demo(4);

        System.out.println(calculate(text));
    }

    public static void solve() {
        String text = FileUtils.content(4);
        System.out.println(calculate(text));
    }
}
