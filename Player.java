public class Player extends Participant {
    private final String name;
    private long money;

    public Player(String name, long money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public long getMoney() {
        return money;
    }
}
