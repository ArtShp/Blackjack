package Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    private final List<Card> cards;
    private static final char[] CARD_SUITS = {'♠', '♣', '♥', '♦'};
    private static final char[] CARD_VALUES = {'2', '3', '4', '5', '6', '7', '8', '9', 'D', 'J', 'Q', 'K', 'A'};

    Deck() {
        cards = new ArrayList<>(52);
        for (char value : CARD_VALUES) {
            for (char suit : CARD_SUITS) {
                cards.add(new Card(suit, value));
            }
        }
        Collections.shuffle(cards);
    }

    Card giveCard() {
        return cards.remove(cards.size()-1);
    }
}
