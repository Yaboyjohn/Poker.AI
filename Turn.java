import java.util.ArrayList;

public class Turn {
    int numPlayers;
    int numPlayersFinishedWithTurn;
    Boolean gameOver;

    public Turn(int n, ArrayList<Player> players) {
        numPlayers = n;
        numPlayersFinishedWithTurn = 0;
        gameOver = false;
    }


}
