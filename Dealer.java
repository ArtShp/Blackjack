package Blackjack;

class Dealer extends Participant {
    Dealer() {
        super();
    }

    void showFirstCard() {
        System.out.print("Dealer card: ");
        System.out.println(cards.get(0));
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
