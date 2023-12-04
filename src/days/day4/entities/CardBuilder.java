package days.day4.entities;

import java.util.List;

public class CardBuilder {

    private final Card card;

    private CardBuilder() {
        card = new Card();
    }

    public static CardBuilder builder() {
        return new CardBuilder();
    }

    public CardBuilder number(int number) {
        card.setNumber(number);
        return this;
    }

    public CardBuilder numbers(List<Integer> numbers) {
        card.setNumbers(numbers);
        return this;
    }

    public CardBuilder winners(List<Integer> winners) {
        card.setWinnings(winners);
        return this;
    }

    public Card build() {
        return card;
    }
}
