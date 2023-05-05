import java.util.*;
import java.io.*;

public class Game{

    public static final int MAX_PLAY = 1;
    public static final int MIN_PLAY = 0;

    public static final String X = "X";
    public static final String O = "O";

    public static final int RANDOM = 0;
    public static final int MINIMAX = 1;
    public static final int ALPHABETA = 2;
    public static final int MEM = 3;
    public static final int USER = 4;

    Board board;
    HashMap<Integer, Player> players;
    int turn;

    public Game(int t1, int t2) {
        board = new Board();

        players = new HashMap<Integer, Player>();

        switch (t1) { //"O", minimizing player
            case RANDOM:
                players.put(0, new RandomPlayer(O, MIN_PLAY)); 
                break;
            case MINIMAX:
                players.put(0, new MinimaxPlayer(O, MIN_PLAY)); 
                break;
            case ALPHABETA:
                players.put(0, new ABPlayer(O, MIN_PLAY)); 
                break;
            case MEM:
                players.put(0, new MemPlayer(O, MIN_PLAY)); 
                break;
            case USER:
                players.put(0, new UserPlayer(O, MIN_PLAY)); 
                break;
        }
        switch (t2) { //"X", maximizing player
            case RANDOM:
                players.put(1, new RandomPlayer(X, MAX_PLAY)); 
                break;
            case MINIMAX:
                players.put(1, new MinimaxPlayer(X, MAX_PLAY)); 
                break;
            case ALPHABETA:
                players.put(1, new ABPlayer(X, MAX_PLAY)); 
                break;
            case MEM:
                players.put(1, new MemPlayer(X, MAX_PLAY)); 
                break;
            case USER:
                players.put(1, new MemPlayer(X, MAX_PLAY)); 
                break;
        }

        turn = (int) (Math.random() * 2); //randomize first player
    }

    public void nextTurn() {
        Player curPlayer = players.get(turn);
        curPlayer.play(board);
        turn = (turn + 1) % 2; //swap turns
    }

    public int playGame() {
        while (board.boardValue() == 0 && board.empty.size() != 0) {
            nextTurn();
            // System.out.println(board);
        }
        return board.boardValue();
    }
}