
public class playerHand {
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
    int calculateInitialHandScore(Card firstCard, Card secondCard, int initialScore) {
        int firstCardNumber = firstCard.number;
        int secondCardNumber = secondCard.number;
        int firstCardSuit = firstCard.suit;
        int secondCardSuit = secondCard.suit;

        // Pair, different suits
        if (firstCardNumber == secondCardNumber && firstCardSuit != secondCardSuit) {
            initialScore*=2;
        }

        // Pair, same suit
        if (firstCardNumber == secondCardNumber && firstCardSuit == secondCardSuit) {
            initialScore*=2;

            // Pair, high cards
            if (firstCardNumber == 1 || firstCardNumber == 10 || firstCardNumber == 11 || firstCardNumber == 12) {
                initialScore ++;
            }
        }

        // Same suit
        if (firstCardSuit == secondCardSuit && firstCardNumber != secondCardNumber) {
            initialScore+=2;
        }
        return initialScore;
    }

    playerHand(Card x, Card y) {
        firstCard = x;
        secondCard = y;
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
