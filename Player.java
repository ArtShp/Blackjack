public class Player extends Participant {
    private final String name;
    private long money;

    public Player(String name, long money) {
        super();
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public long getMoney() {
        return money;
    }

    @Override
    public void showCards() {
        System.out.print("Your cards:  ");
        super.showCards();
    }

    public void takeMoney(int money) {
        this.money += money;
    }

    public void giveMoney(int money) {
        this.money -= money;
    }

    public boolean checkSplit() {
        return cards.peekFirst().getCost() == cards.peekLast().getCost();
    }
}
