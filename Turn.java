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
        // If the player is the big blind, it doesn't make sense to fold, so their 2 options are check or raise
        if (player.isBigBlind && !mustCallToMatch) {
            System.out.println("BB route");
            if (player.handScore >= 20) {
                player.status = "RAISED";
                return "RAISED";
            } else {
                player.status = "CHECKED";
                return "CHECKED";
            }
        }

        if (player.isSmallBlind && !mustCallToMatch) {
            System.out.println("SB route");
            if (player.handScore >= 20) {
                player.status = "RAISED";
                return "RAISED";
            } else if (player.handScore >= 11 && player.handScore <= 20) {
                player.status = "CALLED";
                return "CALLED";
            } else {
                player.status = "FOLDED";
                return "FOLDED";
            }
        }

        if (!mustCallToMatch) {
            System.out.println("no one raised");
            if (player.handScore >= 20) {
                player.status = "RAISED";
                return "RAISED";
            } else if (player.handScore >= 11 && player.handScore <= 20) {
                player.status = "CHECKED";
                return "CHECKED";
            } else {
                player.status =  "FOLDED";
                return "FOLDED";
            }
        }
        System.out.println("someone raised");
        // Here, a previous player raised, so this current player must call to match and stay active in the round
        if (player.handScore >= 24) {
            player.status = "RAISED";
            return "RAISED";
        } else {
            player.status = "FOLDED";
            return "FOLDED";
        }
    }

    public ArrayList<Player> preFlopBetting(ArrayList<Player> players, int firstBetPos, Round currRound, int smallBlindAmount) {
        boolean mustCallToMatch = false;
        for (int i = firstBetPos; i < players.size(); i++) {
            System.out.println("i1: " + i);
            Player player = players.get(i);

            // Player is small blind so BET means calling the big blind
            if (calculateMoveChoice(player, mustCallToMatch).equals("CALLED") && player.isSmallBlind) {
                player.numChips -= smallBlindAmount;
                currRound.pot += smallBlindAmount;
            } else if (calculateMoveChoice(player, mustCallToMatch).equals("RAISED") && player.isSmallBlind) {
                player.numChips -= (betAmount + smallBlindAmount);
                currRound.pot += (betAmount + smallBlindAmount);
                mustCallToMatch = true;
            } else if (calculateMoveChoice(player, mustCallToMatch).equals("RAISED")) {
                player.numChips -= betAmount;
                currRound.pot += betAmount;
                mustCallToMatch = true;
            } else if (calculateMoveChoice(player, mustCallToMatch).equals("CHECKED")){
                System.out.println("CHECKED");
            } else {
                System.out.println("FOLDED");
                System.out.println("hand: " + player.hand.toString() + " | handscore: " + player.handScore);
                System.out.println("player numChips: " + player.numChips);
                System.out.println("player status: " + player.status);
                System.out.println("bigblind: " + player.isBigBlind + " smallblind: " + player.isSmallBlind);
                System.out.println("position: " + player.position);
                System.out.println("Pot: " + currRound.pot);
                player.turnFinished = true;
                players.remove(i);
            }
        }

        //this possibly might not have as many conditions because the blinds are taken care of? need to loook into this (not used since im testing 2 ppl rn)
        for (int i = 0; i < firstBetPos; i++) {
            System.out.println("i2: " + i);
            Player player = players.get(i);
            if (calculateMoveChoice(player, mustCallToMatch).equals("RAISED")) {
                player.numChips -= betAmount;
                currRound.pot += betAmount;
                mustCallToMatch = true;
            }
        }

        // Everyone folded except for one person
        if (players.size() == 1) {
            Player p = players.get(0);
            p.status = "WON";
        }
        return players;
    }

    public Turn(int n, ArrayList<Player> players, int bigBlindPos, int smallBlindPos, int firstBetPos,
                int bigBlindAmount, int smallBlindAmount, Round currRound) {
        numPlayers = n;
        numPlayersFinishedWithTurn = 0;
        turnOver = false;
        roundWinner = false;

        initBlinds(players, bigBlindPos, smallBlindPos, bigBlindAmount, smallBlindAmount, currRound);
        preFlopBetting(players, firstBetPos, currRound, smallBlindAmount);
    }
}
