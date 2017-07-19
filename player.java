import java.util.ArrayList;

public class Player {
    int numChips;
    int position;
    boolean isTurn;
    Hand hand;
    int handScore;
    int currBet;
    boolean isBigBlind;
    boolean isSmallBlind;
    boolean turnFinished;
    boolean isWinner;
    boolean eliminated;
    String status;
    ArrayList<Card> playerCombinations = new ArrayList<Card>();

    public Player(int initialChipCount, boolean isFirstPlayer, boolean bigBlind, boolean smallBlind, int initPosition) {
        numChips = initialChipCount;
        position = initPosition;
        isTurn = isFirstPlayer;
        hand = null;
        handScore = 0;
        currBet = 0;
        isBigBlind = bigBlind;
        isSmallBlind = smallBlind;
        status = null;
        turnFinished = false;
        isWinner = false;
        eliminated = false;
    }

    public String toString() {
        return ("position: " + position + "| numChips: " + this.numChips + "| hand: " + hand.toString() + "| handscore: " + handScore + "| isBigBlind: " + isBigBlind + "| isSmallBlind: " + isSmallBlind);
    }

//    public static void main(String[] args) {
//        Player p = new Player(100, true, false, false);
//        System.out.println("card1: " + p.hand.firstCard.cardName + " card2: " + p.hand.secondCard.cardName);
//        System.out.println("numchips: " + p.numChips + " isTurn: " + p.isTurn + " handscore: " + p.handScore);
//    }
}
