public class Card {
    String cardName;
    String suitName;
    int suit;
    int number;

    // This function was found on https://stackoverflow.com/questions/7961788/math-random-explained
    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    /**
     *
     * @param number
     * @param suitName
     * @return The proper name of the card
     */
    String convertToCardName(int number, String suitName) {
        String properCardName;
        if (number > 1 && number < 10) {
            properCardName = number + " of " + suitName;
        } else if (number == 1) {
            properCardName = "Ace of " + suitName;
        } else if (number == 10) {
            properCardName = "Jack of " + suitName;
        } else if (number == 11) {
            properCardName = "Queen of " + suitName;
        } else {
            properCardName = "King of " + suitName;
        }
        return properCardName;
    }

    /**
     *
     * @param x
     * @param y
     * @return A card with the provided suit and number
     */
    Card(int x, int y) {
        suit = x;
        number = y;
        if (suit == 1) {
            suitName = "Diamonds";
        } else if (suit == 2) {
            suitName = "Clubs";
        } else if (suit == 3) {
            suitName = "Hearts";
        } else if (suit == 4) {
            suitName = "Spades";
        } else {
            System.out.println("Number must be between 1 and 4");
        }
        cardName = convertToCardName(number, suitName);
    }

    /**
     * @return A randomly generated card
     */
    Card() {
        this.suit = randomWithRange(1,4);
        this.number = randomWithRange(1, 12);
        if (suit == 1) {
            suitName = "Diamonds";
        } else if (suit == 2) {
            suitName = "Clubs";
        } else if (suit == 3) {
            suitName = "Hearts";
        } else {
            suitName = "Spades";
        }
        cardName = convertToCardName(number, suitName);
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            Card x = new Card();
//            System.out.println("suit: " + x.suit + " number: " + x.number + " cardName: " + x.cardName);
//        }
//
//    }

}
