package Blackjack;

class Card {
    private final char suit;
    private final char value;
    private int cost;

    Card(char suit, char value) {
        this.suit = suit;
        this.value = value;
        try {
            this.cost = Integer.parseInt(value+"");
        } catch (NumberFormatException e) {
            if (value != 'A') {
                this.cost = 10;
            } else {
                this.cost = 11;
            }
        }
    }

    int getCost() {
        return cost;
    }

    boolean isAce() {
        return value == 'A';
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
