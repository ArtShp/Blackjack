import java.util.LinkedList;

public abstract class Participant {
    protected LinkedList<Card> cards;
    protected int aceCounter;

    public Participant() {
        cards = new LinkedList<>();
        aceCounter = 0;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public void takeCard(Card card) {
        if (card.isAce()) {
            aceCounter++;
        }
        cards.addLast(card);
    }

    public void showCards() {
        for (Card card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    public void foldCards() {
        cards.clear();
        aceCounter = 0;
    }

    public int getCardsSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getCost();
        }
        return sum;
    }

    public int getAceCounter() {
        return aceCounter;
    }

    public boolean checkBlackjack() {
        return getCardsSum() == 21 && cards.size() == 2;
    }
}
