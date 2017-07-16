import java.util.ArrayList;

public class Round {
    int numPlayers;
    boolean roundOver;
    int pot;

    public boolean simulateOneTurn(int n, ArrayList<Player> players, int bigBlindPos, int smallBlindPos,
                                   int firstBetPos, int smallBlindAmount, int bigBlindAmount) {
        Turn turn = new Turn(n, players, bigBlindPos, smallBlindPos, firstBetPos, bigBlindAmount,
                smallBlindAmount, this);
    }

    public Round(int n, ArrayList<Player> players, int smallBlindPos, int bigBlindPos, int firstBetPos,
                 int smallBlindAmount, int bigBlindAmount) {
        numPlayers = n;
        roundOver = false;
        pot = 0;
        while (!roundOver) {
            simulateOneTurn(n, players, bigBlindPos, smallBlindPos, firstBetPos, smallBlindAmount, bigBlindAmount);
        }
    }
}

