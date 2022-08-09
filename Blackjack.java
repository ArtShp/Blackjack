package Blackjack;

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
        System.out.println("----------BLACKJACK----------");

        setupGame();
        initPlayer();

        System.out.printf("\nHi, %s!\n", player.getName());
        System.out.println("Game starts now.");

        startGameLoop();
    }

    private void setupGame() {
        in = new Scanner(System.in);
        dealer = new Dealer();

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

            if (player.checkBlackjack()) {
                if (dealer.isFirstCardAce()) {
                    System.out.println("You have a Blackjack. Dealer has first card Ace.");
                    System.out.print("Do you want to take money now(Y/N): ");
                    if (in.next().equals("Y")) {
                        System.out.printf("You've received %d$.\n", curBet);
                        player.winMoney(curBet*2);
                    } else {
                        continueGame();
                    }
                } else {
                    System.out.println("You have a Blackjack.");
                    System.out.printf("You've received %d$.\n", curBet*3/2);
                    player.winMoney(curBet*5/2);
                }
            } else {
                continueGame();
            }

            if (offerGameEnd()) {break;}
            foldCards();
            gameNumber++;
        }

        System.out.println("\n----------GAME OVER----------\n");
        showPlayerResults();
        System.out.println("\n----------BLACKJACK----------");
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
        player.looseMoney(curBet);
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

    /*
    private boolean offerSurrender() {
        if (dealer.isFirstCardAce()) {
            return false;
        }

        System.out.print("\nDo you want to surrender(Y/n): ");
        if (in.next().equals("Y")) {
            player.winMoney(curBet/2);
            System.out.printf("You've surrendered and lost %d$.\n", curBet/2);
            return true;
        } else {
            return false;
        }
    }
    */

    private void continueGame() {
        System.out.println();
        while (true) {
            player.showCards();

            System.out.print("\nDo you want to take a card(y/N): ");
            if (in.next().equals("y")) {
                player.takeCard(deck.giveCard());

                if (player.getCardsSum() > 21) {
                    player.showCards();
                    System.out.println("\nYou have an overflow(more than 21)!");
                    System.out.printf("You've lost and lost %d$.\n", curBet);
                    return;
                }
            } else {
                break;
            }
        }

        System.out.println("\nNow is dealer's turn.");

        while (dealer.getCardsSum() < 17) {
            dealer.takeCard(deck.giveCard());
        }

        player.showCards();
        dealer.showCards();

        int playerCardsSum = player.getCardsSum();
        int dealerCardsSum = dealer.getCardsSum();

        if (dealerCardsSum > 21) {
            System.out.println("\nDealer has an overflow(more than 21)!");
            System.out.printf("You have won and earned %d$.\n", curBet);
            player.winMoney(curBet*2);
        } else {
            if (playerCardsSum > dealerCardsSum) {
                System.out.printf("\nYou have won and earned %d$.\n", curBet);
                player.winMoney(curBet*2);
            } else if (playerCardsSum < dealerCardsSum) {
                System.out.printf("\nYou have lost and lost %d$.\n", curBet);
            } else {
                System.out.println("\nYou have a draw and your bet was returned.");
                player.winMoney(curBet);
            }
        }
    }

    private void showPlayerResults() {
        System.out.printf("Your final balance: %d$\n", player.getMoney());
        System.out.printf("Good bye, %s!\n", player.getName());
    }
}
