import java.util.LinkedList;

public abstract class Participant {
    protected LinkedList<Card> cards;

    public Participant() {
        cards = new LinkedList<>();
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public void takeCard(Card card) {
        cards.addLast(card);
    }

    public void showCards() {
        for (Card card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
