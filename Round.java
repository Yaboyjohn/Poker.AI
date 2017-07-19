import java.util.ArrayList;

public class Round {
    int numPlayers;
    boolean roundOver;
    int pot;

    public boolean simulateOneTurn(int n, ArrayList<Player> players, int bigBlindPos, int smallBlindPos,
                                   int firstBetPos, int smallBlindAmount, int bigBlindAmount, Deck deck) {
        Turn turn = new Turn(n, players, bigBlindPos, smallBlindPos, firstBetPos, bigBlindAmount,
                smallBlindAmount, this, deck);
        roundOver = true;
        return true;
    }

    public Round(int n, ArrayList<Player> players, int smallBlindPos, int bigBlindPos, int firstBetPos,
                 int smallBlindAmount, int bigBlindAmount) {
        numPlayers = n;
        roundOver = false;
        pot = 0;
        Deck deck = new Deck();
        while (!roundOver) {
            simulateOneTurn(n, players, bigBlindPos, smallBlindPos, firstBetPos, smallBlindAmount, bigBlindAmount, deck);
            for (Player p : players) {
                System.out.println("hand: " + p.hand.toString() + " | handscore: " + p.handScore);
                System.out.println("player numChips: " + p.numChips);
                System.out.println("player status: " + p.status);
                System.out.println("bigblind: " + p.isBigBlind + " smallblind: " + p.isSmallBlind);
                System.out.println("position: " + p.position);
                System.out.println("Pot: " + pot);
            }
        }
    }
}

