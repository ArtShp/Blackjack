package Blackjack;

class Dealer extends Participant {
    Dealer() {
        super();
    }

    void showFirstCard() {
        System.out.print("Dealer card: ");
        System.out.println(cards.peekFirst());
    }

    boolean isFirstCardAce() {
        return cards.peekFirst().isAce();
    }

    @Override
    void showCards() {
        System.out.print("Dealer cards: ");
        super.showCards();
    }
}
