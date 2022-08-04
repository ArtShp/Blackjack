package Blackjack;

import java.util.Collections;
import java.util.LinkedList;

class Deck {
    private final LinkedList<Card> cards;
    private static final char[] CARD_SUITS = {'♠', '♣', '♥', '♦'};
    private static final char[] CARD_VALUES = {'2', '3', '4', '5', '6', '7', '8', '9', 'D', 'J', 'Q', 'K', 'A'};

    Deck() {
        cards = new LinkedList<>();
        for (char value : CARD_VALUES) {
            for (char suit : CARD_SUITS) {
                cards.addFirst(new Card(suit, value));
            }
        }
        Collections.shuffle(cards);
    }

    LinkedList<Card> getCards() {
        return cards;
    }

    Card giveCard() {
        return cards.pollLast();
    }
}
