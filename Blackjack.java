import java.util.Scanner;

public class Blackjack {
    private Dealer dealer;
    private Player player;
    private Deck deck;

    private int curBet;
    private int minBet;
    private int maxBet;

    private Scanner in;

    public void startGame() {
        in = new Scanner(System.in);
        dealer = new Dealer();

        System.out.println("----------Blackjack----------");

        setupGame();
        initPlayer();

        System.out.printf("\nHi, %s!\n", player.getName());
        System.out.println("Game starts now.");

        startGameLoop();
    }

    private void setupGame() {
        System.out.print("Enter the minimum bet($): ");
        minBet = in.nextInt();
        System.out.print("Enter the maximum bet($): ");
        maxBet = in.nextInt();
    }

    private void initPlayer() {
        System.out.print("\nEnter your name: ");
        String playerName = in.next();

        System.out.print("Enter your start balance($): ");
        long playerBalance = in.nextLong();

        player = new Player(playerName, playerBalance);
    }

    private void startGameLoop() {
        int gameNumber = 1;

        while (true) {
            if (!checkMoney()) {
                System.out.println("\nYou have not enough money to play!");
                break;
            }

            System.out.printf("\n----------GAME %d----------\n", gameNumber);

            placeBet();

            deck = new Deck();
            giveStartCards();

            player.showCards();
            dealer.showFirstCard();

            if (!offerSurrender()) {
                if (player.checkBlackjack()) {
                    if (dealer.isFirstCardAce()) {

                    } else {
                        System.out.print("You have a Blackjack. ");
                        System.out.printf("You've received %d$.", curBet*1.5);
                    }
                } else {

                }
            }

            if (offerGameEnd()) {break;}
            foldCards();
            gameNumber++;
        }

        System.out.println("\n----------GAME OVER----------");
    }

    private boolean checkMoney() {
        return player.getMoney() >= minBet;
    }

    private void placeBet() {
        System.out.printf("\nYour balance: %d$.\n", player.getMoney());
        System.out.printf("Enter your bet(%d - %d$): ", minBet, Math.min(player.getMoney(), maxBet));

        curBet = in.nextInt();
        while (curBet < minBet || curBet > maxBet || curBet > player.getMoney()) {
            System.out.print("Your bet is incorrect! Try again: ");
            curBet = in.nextInt();
        }
        player.giveMoney(curBet);
        System.out.printf("\nYou've bet %d$.\n\n", curBet);
    }

    private void giveStartCards() {
        player.takeCard(deck.giveCard());
        player.takeCard(deck.giveCard());
        dealer.takeCard(deck.giveCard());
        dealer.takeCard(deck.giveCard());
    }

    private void foldCards() {
        player.foldCards();
        dealer.foldCards();
    }

    private boolean offerGameEnd() {
        System.out.print("\nDo you want to continue playing(y/N): ");
        return in.next().equals("N");
    }

    private boolean offerSurrender() {
        if (dealer.isFirstCardAce()) {
            return false;
        }

        System.out.print("\nDo you want to surrender(Y/n): ");
        if (in.next().equals("Y")) {
            player.takeMoney(curBet/2);
            System.out.printf("You've surrendered and lost %d$.\n", curBet/2);
            return true;
        } else {
            return false;
        }
    }
}
