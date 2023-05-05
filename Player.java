import java.util.*;
import java.io.*;

public abstract class Player{
    String mark; //X, O
    int type; //MIN_PLAY, MAX_PLAY

    public static final int MAX_PLAY = 1;
    public static final int MIN_PLAY = 0;

    public static final int BOARD_SIZE = 3;

    public static final String X = "X";
    public static final String O = "O";

    public Player(String mark, int type) {
        this.mark = mark;
        this.type = type;
    }

    abstract int play(Board board);
}