import java.util.ArrayList;

public class Turn {
    int numPlayers;
    int numPlayersFinishedWithTurn;
    Boolean turnOver;
    Boolean roundWinner;
    int betAmount = 10;

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

    public String calculateMoveChoice(Player player, boolean mustCallToMatch) {
        if (!mustCallToMatch) {
            if (player.handScore >= 20) {
                player.status = "BET";
                return "BET";
            } else if (player.handScore >= 12 && player.handScore <= 20) {
                player.status = "CHECK";
                return "CHECK";
            } else {
                player.status =  "FOLD";
                return "FOLD";
            }
        }

        // Here, the a previous player raised, so this current player must call to match and stay active in the round
        if (player.handScore >= 24) {
            player.status = "BET";
            return "BET";
        } else {
            player.status = "FOLD";
            return "FOLD";
        }
    }

    public ArrayList<Player> preFlopBetting(ArrayList<Player> players, int firstBetPos, Round currRound) {
        boolean playerBet = false;
        for (int i = firstBetPos; i < players.size(); i++) {
            Player player = players.get(i);
            if (calculateMoveChoice(player, playerBet).equals("BET")) {
                player.numChips -= betAmount;
                currRound.pot += betAmount;
                playerBet = true;
            }
        }
        for (int i = 0; i < firstBetPos; i++) {
            Player player = players.get(i);
            if (calculateMoveChoice(player, playerBet).equals("BET")) {
                player.numChips -= betAmount;
                currRound.pot += betAmount;
                playerBet = true;
            }
        }
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
