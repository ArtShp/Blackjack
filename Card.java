public class Card {
    private final char suit;
    private final char value;
    private int cost;

    public Card(char suit, char value) {
        this.suit = suit;
        this.value = value;
        try {
            this.cost = value - '0';
        } catch (NumberFormatException e) {
            if (value != 'A') {
                this.cost = 10;
            } else {
                this.cost = 11;
            }
        }
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        if (value != 'D') {
            return "" + value + suit;
        } else {
            return "10" + suit;
        }
    }
}
