import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cardsInPlay = new ArrayList<Card>();

    public boolean doesCardExistAlready(ArrayList<Card> cards, Card cardToAdd) {
        for (Card c : cards) {
            if (c.equals(cardToAdd)) {
                return true;
            }
        }
        return false;
    }

    public Card generateUniqueCard(ArrayList<Card> cards) {
        Card card = new Card();
        while (doesCardExistAlready(cards, card)) {
            card = new Card();
        }
        cards.add(card);
        return card;
    }

    public void initHands(ArrayList<Player> players) {
        for (Player p : players) {
            Card firstCard = generateUniqueCard(cardsInPlay);
            Card secondCard = generateUniqueCard(cardsInPlay);
            p.hand = new Hand(firstCard, secondCard);
            p.hand.firstCard = firstCard;
            p.hand.secondCard = secondCard;
            p.handScore = p.hand.initialScore;
            p.playerCombinations.add(firstCard);
            p.playerCombinations.add(secondCard);
            System.out.println("player: " + p.toString());
        }
    }

    public Card dealCard() {
        Card c = generateUniqueCard(cardsInPlay);
        return c;
    }
}
