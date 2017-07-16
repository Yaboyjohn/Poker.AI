import java.util.ArrayList;

public class Poker {
    int numTurns;
    int numPlayers;
    int firstBetPos;
    int bigBlindPos;
    int smallBlindPos;
    int bigBlindAmount;
    int smallBlindAmount;
    boolean gameOver;
    ArrayList<Player> players = new ArrayList<Player>();

    public int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    //have the constructor call this function to setup all the players
    public void initPlayers(int n) {

    }

    /**
     *
     * @param n Number of desired players to have in this poker game
     * Constructor for a new poker game
     */
    //make another constructor with only n and chipcount and make the initialBB initialSB pos be determined randomly
    public Poker(int n, int chipCount, int initialBigBlindPos, int initialSmallBlindPos) {
        numTurns = 0;
        numPlayers = n;
        bigBlindAmount = initialBigBlindPos;
        smallBlindAmount = initialSmallBlindPos;
        gameOver = false;


        if (numPlayers == 2) {
            smallBlindPos = 0;
            bigBlindPos = 1;
            firstBetPos = 0;

            Player player1 = new Player(chipCount, true, false, true, 0);
            players.add(player1);
            Player player2 = new Player(chipCount, false, true, false, 1);
            players.add(player2);
        }

//        For games involving more than 2 players, implement this later on
//        for (int i = 0; i < n; i++) {
//            Player newPlayer = new Player(chipCount);
//        }
//        smallBlindPos = randomWithRange(0, n - 1);
    }

    public static void main(String[] args) {
        Poker game = new Poker(2, 100, 0, 1);
        while (!game.gameOver) {
            Round newRound = new Round(2, game.players, game.smallBlindPos, game.bigBlindPos, game.firstBetPos,
                    game.smallBlindAmount, game.bigBlindAmount);

            Turn newTurn = new Turn(2, game.players);
            game.numTurns++;
        }
//        System.out.println("WINNER IS: " + winner);
//        System.out.println("Number of turns: " + game.numTurns);
    }
}
