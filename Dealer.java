package Blackjack;

class Dealer extends Participant {
    Dealer() {
        super();
    }

    void showFirstCard() {
        System.out.print("Dealer card: ");
        System.out.print(cards.get(0));
        System.out.printf(" - (%d)\n", cards.get(0).getCost());
    }

    boolean isFirstCardAce() {
        return cards.get(0).isAce();
    }

    @Override
    void showCards() {
        System.out.print("Dealer cards: ");
        super.showCards();
    }
}
