package Blackjack;

import java.util.LinkedList;

abstract class Participant {
    LinkedList<Card> cards;
    private int aceCounter;

    Participant() {
        cards = new LinkedList<>();
        aceCounter = 0;
    }

    LinkedList<Card> getCards() {
        return cards;
    }

    void takeCard(Card card) {
        if (card.isAce()) {
            aceCounter++;
        }
        cards.addLast(card);
    }

    void showCards() {
        for (Card card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    void foldCards() {
        cards.clear();
        aceCounter = 0;
    }

    int getCardsSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getCost();
        }
        return sum;
    }

    int getAceCounter() {
        return aceCounter;
    }

    boolean checkBlackjack() {
        return getCardsSum() == 21 && cards.size() == 2;
    }
}
