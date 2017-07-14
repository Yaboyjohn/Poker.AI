import java.util.HashSet;

public class Flop {
    int numCardsInFlop;
    HashSet<Card> cards = new HashSet<Card>();

    /**
     * Adds a card to the flop
     */
    public void addCard() {
        Card card = new Card();
        if (cards.isEmpty()) {
            cards.add(card);
            numCardsInFlop++;
            return;
        }
        boolean addSuccess = false;
        while (!addSuccess) {
            for (Card flopCard : cards) {
                if (!card.equals(flopCard)) {
                    addSuccess = true;
                } else {
                    card = new Card();
                }
            }
        }
        cards.add(card);
        numCardsInFlop++;
    }

    /**
     * Initializes the flop to 3 cards at the start of a turn
     */
    public void initFlop() {
        addCard();
        addCard();
        addCard();
    }

    /**
     * Clears all cards in a flop, prepares flop for start of next turn
     */
    public void clearFlop() {
        cards.clear();
        numCardsInFlop = 0;
    }

    public Flop() {
        initFlop();
        numCardsInFlop = 3;
    }

//    public static void main(String[] args) {
//        Flop flop = new Flop();
//        for (Card card : flop.cards) {
//            System.out.println(card.cardName);
//        }
//        System.out.println("num: " + flop.numCardsInFlop);
//        flop.addCard();
//        System.out.println("num: " + flop.numCardsInFlop);
//        flop.clearFlop();
//        System.out.println("num: " + flop.numCardsInFlop);
//    }
}
