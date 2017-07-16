import java.util.ArrayList;

public class Turn {
    int numPlayers;
    int numPlayersFinishedWithTurn;
    Boolean turnOver;
    Boolean roundWinner;

    /**
     *
     * @param players ArrayList of players still involved in the game
     * @param bigBlindPos Index of player who is Big Blind for the turn
     * @param smallBlindPos Index of player who is Small Blind for the turn
     * @param bigBlindAmount Amount the Big Blind pays
     * @param smallBlindAmount Amount the Small Blind pays
     * @param currRound Round object this turn updates
     * This method deducts the blind amounts from the blinds players and increments the round pot
     */
    public void initBlinds(ArrayList<Player> players, int bigBlindPos, int smallBlindPos, int bigBlindAmount,
                             int smallBlindAmount, Round currRound) {
        Player bigBlindPlayer = players.get(bigBlindPos);
        Player smallBlindPlayer = players.get(smallBlindPos);
        bigBlindPlayer.numChips -= bigBlindAmount;
        smallBlindPlayer.numChips -= smallBlindAmount;

        int totalBlindsAmount = bigBlindAmount + smallBlindAmount;
        currRound.pot += totalBlindsAmount;
    }

    public void calculateMoveChoice(Player player, boolean mustCallToMatch) {
        if (!mustCallToMatch) {
            if (player.handScore >= 20) {
                player.status = "BET";
            } else if (player.handScore >= 12 && player.handScore <= 20) {
                player.status = "CHECK";
            } else {
                player.status =  "FOLD";
            }
        }

    }

    public ArrayList<Player> preFlopBetting(ArrayList<Player> players, int firstBetPos) {

    }

    public Turn(int n, ArrayList<Player> players, int bigBlindPos, int smallBlindPos, int firstBetPos,
                int bigBlindAmount, int smallBlindAmount, Round currRound) {
        numPlayers = n;
        numPlayersFinishedWithTurn = 0;
        turnOver = false;
        roundWinner = false;

        initBlinds(players, bigBlindPos, smallBlindPos, bigBlindAmount, smallBlindAmount, currRound);
    }
}
