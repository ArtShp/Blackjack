import java.util.Scanner;

public class Blackjack {
    private Dealer dealer;
    private Player player;
    private Deck deck;
    private Scanner in;

    public void startGame() {
        in = new Scanner(System.in);
        dealer = new Dealer();

        System.out.println("----------Blackjack----------");

        System.out.print("Enter your name: ");
        String playerName = in.next();

        System.out.print("Enter your balance($): ");
        long playerBalance = in.nextLong();

        player = new Player(playerName, playerBalance);

        System.out.printf("Hi, %s!\n", player.getName());
        System.out.println("Game starts now.\n");

        initGame();
    }

    private void initGame() {
        
    }
}
