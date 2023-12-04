package days.day4.puzzle2;

import days.day4.entities.Card;
import days.day4.puzzle1.Puzzle1;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class Puzzle2 {


    public static Card pop(List<Card> cards) {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    //Esto se puede resolver de manera lineal pero queria hacer cosas paralelas uwu
    public static int count(String text) {
        List<Card> orderCards = Puzzle1.getCards(text);
        return Puzzle1.getCards(text).stream().parallel().map(c -> {
                    List<Card> visitets = new ArrayList<>();
                    visitets.add(c);
                    int count = 0;
                    while (!visitets.isEmpty()) {
                        Card card = pop(visitets);
                        count++;
                        visitets.addAll(
                                orderCards.subList(card.getNumber(),
                                        card.getWinningNumbers().size() + card.getNumber())
                        );
                    }
                    return count;
                })
                .reduce(Integer::sum).orElse(-1);
    }

    public static void demo() {
        String text = FileUtils.demo(4);
        System.out.println(count(text));
    }

    public static void solve() {
        String text = FileUtils.content(4);
        System.out.println(count(text));
    }

}
