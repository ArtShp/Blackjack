package Blackjack;

class Player extends Participant {
    private final String name;
    private long money;

    Player(String name, long money) {
        super();
        this.name = name;
        this.money = money;
    }

    String getName() {
        return name;
    }

    long getMoney() {
        return money;
    }

    @Override
    void showCards() {
        System.out.print("Your cards:  ");
        super.showCards();
    }

    void takeMoney(int money) {
        this.money += money;
    }

    void giveMoney(int money) {
        this.money -= money;
    }
}
