public class Dealer extends Participant {
    public Dealer() {
        super();
    }

    public void showFirstCard() {
        System.out.print("Dealer card: ");
        System.out.println(cards.peekFirst());
    }

    @Override
    public void showCards() {
        System.out.print("Dealer cards: ");
        super.showCards();
    }
}
