
public class Hand {
    int initialScore;
    Card firstCard;
    Card secondCard;

    /**
     *
     * @param firstCard
     * @param secondCard
     * @param initialScore
     * @return A score indicative of how good a player's starting hand is
     */
    public int calculateInitialHandScore(Card firstCard, Card secondCard, int initialScore) {
        int firstCardNumber = firstCard.number;
        int secondCardNumber = secondCard.number;
        int firstCardSuit = firstCard.suit;
        int secondCardSuit = secondCard.suit;

        // Pair, different suits ex. 6 of hearts, 6 of spades
        if (firstCardNumber == secondCardNumber && firstCardSuit != secondCardSuit) {
            initialScore*=2;
        }

        // Same suit ex. 8 of clubs, 2 of clubs
        if (firstCardSuit == secondCardSuit && firstCardNumber != secondCardNumber) {
            initialScore = firstCardNumber + secondCardNumber;
        }

        // High cards Bonus ex. Ace, King, Queen, Jack
        if (firstCardNumber == 1 || firstCardNumber == 10 || firstCardNumber == 11 || firstCardNumber == 12 || firstCardNumber == 13) {
            initialScore ++;
        }
        if (secondCardNumber == 1 || secondCardNumber == 10 || secondCardNumber == 11 || secondCardNumber == 12 || secondCardNumber == 13) {
            initialScore ++;
        }
        return initialScore;
    }

    /**
     *
     * @param x First Card
     * @param y Second Card
     * This constructor creates a hand with the cards specified
     */
    public Hand(Card x, Card y) {
        firstCard = x;
        secondCard = y;
        initialScore = Math.max(firstCard.number, secondCard.number);
        initialScore = calculateInitialHandScore(firstCard, secondCard, initialScore);
    }

    /**
     * This constructor creates a random hand
     */
    public Hand() {
        Card card1 = new Card();
        Card card2 = new Card();
        boolean isEqual = card1.equals(card2);
        while (isEqual) {
            card2 = new Card();
            if (!card1.equals(card2)) {
                isEqual = false;
            }
        }
        firstCard = card1;
        secondCard = card2;
        initialScore = Math.max(firstCard.number, secondCard.number);
        initialScore = calculateInitialHandScore(firstCard, secondCard, initialScore);
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            Card x = new Card();
//            System.out.println("suit: " + x.suit + " number: " + x.number + " cardName: " + x.cardName);
//            Card y = new Card();
//            System.out.println("suit: " + y.suit + " number: " + y.number + " cardName: " + y.cardName);
//            playerHand hand = new playerHand(x, y);
//            System.out.println("handscore: " + hand.initialScore);
//        }
//    }
}
