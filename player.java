import java.util.ArrayList;

public class Player {
    int numChips;
    int position;
    boolean isTurn;
    Hand hand;
    int handScore;
    int currBet;
    boolean isFolded;
    boolean isBet;
    boolean isRaise;
    boolean isBigBlind;
    boolean isSmallBlind;
    boolean isChecked;
    boolean turnFinished;
    boolean isWinner;
    boolean eliminated;
    ArrayList<Card> playerCombinations = new ArrayList<Card>();

    public Player(int initialChipCount, boolean isFirstPlayer, boolean bigBlind, boolean smallBlind) {
        numChips = initialChipCount;
        boolean isTurn = isFirstPlayer;
        hand = new Hand();
        handScore = hand.initialScore;
        currBet = 0;
        isFolded = false;
        isBet = false;
        isRaise = false;
        isBigBlind = bigBlind;
        isSmallBlind = smallBlind;
        isChecked = false;
        turnFinished = false;
        playerCombinations.add(hand.firstCard);
        playerCombinations.add(hand.secondCard);
    }

//    public static void main(String[] args) {
//        Player p = new Player(100, true, false, false);
//        System.out.println("card1: " + p.hand.firstCard.cardName + " card2: " + p.hand.secondCard.cardName);
//        System.out.println("numchips: " + p.numChips + " isTurn: " + p.isTurn + " handscore: " + p.handScore);
//    }
}
