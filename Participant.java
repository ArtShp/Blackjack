package Blackjack;

import java.util.ArrayList;
import java.util.List;

abstract class Participant {
    List<Card> cards;
    private int aceCounter;

    Participant() {
        cards = new ArrayList<>(10);
        aceCounter = 0;
    }

    void takeCard(Card card) {
        if (card.isAce()) {
            aceCounter++;
        }
        cards.add(card);
    }

    void showCards() {
        for (Card card : cards) {
            System.out.print(card + " ");
        }
        System.out.printf("- (%d)\n", getCardsSum());
        //System.out.println();
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

        int aceCounter = getAceCounter();
        while (sum > 21 && aceCounter > 0) {
            sum -= 10;
            aceCounter--;
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
